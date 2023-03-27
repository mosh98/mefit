package com.example.mefit.models.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class WorkoutStatsDTO {

    /**
     * This class is used to return the stats of a workout
     */

    private Integer remainingWorkouts;

    private Integer completedWorkouts;

    private Integer totalWorkouts;
    private HashMap<String,Integer> muscleGroupStats;
}
