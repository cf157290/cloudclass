package com.wscloudclass.dto;

import lombok.Data;

import java.util.Date;

/**
 * 教师评分页面相关属性
 */
@Data
public class ScoreDTO {
    private Long uid;
    private String userName;
    private Long userNumber;
    private String fileName;
    private String fileUrl;
    private Date partiTime;
    private Integer score;
}
