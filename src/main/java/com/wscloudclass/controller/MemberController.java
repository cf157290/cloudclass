package com.wscloudclass.controller;

import com.wscloudclass.dto.MemberDTO;
import com.wscloudclass.mapper.JoinCourseMapper;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.JoinCourseExample;
import com.wscloudclass.model.JoinCourseKey;
import com.wscloudclass.model.User;
import com.wscloudclass.model.UserExample;
import com.wscloudclass.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    @Autowired
    JoinCourseMapper joinCourseMapper;
    @Autowired
    UserMapper userMapper;
    @GetMapping("/member/{cid}/{teacherid}/{uid}")
    public String member(@PathVariable(name = "cid")Long cid,
                         @PathVariable(name = "teacherid")Long teacherid,
                         @PathVariable(name = "uid")Long uid,
                         Model model){
        JoinCourseExample example = new JoinCourseExample();
        example.createCriteria().andCidEqualTo(cid);
        List<JoinCourseKey> joinCourseKeys = joinCourseMapper.selectByExample(example);
        if (joinCourseKeys.size()>0){
            //班课有成员加入
            if (teacherid==uid||teacherid.equals(uid)){
                //如果是教师默认展示学号第一的学生信息
                if (joinCourseKeys.size()>0){
                    List<Long> list=new ArrayList<>();
                    for (JoinCourseKey joinCourseKey:joinCourseKeys){
                        list.add(joinCourseKey.getUid());
                    }
                    UserExample userExample = new UserExample();
                    userExample.createCriteria().andUidIn(list);
                    List<User> users = userMapper.selectByExample(userExample);
                    Comparator<User> byUserNumber=Comparator.comparing(User::getUserNumber);
                    users.sort(byUserNumber);
                    uid=users.get(0).getUid();
                }
            }
            MemberDTO memberDTO=memberService.getMemberRecords(cid,uid);
            model.addAttribute("memberDTO",memberDTO);
            model.addAttribute("message",true);
        }else {
            //无成员加入
            model.addAttribute("message",false);
        }
        return "member";
    }
}
