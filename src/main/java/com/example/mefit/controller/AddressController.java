package com.example.mefit.controller;

import com.example.mefit.mapper.AddressMapper;
import com.example.mefit.models.Address;
import com.example.mefit.models.User;
import com.example.mefit.models.dto.AddressDto;
import com.example.mefit.models.dto.UserDto;
import com.example.mefit.services.address.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    // Make a get method to get all addresses
    @Operation(summary = "Get all addresses", description = "Returns a list of all addresses in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Addresses retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AddressDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<AddressDto> getAllAddresses() {
        return addressMapper.addressToAddressDto(addressService.findAll());
    }

    // Make a get method to get an address by id
    @Operation(summary = "Get an address by id", description = "Returns an address from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address found successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AddressDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Address not found", content = @Content)
    })
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public AddressDto getAddressById(@PathVariable Integer id) {
        return addressMapper.addressToAddressDto(addressService.findById(id));
    }
/*
    // Make a put method to update an address
    @Operation(summary = "Update an address by id", description = "Updates an existing address in the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address updated successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = AddressDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input or validation error",
                    content = {@Content}),
            @ApiResponse(responseCode = "404", description = "Address not found",
                    content = {@Content}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content})
    })
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public AddressDto updateAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto) {

        if (!addressService.exists(id)) {
            throw new RuntimeException("The address with id " + id + " does not exist");
        }
        if (!id.equals(addressDto.getId())) {
            throw new RuntimeException("The id in the path must be the same as the id in the body");
        }

        Address address = addressService.update(addressMapper.addressDtoToAddress(addressDto));

        return addressMapper.addressToAddressDto(address);
    }

 */
    //Update address by id
    @Operation(summary = "Update address by id", description = "Update address by id")
    @ApiResponse(responseCode = "200", description = "Address updated")
    @ApiResponse(responseCode = "404", description = "Address not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PatchMapping()
    @RequestMapping(path = "/updateAddress/{id}",method = RequestMethod.PATCH)
    public AddressDto updateAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto){

        Address address = addressMapper.addressDtoToAddress(addressDto);

        return addressMapper.addressToAddressDto(addressService.update(id,address));
    }

}
