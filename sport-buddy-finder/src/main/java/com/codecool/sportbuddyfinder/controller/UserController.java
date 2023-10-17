package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.User;
import com.codecool.sportbuddyfinder.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public Set<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{userID}")
    public User getUserByID(@PathVariable UUID userID){
        return userService.getUserById(userID);
    }
    @PostMapping
    public boolean postUser(User user){
        return userService.addUser(user);
    }
    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable UUID userId){
        return userService.deleteUserById(userId);
    }
    @PutMapping("/{userID}")
    public boolean updateUser(@PathVariable UUID userID){
        return userService.updateUser(userID);
    }

}