package com.example.mefit.mapper;

import com.example.mefit.models.Profile;
import com.example.mefit.models.dto.ProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(target = "id", source = "profileDto.id")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "profileImg", source = "profileDto.profileImg")
    @Mapping(target = "weight", source = "profileDto.weight")
    @Mapping(target = "height", source = "profileDto.height")
    @Mapping(target = "medicalCondition", source = "profileDto.medicalCondition")
    @Mapping(target = "disabilities", source = "profileDto.disabilities")
    @Mapping(target = "goal", ignore = true)
    @Mapping(target = "address", ignore = true)
    Profile profileDtoToProfile(ProfileDto profileDto);

    @Mapping(target = "id", source = "profile.id")
    @Mapping(target = "user", source = "profile.user.id")
    @Mapping(target = "profileImg", source = "profile.profileImg")
    @Mapping(target = "weight", source = "profile.weight")
    @Mapping(target = "height", source = "profile.height")
    @Mapping(target = "medicalCondition", source = "profile.medicalCondition")
    @Mapping(target = "disabilities", source = "profile.disabilities")
    @Mapping(target = "goal", source = "profile.goal.id")
    @Mapping(target = "address", source = "profile.address.id")
    ProfileDto profileToProfileDto(Profile profile);

    //Collection<ProfileDto> profilesToProfileDtos(Collection<Profile> profiles);

    //Collection<Profile> profileDtosToProfiles(Collection<ProfileDto> profileDtos);

}
