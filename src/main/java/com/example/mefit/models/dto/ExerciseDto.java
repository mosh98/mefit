package com.example.mefit.models.dto;

import lombok.Data;

@Data
public class ExerciseDto {
    //create fields for DTO from Exercise
    private Integer id;
    private String name;
    private String description;
    private String muscleGroup;
    private String exerciseImageLink;
    private String videoLink;
    private int reps;
    private int sets;
    private boolean completed;
    private String userExperience;

    private Integer workout;
}
