package com.example.mefit.mapper;

import com.example.mefit.models.Profile;
import com.example.mefit.models.dto.ProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(target = "user.id", source = "user")
    Profile profileDtoToProfile(ProfileDto profileDto);

    @Mapping(target = "user", source = "user.id")
    ProfileDto profileToProfileDto(Profile profile);

    Collection<ProfileDto> profileToProfileDto(Collection<Profile> profiles);
}
