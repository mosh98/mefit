package com.example.mefit.mapper;

import com.example.mefit.models.User;
import com.example.mefit.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "profile.id", source = "profile")
    @Mapping(target = "id", ignore = true)
    User userDtoToUser(UserDto userDto);

    @Mapping(target = "profile", source = "profile.id")
    UserDto userToUserDto(User user);

    Collection<UserDto> userToUserDto(Collection<User> users);

}
