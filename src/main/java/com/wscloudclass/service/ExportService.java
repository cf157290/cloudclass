package com.wscloudclass.service;

import com.wscloudclass.dto.ExportDTO;
import com.wscloudclass.mapper.*;
import com.wscloudclass.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ExportService {
    @Autowired
    JoinCourseMapper joinCourseMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CompleteSignInMapper completeSignInMapper;
    @Autowired
    SignInMapper signInMapper;
    @Autowired
    PartiActivityMapper partiActivityMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    SelectActivityMapper selectActivityMapper;
    @Autowired
    UserAnswersMapper userAnswersMapper;
    @Autowired
    SelectionMapper selectionMapper;
    @Autowired
    DescriptionMapper descriptionMapper;
    @Autowired
    SubmitFileMapper submitFileMapper;
    @Autowired
    FileScoreMapper fileScoreMapper;
    public List<ExportDTO> getStuScore(Long cid) {
        List<ExportDTO> list=new ArrayList<>();
        //查询是否有成员加入
        JoinCourseExample example = new JoinCourseExample();
        example.createCriteria().andCidEqualTo(cid);
        List<JoinCourseKey> joinCourseKeys = joinCourseMapper.selectByExample(example);
        List<Long>uids=new ArrayList<>();
        for (JoinCourseKey joinCourseKey:joinCourseKeys){
            uids.add(joinCourseKey.getUid());
        }
        if (uids.size()>0){
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUidIn(uids);
            List<User> users = userMapper.selectByExample(userExample);
            //成员信息按学号排序
            Comparator<User>byUserNumber=Comparator.comparing(User::getUserNumber);
            users.sort(byUserNumber);
            int num=1;
            for (User user:users){
                ExportDTO exportDTO=new ExportDTO();
                exportDTO.setNum(num);
                num++;
                exportDTO.setUserName(user.getUsername());
                exportDTO.setUserNumber(user.getUserNumber());
                int score=0;
                //查询用户参与的签到
                CompleteSignInExample completeSignInExample = new CompleteSignInExample();
                completeSignInExample.createCriteria().andUidEqualTo(user.getUid());
                List<CompleteSignIn> completeSignIns = completeSignInMapper.selectByExample(completeSignInExample);
                for (CompleteSignIn completeSignIn:completeSignIns){
                    SignIn signIn = signInMapper.selectByPrimaryKey(completeSignIn.getSignId());
                    if (signIn.getCid()==cid){
                        score+=signIn.getScore();
                    }
                }
                //查询用户参与的活动
                PartiActivityExample partiActivityExample = new PartiActivityExample();
                partiActivityExample.createCriteria().andUidEqualTo(user.getUid());
                List<PartiActivity> partiActivities = partiActivityMapper.selectByExample(partiActivityExample);
                for (PartiActivity partiActivity:partiActivities){
                    Activity activity = activityMapper.selectByPrimaryKey(partiActivity.getActId());
                    if (activity.getActType()==1){
                        //选择题
                        //查找选择题
                        SelectActivityExample selectActivityExample = new SelectActivityExample();
                        selectActivityExample.createCriteria().andActIdEqualTo(activity.getActId());
                        List<SelectActivity> selectActivities = selectActivityMapper.selectByExample(selectActivityExample);
                        //查找用户的回答
                        for (SelectActivity selectActivity:selectActivities){
                            //查找题目正确选项
                            Selection selection = selectionMapper.selectByPrimaryKey(selectActivity.getSelId());
                            //查找用户的回答
                            UserAnswersKey key = new UserAnswersKey();
                            key.setUid(user.getUid());
                            key.setSelId(selectActivity.getSelId());
                            UserAnswers userAnswers = userAnswersMapper.selectByPrimaryKey(key);
                            if (userAnswers!=null){
                                if (userAnswers.getUserSelect().equals(selection.getCorrectOption())){
                                    score+=selection.getScore();
                                }
                            }
                        }
                    }else {
                        //描述题(用户参与过,所以直接加提交得分)
                        //查找描述题
                        Description description = descriptionMapper.selectByPrimaryKey(activity.getDesId());
                        score+=description.getScore();
                        //查询用户提交的文件
                        SubmitFileExample submitFileExample = new SubmitFileExample();
                        submitFileExample.createCriteria().andUidEqualTo(user.getUid());
                        List<SubmitFile> submitFiles = submitFileMapper.selectByExample(submitFileExample);
                        //查询该题目提交的文件
                        FileScoreExample fileScoreExample = new FileScoreExample();
                        fileScoreExample.createCriteria().andDesIdEqualTo(activity.getDesId());
                        List<FileScore> fileScores = fileScoreMapper.selectByExample(fileScoreExample);
                        //遍历查找该文件
                        for (SubmitFile submitFile:submitFiles){
                            for (FileScore fileScore:fileScores){
                                if (fileScore.getFileId()==submitFile.getFileId()){
                                    score+=fileScore.getScore();
                                }
                            }
                        }
                    }
                }
                exportDTO.setScore(score);
                list.add(exportDTO);
            }
        }
        return list;
    }
}
