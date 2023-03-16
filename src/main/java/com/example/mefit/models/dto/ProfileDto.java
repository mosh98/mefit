package com.example.mefit.models.dto;

import com.example.mefit.models.Goal;
import lombok.Data;

@Data
public class ProfileDto {

    private Integer id;
    private Integer user;
    private String profileImg;
    private Integer weight;
    private Integer height;
    private String medicalCondition;
    private String disabilities;

    private Integer goal;

    private Integer address;
}
