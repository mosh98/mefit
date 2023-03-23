package com.example.mefit.services.profile;

import com.example.mefit.models.Profile;
import com.example.mefit.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProfileService extends CrudService<Profile, Integer> {

    Profile update(Integer id, Profile profile);

    public Optional<Profile> findByUserKeycloakId(String keycloakId);
}
