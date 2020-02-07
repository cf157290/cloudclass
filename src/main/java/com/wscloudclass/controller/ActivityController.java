package com.wscloudclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ActivityController {
    @GetMapping("/activity/{cid}/{teacherid}")
    public String activity(@PathVariable(name = "cid")Long cid,
                           @PathVariable(name = "teacherid")Long teacherid,
                           Model model){
        model.addAttribute("teacherid",teacherid);
        return "activity";
    }
}
