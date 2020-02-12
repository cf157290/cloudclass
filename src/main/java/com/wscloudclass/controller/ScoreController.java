package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.dto.ScoreDTO;
import com.wscloudclass.dto.SubmitUserScoreDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.mapper.ActivityMapper;
import com.wscloudclass.model.Activity;
import com.wscloudclass.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @Autowired
    ActivityMapper activityMapper;
    @GetMapping("/score/{cid}/{teacherid}/{actId}")
    public String score(@PathVariable(name = "cid")Long cid,
                        @PathVariable(name = "teacherid")Long teacherid,
                        @PathVariable(name = "actId")Long actId,
                        HttpServletRequest request,
                        Model model){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            //不是教师
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        Activity activity = activityMapper.selectByPrimaryKey(actId);
        List<ScoreDTO>list=scoreService.selectSubmit(actId);
        model.addAttribute("actName",activity.getActivityName());
        if (list.size()>0){
            model.addAttribute("scores",list);
            model.addAttribute("canSubmit",true);
        }else {
            model.addAttribute("canSubmit",false);
            model.addAttribute("isnone",true);
        }
        return "score";
    }
    @ResponseBody
    @PostMapping("/submitUserScore/{cid}/{teacherid}/{actId}")
    public String submitUserScore(@PathVariable(name = "cid")Long cid,
                                  @PathVariable(name = "teacherid")Long teacherid,
                                  @PathVariable(name = "actId")Long actid,
                                  @RequestBody List<SubmitUserScoreDTO> submitUserScoreDTOS,
                                  HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        boolean flag=scoreService.updateUserScore(actid,submitUserScoreDTOS);
        Map<String,Boolean> map=new HashMap<>();
        if (flag){
            map.put("message",true);
            return JSON.toJSONString(map);
        }else {
            map.put("message",false);
            return JSON.toJSONString(map);
        }
    }
}
