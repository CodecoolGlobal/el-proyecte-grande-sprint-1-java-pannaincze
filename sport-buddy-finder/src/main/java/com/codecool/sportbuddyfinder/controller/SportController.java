package com.codecool.sportbuddyfinder.controller;

import com.codecool.sportbuddyfinder.model.entities.Sport;
import com.codecool.sportbuddyfinder.service.SportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportController {
    private SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }
    @GetMapping
    public List<Sport> getAllSports(){
        return sportService.getAll();
    }
}
