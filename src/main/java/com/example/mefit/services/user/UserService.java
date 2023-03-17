package com.example.mefit.services.user;

import com.example.mefit.models.Address;
import com.example.mefit.models.Goal;
import com.example.mefit.models.Profile;
import com.example.mefit.models.User;
import com.example.mefit.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService extends CrudService<User, Integer> {
    Collection<User> findAllByFirstName(String firstName);
    User update(Integer id, User user);

    Address getUserAddress(Integer id);

    Goal getUserGoal(Integer id);

    Profile getUserProfile(Integer id);
}
