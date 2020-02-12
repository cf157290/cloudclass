package com.wscloudclass.service;

import com.wscloudclass.dto.ScoreDTO;
import com.wscloudclass.dto.SubmitUserScoreDTO;
import com.wscloudclass.mapper.*;
import com.wscloudclass.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    PartiActivityMapper partiActivityMapper;
    @Autowired
    FileScoreMapper fileScoreMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    SubmitFileMapper submitFileMapper;
    @Autowired
    UserMapper userMapper;
    public List<ScoreDTO> selectSubmit(Long actId) {
        List<ScoreDTO> list=new ArrayList<>();
        //查询参与活动的学生
        PartiActivityExample example = new PartiActivityExample();
        example.createCriteria().andActIdEqualTo(actId);
        List<PartiActivity> partiActivities = partiActivityMapper.selectByExample(example);//参与活动的学生列表
        //查询活动中的描述题
        Activity activity = activityMapper.selectByPrimaryKey(actId);
        //查询提交的文件列表
        FileScoreExample fileScoreExample = new FileScoreExample();
        fileScoreExample.createCriteria().andDesIdEqualTo(activity.getDesId());
        List<FileScore> fileScores = fileScoreMapper.selectByExample(fileScoreExample);//该题目提交的文件列表
        for (PartiActivity partiActivity:partiActivities){
            ScoreDTO scoreDTO=new ScoreDTO();
            scoreDTO.setUid(partiActivity.getUid());
            //查询当前用户的基本信息
            User user = userMapper.selectByPrimaryKey(partiActivity.getUid());
            scoreDTO.setUserName(user.getUsername());
            scoreDTO.setUserNumber(user.getUserNumber());
            //查询当前用户提交的文件
            SubmitFileExample submitFileExample = new SubmitFileExample();
            submitFileExample.createCriteria().andUidEqualTo(partiActivity.getUid());
            List<SubmitFile> submitFiles = submitFileMapper.selectByExample(submitFileExample);//该用户提交过的文件列表
            loop:
            for (SubmitFile submitFile:submitFiles){
                for (FileScore fileScore:fileScores){
                    //找出用户提交到该活动的文件
                    if (fileScore.getFileId().equals(submitFile.getFileId())){
                        scoreDTO.setScore(fileScore.getScore());
                        scoreDTO.setFileName(submitFile.getFileName());
                        scoreDTO.setFileUrl(submitFile.getFileUrl());
                        scoreDTO.setPartiTime(submitFile.getSubmitTime());
                        break loop;
                    }
                }
            }
            list.add(scoreDTO);
        }
        Comparator<ScoreDTO> byUserNumber=Comparator.comparing(ScoreDTO::getUserNumber);
        list.sort(byUserNumber);
        return list;
    }

    @Transactional
    public boolean updateUserScore(Long actid, List<SubmitUserScoreDTO> submitUserScoreDTOS) {
        //查找相关活动包含的描述题
        Activity activity = activityMapper.selectByPrimaryKey(actid);
        Long desId=activity.getDesId();
        //查找相题目中用户提交的文件
        FileScoreExample example = new FileScoreExample();
        example.createCriteria().andDesIdEqualTo(desId);
        List<FileScore> fileScores = fileScoreMapper.selectByExample(example);
        FileScore record = new FileScore();
        FileScoreExample  fileScoreExample= new FileScoreExample();
        for (SubmitUserScoreDTO submitUserScoreDTO:submitUserScoreDTOS){
            //查找该用户提交的文件
            SubmitFileExample submitFileExample = new SubmitFileExample();
            submitFileExample.createCriteria().andUidEqualTo(submitUserScoreDTO.getUid());
            List<SubmitFile> submitFiles = submitFileMapper.selectByExample(submitFileExample);//用户提交的文件
            //查找用户提交的该题目的文件
            loop:
            for(SubmitFile submitFile:submitFiles){
                for (FileScore fileScore:fileScores){
                    if (submitFile.getFileId().equals(fileScore.getFileId())){
                        //找到文件
                        record.setScore(submitUserScoreDTO.getScore());
                        fileScoreExample.createCriteria()
                                .andDesIdEqualTo(activity.getDesId())
                                .andFileIdEqualTo(fileScore.getFileId());
                        break loop;
                    }
                }
            }
            fileScoreMapper.updateByExampleSelective(record, fileScoreExample);
        }
        return true;
    }
}
