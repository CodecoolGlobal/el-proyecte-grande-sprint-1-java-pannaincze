package com.codecool.sportbuddyfinder.service.DAO.userdao;

import com.codecool.sportbuddyfinder.model.User;
import com.codecool.sportbuddyfinder.model.activity.Activity;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
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
    public User getUserById(UUID id) {
        return userRepository.stream().filter(user -> user.getUserID().equals(id)).findAny().orElse(null);
    }

    @Override
    public boolean addUser(User user) {
        return userRepository.add(user);
    }

    @Override
    public boolean updateUser(UUID userId, User updatedUser) {
        Optional<User> userToUpdate = userRepository.stream().filter(user -> user.getUserID().equals(userId)).findAny();
        if(userToUpdate.isPresent()){
            if(updatedUser.getName() != null){
                userToUpdate.get().setName(updatedUser.getName());
            }
            if(updatedUser.getActivityPosts() != null){
                addNewActivitiesToUser(userToUpdate.get(),updatedUser);
            }
        }
        return false;
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
    public boolean deleteUserByID(UUID id) {
        Optional<User> userToDelete = userRepository.stream().filter(user -> user.getUserID().equals(id)).findAny();
        if(userToDelete.isPresent()){
            userRepository.remove(userToDelete.get());
            return true;
        }
        return false;
    }
}
