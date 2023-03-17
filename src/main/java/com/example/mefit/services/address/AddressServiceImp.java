package com.example.mefit.services.address;

import com.example.mefit.models.Address;
import com.example.mefit.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address findById(Integer id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Collection<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address add(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Address update(Address entity) {
        return addressRepository.save(entity);
    }

    public Address update(Integer id, Address address) {
        //Old address
        Address existingAddress = addressRepository.findById(id).get();

        if(existingAddress==null){
            return null;
        }
        if(address.getAddress()!=null){
            existingAddress.setAddress(address.getAddress());
        }
        if(address.getPost_code()!=null){
            existingAddress.setPost_code(address.getPost_code());
        }
        if(address.getCity()!=null){
            existingAddress.setCity(address.getCity());
        }
        if(address.getCountry()!=null){
            existingAddress.setCountry(address.getCountry());
        }
        return addressRepository.save(existingAddress);
    }

    @Override
    public void deleteById(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return addressRepository.existsById(id);
    }
}
