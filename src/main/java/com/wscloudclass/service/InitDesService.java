package com.wscloudclass.service;

import com.wscloudclass.component.AliyunOSSUtils;
import com.wscloudclass.dto.CreateDesDTO;
import com.wscloudclass.mapper.ActivityMapper;
import com.wscloudclass.mapper.DescriptionMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class InitDesService {
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    DescriptionMapper descriptionMapper;
    @Autowired
    AliyunOSSUtils aliyunOSSUtils;
    @Transactional
    public boolean createDesActivity(Long cid, CreateDesDTO createDesDTO) throws IOException {
        //创建描述题
        Description description=new Description();
        boolean isExist=true;
        Long desId=null;
        while (isExist){
            desId= Long.valueOf(getRandomString(15));
            DescriptionExample example = new DescriptionExample();
            example.createCriteria().andDesIdEqualTo(desId);
            long count = descriptionMapper.countByExample(example);
            if (count==0){
                description.setDesId(desId);
                isExist=false;
            }
        }
        description.setDesContent(createDesDTO.getDesContent());
        description.setFileName(createDesDTO.getFile().getOriginalFilename());
        description.setFileUrl(aliyunOSSUtils.uploadFile(createDesDTO.getFile()));
        description.setFileSize((int) createDesDTO.getFile().getSize());
        description.setScore(createDesDTO.getScore());
        int insert = descriptionMapper.insert(description);
        if (insert!=1){
            return false;
        }
        //创建活动
        Activity activity=new Activity();
        boolean flag=true;
        Long activityId = null;
        //判断活动id是否存在
        while (flag){
            activityId=Long.valueOf(getRandomString(15));
            ActivityExample example = new ActivityExample();
            example.createCriteria().andActIdEqualTo(activityId);
            long count = activityMapper.countByExample(example);
            if (count==0){
                activity.setActId(activityId);
                flag=false;
            }
        }
        activity.setActType(2);
        Calendar calendar=Calendar.getInstance();
        Date date=calendar.getTime();
        if (createDesDTO.getActivityName().equals("")){
            activity.setActivityName("测试活动"+date);
        }else {
            activity.setActivityName(createDesDTO.getActivityName());
        }
        activity.setStartTime(date);
        //活动结束日期
        calendar.add(Calendar.DATE, createDesDTO.getDuration());
        date=calendar.getTime();
        activity.setEndTime(date);
        activity.setCid(cid);
        activity.setDesId(desId);
        int i = activityMapper.insert(activity);
        if (i!=1){
            return false;
        }
        return true;
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
