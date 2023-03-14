package com.example.mefit.services.workout;

import com.example.mefit.models.Workout;
import com.example.mefit.repositories.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    // instantiate workoutRepository
    private final WorkoutRepository workoutRepository;

    @Override
    public List<Workout> findAll() {

        return workoutRepository.findAll();
    }

    @Override
    public Workout findById(Integer id) {
        return null;
    }

    @Override
    public Workout save(Workout workout) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        System.out.println("Workout deleted, NOT IMPLEMENTED YET");

    }

    @Override
    public Workout getProgramByWorkoutId(Integer id) {
        System.out.println("GET PROGRAM by Workout ID, NOT IMPLEMENTED YET");
        return null;
    }

}
