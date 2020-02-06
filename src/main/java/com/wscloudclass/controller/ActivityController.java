package com.wscloudclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivityController {
    @RequestMapping("/activity")
    public String activity(){
        return "activity";
    }
}
