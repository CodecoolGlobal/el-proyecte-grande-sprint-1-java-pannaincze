package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.exception.UserNotFoundException;
import com.codecool.sportbuddyfinder.model.DTO.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.model.payload.TokenAndUserResponse;
import com.codecool.sportbuddyfinder.model.payload.TokenResponse;
import com.codecool.sportbuddyfinder.repository.SportRepository;
import com.codecool.sportbuddyfinder.repository.UserRepository;
import com.codecool.sportbuddyfinder.security.configuration.JwtUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SportRepository sportRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtService;
    private final AuthenticationManager authenticationManager;


    public Set<User> getAllUsers() {
        //return userRepository.getAllUser();
        return null;
    }

    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public TokenResponse addUser(NewUserDTO newUserDTO) {
        //return userRepository.addUser(newUserDTO);
        //TODO
        User user = new User(newUserDTO.name(), newUserDTO.email(), passwordEncoder.encode(newUserDTO.password()), newUserDTO.date());
        //user.addInterests(newUserDTO.interests());
        for (int sportId: newUserDTO.interests()) {
            user.addInterest(sportRepository.findSportById(sportId).get());
        }

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return TokenResponse.builder().token(jwtToken).build();
    }

    public TokenAndUserResponse loginUser(LoginUserDTO loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.email(),
                loginRequest.password()
        ));

        User user = userRepository.findByEmail(loginRequest.email()).orElseThrow();

        String jwtToken = jwtService.generateToken(user);

        return TokenAndUserResponse.builder()
                .token(jwtToken)
                .user(user)
                .build();
    }

    public boolean updateUser(int userID, User updatedUser) {
        // TODO
        //return userRepository.updateUser(userID, updatedUser);
        return false;
    }

    @Transactional
    public void deleteUserById(long userId) {
        userRepository.deleteUserById(userId);
    }

}
