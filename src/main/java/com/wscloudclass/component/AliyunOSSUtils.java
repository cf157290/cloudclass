package com.wscloudclass.component;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@Component
public class AliyunOSSUtils {
    @Value("${aliyun.endpoint}")
    String endpoint ;
    @Value("${aliyun.accesskeyid}")
    String accessKeyId;
    @Value("${aliyun.accesskeysecret}")
    String accessKeySecret;
    @Value("${aliyun.bucketname}")
    String bucketName;
    @Value("${aliyun.urlPrefix}")
    String urlPrefix;
    public String uploadImgFile(MultipartFile file) throws IOException {
        String fileName=file.getOriginalFilename();
        String objectName= UUID.randomUUID().toString()+"-"+fileName;
        ObjectMetadata objectMetadata=new ObjectMetadata();
        objectMetadata.setContentType("image/jpg");
       // objectMetadata.setContentDisposition(fileName);
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream=file.getInputStream();
        ossClient.putObject(bucketName, objectName, inputStream,objectMetadata);
        ossClient.setObjectAcl(bucketName,objectName, CannedAccessControlList.PublicRead);
        // 关闭OSSClient。
        ossClient.shutdown();
        return urlPrefix+objectName;
    }
    public String uploadFile(MultipartFile file) throws IOException {
        String fileName=file.getOriginalFilename();
        String objectName= UUID.randomUUID().toString()+"-"+fileName;
       // objectMetadata.setContentDisposition(fileName);
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream=file.getInputStream();
        ossClient.putObject(bucketName, objectName, inputStream);
        ossClient.setObjectAcl(bucketName,objectName, CannedAccessControlList.PublicRead);
        // 关闭OSSClient。
        ossClient.shutdown();
        return urlPrefix+objectName;
    }

    /**
     * 批量下载oss 文件 并打成zip 包 返回到response中
     *
     * @param fileNames oss上的文件名集合 如：product/image/3448275920.png
     * @param zipFileName 压缩包文件名
     * @param response  HttpServletResponse
     */
    public void batchDownLoadOssFile(List<String> fileNames, String zipFileName, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + zipFileName + ".zip");
        BufferedInputStream bis = null;
        try {
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            int sortNum = 0;
            for (String fileName : fileNames) {
                Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
                GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, fileName, HttpMethod.GET);
                // 设置过期时间。
                request.setExpiration(expiration);
                // 生成签名URL（HTTP GET请求）。
                URL signedUrl = ossClient.generatePresignedUrl(request);
                // 使用签名URL发送请求。
                OSSObject ossObject = ossClient.getObject(signedUrl, new HashMap<>());

                if (ossObject != null) {
                    InputStream inputStream = ossObject.getObjectContent();
                    byte[] buffs = new byte[1024 * 10];

                    String zipFile = sortNum + "_" + fileName.substring(fileName.lastIndexOf("/") + 1);
                    ZipEntry zipEntry = new ZipEntry(zipFile);
                    zos.putNextEntry(zipEntry);
                    bis = new BufferedInputStream(inputStream, 1024 * 10);

                    int read;
                    while ((read = bis.read(buffs, 0, 1024 * 10)) != -1) {
                        zos.write(buffs, 0, read);
                    }
                    ossObject.close();
                }
                sortNum++;
            }
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (null != bis) {
                    bis.close();
                }
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
