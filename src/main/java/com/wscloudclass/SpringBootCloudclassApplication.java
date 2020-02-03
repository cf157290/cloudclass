package com.wscloudclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wscloudclass.mapper")
public class SpringBootCloudclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCloudclassApplication.class, args);
    }

}
