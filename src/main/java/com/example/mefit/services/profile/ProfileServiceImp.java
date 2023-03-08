package com.example.mefit.services.profile;

import com.example.mefit.models.Profile;
import com.example.mefit.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProfileServiceImp implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public Profile findById(Integer id) {
        return profileRepository.findById(id).get();
    }

    @Override
    public Collection<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile add(Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    public Profile update(Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        profileRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return profileRepository.existsById(id);
    }
}
