package com.example.mefit.controller;

import com.example.mefit.mapper.AddressMapper;
import com.example.mefit.mapper.GoalMapper;
import com.example.mefit.mapper.ProfileMapper;
import com.example.mefit.mapper.UserMapper;
import com.example.mefit.models.Address;
import com.example.mefit.models.Goal;
import com.example.mefit.models.Profile;
import com.example.mefit.models.User;
import com.example.mefit.models.dto.AddressDto;
import com.example.mefit.models.dto.GoalDto;
import com.example.mefit.models.dto.ProfileDto;
import com.example.mefit.models.dto.UserDto;
import com.example.mefit.services.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    private final AddressMapper addressMapper;

    private final GoalMapper goalmapper;

    private final ProfileMapper profileMapper;


    //make a get method to get all users
    @Operation(summary = "Get all users", description = "Retrieves a list of all users in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/allUsers")
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<UserDto> getAllUsers(){

        return userMapper.userToUserDto(userService.findAll());
    }

    // Make a get method to get a user by id
    @Operation(summary = "Get a user by ID", description = "Retrieve a user from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
    @GetMapping("/userById/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto getUserById(@PathVariable Integer id){
        User user = userService.findById(id);

        return userMapper.userToUserDto(user);
    }

    // Make a post method to insert a new user

    @Operation(summary = "Create a new user")
    @ApiResponse(responseCode = "201", description = "User created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class)))
    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content)
    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    @PostMapping("/newUser")
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserDto insertUser(@RequestBody UserDto userDto){
        System.out.println("USER KEYCLOAK ID: " + userDto.getKeyCloakId());
        User user = userService.add(userMapper.userDtoToUser(userDto));

        return userMapper.userToUserDto(user);
    }

/*
    @GetMapping("/addressByUserId/{id}")
    @ResponseStatus(value=HttpStatus.OK)
    public Address getAddressByUserId(@PathVariable Integer id ){

        Address userAddress= userService.getUserAddress(id);
        return userAddress;
    }

 */
    @Operation(summary = "Get user´s profile by id", description = "Returns a user's profile from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User profile found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfileDto.class))}),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/profileByUserId/{id}")
    @ResponseStatus(value=HttpStatus.OK)
    public ProfileDto getProfileByUserId(@PathVariable Integer id ){

        Profile userProfile= userService.getUserProfile(id);

        return profileMapper.profileToProfileDto(userProfile);
    }

    @Operation(summary = "Get user´s address by id", description = "Retrieves the address information for a user with the specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address information found", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AddressDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/addressByUserId/{id}")
    @ResponseStatus(value=HttpStatus.OK)
    public AddressDto getAddressByUserId(@PathVariable Integer id ){

        Address userAddress= userService.getUserAddress(id);

        return addressMapper.addressToAddressDto(userAddress);
    }

    @Operation(summary = "Get user's goal by id", description = "Retrieves the goal of a user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Goal retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GoalDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/goalByUserId/{id}")
    @ResponseStatus(value=HttpStatus.OK)
    public GoalDto getGoalByUserId(@PathVariable Integer id ){

        Goal userGoal= userService.getUserGoal(id);

        return goalmapper.goalToGoalDto(userGoal);
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
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PatchMapping()
    @RequestMapping(path = "/updateUser/{id}",method = RequestMethod.PATCH)
    public UserDto updateUser(@PathVariable Integer id, @RequestBody UserDto userDto){

        User user = userMapper.userDtoToUser(userDto);

        return userMapper.userToUserDto(userService.update(id,user));
    }

    //delete user by id
    @Operation(summary = "Delete a user by id", description = "Deletes a user from the system by ID")
    @ApiResponse(responseCode = "200", description = "User deleted successfully",content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "User not found",content = @Content)
    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
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
}
