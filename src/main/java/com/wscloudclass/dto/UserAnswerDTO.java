package com.wscloudclass.dto;

import lombok.Data;

/**
 * 存放用户回答选择题的信息
 */
@Data
public class UserAnswerDTO {
    private Long selId;
    private String userSelect;
}
