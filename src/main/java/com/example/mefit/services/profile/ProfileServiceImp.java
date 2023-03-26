package com.example.mefit.services.profile;

import com.example.mefit.models.Profile;
import com.example.mefit.models.User;
import com.example.mefit.repositories.ProfileRepository;
import com.example.mefit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProfileServiceImp implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;
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

    @Override
    public Profile update(Integer id, Profile profile) {

        Profile existingProfile = profileRepository.findById(id).get();

        if(existingProfile==null){
            return null;
        }
        if(profile.getProfileImg()!=null){
            existingProfile.setProfileImg(profile.getProfileImg());
        }
        if(profile.getHeight()!=null){
            existingProfile.setHeight(profile.getHeight());
        }
        if(profile.getWeight()!=null){
            existingProfile.setWeight(profile.getWeight());
        }
        if(profile.getMedicalCondition()!=null){
            existingProfile.setMedicalCondition(profile.getMedicalCondition());
        }
        if(profile.getDisabilities()!=null){
            existingProfile.setDisabilities(profile.getDisabilities());
        }
        return profileRepository.save(existingProfile);
    }

    // Make a get method to get a profile by key cloak id
    @Override
    public Optional<Profile> findByUserKeycloakId(String keycloakId){

        User user = userRepository.findByKeyCloakId(keycloakId).get();
        System.out.print(user.getProfile());
        return profileRepository.findById(user.getProfile().getId());

    }
}
