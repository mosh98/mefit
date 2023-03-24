package com.example.mefit.services.goal;

import com.example.mefit.models.Address;
import com.example.mefit.models.Goal;
import com.example.mefit.models.Profile;
import com.example.mefit.models.Workout;
import com.example.mefit.models.dto.AddGoalDto;
import com.example.mefit.repositories.GoalRepository;
import com.example.mefit.services.profile.ProfileService;
import com.example.mefit.services.workout.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class GoalServiceImp implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private ProfileService profileService;


    private WorkoutService workoutService;

    @Override
    public Goal findById(Integer id) {
        return goalRepository.findById(id).get();
    }

    @Override
    public Collection<Goal> findAll() {
        return goalRepository.findAll();
    }

    @Override
    public Goal add(Goal entity) {
        return goalRepository.save(entity);
    }

    @Override
    public Goal update(Goal entity) {
        return goalRepository.save(entity);
    }

    @Override
    public Goal update(Integer id, Goal goal) {
        Goal existingGoal = goalRepository.findById(id).get();

        if(existingGoal==null){
            return null;
        }
        if(goal.getEndDate()!=null){
            existingGoal.setEndDate(goal.getEndDate());
        }
        existingGoal.setAchieved(goal.isAchieved());
        existingGoal.setActive(goal.isActive());

        return goalRepository.save(existingGoal);
    }

    @Override
    public Goal addWorkoutsToGoal(AddGoalDto addGoalDto) {

        //get User using keycloakId
        Profile profile = profileService.findByUserKeycloakId(addGoalDto.getKeyCloakId()).get();
        //get user profile using keycloak id

        //get goal from profile
        Goal goal = profile.getGoal();

        //find workout object from list
        List<Workout> workouts = new ArrayList<>();

        //convert workout id to workout object

        for (Integer workoutId : addGoalDto.getWorkouts()) {
            workouts.add(workoutService.findById(workoutId));
        }

        //add workouts to goal
        goal.setWorkouts(workouts);

        //save goal

        //loop through goal workouts
        for (Workout workout : goal.getWorkouts()) {
            //set goal in workout
            workout.setGoal(goal);

            //save workout
            workoutService.save(workout);
        }

        goalRepository.save(goal);

        //return goal
        return goal;

    }

    @Override
    public void deleteById(Integer id) {
        goalRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return goalRepository.existsById(id);
    }
}
