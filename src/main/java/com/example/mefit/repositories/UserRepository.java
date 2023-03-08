package com.example.mefit.repositories;

import com.example.mefit.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    Optional<User> findById(Integer id);

/*    @Modifying
    @Query()
    List<User> findAllMail(String mail);*/
}
