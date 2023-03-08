package com.example.mefit.services.user;

import com.example.mefit.models.User;
import com.example.mefit.repositories.UserRepository;

import java.util.Collection;

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public User add(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Collection<User> findAllByFirstName(String firstName) {
        return null;
    }
}
