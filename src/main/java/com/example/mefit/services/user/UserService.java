package com.example.mefit.services.user;

import com.example.mefit.models.Users;
import com.example.mefit.services.CrudService;

import java.util.Collection;

public interface UserService extends CrudService<Users, Integer> {

    Collection<Users> findAllByFirstName(String firstName);
}
