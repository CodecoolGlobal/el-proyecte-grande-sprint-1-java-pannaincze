package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.DTO.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.repository.UserRepository;
import com.codecool.sportbuddyfinder.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    @GetMapping
    public Set<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{userID}")
    public User getUserByID(@PathVariable long userID){
        return userService.getUserById(userID);
    }
    @GetMapping("/login/{email}/{password}")
    public User loginUser(@PathVariable String email, @PathVariable String password){
        return userService.loginUser(new LoginUserDTO(email, password));
    }
    @PostMapping
    @ResponseBody
    public boolean postUser(@RequestBody NewUserDTO newUserDTO){
        userService.addUser(newUserDTO);
        return false;
    }


    @PutMapping("/{userID}")
    public boolean updateUser(@PathVariable int userID, @RequestBody User updatedUser){
        return userService.updateUser(userID, updatedUser);
    }
    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable int userId){
        return userService.deleteUserById(userId);
    }

}
