package com.wscloudclass.controller;

import com.alibaba.fastjson.JSON;
import com.wscloudclass.dto.CollectionDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.mapper.UserFavMapper;
import com.wscloudclass.model.UserFavExample;
import com.wscloudclass.model.UserFavKey;
import com.wscloudclass.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CollectionController {
    @Autowired
    UserFavMapper userFavMapper;
    @Autowired
    CollectionService collectionService;
    @ResponseBody
    @GetMapping("collectionSelect/{selId}")
    public String collectionSelect(@PathVariable(name = "selId")Long selId,
                                   HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        UserFavExample example = new UserFavExample();
        example.createCriteria().andSelIdEqualTo(selId).andUidEqualTo(user.getUid());
        long count = userFavMapper.countByExample(example);
        Map <String,Boolean> map=new HashMap<>();
        if (count==1){
            //已经收藏过该题目
            map.put("message",false);
        }else {
            UserFavKey record = new UserFavKey();
            record.setSelId(selId);
            record.setUid(user.getUid());
            userFavMapper.insert(record);
            map.put("message",true);
        }
        return JSON.toJSONString(map);
    }
    @GetMapping("/collection")
    public String collection(HttpServletRequest request,
                             Model model){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        List<CollectionDTO> list=collectionService.getUserFav(user.getUid());
        if (list.size()>0){
            model.addAttribute("message",true);
            model.addAttribute("selections",list);
        }else {
            model.addAttribute("message",false);
        }
        return "collection";
    }
    @ResponseBody
    @GetMapping("/deleteCollection/{selId}")
    public String deleteCollection(@PathVariable(name = "selId")Long selId,
                                   HttpServletRequest request){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        UserFavKey key = new UserFavKey();
        key.setUid(user.getUid());
        key.setSelId(selId);
        userFavMapper.deleteByPrimaryKey(key);
        Map<String,Boolean> map=new HashMap<>();
        map.put("message",true);
        return JSON.toJSONString(map);
    }
}
