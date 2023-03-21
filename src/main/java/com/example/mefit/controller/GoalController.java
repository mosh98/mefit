package com.example.mefit.controller;

import com.example.mefit.mapper.GoalMapper;
import com.example.mefit.models.Goal;
import com.example.mefit.models.User;
import com.example.mefit.models.dto.AddressDto;
import com.example.mefit.models.dto.GoalDto;
import com.example.mefit.models.dto.UserDto;
import com.example.mefit.services.goal.GoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    //Make a get method to get all goals
    @Operation(summary = "Get all goals", description = "Returns a list of all goals in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Goals retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GoalDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/allGoals")
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<GoalDto> getAllGoals() {
        return goalMapper.goalToGoalDto(goalService.findAll());
    }


    // Make a get method to get a goal by id
    @Operation(summary = "Get a goal by id", description = "Returns a goal from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Goal found successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = GoalDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Goal not found", content = @Content)
    })
    @GetMapping("/goalById/{id}")
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
