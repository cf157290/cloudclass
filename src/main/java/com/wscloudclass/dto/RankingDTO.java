package com.wscloudclass.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RankingDTO {
    private String userName;
    private Long userNumber;
    private Integer score;
    private Date partiTime;
}
