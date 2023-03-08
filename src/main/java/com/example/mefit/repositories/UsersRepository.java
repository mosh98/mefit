package com.example.mefit.repositories;

import com.example.mefit.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Override
    Optional<Users> findById(Integer id);

/*    @Modifying
    @Query()
    List<User> findAllMail(String mail);*/
}
