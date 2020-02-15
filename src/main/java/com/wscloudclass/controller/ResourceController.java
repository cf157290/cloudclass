package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.dto.ResourceDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ResourceController {
    @Autowired
    ResourceService resourceService;
    @ResponseBody
    @PostMapping("/uploadResource/{cid}/{teacherid}")
    public String uploadResource(@RequestPart(name = "fileName") Map<String,Object> fileName,
                                 @RequestPart(name = "resource")MultipartFile file,
                                 @PathVariable(name = "cid")Long cid,
                                 @PathVariable(name = "teacherid")Long teacherid,
                                 HttpServletRequest request) throws IOException {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        resourceService.uploadResource((String)fileName.get("userName"),file,cid);
        Map<String,Boolean> map=new HashMap<>();
        map.put("message",true);
        return JSON.toJSONString(map);
    }
    @GetMapping("/resources/{cid}/{teacherid}")
    public String resources(@PathVariable(name = "cid")Long cid,
                            @PathVariable(name = "teacherid")Long teacherid,
                            Model model){
        List<ResourceDTO> list=resourceService.getResources(cid);
        if (list.size()>0){
            model.addAttribute("resources",list);
            model.addAttribute("message",true);
        }else {
            model.addAttribute("message",false);
        }
        return "resources";
    }
}
