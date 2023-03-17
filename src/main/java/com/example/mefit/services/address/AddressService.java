package com.example.mefit.services.address;

import com.example.mefit.models.Address;
import com.example.mefit.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface AddressService extends CrudService<Address, Integer> {

    Address update(Integer id, Address address);
}
