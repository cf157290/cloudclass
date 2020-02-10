package com.wscloudclass.dto;

import lombok.Data;

/**
 * 选择题相关属性，展示选择题
 */
@Data
public class AnswerDTO {
    private Long selId;
    private Integer selNum;
    private String selContent;
    private String imgUrl;
    private String a;
    private String b;
    private String c;
    private String d;
    private String selAna;
    private Integer score;
    private String correctOption;
    private Integer oneOrMore;//单选还是多选
}
