package com.wscloudclass;

import com.wscloudclass.dto.UserDTO;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCloudclassApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
        UserDTO userDTO=new UserDTO();
        userDTO.setSchool("aa");
        userDTO.setImgUrl("aaaaaa");
        userDTO.setUserNumber(123L);
        redisTemplate.opsForValue().set("1005e08a-a7ee-4d91-b192-5f352c6adf01",userDTO);
        UserDTO user = (UserDTO) redisTemplate.opsForValue().get("1005e08a-a7ee-4d91-b192-5f352c6adf01");
        if (user!=null){
            System.out.println(user);
        }
    }

}
