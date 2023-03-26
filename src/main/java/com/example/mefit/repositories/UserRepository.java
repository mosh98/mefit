package com.example.mefit.repositories;

import com.example.mefit.models.User;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    Optional<User> findById(Integer id);


    //Optional<User> findByKeyCloakId(String keyCloakId);
    Optional<User> findByKeyCloakId(String keyCloakId);





}
