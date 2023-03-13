package com.example.mefit.controller;

import com.example.mefit.mapper.ProfileMapper;
import com.example.mefit.models.Profile;
import com.example.mefit.models.dto.ProfileDto;
import com.example.mefit.services.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    // Make a get method to get all profiles
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<ProfileDto> getAllProfiles() {
        return profileMapper.profileToProfileDto(profileService.findAll());
    }

    // Make a get method to get a profile by id
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ProfileDto getProfileById(@PathVariable Integer id) {
        return profileMapper.profileToProfileDto(profileService.findById(id));
    }

    // Make a put method to update a profile
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ProfileDto updateProfile(@PathVariable Integer id, @RequestBody ProfileDto profileDto) {

        if (!profileService.exists(id)) {
            throw new RuntimeException("The profile with id " + id + " does not exist");
        }
        if (!id.equals(profileDto.getId())) {
            throw new RuntimeException("The id in the path must be the same as the id in the body");
        }
        // Dont update user id


        Profile profile = profileService.update(profileMapper.profileDtoToProfile(profileDto));

        return profileMapper.profileToProfileDto(profile);
    }

}