package com.wscloudclass.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDTO implements Serializable {
    private String email;
    private String userName;
    private Long userNumber;
    private String imgUrl;
    private Date birthday;
    private String collegeDapartments;
    private String school;
}
