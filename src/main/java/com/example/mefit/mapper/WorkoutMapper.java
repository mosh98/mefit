package com.example.mefit.mapper;

import com.example.mefit.models.Exercise;
import com.example.mefit.models.Goal;
import com.example.mefit.models.Program;
import com.example.mefit.models.Workout;
import com.example.mefit.models.dto.WorkoutDTO;
import com.example.mefit.services.exercise.ExcerciseService;
import com.example.mefit.services.goal.GoalService;
import com.example.mefit.services.workout.WorkoutService;
import org.mapstruct.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface WorkoutMapper {

    //--------------WORKOUT --> workoutDTO Mapping----------------

    @Mapping(target = "programs", source = "programs", qualifiedByName = "programConverter")
    @Mapping(target="goals", source="goals", qualifiedByName = "goalConverterToInteger")
    //@Mapping(target="exercises", source="exercises", qualifiedByName = "exerciseConverter")
    WorkoutDTO workoutToWorkoutDto(Workout workout);

    @Named("goalConverterToInteger")
    default Set<Integer> goalConverterToInteger(Set<Goal> goals){
        //check if goals is null then return empty set
        if(goals == null){
            return new HashSet<>();
        }
        return goals.stream().map(Goal::getId).collect(Collectors.toSet());
    }
    @Named("programConverter")
    default Set<Integer> programConverter(Set<Program> programs){
        //check if programs is null then return empty set
        if(programs == null){
            return new HashSet<>();
        }
        return programs.stream().map(Program::getId).collect(Collectors.toSet());
    }


    @Named("exerciseConverter")
    default Set<Integer> exerciseConverter(Set<Exercise> exercises){
        //check if exercises is null then return empty set
        if(exercises == null){
            return new HashSet<>();
        }
        return exercises.stream().map(Exercise::getId).collect(Collectors.toSet());
    }



    //--------------workoutDTO --> WORKOUT Mapping----------------

/*   @Mapping(target = "programs", source = "programs", qualifiedByName = "programConverter")
    @Mapping(target="goal", source="goal", qualifiedByName = "goalConverter")
    @Mapping(target="exercises", source="exercises", qualifiedByName = "exerciseConverter")
    Workout workoutDtoToWorkout(WorkoutDTO workoutDTO, @Context WorkoutService workoutService);

    @Named("goalConverter")
    default Exercise goalConverter(int goalId, @Context WorkoutService workoutService){
        //find wrokout by id

        //from that workout get the goal object

        return workoutService.findExerciseById(goalId);
    }*/
    //Workout workoutDtoToWorkout(WorkoutDTO workoutDTO, @Context WorkoutService workoutService);

    @Mappings({
            @Mapping(target = "id", source = "workoutDTO.id"),
            @Mapping(target = "name", source = "workoutDTO.name"),
            @Mapping(target = "type", source = "workoutDTO.type"),
            @Mapping(target = "completed", source = "workoutDTO.completed"),
            @Mapping(target = "programs", ignore = true),
            @Mapping(target = "goals", source = "workoutDTO.goals", ignore = true ),
            //@Mapping(target = "exercises", source = "workoutDTO.exercises", qualifiedByName = "exerciseConverterFromDto")
            //@Mapping(target = "exercises", source = "workoutDTO.exercises", qualifiedByName = "exerciseConverterFromDto")
    })
    Workout workoutDtoToWorkout(WorkoutDTO workoutDTO, @Context WorkoutService workoutService, @Context ExcerciseService exerciseService, @Context GoalService goalService);

    @Named("exerciseConverterFromDto")
    default Set<Exercise> exerciseConverterFromDto(Set<Integer> exercises, @Context ExcerciseService exerciseService ){
        //check if exercises is null then return empty set
        if(exercises == null){
            return new HashSet<>();
        }
        return exercises.stream().map(exerciseService::findById).collect(Collectors.toSet());
    }

/*    @Named("goalConverter")
    default Set<Goal> goalConverter(int goalId, @Context GoalService goalService){
        //find wrokout by id

        //from that workout get the goal object
        if (goalService.findById(goalId) == null){
            return null;
        }
        return goalService.findById(goalId).getGoals();
        return goalService.findById(goalId);
    }*/



}
