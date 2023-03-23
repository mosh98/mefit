package com.example.mefit.controller;

import com.example.mefit.mapper.ProfileMapper;
import com.example.mefit.models.Profile;
import com.example.mefit.models.User;
import com.example.mefit.models.dto.AddressDto;
import com.example.mefit.models.dto.ProfileDto;
import com.example.mefit.models.dto.UserDto;
import com.example.mefit.services.profile.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileController {


    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    // Make a get method to get all profiles
    @Operation(summary = "Get all profiles", description = "Returns a list of all  profiles in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profiles retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AddressDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/allProfiles")
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<ProfileDto> getAllProfiles() {
        Collection<Profile> profiles =  profileService.findAll();

        // Loop through each profile and convert into dto and store it in a list
        // return list
        Collection<ProfileDto> profileDtos = profiles.stream().map(profile -> profileMapper.profileToProfileDto(profile)).collect(Collectors.toList());


        return profileDtos;
    }

    // Make a get method to get a profile by id
    @Operation(summary = "Get a profile by id", description = "Returns a profile from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile found successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Profile not found", content = @Content)
    })
    @GetMapping("/profileById/{id}")
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


    //TODO: get user Profile by user keycloak id
    @Operation(summary = "Get a profile by user keycloak id", description = "Returns a profile from the system by user keycloak id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile found successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Profile not found", content = @Content)
    })
    @GetMapping("/profileByUserKeycloakId/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ProfileDto getProfileByUserKeycloakId(@PathVariable String id) {
        return profileMapper.profileToProfileDto(profileService.findByUserKeycloakId(id).get());
    }


}
