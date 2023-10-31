package com.codecool.sportbuddyfinder.repository;

import com.codecool.sportbuddyfinder.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     // Set<User> findAllUser();
     User getUserByUser_ID(long id);
     // boolean addUser(NewUserDTO newUser);
     User findByEmailAndPassword(String email, String password);
     // boolean updateUser(long userID, User updatedUser);
     // boolean deleteUserByID(long id);
}
