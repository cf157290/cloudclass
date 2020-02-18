package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.dto.ModInfoDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @GetMapping("/userInfo")
    public String UserInfo(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        model.addAttribute("userInfo",user);
        return "userinfo";
    }
    @GetMapping("/modInfo")
    public String modInfo(){
        return "modinfo";
    }
    @ResponseBody
    @PostMapping("/updateUserInfo")
    public String updateUserInfo(ModInfoDTO modInfoDTO,HttpServletRequest request) throws IOException {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("token")){
                userInfoService.updateUserInfo(cookie,modInfoDTO,user.getUid(),request);
            }
        }
        Map<String,Boolean> map=new HashMap<>();
        map.put("message",true);
        return JSON.toJSONString(map);
    }
    @GetMapping("/changePassword")
    public String changePassword(){
        return "changepassword";
    }
    @PostMapping("/submitPassword")
    public String submitPassword(String email, String oldPassword, String newPassword,Model model){
        boolean flag=userInfoService.changePassword(email,oldPassword,newPassword);
        if (flag){
            //修改成功
            return "changesuccess";
        }else {
            //修改失败
            model.addAttribute("message",true);
            return "changepassword";
        }
    }
}
