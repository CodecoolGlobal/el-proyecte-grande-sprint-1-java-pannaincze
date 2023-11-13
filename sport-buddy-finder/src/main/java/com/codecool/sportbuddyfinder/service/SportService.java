package com.codecool.sportbuddyfinder.service;

import com.codecool.sportbuddyfinder.model.entities.Sport;
import com.codecool.sportbuddyfinder.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class SportService {
    private SportRepository sportRepository;
    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }
    public List<Sport> getAll() {
        return sportRepository.findAll();
    }
}
