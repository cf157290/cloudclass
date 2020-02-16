package com.wscloudclass.service;

import com.wscloudclass.dto.CourseDTO;
import com.wscloudclass.mapper.CourseMapper;
import com.wscloudclass.mapper.JoinCourseMapper;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.Course;
import com.wscloudclass.model.JoinCourseKey;
import com.wscloudclass.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    JoinCourseMapper joinCourseMapper;
    public CourseDTO getDetails(Long cid) {
        CourseDTO courseDTO=new CourseDTO();
        Course course = courseMapper.selectByPrimaryKey(cid);
        BeanUtils.copyProperties(course,courseDTO);
        User user = userMapper.selectByPrimaryKey(courseDTO.getTeacherid());
        courseDTO.setTeacherName(user.getUsername());
        return courseDTO;
    }

    public void outCourse(Long cid, Long teacherid, Long uid) {
        if (teacherid==uid){
            //教师退出
            courseMapper.deleteByPrimaryKey(cid);
        }else {
            //学生退出
            JoinCourseKey key = new JoinCourseKey();
            key.setUid(uid);
            key.setCid(cid);
            joinCourseMapper.deleteByPrimaryKey(key);
        }
    }
}
