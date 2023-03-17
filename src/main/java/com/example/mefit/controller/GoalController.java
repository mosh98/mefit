package com.example.mefit.controller;

import com.example.mefit.mapper.GoalMapper;
import com.example.mefit.models.Goal;
import com.example.mefit.models.User;
import com.example.mefit.models.dto.GoalDto;
import com.example.mefit.models.dto.UserDto;
import com.example.mefit.services.goal.GoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/goal")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class GoalController {

    private final GoalService goalService;
    private final GoalMapper goalMapper;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<GoalDto> getAllGoals() {
        return goalMapper.goalToGoalDto(goalService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public GoalDto getGoalById(@PathVariable Integer id) {
        return goalMapper.goalToGoalDto(goalService.findById(id));
    }

    /*
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public GoalDto updateGoal(@PathVariable Integer id, @RequestBody GoalDto goalDto) {

        if (!goalService.exists(id)) {
            throw new RuntimeException("The goal with id " + id + " does not exist");
        }
        if (!id.equals(goalDto.getId())) {
            throw new RuntimeException("The id in the path must be the same as the id in the body");
        }


        Goal goal = goalService.update(goalMapper.goalDtoToGoal(goalDto));

        return goalMapper.goalToGoalDto(goal);
    }

     */

    //Update user by id
    @Operation(summary = "Update goal by id", description = "Update goal by id")
    @ApiResponse(responseCode = "200", description = "Goal updated")
    @ApiResponse(responseCode = "404", description = "Goal not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PatchMapping()
    @RequestMapping(path = "/updateGoal/{id}",method = RequestMethod.PATCH)
    public GoalDto updateGoal(@PathVariable Integer id, @RequestBody GoalDto goalDto){

        Goal goal = goalMapper.goalDtoToGoal(goalDto);

        return goalMapper.goalToGoalDto(goalService.update(id,goal));
    }

}
