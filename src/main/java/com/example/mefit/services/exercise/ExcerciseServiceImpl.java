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
    public Exercise findById(Integer id) {
        return excerciseRepository.findById(id).get();
    }

    @Override
    public List<Exercise> findByName(String name) {
        System.out.println("Find by name Not implemented");
        return null;
    }




    @Override
    public List<Exercise> findByMuscleGroup(String muscleGroup)

    {
        return excerciseRepository.findByMuscleGroup(muscleGroup);
    }

    @Override
    public Exercise save(Exercise exercise) {
        return excerciseRepository.save(exercise);
    }

    @Override
    public void deleteById(Integer id) {
        excerciseRepository.deleteById(id);

    }

    @Override
    public Exercise update(Integer id,Exercise exercise) {
        Exercise exsistingExercise = excerciseRepository.findById(id).get();

        if (exsistingExercise == null) {
            return null;
        }
        //check if excercise is not null
        if(exercise.getName() != null){
            exsistingExercise.setName(exercise.getName());
        }
        if (exercise.getDescription() != null){
            exsistingExercise.setDescription(exercise.getDescription());
        }
        if (exercise.getMuscleGroup() != null){
            exsistingExercise.setMuscleGroup(exercise.getMuscleGroup());
        }
        if (exercise.getUserExperience() != null){
            exsistingExercise.setUserExperience(exercise.getUserExperience());
        }
        if (exercise.getSets() != 0){
            exsistingExercise.setSets(exercise.getSets());
        }
        if (exercise.getReps() != 0){
            exsistingExercise.setReps(exercise.getReps());
        }
        exsistingExercise.setCompleted(exercise.isCompleted());

        // Update the properties of the exercise object
        return excerciseRepository.save(exsistingExercise);
    }


}
