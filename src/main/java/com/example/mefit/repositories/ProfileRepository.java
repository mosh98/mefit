package com.example.mefit.repositories;

import com.example.mefit.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    @Override
    Optional<Profile> findById(Integer id);
}
