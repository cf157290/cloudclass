package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.dto.CourseDTO;
import com.wscloudclass.dto.CreateCourseDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.mapper.CourseMapper;
import com.wscloudclass.model.Course;
import com.wscloudclass.service.CreateCourseService;
import com.wscloudclass.service.JoinCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CreateAndJoinCourseController {
    @Autowired
    CreateCourseService createCourseService;
    @Autowired
    JoinCourseService joinCourseService;
    @Autowired
    CourseMapper courseMapper;
    @RequestMapping("/create")
    public String create(){
        return "create";
    }
    @RequestMapping("/join")
    public String join(){
        return "join";
    }
    @PostMapping("/createCourse")
    public String createCourse(CreateCourseDTO createCourseDTO, HttpServletRequest request) throws ParseException, IOException {
        boolean flag=createCourseService.createCourse(createCourseDTO,request);
        if (flag){
            //创建成功
            return "redirect:/index";
        }else {
            //创建失败
            throw  new CustomizeException(CustomizeErrorCode.ERROR_CREATE_COURSE);
        }
    }
    @ResponseBody
    @PostMapping("/findCourse")
    public String findCourse(@RequestBody Map<String,String> code,HttpServletRequest request){
        CourseDTO courseDTO=joinCourseService.findCourseByCode(code.get("code"));
        if (courseDTO!=null){
            UserDTO userDTO= (UserDTO) request.getSession().getAttribute("user");
            if (courseDTO.getTeacherid().equals(userDTO.getUid())){
                Map<String,String> map=new HashMap<>();
                map.put("message","您不能加入自己创建的班课!");
                return JSON.toJSONString(map);
            }
            return JSON.toJSONString(courseDTO);
        }else {
            Map<String,String> map=new HashMap<>();
            map.put("message","班课不存在,请检查邀请码是否正确");
            return JSON.toJSONString(map);
        }
    }
    @ResponseBody
    @PostMapping("/joinCourse")
    public String joinCourse(@RequestBody Map<String,Long>data){
        Long cid=data.get("cid");
        Long uid=data.get("uid");
        boolean flag=joinCourseService.joinCourse(cid,uid);
        if (flag){
            Map<String,Integer> map=new HashMap<>();
            map.put("code",1);
            return JSON.toJSONString(map);
        }else {
            Map<String,Integer> map=new HashMap<>();
            map.put("code",2);
            return JSON.toJSONString(map);
        }
    }
    @ResponseBody
    @GetMapping("/getInviteCode/{cid}")
    public String getInviteCode(@PathVariable(name = "cid")Long cid){
        Course course = courseMapper.selectByPrimaryKey(cid);
        Map<String,Object>map=new HashMap<>();
        map.put("message",true);
        map.put("inviteCode",course.getInvitCode());
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @GetMapping("/getClassInfo/{cid}")
    public String getClassInfo(@PathVariable(name = "cid")Long cid){
        Course course = courseMapper.selectByPrimaryKey(cid);
        Map<String,Object> map=new HashMap<>();
        map.put("message",true);
        map.put("className",course.getClassName());
        map.put("courseName",course.getCourseName());
        map.put("img",course.getCourseUrl());
        return JSON.toJSONString(map);
    }
}
