package com.example.mefit.mapper;

import com.example.mefit.models.Goal;
import com.example.mefit.models.dto.GoalDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface GoalMapper {

    @Mapping(target = "profile.id", source = "profile")
    Goal goalDtoToGoal(GoalDto goalDto);

    @Mapping(target = "profile", source = "profile.id")
    GoalDto goalToGoalDto(Goal goal);

    Collection<GoalDto> goalToGoalDto(Collection<Goal> goals);
}
