package com.example.mefit.services.user;

import com.example.mefit.models.Users;
import com.example.mefit.repositories.UserRepository;

import java.util.Collection;

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Collection<Users> findAll() {
        return null;
    }

    @Override
    public Users add(Users entity) {
        return null;
    }

    @Override
    public Users update(Users entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Collection<Users> findAllByFirstName(String firstName) {
        return null;
    }
}
