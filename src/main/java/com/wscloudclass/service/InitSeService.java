package com.wscloudclass.service;

import com.wscloudclass.component.AliyunOSSUtils;
import com.wscloudclass.dto.SelectionDTO;
import com.wscloudclass.mapper.ActivityMapper;
import com.wscloudclass.mapper.SelectActivityMapper;
import com.wscloudclass.mapper.SelectionMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class InitSeService {
    @Autowired
    SelectionMapper selectionMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    AliyunOSSUtils aliyunOSSUtils;
    @Autowired
    SelectActivityMapper selectActivityMapper;
    private static int selNum=1;
    @Transactional
    public boolean createSeActivity(Long cid, List<MultipartFile> imgs, List<SelectionDTO> selectionDTOS, String activityName, String duration) throws IOException {
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
        activity.setActType(1);
        Calendar calendar=Calendar.getInstance();
        Date date=calendar.getTime();
        if (activityName.equals("")){
            activity.setActivityName("测试活动"+date);
        }else {
            activity.setActivityName(activityName);
        }
        activity.setStartTime(date);
        //活动结束日期
        calendar.add(Calendar.DATE, Integer.parseInt(duration));
        date=calendar.getTime();
        activity.setEndTime(date);
        activity.setCid(cid);
        activityMapper.insertSelective(activity);
        int isInsert;
        for (SelectionDTO selectionDTO:selectionDTOS){
            //判断题目是否存在图片
            if (selectionDTO.isHaveImg()){
                Selection selection = null;
                if (imgs.size()>0) {
                    MultipartFile file = imgs.get(0);
                    imgs.remove(0);
                    String imgUrl = aliyunOSSUtils.uploadImgFile(file);
                    selection = setSelection(selectionDTO);
                    selection.setImgUrl(imgUrl);
                }
                isInsert = selectionMapper.insertSelective(selection);
                 //将题目与活动关联
                 if (isInsert==1){
                     SelectActivity selectActivity = new SelectActivity();
                     selectActivity.setActId(activityId);
                     selectActivity.setSelId(selection.getSelId());
                     selectActivity.setSelNum(selNum);
                     selNum++;
                     selectActivityMapper.insert(selectActivity);
                 }
            }else {
               Selection selection=setSelection(selectionDTO);
               isInsert=selectionMapper.insertSelective(selection);
                //将题目与活动关联
                if (isInsert==1){
                    SelectActivity selectActivity = new SelectActivity();
                    selectActivity.setActId(activityId);
                    selectActivity.setSelId(selection.getSelId());
                    selectActivity.setSelNum(selNum);
                    selNum++;
                    selectActivityMapper.insert(selectActivity);
                }
            }
        }
        return true;
    }
    //封装的插入问题公共属性方法
    private Selection setSelection(SelectionDTO selectionDTO){
        Selection selection=new Selection();
        Long selId;
        boolean flag=true;
        //判断题目id是否存在
        while (flag){
            selId= Long.valueOf(getRandomString(15));
            SelectionExample example = new SelectionExample();
            example.createCriteria().andSelIdEqualTo(selId);
            long count = selectionMapper.countByExample(example);
            if (count==0){
                selection.setSelId(selId);
                flag=false;
            }
        }
        StringBuilder correctOption=new StringBuilder();
        selection.setSelId(Long.valueOf(getRandomString(15)));
        selection.setSelContent(selectionDTO.getSelContent());
        selection.setA(selectionDTO.getA());
        selection.setB(selectionDTO.getB());
        selection.setC(selectionDTO.getC());
        selection.setD(selectionDTO.getD());
        selection.setSelAna(selectionDTO.getAnalysis());
        selection.setScore(selectionDTO.getScore());
        //设置正确选项
        if (selectionDTO.isCheckA()){
            correctOption.append("A");
        }
        if (selectionDTO.isCheckB()){
            correctOption.append("B");
        }
        if (selectionDTO.isCheckC()){
            correctOption.append("C");
        }
        if (selectionDTO.isCheckD()){
            correctOption.append("D");
        }
        selection.setCorrectOption(String.valueOf(correctOption));
        return selection;
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
