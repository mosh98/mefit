package com.example.mefit.controller;

import com.example.mefit.models.Users;
import com.example.mefit.services.user.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    //make a get method to get all users
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<Users> getAllUsers(){
        usersService.findAll().forEach(System.out::println);
        return usersService.findAll();
    }

    //insert a new user
    //make a post method to insert a new user
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Users insertUser(@RequestBody Users users){
        return usersService.add(users);
    }

}
