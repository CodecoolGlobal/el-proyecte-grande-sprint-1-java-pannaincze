package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.DTO.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.model.payload.TokenResponse;
import com.codecool.sportbuddyfinder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
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
    public Optional<User> loginUser(@PathVariable String email, @PathVariable String password){
        return userService.loginUser(new LoginUserDTO(email, password));
    }
    @PostMapping
    public ResponseEntity<TokenResponse> registerUser(@RequestBody NewUserDTO newUserDTO){
        return ResponseEntity.ok(userService.addUser(newUserDTO));
    }


    @PutMapping("/{userID}")
    public boolean updateUser(@PathVariable int userID, @RequestBody User updatedUser){
        return userService.updateUser(userID, updatedUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId){
        userService.deleteUserById(userId);
    }

}
