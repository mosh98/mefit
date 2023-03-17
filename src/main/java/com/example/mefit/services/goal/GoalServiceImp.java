package com.example.mefit.services.goal;

import com.example.mefit.models.Address;
import com.example.mefit.models.Goal;
import com.example.mefit.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GoalServiceImp implements GoalService {

    @Autowired
    private GoalRepository goalRepository;
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
        return goalRepository.save(existingGoal);
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
