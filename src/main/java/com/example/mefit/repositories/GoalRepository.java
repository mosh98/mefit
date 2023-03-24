package com.example.mefit.repositories;

import com.example.mefit.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Integer> {


    List<Goal> findByActiveIsTrue();

}
