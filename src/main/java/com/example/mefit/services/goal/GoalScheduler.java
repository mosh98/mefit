package com.example.mefit.services.goal;


import com.example.mefit.models.Goal;
import com.example.mefit.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class GoalScheduler {

    private final GoalRepository goalRepository;

    @Autowired
    public GoalScheduler(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    //TODO: compare current date(day,month year) with goal end date in the same format

    @Scheduled(cron = "0 0 0 * * *") // run at midnight every day
    public void updateActiveGoals() {
        Date now = new Date();
        //now.getDay();
        List<Goal> goals = goalRepository.findByActiveIsTrue();
/*        for (Goal goal : goals) {
            Date goalEndDate = goal.getEndDate();
            if(goalEndDate.compareTo(now) == 0){
                goal.setActive(false);
            }

            goalRepository.save(goal);
        }*/
    }
}
