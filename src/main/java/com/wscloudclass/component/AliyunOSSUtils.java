package com.wscloudclass.component;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


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

}
