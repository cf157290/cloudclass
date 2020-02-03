package com.wscloudclass.controller;

import com.wscloudclass.dto.RegisterDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.User;
import com.wscloudclass.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    //@Autowired
   // UserDTO userDTO;
    @PostMapping("/register")
    public String register(RegisterDTO registerDTO){
        registerDTO.setCreateTime(new Date());
        User user=new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());
        user.setEmail(registerDTO.getEmail());
        user.setUserNumber(registerDTO.getNumber());
        user.setCreateTime(registerDTO.getCreateTime());
        userMapper.insertSelective(user);
        return "success";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password,
                        HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse,
                        Model model){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<User> list=userMapper.selectByExample(userExample);
        if (list.size()==1){
            String token= UUID.randomUUID().toString();
            Cookie cookie=new Cookie("token",token);
            httpServletResponse.addCookie(cookie);
            UserDTO userDTO=new UserDTO();
            userDTO.setEmail(list.get(0).getEmail());
            userDTO.setUserName(list.get(0).getUsername());
            userDTO.setUserNumber(list.get(0).getUserNumber());
            userDTO.setImgUrl(list.get(0).getImgUrl());
            userDTO.setBirthday(list.get(0).getBirthday());
            userDTO.setCollegeDapartments(list.get(0).getCollegeDapartments());
            userDTO.setSchool(list.get(0).getSchool());
            httpServletRequest.getSession().setAttribute(token,userDTO);
            redisTemplate.opsForValue().set(token,userDTO);
            redisTemplate.expire(token,10, TimeUnit.DAYS);
            return "redirect:/index";
        }
        model.addAttribute("erruser",true);
        return "/login";
    }
}