package com.wscloudclass.controller;

import com.wscloudclass.dto.RankingDTO;
import com.wscloudclass.mapper.ActivityMapper;
import com.wscloudclass.model.Activity;
import com.wscloudclass.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RankingController {
    @Autowired
    RankingService rankingService;
    @Autowired
    ActivityMapper activityMapper;
    @GetMapping("/ranking/{cid}/{teacherid}/{actId}")
    public String ranking(@PathVariable(name = "cid")Long cid,
                          @PathVariable(name = "teacherid")Long teacherid,
                          @PathVariable(name = "actId")Long actId,
                          Model model){
        List<RankingDTO> list=rankingService.getRanking(actId);
        Activity activity = activityMapper.selectByPrimaryKey(actId);
        model.addAttribute("activityName",activity.getActivityName());
        if(list.size()>0){
            model.addAttribute("rankings",list);
        }else {
            model.addAttribute("isnull",true);
        }
        return "ranking";
    }

}
