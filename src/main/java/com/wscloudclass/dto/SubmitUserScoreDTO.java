package com.wscloudclass.dto;

import lombok.Data;

/**
 * 接收教师提交的学生成绩
 */
@Data
public class SubmitUserScoreDTO {
    private Long uid;
    private Integer score;
}
