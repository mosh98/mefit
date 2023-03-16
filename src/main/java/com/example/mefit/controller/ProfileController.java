package com.example.mefit.controller;

import com.example.mefit.mapper.ProfileMapper;
import com.example.mefit.models.Profile;
import com.example.mefit.models.User;
import com.example.mefit.models.dto.ProfileDto;
import com.example.mefit.models.dto.UserDto;
import com.example.mefit.services.profile.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

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
        Collection<Profile> profiles =  profileService.findAll();

        // Loop through each profile and convert into dto and store it in a list
        // return list
        Collection<ProfileDto> profileDtos = profiles.stream().map(profile -> profileMapper.profileToProfileDto(profile)).collect(Collectors.toList());


        return profileDtos;
    }

    // Make a get method to get a profile by id
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ProfileDto getProfileById(@PathVariable Integer id) {
        return profileMapper.profileToProfileDto(profileService.findById(id));
    }
/*
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

 */
    //Update Profile by id
    @Operation(summary = "Update profile by id", description = "Update profile by id")
    @ApiResponse(responseCode = "200", description = "Profile updated")
    @ApiResponse(responseCode = "404", description = "Profile not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PatchMapping()
    @RequestMapping(path = "/updateProfile/{id}",method = RequestMethod.PATCH)
    public ProfileDto updateProfile(@PathVariable Integer id, @RequestBody ProfileDto profileDto){

        Profile profile = profileMapper.profileDtoToProfile(profileDto);

        return profileMapper.profileToProfileDto(profileService.update(id,profile));
    }

}
