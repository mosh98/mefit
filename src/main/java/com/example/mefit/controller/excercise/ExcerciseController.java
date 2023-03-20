package com.example.mefit.controller.excercise;

import com.example.mefit.mapper.ExerciseMapper;
import com.example.mefit.models.Exercise;
import com.example.mefit.models.dto.ExerciseDto;
import com.example.mefit.models.dto.UserDto;
import com.example.mefit.services.exercise.ExcerciseService;
import com.example.mefit.services.workout.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class ExcerciseController {

    /**
     *  Create controller for getting ALL excercises
     *  Create controller for getting excercise by id
     *  Create controller for getting excercise by muscle group
     *  Post New Excercise
     *  Update Excercise
     *  Delete Excercise
     *  Get Excercise by muscle group
     */

    //TODO: instantiate service
    private final ExcerciseService excerciseService;

    private final WorkoutService workoutService;

    //TODO: instantiate mapper
    private final ExerciseMapper excerciseMapper;

    //get all exercises
    @Operation(summary = "Get all exercises", description = "Retrieves a list of all users in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercises retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ExerciseDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping
    @RequestMapping(path = "/allExercises",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public List<ExerciseDto> getAllExercises(){

        List<Exercise> exercises = excerciseService.findAll();
        List<ExerciseDto> exerciseDtos = new ArrayList<>();

        for (Exercise exercise : exercises) {
            exerciseDtos.add(excerciseMapper.exerciseToExerciseDto(exercise));
        }

        return exerciseDtos;
    }


    //get exercise by id
    @Operation(summary = "Get an exercise by id", description = "Retrieve an exercise from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "404", description = "Exercise not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
    @GetMapping
    @RequestMapping(path = "/exerciseById/{id}",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public ExerciseDto getExerciseById(@PathVariable Integer id){

        //return exerciseService.findById(id);
        return excerciseMapper.exerciseToExerciseDto(excerciseService.findById(id));
    }

    //get all exercises by muscle group
    @Operation(summary = "Get an exercise by MuscleGroup id", description = "Retrieve an exercise MuscleGroup from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercise retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExerciseDto.class))),
            @ApiResponse(responseCode = "404", description = "Exercise not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
    @GetMapping
    @RequestMapping(path = "/exerciseByMuscleGroup/{muscleGroup}",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public List<ExerciseDto> getExerciseByMuscleGroup(@PathVariable String muscleGroup){



        //return excerciseService.findByMuscleGroup(muscleGroup);

        return excerciseService.findByMuscleGroup(muscleGroup).stream().map(excerciseMapper::exerciseToExerciseDto).collect(Collectors.toList());

    }

    // Post New Exercise
    @Operation(summary = "Create a new exercise")
    @ApiResponse(responseCode = "201", description = "Exercise created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExerciseDto.class)))
    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content)
    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    @PostMapping
    @RequestMapping(path = "/newExercise",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ExerciseDto postNewExercise(@RequestBody ExerciseDto exerciseDto){


        Exercise exercise = excerciseMapper.exerciseDtoToExercise(exerciseDto,workoutService);

        return excerciseMapper.exerciseToExerciseDto( excerciseService.save(exercise));
    }

    // Update Exercise
    @Operation(summary = "Update exercise by id", description = "Update exercise by id")
    @ApiResponse(responseCode = "200", description = "Exercise updated")
    @ApiResponse(responseCode = "404", description = "Exercise not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PatchMapping()
    @RequestMapping(path = "/updateExercise/{id}",method = RequestMethod.PATCH)
    public ExerciseDto updateExercise(@PathVariable Integer id, @RequestBody ExerciseDto exerciseDto){

        Exercise exercise = excerciseMapper.exerciseDtoToExercise(exerciseDto,workoutService);

        return excerciseMapper.exerciseToExerciseDto(excerciseService.update(id,exercise));
    }

    // Delete Excercise
    @Operation(summary = "Delete exercise by id", description = "Delete exercise by id")
    @ApiResponse(responseCode = "200", description = "Exercise deleted")
    @ApiResponse(responseCode = "404", description = "Exercise not found")
    @DeleteMapping
    @RequestMapping(path = "/deleteExercise/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteExercise(@PathVariable Integer id){

        try {
            excerciseService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (DataException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
