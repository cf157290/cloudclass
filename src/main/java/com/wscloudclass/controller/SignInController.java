package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.dto.CompleteSignInDTO;
import com.wscloudclass.dto.SignInDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.mapper.SignInMapper;
import com.wscloudclass.model.SignIn;
import com.wscloudclass.model.SignInExample;
import com.wscloudclass.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SignInController {
    @Autowired
    SignInService signInService;
    @Autowired
    SignInMapper signInMapper;
    @ResponseBody
    @GetMapping("/checkSignIn/{cid}/{teacherid}")
    public String checkSignIn(@PathVariable(name = "cid")Long cid,
                              @PathVariable(name = "teacherid")Long teacherid){
        boolean flag=signInService.haveSignIn(cid);
        Map<String,Boolean> map=new HashMap<>();
        if (flag){
            //存在未结束的签到
            map.put("message",false);
        }else {
            map.put("message",true);
        }
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @PostMapping("/createSignIn/{cid}/{teacherid}")
    public String createSignIn(@PathVariable(name = "cid")Long cid,
                               @PathVariable(name = "teacherid")Long teacherid,
                               @RequestBody SignInDTO signInDTO,
                               HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        boolean flag=signInService.createSignIn(cid,signInDTO);
        Map<String,Boolean> map=new HashMap<>();
        if (flag){
            map.put("message",true);
        }else {
            map.put("message",false);
        }
        return JSON.toJSONString(map);
    }
    @GetMapping("/signIn/{cid}/{teacherid}")
    public String signIn(@PathVariable(name = "cid")Long cid,
                         @PathVariable(name = "teacherid")Long teacherid){
        boolean flag=signInService.haveSignIn(cid);
        if (flag){
            //存在进行的签到
            return "signin";
        }else {
            //不存在签到，强制跳转
            return "redirect:/activity/"+cid+"/"+teacherid;
        }
    }
    @ResponseBody
    @PostMapping("/submitSignInCode/{cid}/{teacherid}")
    public String submitSignInCode(@PathVariable(name = "cid")Long cid,
                                   @PathVariable(name = "teacherid")Long teacherid,
                                   @RequestBody Map<String,Object> code,
                                   HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_SIGN_IN);
        }
        int flag=signInService.signIn(cid,user.getUid(), (String) code.get("code"));
        Map<String,Boolean> map=new HashMap<>();
        if (flag==1){
            //签到成功
            map.put("message",true);
        }
        if (flag==2){
            //签到码错误
            map.put("errCode",true);
        }
        if (flag==3){
            map.put("doubleSign",true);
        }
        if (flag==4){
            map.put("signEnd",true);
        }
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @GetMapping("lookSignIn/{cid}")
    public String lookSignIn(@PathVariable(name = "cid")Long cid){
        Map<String,Object> map=new HashMap<>();
        //查询签到活动是否结束
        SignInExample example = new SignInExample();
        example.createCriteria().andCidEqualTo(cid);
        List<SignIn> signIns = signInMapper.selectByExample(example);
        for (SignIn signIn:signIns){
            if (signIn.getEndTime().after(new Date())){
                //存在正在进行的活动
                List<CompleteSignInDTO> list=signInService.lookSignIn(cid);
                map.put("message",true);
                map.put("signIn",list);
                return JSON.toJSONString(map);
            }
        }
        map.put("message",false);
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @GetMapping("/endSignIn/{cid}/{teacherid}")
    public String endSignIn(@PathVariable(name = "cid")Long cid,
                            @PathVariable(name = "teacherid")Long teacherid,
                            HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        boolean flag=signInService.endSignIn(cid);
        Map<String,Boolean> map=new HashMap<>();
        if (flag){
            //成功结束签到
            map.put("message",true);
        }
        return JSON.toJSONString(map);
    }
    @ResponseBody
    @GetMapping("/getSignInCode/{cid}")
    public String getSignInCode(@PathVariable(name = "cid")Long cid){
        String signInCode=signInService.findSignInCode(cid);
        Map<String,String> map=new HashMap();
        map.put("signInCode",signInCode);
        return JSON.toJSONString(map);
    }
}
