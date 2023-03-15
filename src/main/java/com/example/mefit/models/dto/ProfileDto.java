package com.example.mefit.models.dto;

import com.example.mefit.models.Goal;
import lombok.Data;

@Data
public class ProfileDto {

    private int id;
    private int user;
    private String profile_img;
    private int weight;
    private int height;
    private String medical_condition;
    private String disabilities;

    private int goal;

    private int address;
}
