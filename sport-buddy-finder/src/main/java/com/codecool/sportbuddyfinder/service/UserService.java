package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.model.DTO.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.repository.UserRepository;
import com.codecool.sportbuddyfinder.service.DAO.userdao.UserDao;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Set<User> getAllUsers(){
        return userRepository.getAllUser();
    }
    public User getUserById(int id){
        return userRepository.getUserById(id);
    }
    public boolean addUser(NewUserDTO newUserDTO){
        return userRepository.addUser(newUserDTO);
    }
    public User loginUser(LoginUserDTO loginUserDTO){
        return userRepository.findByEmailAndPassword(loginUserDTO.email(), loginUserDTO.password());
    }
    public boolean updateUser(int userID,User updatedUser){
        return userRepository.updateUser(userID, updatedUser);
    }
    public boolean deleteUserById(int userId){
       return userRepository.deleteUserByID(userId);
    }

}
