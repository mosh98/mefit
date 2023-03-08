package com.example.mefit.controller;

import com.example.mefit.mapper.ProfileMapper;
import com.example.mefit.models.dto.ProfileDto;
import com.example.mefit.services.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public Collection<ProfileDto> getAllProfiles(){
        return profileMapper.profileToProfileDto(profileService.findAll());
    }

}
