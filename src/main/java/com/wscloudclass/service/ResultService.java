package com.wscloudclass.service;

import com.wscloudclass.dto.ResultDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.mapper.SelectActivityMapper;
import com.wscloudclass.mapper.SelectionMapper;
import com.wscloudclass.mapper.UserAnswersMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    SelectActivityMapper selectActivityMapper;
    @Autowired
    SelectionMapper selectionMapper;
    @Autowired
    UserAnswersMapper userAnswersMapper;
    public List<ResultDTO> findResult(Long actId, Long teacherid, Long uid) {
        List<ResultDTO> list=new ArrayList<>();
        //查询活动中包含的选择题
        SelectActivityExample example = new SelectActivityExample();
        example.createCriteria().andActIdEqualTo(actId);
        List<SelectActivity> selectActivities = selectActivityMapper.selectByExample(example);
        if (selectActivities.size()==0){
            throw new CustomizeException(CustomizeErrorCode.ERROR_ACTIVITY_RESULT);
        }
        for (SelectActivity selectActivity:selectActivities){
            ResultDTO resultDTO=new ResultDTO();
            resultDTO.setSelId(selectActivity.getSelId());
            resultDTO.setSelNum(selectActivity.getSelNum());
            //查询选择题
            Selection selection = selectionMapper.selectByPrimaryKey(selectActivity.getSelId());
            resultDTO.setSelContent(selection.getSelContent());
                //教师查看
            String selAna=selection.getSelAna();
            if (selAna==null){
                resultDTO.setHaveAna(false);
            }else {
                resultDTO.setHaveAna(true);
                resultDTO.setSelAna(selAna);
            }
            String imgUrl=selection.getImgUrl();
            if (imgUrl==null){
                resultDTO.setHaveImg(false);
            }else {
                resultDTO.setHaveImg(true);
                resultDTO.setImgUrl(selection.getImgUrl());
            }
            resultDTO.setA(selection.getA());
            resultDTO.setB(selection.getB());
            String C=selection.getC();
            if (C==null||C.equals("")){
                resultDTO.setHaveC(false);
            }else {
                resultDTO.setHaveC(true);
                resultDTO.setC(selection.getC());
            }
            String D=selection.getD();
            if (D==null||D.equals("")){
                resultDTO.setHaveD(false);
            }else {
                resultDTO.setHaveD(true);
                resultDTO.setD(selection.getD());
            }
            String correctOption=selection.getCorrectOption();
            if (correctOption!=null){
                char[] correctOptions=correctOption.toCharArray();
                for (int i=0;i<correctOptions.length;i++){
                    if (correctOptions[i]=='A'){
                        resultDTO.setATrue(true);
                    }
                    if (correctOptions[i]=='B'){
                        resultDTO.setBTrue(true);
                    }
                    if (correctOptions[i]=='C'){
                        resultDTO.setCTrue(true);
                    }
                    if (correctOptions[i]=='D'){
                        resultDTO.setDTrue(true);
                    }
                }
                resultDTO.setCorrectOption(correctOption);
            }
            //查询用户回答列表
            UserAnswersExample userAnswersExample = new UserAnswersExample();
            userAnswersExample.createCriteria().andSelIdEqualTo(selectActivity.getSelId());
            List<UserAnswers> userAnswers = userAnswersMapper.selectByExample(userAnswersExample);
            int chooseA=0;
            int chooseB=0;
            int chooseC=0;
            int chooseD=0;
            int correct=0;
            for (UserAnswers userAnswers1:userAnswers){
                char[] userSelect=userAnswers1.getUserSelect().toCharArray();
                for (int i=0;i<userSelect.length;i++){
                    if (userSelect[i]=='A'){
                        chooseA++;
                    }
                    if (userSelect[i]=='B'){
                        chooseB++;
                    }
                    if (userSelect[i]=='C'){
                        chooseC++;
                    }
                    if (userSelect[i]=='D'){
                        chooseD++;
                    }
                    if (userAnswers1.getUserSelect().equals(selection.getCorrectOption())){
                        correct++;
                    }
                }
            }
            resultDTO.setChooseA(chooseA);
            resultDTO.setChooseB(chooseB);
            resultDTO.setChooseC(chooseC);
            resultDTO.setChooseD(chooseD);
            double accRate=(double)correct/userAnswers.size();
            BigDecimal bigDecimal=new BigDecimal(accRate);
            accRate=bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            resultDTO.setAccRate((int) (accRate*100));
            list.add(resultDTO);
            if (teacherid!=uid){
                //学生查看
                UserAnswersKey key = new UserAnswersKey();
                key.setUid(uid);
                key.setSelId(selectActivity.getSelId());
                UserAnswers userAnswers1 = userAnswersMapper.selectByPrimaryKey(key);
                resultDTO.setYourOption(userAnswers1.getUserSelect());
            }
        }
        Comparator<ResultDTO> bySelNum=Comparator.comparing(ResultDTO::getSelNum);
        list.sort(bySelNum);
        return list;
    }

    public int getUserScore(Long actId, Long uid) {
        //查询题目列表
        int score=0;
        SelectActivityExample example = new SelectActivityExample();
        example.createCriteria().andActIdEqualTo(actId);
        List<SelectActivity> selectActivities = selectActivityMapper.selectByExample(example);
        for (SelectActivity selectActivity:selectActivities){
            //查询用户的选择
            UserAnswersKey key = new UserAnswersKey();
            key.setSelId(selectActivity.getSelId());
            key.setUid(uid);
            UserAnswers userAnswers = userAnswersMapper.selectByPrimaryKey(key);
            //查询该选择题
            Selection selection = selectionMapper.selectByPrimaryKey(selectActivity.getSelId());
            if (userAnswers.getUserSelect().equals(selection.getCorrectOption())){
                score++;
            }
        }
        return score;
    }
}
