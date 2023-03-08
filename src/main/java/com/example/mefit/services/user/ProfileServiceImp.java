package com.example.mefit.services.user;

import com.example.mefit.models.Profile;
import com.example.mefit.repositories.ProfileRepository;

import java.util.Collection;

public class ProfileServiceImp implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImp(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findById(Integer id) {
        return profileRepository.findById(id).get();
    }

    @Override
    public Collection<Profile> findAll() {
        return null;
    }

    @Override
    public Profile add(Profile entity) {
        return null;
    }

    @Override
    public Profile update(Profile entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
