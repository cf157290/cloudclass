package com.wscloudclass.dto;

import lombok.Data;

/**
 * 消息列表侧边栏信息展示
 */
@Data
public class MessageMemberDTO {
    private Long uid;
    private Long userNumber;
    private String userName;
    private String imgUrl;
    private Integer messageCount;
}
