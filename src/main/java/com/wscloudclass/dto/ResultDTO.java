package com.wscloudclass.dto;

import lombok.Data;

/**
 * 答题结果信息展示
 */
@Data
public class ResultDTO {
    private Long selId;
    private Integer selNum;
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
    private String correctOption;
    private String yourOption;
    private Integer accRate;
    private Integer chooseA;
    private Integer chooseB;
    private Integer chooseC;
    private Integer chooseD;
    private Boolean haveAna;
    private String selAna;
}
