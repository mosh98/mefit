package com.example.mefit.repositories;


import com.example.mefit.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExcerciseRepository extends JpaRepository<Exercise,Integer> {

    Optional<Exercise> findById(Integer id);

}
