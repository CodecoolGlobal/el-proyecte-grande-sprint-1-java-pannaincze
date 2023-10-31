package com.codecool.sportbuddyfinder.repository;

import com.codecool.sportbuddyfinder.model.DTO.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

     Set<User> getAllUser();
     User getUserById(long id);
     boolean addUser(NewUserDTO newUser);
     User findByEmailAndPassword(String email, String password);
     boolean updateUser(long userID, User updatedUser);
     boolean deleteUserByID(long id);
}
