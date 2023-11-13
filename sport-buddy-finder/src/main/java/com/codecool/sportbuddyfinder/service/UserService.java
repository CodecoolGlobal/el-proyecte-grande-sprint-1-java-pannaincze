package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.model.DTO.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.repository.SportRepository;
import com.codecool.sportbuddyfinder.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private UserRepository userRepository;
    private final SportRepository sportRepository;

    public UserService(UserRepository userRepository, SportRepository sportRepository) {
        this.userRepository = userRepository;
        this.sportRepository = sportRepository;
    }

    public Set<User> getAllUsers(){
        //return userRepository.getAllUser();
        return null;
    }
    public User getUserById(long id){
        return userRepository.findById(id).get();
    }
    public boolean addUser(NewUserDTO newUserDTO){
        //return userRepository.addUser(newUserDTO);
        //TODO
        User user = new User(newUserDTO.name(), newUserDTO.email(), newUserDTO.password(), newUserDTO.date());
        //user.addInterests(newUserDTO.interests());
        for (int sportId: newUserDTO.interests()) {
            user.addInterest(sportRepository.findSportById(sportId).get());
        }
        userRepository.save(user);
        return false;
    }
    public Optional<User> loginUser(LoginUserDTO loginUserDTO){
        return userRepository.findByEmailAndPassword(loginUserDTO.email(), loginUserDTO.password());
    }
    public boolean updateUser(int userID,User updatedUser){
        // TODO
        //return userRepository.updateUser(userID, updatedUser);
        return false;
    }
    @Transactional
    public void deleteUserById(long userId){
        userRepository.deleteUserById(userId);
    }

}
