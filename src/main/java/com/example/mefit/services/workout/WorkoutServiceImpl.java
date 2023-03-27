package com.example.mefit.services.workout;

import com.example.mefit.models.*;
import com.example.mefit.models.dto.WorkoutStatsDTO;
import com.example.mefit.repositories.ExcerciseRepository;
import com.example.mefit.repositories.WorkoutRepository;
import com.example.mefit.services.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

            //exerciseRepository.save(exercise);
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

    public WorkoutStatsDTO getWorkoutStats(String keyClockId) {
        //get profile by keyclock id
        Profile profile = profileService.findByUserKeycloakId(keyClockId).get();

        WorkoutStatsDTO workoutStatsDTO = new WorkoutStatsDTO();


        //get all workouts
        Goal profileGoal = profile.getGoal();

        //get all workout from that goal
        List<Workout> workouts = profileGoal.getWorkouts();

        int remainingWorkouts = 0;
        int totalWorkouts = workouts.size();
        int completedWorkouts = 0;

        HashMap<String, Integer> muscleGroupStats = new HashMap<>();


        //loop through each workout and get the stats
        for (Workout workout : workouts) {


            //get the exercises

            if (workout.isCompleted() == true) {
                completedWorkouts++;

                //for each exercise get the muscle group
                for (Exercise exercise : workout.getExercises()) {
                    //get the muscle group
                    String muscleGroup = exercise.getMuscleGroup();
                    //check if the muscle group is in the map
                    if (muscleGroupStats.containsKey(muscleGroup)) {
                        //if it is then increment the value
                        muscleGroupStats.put(muscleGroup, muscleGroupStats.get(muscleGroup) + 1);
                    } else {
                        //if it is not then add it to the map
                        muscleGroupStats.put(muscleGroup, 1);
                    }
                }

            }

        }
            //set the stats
            workoutStatsDTO.setRemainingWorkouts(totalWorkouts - completedWorkouts);
            workoutStatsDTO.setCompletedWorkouts(completedWorkouts);
            workoutStatsDTO.setTotalWorkouts(totalWorkouts);
            workoutStatsDTO.setMuscleGroupStats(muscleGroupStats);

            return workoutStatsDTO;
        }



}
