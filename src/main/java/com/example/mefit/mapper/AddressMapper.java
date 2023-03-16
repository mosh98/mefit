package com.example.mefit.mapper;

import com.example.mefit.models.Address;
import com.example.mefit.models.Profile;
import com.example.mefit.models.dto.AddressDto;
import com.example.mefit.models.dto.ProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "profile.id", source = "profile")
    Address addressDtoToAddress(AddressDto addressDto);

    @Mapping(target = "profile", source = "profile.id")
    AddressDto addressToAddressDto(Address address);

    Collection<AddressDto> addressToAddressDto(Collection<Address> addresses);
}
