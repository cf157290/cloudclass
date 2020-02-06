package com.wscloudclass.controller;

import com.wscloudclass.dto.CourseDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.service.CreateCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class CreateAndJoinCourseController {
    @Autowired
    CreateCourseService createCourseService;
    @RequestMapping("/create")
    public String create(){
        return "/create";
    }
    @PostMapping("/createCourse")
    public String createCourse(CourseDTO courseDTO, HttpServletRequest request) throws ParseException, IOException {
        boolean flag=createCourseService.createCourse(courseDTO,request);
        if (flag){
            //创建成功
            return "/activity";
        }else {
            //创建失败
            throw  new CustomizeException(CustomizeErrorCode.ERROR_CREATE_COURSE);
        }
    }
}
