package com.wscloudclass.dto;

import lombok.Data;

/**
 * 收藏页面信息展示
 */
@Data
public class CollectionDTO {
    private String courseName;
    private Long selId;
    private String selContent;
    private Boolean haveImg;
    private String imgUrl;
    private String a;
    private String b;
    private Boolean haveC;
    private String c;
    private Boolean haveD;
    private String d;
    private Boolean aTrue;
    private Boolean bTrue;
    private Boolean cTrue;
    private Boolean dTrue;
    private Boolean haveAna;
    private String selAna;
}
