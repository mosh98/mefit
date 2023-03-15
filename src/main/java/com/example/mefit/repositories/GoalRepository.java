package com.example.mefit.repositories;

import com.example.mefit.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Integer> {

}
