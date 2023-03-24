package com.example.mefit.models.dto;

import com.example.mefit.models.Exercise;
import lombok.Data;

import java.util.Set;

@Data
public class WorkoutDTO {

    private int id;
    private String name;
    private String type;
    private boolean completed;

    private Set<Integer> programs; //program ids as a set

    private Set<Exercise> exercises; //excercise ids as a set

    private int goal; //goal id

    private String experienceLevel;

}
