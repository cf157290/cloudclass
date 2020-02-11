package com.wscloudclass.controller;

import com.wscloudclass.dto.CreateDesDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.service.InitDesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class InitDesController {
    @Autowired
    InitDesService initDesService;
    @GetMapping("/initdes/{cid}/{teacherid}")
    public String initdes(@PathVariable(name = "cid")Long cid,
                          @PathVariable(name = "teacherid")Long teacherid,
                          HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        return "initdes";
    }
    @PostMapping("createDesActivity/{cid}/{teacherid}")
    public String createDesActivity(@PathVariable(name = "cid")Long cid,
                                    @PathVariable(name = "teacherid")Long teacherid,
                                    HttpServletRequest request,
                                    CreateDesDTO createDesDTO) throws IOException {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        boolean flag=initDesService.createDesActivity(cid,createDesDTO);
        if (flag){
            return "redirect:/activity/"+cid+"/"+teacherid;
        }else {
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_DESACTIVITY);
        }
    }
}
