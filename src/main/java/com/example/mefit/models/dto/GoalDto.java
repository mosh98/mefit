package com.example.mefit.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GoalDto {
    private int id;
    private Date endDate;
    private boolean achieved;
    private boolean active;
    private int profile;

    //private


}
