package com.example.mefit.controller.excercise;

import com.example.mefit.mapper.ExerciseMapper;
import com.example.mefit.models.Exercise;
import com.example.mefit.models.dto.ExerciseDto;
import com.example.mefit.services.exercise.ExcerciseService;
import com.example.mefit.services.workout.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/excercises")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ExcerciseController {

    /**
     *  Create controller for getting ALL excercises
     *  Create controller for getting excercise by id
     *  Create controller for getting excercise by muscle group
     *  Post New Excercise
     *  Update Excercise
     *  Delete Excercise
     *  Get Excercise by muscle group
     *TODO: create mapper
     * TODO: create DTOs
     */

    //TODO: instantiate service
    private final ExcerciseService excerciseService;

    private final WorkoutService workoutService;

    //TODO: instantiate mapper
    private final ExerciseMapper excerciseMapper;

    //get all excercises
    @GetMapping
    @RequestMapping(path = "/allExcercises",method = RequestMethod.GET)
    public List<ExerciseDto> getAllExcercises(){

        List<Exercise> exercises = excerciseService.findAll();
        List<ExerciseDto> exerciseDtos = new ArrayList<>();

        for (Exercise exercise : exercises) {
            exerciseDtos.add(excerciseMapper.exerciseToExerciseDto(exercise));
        }

        return exerciseDtos;
    }


    //get excercise by id
    @GetMapping
    @RequestMapping(path = "/excerciseById/{id}",method = RequestMethod.GET)
    public ExerciseDto getExcerciseById(@PathVariable Integer id){

        //return excerciseService.findById(id);
        return excerciseMapper.exerciseToExerciseDto(excerciseService.findById(id));
    }

    //get all excercises by muscle group
    @GetMapping
    @RequestMapping(path = "/excerciseByMuscleGroup/{muscleGroup}",method = RequestMethod.GET)
    public List<ExerciseDto> getExcerciseByMuscleGroup(@PathVariable String muscleGroup){



        //return excerciseService.findByMuscleGroup(muscleGroup);

        return excerciseService.findByMuscleGroup(muscleGroup).stream().map(excerciseMapper::exerciseToExerciseDto).collect(Collectors.toList());

    }

    // Post New Excercise
    @PostMapping
    @RequestMapping(path = "/newExcercise",method = RequestMethod.POST)
    public ExerciseDto postNewExcercise(@RequestBody ExerciseDto exerciseDto){


        Exercise exercise = excerciseMapper.exerciseDtoToExercise(exerciseDto,workoutService);

        return excerciseMapper.exerciseToExerciseDto( excerciseService.save(exercise));
    }

    // Update Excercise
    @Operation(summary = "Update excercise by id", description = "Update excercise by id")
    @ApiResponse(responseCode = "200", description = "Excercise updated")
    @ApiResponse(responseCode = "404", description = "Excercise not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PatchMapping()
    @RequestMapping(path = "/updateExcercise/{id}",method = RequestMethod.PATCH)
    public ExerciseDto updateExcercise(@PathVariable Integer id, @RequestBody ExerciseDto exerciseDto){

        Exercise exercise = excerciseMapper.exerciseDtoToExercise(exerciseDto,workoutService);

        return excerciseMapper.exerciseToExerciseDto(excerciseService.update(id,exercise));
    }

    // Delete Excercise
    @Operation(summary = "Delete excercise by id", description = "Delete excercise by id")
    @ApiResponse(responseCode = "200", description = "Excercise deleted")
    @ApiResponse(responseCode = "404", description = "Excercise not found")
    @DeleteMapping
    @RequestMapping(path = "/deleteExcercise/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteExcercise(@PathVariable Integer id){

        try {
            excerciseService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (DataException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
