package com.wscloudclass.controller;

import com.wscloudclass.dto.DescriptionDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.mapper.ActivityMapper;
import com.wscloudclass.mapper.DescriptionMapper;
import com.wscloudclass.model.Activity;
import com.wscloudclass.model.Description;
import com.wscloudclass.model.DescriptionExample;
import com.wscloudclass.service.ActivityService;
import com.wscloudclass.service.DesAnswerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class DesAnswerController {
    @Autowired
    ActivityService activityService;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    DescriptionMapper descriptionMapper;
    @Autowired
    DesAnswerService desAnswerService;
    @GetMapping("/desanswer/{cid}/{teacherid}/{actId}")
    public String desAnswer(@PathVariable(name = "cid")Long cid,
                            @PathVariable(name = "teacherid")Long teacherid,
                            @PathVariable(name = "actId")Long actId,
                            HttpServletRequest request,
                            Model model){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (teacherid.equals(user.getUid())){
            return "score";
        }
        boolean flag=activityService.isParti(actId,user.getUid());
        if (flag){
            //已经参与过活动
            return "redirect:/ranking/"+cid+"/"+teacherid+"/"+actId;
        }else {
            Activity activity = activityMapper.selectByPrimaryKey(actId);
            model.addAttribute("actName",activity.getActivityName());
            DescriptionDTO descriptionDTO=new DescriptionDTO();
            descriptionDTO.setSubTime(activity.getStartTime());
            Description description = descriptionMapper.selectByPrimaryKey(activity.getDesId());
            BeanUtils.copyProperties(description,descriptionDTO);
            model.addAttribute("description",descriptionDTO);
            return "desanswer";
        }
    }
    @PostMapping("/submitDescription/{cid}/{teacherid}/{actId}")
    public String submitDescription(@PathVariable(name = "cid")Long cid,
                                    @PathVariable(name = "teacherid")Long teacherid,
                                    @PathVariable(name = "actId")Long actId,
                                    MultipartFile file,
                                    HttpServletRequest request) throws IOException {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_SUBMIT_SELECTION);
        }
        boolean flag=desAnswerService.insertUserAnswer(user.getUid(),actId,file);
        if (flag){
            return "redirect:/ranking/"+cid+"/"+teacherid+"/"+actId;
        }else {
            throw new CustomizeException(CustomizeErrorCode.ERROR_SUBMIT_DESACTIVITY);
        }
    }
}
