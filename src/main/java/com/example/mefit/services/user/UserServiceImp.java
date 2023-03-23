package com.example.mefit.services.user;

import com.example.mefit.models.Address;
import com.example.mefit.models.Goal;
import com.example.mefit.models.Profile;
import com.example.mefit.models.User;
import com.example.mefit.repositories.AddressRepository;
import com.example.mefit.repositories.GoalRepository;
import com.example.mefit.repositories.ProfileRepository;
import com.example.mefit.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;

    private final GoalRepository goalRepository;


    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User entity) {
        //TODO: before adding user chekc if any user exist with the same keycloak id
        userRepository.findByKeyCloakId(entity.getKeyCloakId()).ifPresent(user -> {
            throw new IllegalStateException("User exists with the same keycloak id");
        });


        //check if keycloak id is already in the database
        Optional<User> user = userRepository.findByKeyCloakId(entity.getKeyCloakId());

        if(user.isPresent()) {
            
            return user.get();

        }


        Profile profile = new Profile();

        profile.setUser(entity);


        profile.setAddress(new Address());
        profile.getAddress().setProfile(profile);
        entity.setProfile(profile);

        profileRepository.save(entity.getProfile());
        addressRepository.save(entity.getProfile().getAddress());



        return userRepository.save(entity);
    }

    public Address getUserAddress(Integer id) {
        User user = userRepository.findById(id).get();
        if(user!=null){
            System.out.println(user.toString());
            System.out.println(user.getProfile().getAddress().getAddress());
            return user.getProfile().getAddress();
        }
        return null;
    }

    public Goal getUserGoal(Integer id) {
        User user = userRepository.findById(id).get();
        if(user!=null){
            System.out.println(user.toString());
            System.out.println(user.getProfile().getGoal().getEndDate());
            return user.getProfile().getGoal();
        }
        return null;
    }

    public Profile getUserProfile(Integer id) {
        User user = userRepository.findById(id).get();
        if(user!=null){
            System.out.println(user.toString());
            System.out.println(user.getProfile().getHeight());
            return user.getProfile();
        }
        return null;
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(Integer id, User user) {
        //Old user
        User existingUser = userRepository.findById(id).get();

        if(existingUser==null){
            return null;
        }
        if(user.getPassword()!= null){
            existingUser.setPassword(user.getPassword());
        }
        if(user.getE_mail()!=null){
            existingUser.setPassword(user.getPassword());
        }
        if(user.getFirst_name()!=null){
            existingUser.setFirst_name(user.getFirst_name());
        }
        if(user.getLast_name()!=null){
            existingUser.setLast_name(user.getLast_name());
        }
        if (user.getUserType() != null) {
            existingUser.setUserType(user.getUserType());
        }
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteById(Integer id) {
        /**
         * TODO: remove adress, goal and profile from user ()
         * TODO: in order to remove profile we need to remove profile from adress
         * TODO: in order to remove profile we need to remove profile from goal
         */
        //get user by id
        User user = findById(id);

        //get user profile
        Profile profile = user.getProfile();

        //get profile goal
        Goal goal = profile.getGoal();
            //from the goal object set profile to null

        //get profile adress
        Address address= profile.getAddress();
            //from the address object set profile to null

        goal.setProfile(null);
        address.setProfile(null);
        profile.setUser(null);
        profile.setAddress(null);
        profile.setGoal(null);
        user.setProfile(null);

        //radera profile
        profileRepository.deleteById(profile.getId());

        //radera adress
        addressRepository.deleteById(address.getId());


        userRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public Collection<User> findAllByFirstName(String firstName) {
        return null;
    }

    @Override
    public Optional<User> findByKeyCloakId(String keyCloakId) {
        return userRepository.findByKeyCloakId(keyCloakId);
    }
}
