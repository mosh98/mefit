package com.example.mefit.controller.workout;


import com.example.mefit.mapper.WorkoutMapper;
import com.example.mefit.models.Workout;
import com.example.mefit.models.dto.WorkoutDTO;
import com.example.mefit.services.workout.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    //TODO: instiantiation of workoutService
    private final WorkoutService workoutService;

    //TODO instiantiation of workoutMapper

    private final WorkoutMapper workoutMapper;

    //GET all workouts
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<WorkoutDTO> getAllWorkouts(){

        //find all from service
        List<Workout> workouts = workoutService.findAll();

        //loop through each workout and convert into dto and store it in a list
        //return list
        List<WorkoutDTO> workoutDTOs = workouts.stream().map(workout -> workoutMapper.workoutToWorkoutDto(workout)).collect(Collectors.toList());

        return workoutDTOs;
    }

    //GET workout by id


}
