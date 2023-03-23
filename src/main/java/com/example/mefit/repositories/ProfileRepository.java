package com.example.mefit.repositories;

import com.example.mefit.models.Profile;
import com.example.mefit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {


}
