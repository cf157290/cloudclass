package com.wscloudclass.dto;

import lombok.Data;

/**
 * 发布选择题活动相关属性，收集页面元素
 */
@Data
public class SelectionDTO {
    private Long selId;
    private String selContent;
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean checkA;
    private boolean checkB;
    private boolean checkC;
    private boolean checkD;
    private int score;
    private String analysis;
    private boolean haveImg;
}
