package com.codecool.sportbuddyfinder.repository;

import com.codecool.sportbuddyfinder.model.entities.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SportRepository extends JpaRepository<Sport, Long> {
    List<Sport> findAll();
    Optional<Sport> findSportById(long id);
}
