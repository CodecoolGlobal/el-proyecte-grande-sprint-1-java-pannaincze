package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.User;
import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.activity.Sport;
import com.codecool.sportbuddyfinder.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
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
    @ResponseBody
    public boolean postUser(@RequestBody NewUserDTO newUserDTO){
        return userService.addUser(newUserDTO);
    }
    @PutMapping("/{userID}")
    public boolean updateUser(@PathVariable UUID userID, @RequestBody User updatedUser){
        return userService.updateUser(userID, updatedUser);
    }
    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable UUID userId){
        return userService.deleteUserById(userId);
    }

}
