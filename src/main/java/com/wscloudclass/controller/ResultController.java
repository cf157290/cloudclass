package com.wscloudclass.controller;

import com.wscloudclass.dto.ResultDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.mapper.ActivityMapper;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.Activity;
import com.wscloudclass.model.User;
import com.wscloudclass.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ResultController {
    @Autowired
    ResultService resultService;
    @Autowired
    ActivityMapper activityMapper;
    @GetMapping("/result/{cid}/{teacherid}/{actId}")
    public String result(@PathVariable(name = "cid")Long cid,
                         @PathVariable(name = "teacherid")Long teacherid,
                         @PathVariable(name = "actId")Long actId,
                         HttpServletRequest request,
                         Model model){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        List<ResultDTO> list=resultService.findResult(actId,teacherid,user.getUid());
        model.addAttribute("selections",list);
        Activity activity = activityMapper.selectByPrimaryKey(actId);
        model.addAttribute("actName",activity.getActivityName());
        if (!teacherid.equals(user.getUid())){
            int score=resultService.getUserScore(actId,user.getUid());
            model.addAttribute("score",score);
            model.addAttribute("userName",user.getUserName());
            model.addAttribute("userNumber",user.getUserNumber());
        }
        return "result";
    }
}
