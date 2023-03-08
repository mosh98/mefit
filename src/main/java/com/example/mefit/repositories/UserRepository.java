package com.example.mefit.repositories;

import com.example.mefit.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    @Override
    Optional<Users> findById(Integer id);

/*    @Modifying
    @Query()
    List<User> findAllMail(String mail);*/
}
