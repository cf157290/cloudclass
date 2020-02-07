package com.wscloudclass.service;

import com.wscloudclass.dto.CourseDTO;
import com.wscloudclass.mapper.CourseMapper;
import com.wscloudclass.mapper.JoinCourseMapper;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    JoinCourseMapper joinCourseMapper;
    @Autowired
    UserMapper userMapper;
    public List<CourseDTO> selectCourseById(Long uid) {
        List<CourseDTO> list=new ArrayList<>();
        JoinCourseExample joinCourseExample = new JoinCourseExample();
        joinCourseExample.createCriteria().andUidEqualTo(uid);
        List<JoinCourseKey> joinCourseKeys = joinCourseMapper.selectByExample(joinCourseExample);
        for (JoinCourseKey joinCourseKey:joinCourseKeys){
            Course course = courseMapper.selectByPrimaryKey(joinCourseKey.getCid());
            User user = userMapper.selectByPrimaryKey(course.getTeacherid());
            CourseDTO courseDTO=new CourseDTO();
            BeanUtils.copyProperties(course,courseDTO);
            courseDTO.setTeacherName(user.getUsername());
            list.add(courseDTO);
        }
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andTeacheridEqualTo(uid);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        User user = userMapper.selectByPrimaryKey(uid);
        for (Course course:courses){
            CourseDTO courseDTO=new CourseDTO();
            BeanUtils.copyProperties(course,courseDTO);
            courseDTO.setTeacherName(user.getUsername());
            list.add(courseDTO);
        }
        return list;
    }
}
