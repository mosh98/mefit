package com.example.mefit.services.workout;

import com.example.mefit.models.*;
import com.example.mefit.models.dto.WorkoutStatsDTO;
import com.example.mefit.repositories.ExcerciseRepository;
import com.example.mefit.repositories.WorkoutRepository;
import com.example.mefit.services.profile.ProfileService;
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

    private final ExcerciseRepository exerciseRepository;

    private final ProfileService profileService;

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

        //DONE: save the exercises
        workout.setCompleted(false);

        //get exercises from workout
        Set<Exercise> exercises = workout.getExercises();
        //loop through each exercise and set the workout
        for(Exercise exercise: exercises){
            exercise.setWorkout(workout);
            exerciseRepository.save(exercise);
        }

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

    public WorkoutStatsDTO getWorkoutStats(String keyClockId){
        //get profile by keyclock id
        Profile profile = profileService.findByUserKeycloakId(keyClockId).get();

        WorkoutStatsDTO workoutStatsDTO = new WorkoutStatsDTO();



        //get all workouts
        Goal profileGoal = profile.getGoal();

        //get all workout from that goal


        //calculate the stats

        return null;
    }


}
