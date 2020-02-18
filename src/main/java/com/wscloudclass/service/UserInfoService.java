package com.wscloudclass.service;

import com.wscloudclass.component.AliyunOSSUtils;
import com.wscloudclass.dto.ModInfoDTO;
import com.wscloudclass.dto.UserDTO;
import com.wscloudclass.mapper.UserMapper;
import com.wscloudclass.model.User;
import com.wscloudclass.model.UserExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class UserInfoService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AliyunOSSUtils aliyunOSSUtils;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    public void updateUserInfo(Cookie cookie, ModInfoDTO modInfoDTO, Long uid, HttpServletRequest request) throws IOException {
        //更新数据库
        User record = new User();
        if (modInfoDTO.getImg()!=null){
            record.setImgUrl(aliyunOSSUtils.uploadImgFile(modInfoDTO.getImg()));
        }
        if (modInfoDTO.getBirthday()!=null&&!modInfoDTO.getBirthday().equals("")){
            /*SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH;mm:ss");
            Date birthday=simpleDateFormat.parse(String.valueOf(modInfoDTO.getBirthday()));*/
            record.setBirthday(modInfoDTO.getBirthday());
        }
        if (modInfoDTO.getCollegeDepartment()!=null&&!modInfoDTO.getCollegeDepartment().equals("")){
            record.setCollegeDepartment(modInfoDTO.getCollegeDepartment());
        }
        if (modInfoDTO.getSchool()!=null&&!modInfoDTO.getSchool().equals("")){
            record.setSchool(modInfoDTO.getSchool());
        }
        if (modInfoDTO.getUserName()!=null&&!modInfoDTO.getUserName().equals("")){
            record.setUsername(modInfoDTO.getUserName());
        }
        if (modInfoDTO.getUserNumber()!=null&&!modInfoDTO.getUserNumber().equals("")){
            record.setUserNumber(modInfoDTO.getUserNumber());
        }
        UserExample example = new UserExample();
        example.createCriteria().andUidEqualTo(uid);
        userMapper.updateByExampleSelective(record, example);
        //更新session与缓存
        RedisSerializer redisSerializer=new StringRedisSerializer();
        RedisSerializer redisSerializervalue=new Jackson2JsonRedisSerializer(UserDTO.class);
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializervalue);
        UserDTO userDTO=new UserDTO();
        User user = userMapper.selectByPrimaryKey(uid);
        BeanUtils.copyProperties(user,userDTO);
        userDTO.setUserName(user.getUsername());
        request.getSession().setAttribute("user",userDTO);
        redisTemplate.opsForValue().set(cookie.getValue(),userDTO);
        redisTemplate.expire(cookie.getValue(),10, TimeUnit.DAYS);
    }
}
