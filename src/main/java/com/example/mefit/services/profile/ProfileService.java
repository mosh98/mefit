package com.example.mefit.services.profile;

import com.example.mefit.models.Profile;
import com.example.mefit.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService extends CrudService<Profile, Integer> {

    Profile update(Integer id, Profile profile);
}
