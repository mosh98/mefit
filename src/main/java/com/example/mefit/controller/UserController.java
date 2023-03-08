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

        return userMapper.userToUserDto(userService.findAll());
    }

    // Make a get method to get a user by id
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto getUserById(@PathVariable Integer id){
        User user = userService.findById(id);

        return userMapper.userToUserDto(user);
    }

    // Make a post method to insert a new user
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserDto insertUser(@RequestBody UserDto userDto){
        User user = userService.add(userMapper.userDtoToUser(userDto));

        return userMapper.userToUserDto(user);
    }
}
