package com.wscloudclass.service;

import com.wscloudclass.dto.CourseDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.mapper.CourseMapper;
import com.wscloudclass.mapper.JoinCourseMapper;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinCourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    JoinCourseMapper joinCourseMapper;
    public CourseDTO findCourseByCode(String code) {
        CourseExample example = new CourseExample();
        example.createCriteria().andInvitCodeEqualTo(code);
        List<Course> courses = courseMapper.selectByExample(example);
        if (courses.size()==1){
            CourseDTO courseDTO=new CourseDTO();
            BeanUtils.copyProperties(courses.get(0),courseDTO);
            User user = userMapper.selectByPrimaryKey(courseDTO.getTeacherid());
            courseDTO.setTeacherName(user.getUsername());
            return courseDTO;
        }else {
            return null;
        }
    }

    public boolean joinCourse(Long cid, Long uid) {
        JoinCourseKey joinCourseKey=new JoinCourseKey();
        joinCourseKey.setCid(cid);
        joinCourseKey.setUid(uid);
        JoinCourseExample example = new JoinCourseExample();
        example.createCriteria().andCidEqualTo(cid).andUidEqualTo(uid);
        List<JoinCourseKey> joinCourseKeys = joinCourseMapper.selectByExample(example);
        if (joinCourseKeys.size()!=0){
            return false;
        }
        int insert = joinCourseMapper.insert(joinCourseKey);
        if (insert==1){
            return true;
        }else {
            throw new CustomizeException(CustomizeErrorCode.ERROR_JOIN_COURSE);
        }
    }
}
