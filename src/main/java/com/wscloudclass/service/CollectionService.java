package com.wscloudclass.service;

import com.wscloudclass.dto.CollectionDTO;
import com.wscloudclass.mapper.*;
import com.wscloudclass.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {
    @Autowired
    UserFavMapper userFavMapper;
    @Autowired
    SelectionMapper selectionMapper;
    @Autowired
    SelectActivityMapper selectActivityMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    CourseMapper courseMapper;
    public List<CollectionDTO> getUserFav(Long uid) {
        List<CollectionDTO> list=new ArrayList<>();
        //查询该用户的收藏
        UserFavExample example = new UserFavExample();
        example.createCriteria().andUidEqualTo(uid);
        List<UserFavKey> userFavKeys = userFavMapper.selectByExample(example);
        for (UserFavKey userFavKey:userFavKeys){
//            查找题目信息
            CollectionDTO collectionDTO=new CollectionDTO();
            Selection selection = selectionMapper.selectByPrimaryKey(userFavKey.getSelId());//找到该题目
            SelectActivityExample selectActivityExample = new SelectActivityExample();
            selectActivityExample.createCriteria().andSelIdEqualTo(userFavKey.getSelId());
            List<SelectActivity> selectActivities = selectActivityMapper.selectByExample(selectActivityExample);
            Activity activity = activityMapper.selectByPrimaryKey(selectActivities.get(0).getActId());
            Course course = courseMapper.selectByPrimaryKey(activity.getCid());
            collectionDTO.setCourseName(course.getCourseName());
            collectionDTO.setSelId(userFavKey.getSelId());
            collectionDTO.setSelContent(selection.getSelContent());
            if (selection.getImgUrl()==null||selection.getImgUrl().equals("")){
                collectionDTO.setHaveImg(false);
            }else {
                collectionDTO.setHaveImg(true);
                collectionDTO.setImgUrl(selection.getImgUrl());
            }
            collectionDTO.setA(selection.getA());
            collectionDTO.setB(selection.getB());
            if (selection.getC().equals("")||selection.getC()==null){
                collectionDTO.setHaveC(false);
            }else {
                collectionDTO.setHaveC(true);
                collectionDTO.setC(selection.getC());
            }
            if (selection.getD().equals("")||selection.getD()==null){
                collectionDTO.setHaveD(false);
            }else {
                collectionDTO.setHaveD(true);
                collectionDTO.setD(selection.getD());
            }
            if (selection.getSelAna().equals("")||selection.getSelAna()==null){
                collectionDTO.setHaveAna(false);
            }else {
                collectionDTO.setHaveAna(true);
                collectionDTO.setSelAna(selection.getSelAna());
            }
            char[] correctOption=selection.getCorrectOption().toCharArray();
            if (correctOption!=null){
                for (int i=0;i<correctOption.length;i++){
                    if (correctOption[i]=='A'){
                        collectionDTO.setATrue(true);
                    }
                    if (correctOption[i]=='B'){
                        collectionDTO.setBTrue(true);
                    }
                    if (correctOption[i]=='C'){
                        collectionDTO.setCTrue(true);
                    }
                    if (correctOption[i]=='D'){
                        collectionDTO.setDTrue(true);
                    }
                }
            }
            list.add(collectionDTO);
        }
        return list;
    }
}
