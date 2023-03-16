package com.example.mefit.controller;

import com.example.mefit.mapper.UserMapper;
import com.example.mefit.models.Address;
import com.example.mefit.models.User;
import com.example.mefit.models.dto.UserDto;
import com.example.mefit.services.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
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


    @GetMapping("/addressByUserId/{id}")
    @ResponseStatus(value=HttpStatus.OK)
    public Address getAddressByUserId(@PathVariable Integer id ){

        Address userAddress= userService.getUserAddress(id);
        return userAddress;
    }

    /*
    // Make a put method to update a user
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto updateUser(@PathVariable Integer id, @RequestBody UserDto userDto){
        // Check if id exists
        if(!userService.exists(id)){
            throw new RuntimeException("The user with id " + id + " does not exist");
        }
        // Check if the id in the path is the same as the id in the body
        if(!id.equals(userDto.getId())){
            throw new RuntimeException("The id in the path must be the same as the id in the body");
        }

        // Dont update profile id to create a new profile if profile id already exists

        User user = userService.update(userMapper.userDtoToUser(userDto));

        return userMapper.userToUserDto(user);
    }

     */

    //Update user by id
    @Operation(summary = "Update user by id", description = "Update user by id")
    @ApiResponse(responseCode = "200", description = "User updated")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PatchMapping()
    @RequestMapping(path = "/updateUser/{id}",method = RequestMethod.PATCH)
    public UserDto updateUser(@PathVariable Integer id, @RequestBody UserDto userDto){

        User user = userMapper.userDtoToUser(userDto);

        return userMapper.userToUserDto(userService.update(id,user));
    }

    //delete user by id
    @DeleteMapping
    @RequestMapping(path = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){

        try{
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
              }catch (DataException e){
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
              }
    }

    /**
     *  public ResponseEntity<?> deleteExcercise(@PathVariable Integer id){
     *
     *         try {
     *             excerciseService.deleteById(id);
     *             return new ResponseEntity<>(HttpStatus.OK);
     *         }catch (DataException e){
     *             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     *         }
     *     }
     */
}
