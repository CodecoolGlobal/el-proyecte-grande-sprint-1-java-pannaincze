package com.codecool.sportbuddyfinder.service.DAO.userdao;

import com.codecool.sportbuddyfinder.model.DTO.LoginUserDTO;
import com.codecool.sportbuddyfinder.model.DTO.NewUserDTO;
import com.codecool.sportbuddyfinder.model.entities.User;
import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.entities.Sport;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUserDAO implements UserDao {
    private final Set<User> userRepository;

    public MemoryUserDAO() {
        this.userRepository = new HashSet<>();
    }

    @Override
    public Set<User> getAllUser() {
        return new HashSet<>(userRepository);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.stream().filter(user -> user.getId() == (id)).findAny().orElse(null);
    }

    @Override
    public boolean addUser(NewUserDTO newUserDTO) {
        User user = new User(newUserDTO.name(), newUserDTO.email(), newUserDTO.password(), newUserDTO.date());
        user.addInterests(Set.of(newUserDTO.interests()));
        if (!emailExistsInRepository(user)) return userRepository.add(user);
        return false;
    }

    @Override
    public User loginUser(LoginUserDTO loginUserDTO) {
        for (User user : userRepository){
            if (user.getEmail().equals(loginUserDTO.email()) && user.getPassword().equals(loginUserDTO.password())){
                return user;
            }
        }
        return null;
    }


    @Override
    public boolean updateUser(int userId, User updatedUser) {
        Optional<User> userToUpdate = userRepository.stream().filter(user -> user.getId() == (userId)).findAny();
        if(userToUpdate.isPresent()){
            if(updatedUser.getName() != null && !updatedUser.getName().isEmpty()){
                userToUpdate.get().setName(updatedUser.getName());
            }
            if(updatedUser.getActivityPosts() != null){
                addNewActivitiesToUser(userToUpdate.get(),updatedUser);
            }
            if(updatedUser.getBirthDate() != null){
                userToUpdate.get().setBirthDate(updatedUser.getBirthDate());
            }
            if(updatedUser.getEmail() != null && !updatedUser.getEmail().isEmpty()){
                userToUpdate.get().setEmail(updatedUser.getEmail());
            }
            if(updatedUser.getInterests() != null){
                addNewInterests(userToUpdate.get(),updatedUser);
            }
            return true;
        }
        return false;
    }
    private void addNewInterests(User userToUpdate, User updatedUser){
        Set<Sport> newInterests = updatedUser.getInterests();
        for(Sport interest : userToUpdate.getInterests()){
            for(Sport newInterest : newInterests){
                if(interest != newInterest){
                    userToUpdate.addInterest(newInterest);
                }
            }
        }
    }
    private void addNewActivitiesToUser(User userToUpdate, User updatedUser){
        Set<Activity> newActivities = updatedUser.getActivityPosts();
        for(Activity activity : userToUpdate.getActivityPosts()){
            for(Activity newActivity : newActivities){
                if(!activity.equals(newActivity)){
                    userToUpdate.addPostedActivity(newActivity);
                }
            }
        }
    }
    @Override
    public boolean deleteUserByID(int id) {
        Optional<User> userToDelete = userRepository.stream().filter(user -> user.getId() == (id)).findAny();
        if(userToDelete.isPresent()){
            userRepository.remove(userToDelete.get());
            return true;
        }
        return false;
    }
    private boolean emailExistsInRepository(User user) {
        for (User u : userRepository) {
            if(u.getEmail().equals(user.getEmail())){
                return true;
            }
        }
        return false;
    }
}
