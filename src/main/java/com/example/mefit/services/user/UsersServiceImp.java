package com.example.mefit.services.user;

import com.example.mefit.models.Users;
import com.example.mefit.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UsersServiceImp implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImp(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users findById(Integer id) {
        Optional<Users> users =  usersRepository.findById(id);

        if(users.isPresent()){
            return users.get();
        }else{
            throw new RuntimeException("User not found");
        }
    }


    @Override
    public Collection<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users add(Users entity) {
        return usersRepository.save(entity);
    }

    @Override
    public Users update(Users entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Collection<Users> findAllByFirstName(String firstName) {
        return null;
    }
}
