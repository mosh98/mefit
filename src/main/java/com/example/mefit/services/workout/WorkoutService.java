package com.example.mefit.services.workout;

import com.example.mefit.models.Workout;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WorkoutService {

    List<Workout> findAll();
    Workout findById(Integer id);

    Workout save(Workout workout);

    //delete
    void deleteById(Integer id);

    //get program associated with workout
    Workout getProgramByWorkoutId(Integer id);
}
