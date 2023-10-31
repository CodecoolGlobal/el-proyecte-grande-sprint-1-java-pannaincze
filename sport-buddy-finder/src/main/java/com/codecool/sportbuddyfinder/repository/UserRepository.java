package com.codecool.sportbuddyfinder.repository;

import com.codecool.sportbuddyfinder.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Set<User> getAllUser();
    // User getUserById(UUID id);
    // boolean addUser(NewUserDTO newUser);
    // User loginUser(LoginUserDTO loginUserDTO);
    // boolean updateUser(UUID userID, User updatedUser);
    // boolean deleteUserByID(UUID id);
}
