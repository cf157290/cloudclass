package com.wscloudclass.dto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


/**
 * 接收用户修改的信息
 */
@Data
public class ModInfoDTO {
    private MultipartFile img;
    private String userName;
    private Long userNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String school;
    private String collegeDepartment;
}
