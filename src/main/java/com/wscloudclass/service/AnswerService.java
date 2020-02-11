package com.wscloudclass.service;

import com.wscloudclass.dto.AnswerDTO;
import com.wscloudclass.dto.UserAnswerDTO;
import com.wscloudclass.mapper.PartiActivityMapper;
import com.wscloudclass.mapper.SelectActivityMapper;
import com.wscloudclass.mapper.SelectionMapper;
import com.wscloudclass.mapper.UserAnswersMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    SelectActivityMapper selectActivityMapper;
    @Autowired
    SelectionMapper selectionMapper;
    @Autowired
    UserAnswersMapper userAnswersMapper;
    @Autowired
    PartiActivityMapper partiActivityMapper;
    public List<AnswerDTO> getSelection(Long actId) {
        List<AnswerDTO> list=new ArrayList<>();
        SelectActivityExample example = new SelectActivityExample();
        example.createCriteria().andActIdEqualTo(actId);
        example.setOrderByClause("sel_num");
        List<SelectActivity> selectActivities = selectActivityMapper.selectByExample(example);
        for (SelectActivity selectActivity:selectActivities){
            AnswerDTO answerDTO=new AnswerDTO();
            Selection selection = selectionMapper.selectByPrimaryKey(selectActivity.getSelId());
            BeanUtils.copyProperties(selection,answerDTO);
            answerDTO.setSelNum(selectActivity.getSelNum());
            if (selection.getCorrectOption().length()>1){
                answerDTO.setOneOrMore(2);//多选
            }else {
                answerDTO.setOneOrMore(1);//单选
            }
            list.add(answerDTO);
        }
        return list;
    }
    @Transactional
    public boolean insertUserAnswer(Long uid, Long actId, List<UserAnswerDTO> userAnswerDTOS) {
        for (UserAnswerDTO userAnswerDTO:userAnswerDTOS){
            UserAnswers userAnswers=new UserAnswers();
            BeanUtils.copyProperties(userAnswerDTO,userAnswers);
            userAnswers.setUid(uid);
            userAnswersMapper.insertSelective(userAnswers);
        }
        PartiActivity record = new PartiActivity();
        record.setUid(uid);
        record.setActId(actId);
        record.setPartiTime(new Date());
        partiActivityMapper.insert(record);
        return true;
    }
}
