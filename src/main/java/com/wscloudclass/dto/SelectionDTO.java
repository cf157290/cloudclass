package com.wscloudclass.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SelectionDTO {
    private Long selId;
    private String selContent;
   // private MultipartFile img;
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
