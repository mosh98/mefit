package com.example.mefit.mapper;

import com.example.mefit.models.Exercise;
import com.example.mefit.models.Program;
import com.example.mefit.models.Workout;
import com.example.mefit.models.dto.WorkoutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface WorkoutMapper {

    //--------------WORKOUT --> workoutDTO Mapping----------------

    @Mapping(target = "programs", source = "programs", qualifiedByName = "programConverter")
    @Mapping(target="goal", source="goal.id")
    @Mapping(target="exercises", source="exercises", qualifiedByName = "exerciseConverter")
    WorkoutDTO workoutToWorkoutDto(Workout workout);

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

/*    @Mapping(target = "programs", source = "programs", qualifiedByName = "programConverter")
    @Mapping(target="goal", source="goal", qualifiedByName = "goalConverter")
    @Mapping(target="exercises", source="exercises", qualifiedByName = "exerciseConverter")
    Workout workoutDtoToWorkout(WorkoutDTO workoutDTO);*/

}
