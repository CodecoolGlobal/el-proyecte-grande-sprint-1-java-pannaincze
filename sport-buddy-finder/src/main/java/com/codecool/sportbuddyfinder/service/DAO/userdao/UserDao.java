package com.codecool.sportbuddyfinder.service.DAO.userdao;

import com.codecool.sportbuddyfinder.model.User;

import java.util.Set;
import java.util.UUID;

public interface UserDao {
    public Set<User> getAllUser();
    public User getUserById(UUID id);
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUserByID(UUID id);

}
