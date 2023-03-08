package com.example.mefit.services.user;

import com.example.mefit.models.Profile;
import com.example.mefit.models.User;
import com.example.mefit.services.CrudService;

import java.util.Collection;

public interface ProfileService extends CrudService<Profile, Integer> {

    //Collection<Profile> findAllByFirstName(String firstName);
}
