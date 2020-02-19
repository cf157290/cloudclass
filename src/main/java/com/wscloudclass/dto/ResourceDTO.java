package com.wscloudclass.dto;

import lombok.Data;

import java.util.Date;

/**
 * 资源页信息展示
 */
@Data
public class ResourceDTO {
    private Long resourceId;
    private String resourceName;
    private Integer resourceSize;
    private Date uploadTime;
    private String resourceUrl;
}
