package com.codecool.sportbuddyfinder.service.DAO.userdao;

import com.codecool.sportbuddyfinder.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
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
        return null;
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(UUID userId) {
        return false;
    }

    @Override
    public boolean deleteUserByID(UUID id) {
        return false;
    }
}
