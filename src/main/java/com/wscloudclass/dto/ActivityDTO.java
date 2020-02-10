package com.wscloudclass.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ActivityDTO {
    private Long actId;
    private String activityName;
    private Integer actType;//1代表选择题
    private Integer status;//1代表活动进行中
    private Date startTime;
    private Date endTime;
    private Long sumPati;//参与人数
    private Long totalItem;//题目总数
}
