package com.codecool.sportbuddyfinder.service.DAO.userdao;

import com.codecool.sportbuddyfinder.model.DTO.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.User;

import java.util.Set;
import java.util.UUID;

public interface UserDao {
    public Set<User> getAllUser();
    public User getUserById(UUID id);
    public boolean addUser(NewUserDTO newUser);
    public User loginUser(LoginUserDTO loginUserDTO);
    public boolean updateUser(UUID userID, User updatedUser);
    public boolean deleteUserByID(UUID id);

}
