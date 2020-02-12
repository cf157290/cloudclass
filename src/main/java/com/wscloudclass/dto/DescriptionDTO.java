package com.wscloudclass.dto;

import lombok.Data;

import java.util.Date;

/**
 * 用于用户回答描述题时展示相关属性
 */
@Data
public class DescriptionDTO {
    private Long desId;
    private String desContent;
    private String fileName;
    private String fileUrl;
    private Integer fileSize;
    private Integer score;
    private Date subTime;//发布时间
}
