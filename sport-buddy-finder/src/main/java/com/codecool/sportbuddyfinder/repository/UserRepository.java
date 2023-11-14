package com.codecool.sportbuddyfinder.repository;

import com.codecool.sportbuddyfinder.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

     // Set<User> findAllUser();
     Optional<User> findById(long id);
     // boolean addUser(NewUserDTO newUser);
     Optional<User> findByEmail(String email);
     Optional<User> findByEmailAndPassword(String email, String password);
     // boolean updateUser(long userID, User updatedUser);
     void deleteUserById(long id);
}
