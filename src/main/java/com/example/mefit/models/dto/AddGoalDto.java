package com.example.mefit.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class AddGoalDto {


    private String keyCloakId;



    private List<Integer> workouts;
}
