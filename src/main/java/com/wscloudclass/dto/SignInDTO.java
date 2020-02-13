package com.wscloudclass.dto;

import lombok.Data;

/**
 * 创建签到
 */
@Data
public class SignInDTO {
    private String signCode;
    private Integer score;
    private Integer minute;
}
