package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.component.ExcelUtils;
import com.wscloudclass.dto.ExportDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.exception.CustomizeErrorCode;
import com.wscloudclass.exception.CustomizeException;
import com.wscloudclass.mapper.JoinCourseMapper;
import com.wscloudclass.model.JoinCourseExample;
import com.wscloudclass.model.JoinCourseKey;
import com.wscloudclass.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExportComtroller {
    @Autowired
    ExportService exportService;
    @Autowired
    JoinCourseMapper joinCourseMapper;
    @GetMapping("/export/{cid}/{teacherid}")
    public void export(@PathVariable("cid")Long cid,
                         @PathVariable("teacherid")Long teacherid,
                         HttpServletRequest request,
                         HttpServletResponse response) throws UnsupportedEncodingException {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        List<ExportDTO> list=exportService.getStuScore(cid);
        if (list.size()>0){
            String[] str=new String[]{"编号","姓名","学号","成绩"};
            ExcelUtils.export(response,list,str);
        }
    }
    @ResponseBody
    @GetMapping("/checkMember/{cid}/{teacherid}")
    public String checkMember(@PathVariable(name = "cid")Long cid,
                              @PathVariable(name = "teacherid")Long teacherid,
                              HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        if (!teacherid.equals(user.getUid())){
            throw new CustomizeException(CustomizeErrorCode.ERROR_CREATE_ACTIVITY);
        }
        JoinCourseExample example = new JoinCourseExample();
        example.createCriteria().andCidEqualTo(cid);
        List<JoinCourseKey> joinCourseKeys = joinCourseMapper.selectByExample(example);
        Map<String,Boolean> map=new HashMap<>();
        if (joinCourseKeys.size()>0){
            map.put("message",true);
        }else {
            map.put("message",false);
        }
        return JSON.toJSONString(map);
    }
}
