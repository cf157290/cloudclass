package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.dto.CourseDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DetailsController {
    @Autowired
    DetailsService detailsService;
    @GetMapping("/details/{cid}")
    public String details(@PathVariable(name = "cid")Long cid,
                          Model model){
        CourseDTO courseDTO=detailsService.getDetails(cid);
        model.addAttribute("course",courseDTO);
        model.addAttribute("teacherid",courseDTO.getTeacherid());
        return "details";
    }
    @ResponseBody
    @GetMapping("/outCourse/{cid}/{teacherid}")
    public String outCourse(@PathVariable(name = "cid")Long cid,
                            @PathVariable(name = "teacherid")Long teacherid,
                            HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        detailsService.outCourse(cid,teacherid,user.getUid());
        Map<String,Boolean> map=new HashMap<>();
        map.put("message",true);
        return JSON.toJSONString(map);
    }
}
