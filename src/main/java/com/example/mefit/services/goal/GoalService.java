package com.example.mefit.services.goal;

import com.example.mefit.models.Goal;
import com.example.mefit.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface GoalService extends CrudService<Goal, Integer> {
}
