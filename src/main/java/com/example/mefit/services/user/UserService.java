package com.example.mefit.services.user;

import com.example.mefit.models.User;
import com.example.mefit.services.CrudService;

import java.util.Collection;

public interface UserService extends CrudService<User, Integer> {
    Collection<User> findAllByFirstName(String firstName);
}
