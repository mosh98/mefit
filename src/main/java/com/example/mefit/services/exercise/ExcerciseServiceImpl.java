package com.example.mefit.services.exercise;

import com.example.mefit.models.Exercise;
import com.example.mefit.repositories.ExcerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcerciseServiceImpl implements ExcerciseService {

    //TODO: instantiate repository
    private final ExcerciseRepository excerciseRepository;


    @Override
    public List<Exercise> findAll() {
        return excerciseRepository.findAll();
    }

    @Override
    public List<Exercise> findByName(String name) {
        System.out.println("Find by name Not implemented");
        return null;
    }

    @Override
    public List<Exercise> findByMuscleGroup(String muscleGroup)

    {
        System.out.println("Find by mucle group NOT IMPLEMENTED");
        return null;
    }

    @Override
    public Exercise save(Exercise exercise) {
        System.out.println("Save Not implemented");
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        System.out.println("Delete by id NOT IMPLEMENTED");

    }
}
