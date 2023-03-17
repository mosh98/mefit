package com.example.mefit.services.workout;

import com.example.mefit.models.Exercise;
import com.example.mefit.models.Goal;
import com.example.mefit.models.Program;
import com.example.mefit.models.Workout;
import com.example.mefit.repositories.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


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

        return workoutRepository.findById(id).orElse(null);
    }

    @Override
    public Workout save(Workout workout) {

        return workoutRepository.save(workout);
    }

    @Override
    public void deleteById(Integer id) {

            workoutRepository.deleteById(id);
    }

    @Override
    public Set<Program> getProgramByWorkoutId(Integer id) {

        //get the workout object using id
        Optional<Workout> workoutObject =  workoutRepository.findById(id);
        if(workoutObject.isPresent()){
            Workout workout = workoutObject.get();
            return workout.getPrograms();
        }

        return null;
    }

    @Override
    public List<Exercise> getWorkoutExcercises(Integer id) {
        Optional<Workout> workoutObject =  workoutRepository.findById(id);
        if(workoutObject.isPresent()){
            Workout workout = workoutObject.get();
            return workout.getExercises().stream().toList();
        }
        return null;
    }

    @Override
    public Goal getWorkoutGoal(Integer id) {
        Optional<Workout> workoutObject =  workoutRepository.findById(id);
        if(workoutObject.isPresent()){
            Workout workout = workoutObject.get();
            return workout.getGoal();
        }
        return null;
    }
    @Override
    public Workout update(Integer id, Workout workout ){
        //old workout
        Workout existingWorkout = workoutRepository.findById(id).get();

        //check if workout is not null
        if(existingWorkout==null){
            return null;
        }
        if(workout.getName()!=null){
            existingWorkout.setName(workout.getName());
        }
        if(workout.getType()!=null){
            existingWorkout.setType(workout.getType());
        }

        existingWorkout.setCompleted(workout.isCompleted());

        return workoutRepository.save(existingWorkout);

    }


}
