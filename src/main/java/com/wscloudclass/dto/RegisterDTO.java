package com.wscloudclass.dto;


import lombok.Data;

import java.util.Date;

@Data
public class RegisterDTO {
    private String email;
    private String password;
    private String username;
    private Long number;
    private Date createTime;
}
