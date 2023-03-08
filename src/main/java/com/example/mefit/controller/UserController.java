package com.example.mefit.controller;

import com.example.mefit.mapper.UserMapper;
import com.example.mefit.models.User;
import com.example.mefit.models.dto.UserDto;
import com.example.mefit.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private final UserMapper userMapper;


    //make a get method to get all users
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<UserDto> getAllUsers(){
        //userService.findAll().forEach(System.out::println);
        return userMapper.userToUserDto(userService.findAll());
    }

    //insert a new user
    //make a post method to insert a new user
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserDto insertUser(@RequestBody UserDto userDto){
        User user = userService.add(userMapper.userDtoToUser(userDto));

        UserDto returnNewUserDto = userMapper.userToUserDto(user);

        return returnNewUserDto;
    }
}
