package com.example.mefit.models.dto;

import com.example.mefit.models.Workout;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GoalDto {
    private int id;
    private String endDate;
    private boolean achieved;
    private boolean active;
    private int profile;

    private List<Workout> workouts;

    //private


}
