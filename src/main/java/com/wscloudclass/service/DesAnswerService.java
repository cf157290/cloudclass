package com.wscloudclass.service;

import com.wscloudclass.component.AliyunOSSUtils;
import com.wscloudclass.mapper.ActivityMapper;
import com.wscloudclass.mapper.FileScoreMapper;
import com.wscloudclass.mapper.PartiActivityMapper;
import com.wscloudclass.mapper.SubmitFileMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

@Service
public class DesAnswerService {
    @Autowired
    PartiActivityMapper partiActivityMapper;
    @Autowired
    SubmitFileMapper submitFileMapper;
    @Autowired
    AliyunOSSUtils aliyunOSSUtils;
    @Autowired
    FileScoreMapper fileScoreMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Transactional
    public boolean insertUserAnswer(Long uid, Long actId, MultipartFile file) throws IOException {
        //参与活动
        PartiActivity record = new PartiActivity();
        record.setUid(uid);
        record.setActId(actId);
        record.setPartiTime(new Date());
        partiActivityMapper.insert(record);
        //插入提交记录
        SubmitFile submitFile = new SubmitFile();
        boolean flag=true;
        Long fileId = null;
        while (flag){
            fileId= Long.parseLong(getRandomString(15));
            SubmitFileExample example = new SubmitFileExample();
            example.createCriteria().andFileIdEqualTo(fileId);
            long count = submitFileMapper.countByExample(example);
            if (count==0){
                submitFile.setFileId(fileId);
                flag=false;
            }
        }
        submitFile.setFileName(file.getOriginalFilename());
        submitFile.setFileSize((int) file.getSize());
        submitFile.setFileUrl(aliyunOSSUtils.uploadFile(file));
        submitFile.setSubmitTime(new Date());
        submitFile.setUid(uid);
        submitFileMapper.insert(submitFile);
        //将文件与题目关联
            //查询描述题id
        Activity activity = activityMapper.selectByPrimaryKey(actId);
        FileScore fileScore = new FileScore();
        fileScore.setFileId(fileId);
        fileScore.setDesId(activity.getDesId());
        int i = fileScoreMapper.insertSelective(fileScore);
        if (i==1){
            return true;
        }else {
            return false;
        }
    }
    //随机生成id
    private String getRandomString(int length){
        String str="0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
