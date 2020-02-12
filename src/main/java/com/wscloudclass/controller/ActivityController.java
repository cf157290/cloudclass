package com.wscloudclass.controller;

import com.wscloudclass.dto.ActivityDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @GetMapping("/activity/{cid}/{teacherid}")
    public String activity(@PathVariable(name = "cid")Long cid,
                           @PathVariable(name = "teacherid")Long teacherid,
                           Model model){
        List<ActivityDTO> list=activityService.getActivity(cid);
        if (list.size()>0){
            model.addAttribute("activitys",list);
        }else {
            model.addAttribute("showImg",true);
        }
        return "activity";
    }
    @GetMapping("/checkActivity/{cid}/{teacherid}/{actId}/{status}/{actType}")
    public String checkActivity(@PathVariable(name = "cid")Long cid,
                                @PathVariable(name = "teacherid")Long teacherid,
                                @PathVariable(name = "actId")Long actId,
                                @PathVariable(name = "status")Integer status,
                                @PathVariable(name = "actType")Integer actType,
                                HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        if (teacherid.equals(user.getUid())){
            //教师操作
            if (actType==1){
                //选择题
                return "redirect:/ranking/"+cid+"/"+teacherid+"/"+actId;
            }else {
                //描述题
                return "redirect:/score/"+cid+"/"+teacherid+"/"+actId;
            }
        }else {
            //学生操作
            if (status==1){//活动是否结束
                //活动进行中
                if (actType==1){
                    //选择题
                    boolean flag=activityService.isParti(actId,user.getUid());//判断是否参与过活动
                    if (flag){
                        //参与过活动
                        return "redirect:/ranking/"+cid+"/"+teacherid+"/"+actId;
                    }else {
                        //未参与活动
                        return "redirect:/answer/"+cid+"/"+teacherid+"/"+actId;
                    }
                }else{
                    //描述题
                    boolean flag=activityService.isParti(actId,user.getUid());
                    if (flag){
                        //参与过
                        return "redirect:/ranking/"+cid+"/"+teacherid+"/"+actId;
                    }else {
                        //未参与
                        return "redirect:/desanswer/"+cid+"/"+teacherid+"/"+actId;
                    }
                }
            }else {
                //活动结束
                return "redirect:/ranking/"+cid+"/"+teacherid+"/"+actId;
            }
        }
    }
}
