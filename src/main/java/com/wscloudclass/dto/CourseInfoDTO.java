package com.wscloudclass.dto;

import lombok.Data;

import java.util.Date;

/**
 * 接收与展示班课公告
 */
@Data
public class CourseInfoDTO {
    private Long infoId;
    private String infoTitle;
    private String infoContent;
    private Date releaseTime;
}
