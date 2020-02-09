package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.dto.SelectionDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.service.InitSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InitSeController {
    @Autowired
    InitSeService initSeService;
    @GetMapping("/initse/{cid}/{teacherid}")
    public String initSe(@PathVariable(name = "cid") Long cid,
                         @PathVariable(name = "teacherid") Long teacherid){
        return "initse";
    }
    @ResponseBody
    @PostMapping("/createSelActivity/{cid}/{teacherid}")
    public String createSelActivity(@PathVariable(name = "cid") Long cid,
                                    @PathVariable(name = "teacherid") Long teacherid,
                                    @RequestPart(name = "imgs") List<MultipartFile> imgs,
                                    @RequestPart(name = "selection") List<SelectionDTO> selectionDTOS,
                                    @RequestPart(name = "activityName") String activityName,
                                    @RequestPart(name = "duration")String duration,
                                    HttpServletRequest request) throws IOException{
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");
        Long uid=user.getUid();
        if (!teacherid.equals(uid)){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        boolean flag=initSeService.createSeActivity(cid,imgs,selectionDTOS,activityName,duration);
        if (flag){
            Map<String,Boolean> map=new HashMap();
            map.put("message",true);
            return JSON.toJSONString(map);
        }else {
            Map<String,Boolean> map=new HashMap();
            map.put("message",false);
            return JSON.toJSONString(map);
        }
    }
}
