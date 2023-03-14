package com.example.mefit.controller.workout;


import com.example.mefit.models.Workout;
import com.example.mefit.services.workout.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Scanner;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    //TODO: instiantiation of workoutService
    private final WorkoutService workoutService;

    //TODO instiantiation of workoutMapper

    //private final WorkoutMapper workoutMapper;

    //GET all workouts
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<Workout> getAllWorkouts(){

        //return workoutMapper.workoutToWorkoutDto(workoutService.findAll());
        return workoutService.findAll();
    }

    //GET workout by id


}
