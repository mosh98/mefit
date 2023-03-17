package com.example.mefit.controller;

import com.example.mefit.mapper.AddressMapper;
import com.example.mefit.models.Address;
import com.example.mefit.models.dto.AddressDto;
import com.example.mefit.services.address.AddressService;

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

    // Make a get method to get all profiles
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<AddressDto> getAllAddresses() {
        return addressMapper.addressToAddressDto(addressService.findAll());
    }

    // Make a get method to get a profile by id
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public AddressDto getAddressById(@PathVariable Integer id) {
        return addressMapper.addressToAddressDto(addressService.findById(id));
    }

    // Make a put method to update a profile
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public AddressDto updateAddress(@PathVariable Integer id, @RequestBody AddressDto addressDto) {

        if (!addressService.exists(id)) {
            throw new RuntimeException("The address with id " + id + " does not exist");
        }
        if (!id.equals(addressDto.getId())) {
            throw new RuntimeException("The id in the path must be the same as the id in the body");
        }
        // Dont update user id


        Address address = addressService.update(addressMapper.addressDtoToAddress(addressDto));

        return addressMapper.addressToAddressDto(address);
    }

}
