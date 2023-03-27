package com.example.mefit.services.workout;

import com.example.mefit.models.Exercise;
import com.example.mefit.models.Goal;
import com.example.mefit.models.Program;
import com.example.mefit.models.Workout;

import java.util.List;
import java.util.Set;


public interface WorkoutService {

    List<Workout> findAll();
    Workout findById(Integer id);

    Workout save(Workout workout);

    //delete
    void deleteById(Integer id);

    //get program associated with workout
    Set<Program> getProgramByWorkoutId(Integer id);

    List<Exercise> getWorkoutExcercises(Integer id);


    Workout update (Integer id, Workout workout);





}
