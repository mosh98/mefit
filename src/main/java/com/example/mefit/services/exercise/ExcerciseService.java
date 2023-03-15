package com.example.mefit.services.exercise;

import com.example.mefit.models.Exercise;

import java.util.List;

public interface ExcerciseService {

    List<Exercise> findAll();

    List<Exercise> findByName(String name);

    List<Exercise> findByMuscleGroup(String muscleGroup);

    Exercise save(Exercise exercise);

    void deleteById(Integer id);


}
