package com.codecool.sportbuddyfinder.service.DAO.userdao;

import com.codecool.sportbuddyfinder.model.User;
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
        if (!emailExistsInRepository(user)) return userRepository.add(user);
        return false;
    }


    @Override
    public boolean updateUser(UUID userId) {
        return false;
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
    private boolean emailExistsInRepository(User user) {
        for (User u : userRepository) {
            if(u.getEmail().equals(user.getEmail())){
                return true;
            }
        }
        return false;
    }
}
