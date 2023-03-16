package com.example.mefit.controller.workout;


import com.example.mefit.mapper.WorkoutMapper;
import com.example.mefit.models.Exercise;
import com.example.mefit.models.Goal;
import com.example.mefit.models.Program;
import com.example.mefit.models.Workout;
import com.example.mefit.models.dto.WorkoutDTO;
import com.example.mefit.services.workout.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class WorkoutController {

    //instiantiation of workoutService
    private final WorkoutService workoutService;

    //instiantiation of workoutMapper
    private final WorkoutMapper workoutMapper;



    //GET all workouts
    //@PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get all workouts", description = "Get all workouts")
    @GetMapping
    @RequestMapping(path = "/allWorkouts",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<WorkoutDTO> getAllWorkouts(){

        //find all from service
        List<Workout> workouts = workoutService.findAll();

        //loop through each workout and convert into dto and store it in a list
        //return list
        List<WorkoutDTO> workoutDTOs = workouts.stream().map(workout -> workoutMapper.workoutToWorkoutDto(workout)).collect(Collectors.toList());

        return workoutDTOs;
    }

    //GET workout by id
    @Operation(summary = "Get workout by id", description = "Get workout by id")
    @GetMapping
    @RequestMapping(path = "/workoutById/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public WorkoutDTO getWorkoutById(@PathVariable Integer id){

        System.out.println("Workout id: " + id);

        //find workout by id
        Workout workout = workoutService.findById(id);

        //convert workout to dto
        WorkoutDTO workoutDTO = workoutMapper.workoutToWorkoutDto(workout);

        //return dto
        return workoutDTO;
    }

    //GET all exercises from a workout id
    @Operation(summary = "Get all exercises from a workout id", description = "Get all exercises from a workout id")
    @GetMapping
    @RequestMapping(path = "/workoutexcercises/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Exercise> getWorkoutExcercises(@PathVariable Integer id){

        List<Exercise> exerciseList = workoutService.getWorkoutExcercises(id);

        //TODO: convert list of exercises to dto
        return exerciseList;
    }

    //get program associated with workout
    @Operation(summary = "Get program associated with workout", description = "Get program associated with workout")
    @GetMapping
    @RequestMapping(path = "/programByWorkoutId/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Set<Program> getProgramByWorkoutId(@PathVariable Integer id){

            Set<Program> program = workoutService.getProgramByWorkoutId(id);

            return program;
    }

    //get goal by workout id
    @Operation(summary = "Get goal by workout id", description = "Get goal by workout id")
    @GetMapping
    @RequestMapping(path = "/goalByWorkoutId/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Goal getGoalByWorkoutId(@PathVariable Integer id){

        //TODO: convert goal to dto

        Goal goal = workoutService.getWorkoutGoal(id);

        return goal;
    }

    //POST workout
    @Operation(summary = "Create workout", description = "Create workout")
    @PostMapping
    @RequestMapping(path = "/createWorkout",method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public WorkoutDTO createWorkout(@RequestBody WorkoutDTO workoutDTO){
        Workout workout = workoutMapper.workoutDtoToWorkout(workoutDTO,workoutService);

        return workoutMapper.workoutToWorkoutDto(workoutService.save(workout));
    }

    // Update Workout
    @Operation(summary = "Update workout by id", description = "Update workout by id")
    @ApiResponse(responseCode = "200", description = "Workout updated")
    @ApiResponse(responseCode = "404", description = "Workout not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PatchMapping()
    @RequestMapping(path = "/updateWorkout/{id}",method = RequestMethod.PATCH)
    public WorkoutDTO updateWorkout(@PathVariable Integer id, @RequestBody WorkoutDTO workoutDto){

        Workout workout = workoutMapper.workoutDtoToWorkout(workoutDto,workoutService);

        return workoutMapper.workoutToWorkoutDto(workoutService.update(id,workout));
    }

    //delete workout by id
    @Operation(summary = "Delete workout by id", description = "Delete workout by id")
    @DeleteMapping
    @RequestMapping(path = "/deleteWorkoutById/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWorkoutById(@PathVariable Integer id){
      try{
          workoutService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
      }catch (DataException e){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }




}
