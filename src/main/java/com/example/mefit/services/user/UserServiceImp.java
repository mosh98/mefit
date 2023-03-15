package com.example.mefit.services.user;

import com.example.mefit.models.Profile;
import com.example.mefit.models.User;
import com.example.mefit.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

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
        /**
         * TODO: remove adress, goal and profile from user
         * TODO: in order to remove profile we need to remove profile from adress
         * TODO: in order to remove profile we need to remove profile from goal
         */
        //get user by id
        User user = findById(id);

        //get user profile
        Profile profile = user.getProfile();


        profile.setUser(null);
        profile.setAddress(null);
        profile.setGoal(null);

        user.setProfile(null);

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
