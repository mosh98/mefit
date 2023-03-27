package com.example.mefit.models.dto;

import java.util.HashMap;

public class WorkoutStatsDTO {

    /**
     * This class is used to return the stats of a workout
     */

    private Integer remainingWorkouts;

    private Integer CompletedWorkouts;

    private Integer totalWorkouts;
    private HashMap<String,Integer> muscleGroupStats;
}
