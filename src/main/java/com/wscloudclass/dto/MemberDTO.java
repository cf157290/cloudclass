package com.wscloudclass.dto;

import lombok.Data;

import java.util.List;

/**
 * 成员页面相关属性展示
 */
@Data
public class MemberDTO {
    private List<UserDTO> users;//成员列表
    private UserDTO user;//当前学生信息
    private Integer score;
    private Integer completeSignIn;
    private Integer totalSignIn;
    private Integer completeActivity;
    private Integer totalActivity;
    private Integer downloadResources;
    private Integer totalResources;
    private Integer signInProgress;
    private Integer activityProgress;
    private Integer resourceProgress;
}
