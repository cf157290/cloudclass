package com.wscloudclass.dto;

import lombok.Data;

import java.util.Date;

/**
 * 聊天内容信息展示
 */
@Data
public class MessageContentDTO {
    private Long sendId;
    private Long toId;
    private String userName;
    private String imgUrl;
    private Date sendTime;
    private String messageContent;
}
