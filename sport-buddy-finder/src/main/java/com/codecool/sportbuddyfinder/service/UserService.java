package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.model.User;
import com.codecool.sportbuddyfinder.service.DAO.userdao.UserDao;

import java.util.Set;
import java.util.UUID;

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
    public boolean addUser(User user){
        return userDao.addUser(user);
    }
    public boolean updateUser(User user){
        return userDao.updateUser(user);
    }
    public boolean deleteUserById(UUID userId){
       return userDao.deleteUserByID(userId);
    }

}
