package com.wscloudclass.dto;

import lombok.Data;

import java.util.Date;

/**
 * 完成签到页面信息展示
 */
@Data
public class CompleteSignInDTO {
    private UserDTO user;
    private Date signDate;
}
