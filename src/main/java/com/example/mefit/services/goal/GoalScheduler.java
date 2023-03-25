package com.example.mefit.services.goal;


import com.example.mefit.models.Goal;
import com.example.mefit.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class GoalScheduler {

    private final GoalRepository goalRepository;

    @Autowired
    public GoalScheduler(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }


    @Scheduled(cron = "0 0 0 * * *") // run at midnight every day
    public void updateActiveGoals() {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth()+7;
        String dateInString = year + "-" + month + "-" + day;

        List<Goal> goals = goalRepository.findByActiveIsTrue();

        for (Goal goal : goals) {
            if (goal.getEndDate().equals(dateInString)) {
                goal.setActive(false);
                goalRepository.save(goal);
            }

        }
    }
}
