package com.wscloudclass.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 创建描述题，收集页面元素
 */
@Data
public class CreateDesDTO {
    private String activityName;
    private String desContent;
    private MultipartFile file;
    private Integer score;
    private Integer duration;
}
