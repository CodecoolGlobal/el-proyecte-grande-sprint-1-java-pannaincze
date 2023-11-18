package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.DTO.user.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.user.NewUserDTO;
import com.codecool.sportbuddyfinder.model.entities.Sport;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.model.payload.TokenAndUserResponse;
import com.codecool.sportbuddyfinder.model.payload.TokenResponse;
import com.codecool.sportbuddyfinder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
    @PostMapping("/login")
    public ResponseEntity<TokenAndUserResponse> loginUser(@RequestBody LoginUserDTO loginRequest){
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @GetMapping("/current-user")
    public User getUserByEmailAndPassword(@RequestBody String email,@RequestBody String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }

    @PostMapping
    public ResponseEntity<TokenResponse> registerUser(@RequestBody NewUserDTO newUserDTO){
        return ResponseEntity.ok(userService.addUser(newUserDTO));
    }


    @PutMapping("/{userID}")
    public boolean updateUser(@PathVariable int userID, @RequestBody Sport interests){
        return userService.updateUser(userID, interests);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId){
        userService.deleteUserById(userId);
    }

}
