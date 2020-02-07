package com.wscloudclass.controller;

import com.wscloudclass.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserInfoController {
    @GetMapping("/userInfo")
    public String UserInfo(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        model.addAttribute("userInfo",user);
        return "userinfo";
    }
}
