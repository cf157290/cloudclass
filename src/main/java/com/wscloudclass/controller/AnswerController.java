package com.wscloudclass.controller;

import com.wscloudclass.dto.AnswerDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.mapper.ActivityMapper;
import com.wscloudclass.model.Activity;
import com.wscloudclass.service.ActivityService;
import com.wscloudclass.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AnswerController {
    @Autowired
    ActivityService activityService;
    @Autowired
    AnswerService answerService;
    @Autowired
    ActivityMapper activityMapper;
    @GetMapping("/answer/{cid}/{teacherid}/{actId}")
    public String answer(@PathVariable(name = "cid")Long cid,
                         @PathVariable(name = "teacherid")Long teacherid,
                         @PathVariable(name = "actId")Long actId,
                         HttpServletRequest request,
                         Model model){
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        if (teacherid.equals(user.getUid())){
            //如果是教师强制跳转
            return "ranking";
        }else {
            boolean flag=activityService.isParti(actId,user.getUid());//判断是否参与过活动
            if (flag){
                return "ranking";
            }else {
                Activity activity = activityMapper.selectByPrimaryKey(actId);
                List<AnswerDTO> list=answerService.getSelection(actId);
                model.addAttribute("selections",list);
                model.addAttribute("activityName",activity.getActivityName());
                return "answer";
            }
        }
    }
}
