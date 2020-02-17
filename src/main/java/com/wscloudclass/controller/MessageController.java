package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.dto.CourseInfoDTO;
import com.wscloudclass.dto.MessageContentDTO;
import com.wscloudclass.dto.MessageMemberDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.mapper.JoinCourseMapper;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.JoinCourseExample;
import com.wscloudclass.model.JoinCourseKey;
import com.wscloudclass.model.User;
import com.wscloudclass.model.UserExample;
import com.wscloudclass.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;
    @Autowired
    JoinCourseMapper joinCourseMapper;
    @Autowired
    UserMapper userMapper;
    @GetMapping("/message/{cid}/{teacherid}/{uid}")
    public String message(@PathVariable(name = "cid")Long cid,
                          @PathVariable(name = "teacherid")Long teacherid,
                          @PathVariable(name = "uid")Long uid,
                          @RequestParam(name = "redirect")Integer redirect,
                          @RequestParam(name = "click")Integer click,
                          HttpServletRequest request,
                          Model model){
        model.addAttribute("click",click);//判断是否要点击消息按钮
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        //获取通知信息
        List<CourseInfoDTO> list=messageService.getCourseInfo(cid);
        if (list.size()>0){
            model.addAttribute("courseInfos",list);
            model.addAttribute("message",true);
        }else {
            model.addAttribute("message",false);
        }
        //获取消息成员列表
//        查询是否有成员
        JoinCourseExample example = new JoinCourseExample();
        example.createCriteria().andCidEqualTo(cid);
        List<JoinCourseKey> joinCourseKeys = joinCourseMapper.selectByExample(example);
        List<Long> uids=new ArrayList<>();
        for (JoinCourseKey joinCourseKey:joinCourseKeys){
            uids.add(joinCourseKey.getUid());
        }
        if (uids.size()>0){
            if (!teacherid.equals(user.getUid())){
                //学生查看消息时获取教师信息
                User teacher = userMapper.selectByPrimaryKey(teacherid);
                UserDTO userDTO=new UserDTO();
                BeanUtils.copyProperties(teacher,userDTO);
                userDTO.setUserName(teacher.getUsername());
                model.addAttribute("teacher",userDTO);
            }else if (click==0){
                //教师查看消息列表,定位到一号学生
                UserExample userExample = new UserExample();
                userExample.createCriteria().andUidIn(uids);
                List<User> users = userMapper.selectByExample(userExample);
                Comparator<User> byUserNumber=Comparator.comparing(User::getUserNumber);
                users.sort(byUserNumber);
                uid=users.get(0).getUid();
            }
            List<MessageMemberDTO> messageMemberDTOS=messageService.getMembers(cid,user.getUid());
            model.addAttribute("messageMembers",messageMemberDTOS);
        }else {
            model.addAttribute("disabled",true);
        }
        //定位当前接收者
        model.addAttribute("toUser",uid);
        if (teacherid.equals(user.getUid())&&uids.size()>0){
            if (redirect!=2){
                return "redirect:/message/"+cid+"/"+teacherid+"/"+uid+"?redirect=2&click=0";
            }else {
                return "message";
            }
        }else {
            return "message";
        }
    }
    @ResponseBody
    @PostMapping("/createCourseInfo/{cid}/{teacherid}")
    public String createCourseInfo(@PathVariable(name = "cid")Long cid,
                                   @PathVariable(name = "teacherid")Long teacherid,
                                   @RequestBody CourseInfoDTO courseInfoDTO,
                                   HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        messageService.createCourseInfo(cid,courseInfoDTO);
        Map<String,Boolean> map=new HashMap<>();
        map.put("message",true);
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @GetMapping("/getMessage/{cid}/{teacherid}/{uid}")
    public String getMessage(@PathVariable(name = "cid")Long cid,
                             @PathVariable(name = "teacherid")Long teacherId,
                             @PathVariable(name = "uid")Long uid,
                             HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        List<MessageContentDTO> messages=messageService.getMessage(user.getUid(),uid);
        return JSON.toJSONString(messages);
    }
    @ResponseBody
    @PostMapping("/submitUserMessage/{cid}/{teacherid}/{uid}")
    public String submitUserMessage(@PathVariable(name = "cid")Long cid,
                                    @PathVariable(name = "teacherid") Long teacherid,
                                    @PathVariable(name = "uid")Long uid,
                                    @RequestBody Map map,
                                    HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        messageService.submitUserMessage(user.getUid(),uid,map);
        Map<String,Boolean>result=new HashMap<>();
        result.put("message",true);
        return JSON.toJSONString(result);
    }
}
