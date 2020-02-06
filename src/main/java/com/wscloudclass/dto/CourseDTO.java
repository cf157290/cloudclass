package com.wscloudclass.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CourseDTO {
    private Long cid;
    private String invitCode;
    private String courseUrl;
    private String courseName;
    private String className;
    private String collegeDepartment;
    private String school;
    private Date startTime;
    private Date endTime;
    private Long teacherid;
    private String teacherName;
}
