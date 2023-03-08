package com.example.mefit.services.user;

import com.example.mefit.models.User;
import com.example.mefit.repositories.UserRepository;

import java.util.Collection;

public class UserServiceImp implements UserService{

    UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public Collection<User> findAllByFirstName(String firstName) {
        return null;
    }
}
