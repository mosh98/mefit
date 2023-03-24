package com.example.mefit.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GoalDto {
    private int id;
    private String endDate;
    private boolean achieved;
    private boolean active;
    private int profile;

    //private


}
