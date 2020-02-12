package com.wscloudclass.service;

import com.wscloudclass.dto.RankingDTO;
import com.wscloudclass.mapper.*;
import com.wscloudclass.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RankingService {
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
    UserMapper userMapper;
    @Autowired
    DescriptionMapper descriptionMapper;
    @Autowired
    FileScoreMapper fileScoreMapper;
    @Autowired
    SubmitFileMapper submitFileMapper;
    public List<RankingDTO> getRanking(Long actId) {
        List<RankingDTO> list=new ArrayList<>();
        Activity activity = activityMapper.selectByPrimaryKey(actId);
        PartiActivityExample example = new PartiActivityExample();
        example.createCriteria().andActIdEqualTo(actId);
        List<PartiActivity> partiActivities = partiActivityMapper.selectByExample(example);//查询参与活动的学生
        if (activity.getActType()==1){
            //选择题
            SelectActivityExample selectActivityExample = new SelectActivityExample();
            selectActivityExample.createCriteria().andActIdEqualTo(actId);
            List<SelectActivity> selectActivities = selectActivityMapper.selectByExample(selectActivityExample);//查询活动中包含的选择题
            List<Long> selIds = new ArrayList<>();
            for (SelectActivity selectActivity:selectActivities){
                selIds.add(selectActivity.getSelId());//拿到选择题id
            }
            //查询选择题的正确选项
            SelectionExample selectionExample = new SelectionExample();
            selectionExample.createCriteria().andSelIdIn(selIds);
            List<Selection> selections = selectionMapper.selectByExample(selectionExample);//获得选择题列表
            List<String> correctOptions=new ArrayList<>();
            for (Selection selection:selections){
                //获得选项列表
                if (selection.getCorrectOption()!=null||selection.getCorrectOption()!=""){
                    correctOptions.add(selection.getCorrectOption());
                }else {
                    correctOptions.add("error");//题目未设置正确答案
                }
            }
            for (PartiActivity partiActivity:partiActivities){
                int score=0;
                RankingDTO rankingDTO=new RankingDTO();
                rankingDTO.setPartiTime(partiActivity.getPartiTime());
                //查询学生信息
                User user = userMapper.selectByPrimaryKey(partiActivity.getUid());
                rankingDTO.setUserName(user.getUsername());
                rankingDTO.setUserNumber(user.getUserNumber());
                //查询参与学生的回答
                UserAnswersExample userAnswersExample = new UserAnswersExample();
                userAnswersExample.createCriteria().andUidEqualTo(partiActivity.getUid()).andSelIdIn(selIds);
                List<UserAnswers> userAnswers = userAnswersMapper.selectByExample(userAnswersExample);//用户的答案
                for(UserAnswers userAnswer:userAnswers){
                    int i=0;
                    if (userAnswer.getUserSelect()!=null){
                        if (userAnswer.getUserSelect().equals(correctOptions.get(i))){
                            score+=selections.get(i).getScore();
                            i++;
                        }
                    }else {
                            i++;
                    }
                }
                rankingDTO.setScore(score);
                list.add(rankingDTO);
            }

        }else {
            //描述题
            //查询此活动的描述题
            Description description = descriptionMapper.selectByPrimaryKey(activity.getDesId());
            for (PartiActivity partiActivity:partiActivities){
                RankingDTO rankingDTO=new RankingDTO();
                int score=0;
                if (description.getScore()!=null){
                    score+=description.getScore();
                }
                //查询此用户提交的过文件
                SubmitFileExample submitFileExample = new SubmitFileExample();
                submitFileExample.createCriteria().andUidEqualTo(partiActivity.getUid());
                List<SubmitFile> submitFiles = submitFileMapper.selectByExample(submitFileExample);
                for (SubmitFile submitFile:submitFiles){
                    FileScoreExample fileScoreExample = new FileScoreExample();
                    fileScoreExample.createCriteria().andFileIdEqualTo(submitFile.getFileId());
                    List<FileScore> fileScores = fileScoreMapper.selectByExample(fileScoreExample);
                    for (FileScore fileScore:fileScores){
                        //找到此描述题的文件
                        if (fileScore.getDesId().equals(description.getDesId())){
                            if (fileScore.getScore()!=null){
                                score+=fileScore.getScore();
                            }
                        }
                    }
                }
                rankingDTO.setScore(score);
                User user = userMapper.selectByPrimaryKey(partiActivity.getUid());
                rankingDTO.setUserNumber(user.getUserNumber());
                rankingDTO.setUserName(user.getUsername());
                rankingDTO.setPartiTime(partiActivity.getPartiTime());
                list.add(rankingDTO);
            }
        }
        //List<RankingDTO> newList=list.stream().sorted(Comparator.comparing(RankingDTO::getScore).reversed()).collect(Collectors.toList());
        Comparator<RankingDTO> byScore=Comparator.comparing(RankingDTO::getScore).reversed();//优先分数倒序
        Comparator<RankingDTO> byPartiTime=Comparator.comparing(RankingDTO::getPartiTime);//时间正序
        Comparator<RankingDTO> byUserNumber=Comparator.comparing(RankingDTO::getUserNumber);//学号正序
        list.sort(byScore.thenComparing(byPartiTime).thenComparing(byUserNumber));
        return list;
    }
}
