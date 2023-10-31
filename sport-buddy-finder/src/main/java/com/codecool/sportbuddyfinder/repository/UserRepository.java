package com.codecool.sportbuddyfinder.repository;

import com.codecool.sportbuddyfinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
