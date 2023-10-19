package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.User;
import com.codecool.sportbuddyfinder.service.DAO.userdao.UserDao;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
@Service
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Set<User> getAllUsers(){
        return userDao.getAllUser();
    }
    public User getUserById(UUID id){
        return userDao.getUserById(id);
    }
    public boolean addUser(NewUserDTO newUserDTO){
        return userDao.addUser(newUserDTO);
    }
    public boolean updateUser(UUID userID,User updatedUser){
        return userDao.updateUser(userID, updatedUser);
    }
    public boolean deleteUserById(UUID userId){
       return userDao.deleteUserByID(userId);
    }

}
