package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.model.DTO.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.entities.Role;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.model.payload.TokenResponse;
import com.codecool.sportbuddyfinder.repository.SportRepository;
import com.codecool.sportbuddyfinder.repository.UserRepository;
import com.codecool.sportbuddyfinder.security.configuration.JwtUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
        return userRepository.findById(id).get();
    }

    public TokenResponse addUser(NewUserDTO newUserDTO) {
        //return userRepository.addUser(newUserDTO);
        //TODO

//        User user = new User(newUserDTO.name(), newUserDTO.email(), newUserDTO.password(), newUserDTO.date());
//        //user.addInterests(newUserDTO.interests());
//        for (int sportId: newUserDTO.interests()) {
//            user.addInterest(sportRepository.findSportById(sportId).get());
//        }
        User user = User.builder()
                .name(newUserDTO.name())
                .email(newUserDTO.email())
                .password(passwordEncoder.encode(newUserDTO.password()))
                .birthDate(newUserDTO.date())
                .role(Role.USER)
                .profilePicURL("https://thumbs.dreamstime.com/b/head-silhouette-face-front-view-human-elegant-part-human-vector-illustration-79409597.jpg")
                .build();

        for (int sportId: newUserDTO.interests()) {
            user.addInterest(sportRepository.findSportById(sportId).get());
        }
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return TokenResponse.builder().token(jwtToken).build();
    }

    public Optional<User> loginUser(LoginUserDTO loginUserDTO) {
        return userRepository.findByEmailAndPassword(loginUserDTO.email(), loginUserDTO.password());
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
