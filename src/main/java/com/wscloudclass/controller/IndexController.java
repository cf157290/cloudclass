package com.wscloudclass.controller;

import com.wscloudclass.dto.CourseDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    IndexService indexService;
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        List<CourseDTO> list=indexService.selectCourseById(user.getUid());
        if (list.size()!=0){
            model.addAttribute("courses",list);
        }
        return "/index";
    }
}
