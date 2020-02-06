package com.wscloudclass.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;

@Data
public class CourseDTO {
    private String school;
    private String collegeDepartment;
    private String className;
    private String courseName;
    private MultipartFile file;
    private String startTime;
    private String endTime;
}
