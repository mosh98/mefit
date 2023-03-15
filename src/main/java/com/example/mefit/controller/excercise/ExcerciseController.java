package com.example.mefit.controller.excercise;

import com.example.mefit.models.Exercise;
import com.example.mefit.services.exercise.ExcerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/excercises")
@RequiredArgsConstructor
public class ExcerciseController {

    /**
     * TODO: Create controller for getting ALL excercises
     * TODO: Create controller for getting excercise by id
     * TODO: Create controller for getting excercise by name
     * TODO: Create controller for getting excercise by muscle group
     * TODO: Post New Excercise
     * TODO: Update Excercise
     * TODO: Delete Excercise
     * TODO: Get Excercise by muscle group
     *
     */

    //TODO: instantiate service
    private final ExcerciseService excerciseService;

    //TODO: instantiate mapper

    //get all excercises
    @GetMapping
    @RequestMapping(path = "/allExcercises",method = RequestMethod.GET)
    public List<Exercise> getAllExcercises(){

        return excerciseService.findAll();
    }



}
