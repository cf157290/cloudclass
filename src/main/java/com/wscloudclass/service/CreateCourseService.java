package com.wscloudclass.service;

import com.wscloudclass.component.AliyunOSSUtils;
import com.wscloudclass.dto.CreateCourseDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.mapper.CourseMapper;
import com.wscloudclass.model.Course;
import com.wscloudclass.model.CourseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CreateCourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    AliyunOSSUtils aliyunOSSUtils;
    public boolean createCourse(CreateCourseDTO createCourseDTO, HttpServletRequest request) throws ParseException, IOException {
        boolean flag=true;
        UserDTO userDTO;
        userDTO= (UserDTO) request.getSession().getAttribute("user");
        int isinsert = 0;
        while (flag){
            String code=getRandomString(10);
            CourseExample example = new CourseExample();
            example.createCriteria().andInvitCodeEqualTo(code);
            List<Course> courses = courseMapper.selectByExample(example);
            if (courses.size()==0){
                Course course=new Course();
                course.setInvitCode(code);
                course.setClassName(createCourseDTO.getClassName());
                course.setCollegeDepartment(createCourseDTO.getCollegeDepartment());
                course.setCourseName(createCourseDTO.getCourseName());
                if (createCourseDTO.getFile()!=null){
                    String imgUrl=aliyunOSSUtils.uploadFile(createCourseDTO.getFile());
                    course.setCourseUrl(imgUrl);
                }
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                Date startTime=df.parse(createCourseDTO.getStartTime());
                Date endTime=df.parse(createCourseDTO.getEndTime());
                course.setStartTime(startTime);
                course.setEndTime(endTime);
                course.setSchool(createCourseDTO.getSchool());
                course.setTeacherid(userDTO.getUid());
                isinsert = courseMapper.insertSelective(course);
                flag=false;
            }
        }
        if (isinsert==1){
            return true;
        }else {
            return false;
        }
    }

    private String getRandomString(int length){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
