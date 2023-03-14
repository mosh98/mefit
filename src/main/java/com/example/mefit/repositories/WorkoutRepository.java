package com.example.mefit.repositories;

import com.example.mefit.models.Workout;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Integer> {

    //TODO: get program by workout id
    //Workout getProgramByWorkoutId(Integer id);



}
