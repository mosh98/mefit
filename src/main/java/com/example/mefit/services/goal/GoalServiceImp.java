package com.example.mefit.services.goal;

import com.example.mefit.models.Address;
import com.example.mefit.models.Goal;
import com.example.mefit.models.Profile;
import com.example.mefit.models.Workout;
import com.example.mefit.models.dto.AddGoalDto;
import com.example.mefit.repositories.GoalRepository;
import com.example.mefit.repositories.ProfileRepository;
import com.example.mefit.services.profile.ProfileService;
import com.example.mefit.services.workout.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class GoalServiceImp implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileService profileService;


     @Autowired
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
        if (profile.getGoal() == null) {
            Goal goal = new Goal();

            //set end date for goal
            LocalDate currentDate = LocalDate.now();
            int year = currentDate.getYear();
            int month = currentDate.getMonthValue();
            int day = currentDate.getDayOfMonth()+7;
            String dateInString = year + "-" + month + "-" + day;
            goal.setEndDate(dateInString);
            goal.setActive(true);


            goal.setProfile(profile);
            goalRepository.save(goal);
            profile.setGoal(goal);
            profileRepository.save(profile);

        }
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

            //for each workout
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
