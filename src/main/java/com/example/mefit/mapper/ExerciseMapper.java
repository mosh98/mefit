package com.example.mefit.mapper;


import com.example.mefit.models.Exercise;
import com.example.mefit.models.Workout;
import com.example.mefit.models.dto.ExerciseDto;
import com.example.mefit.services.exercise.ExcerciseService;
import com.example.mefit.services.workout.WorkoutService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    // Exercise to ExerciseDto

    @Mapping(target = "workout", source = "workout", qualifiedByName = "workoutConverterNull")
    ExerciseDto exerciseToExerciseDto(Exercise exercise);

    // ExerciseDto to Exercise
    @Mapping(target = "workout", source = "workout", qualifiedByName = "workoutConverter")
    Exercise exerciseDtoToExercise(ExerciseDto exerciseDto, @Context WorkoutService workoutService);

    @Named("workoutConverter")
    default Workout workoutConverter(int workout, @Context WorkoutService workoutService){
        return workoutService.findById(workout);
    }


    @Named("workoutConverterNull")
    default Integer workoutConverterNull(Workout workout){
        if(workout == null){
            return -1;
        }
        return workout.getId();
    }


}
