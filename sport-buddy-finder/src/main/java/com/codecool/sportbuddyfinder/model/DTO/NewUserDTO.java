package com.codecool.sportbuddyfinder.model.DTO;

import com.codecool.sportbuddyfinder.model.activity.Sport;

import java.time.LocalDate;

public record NewUserDTO(String name, String email, String password, Sport[] interests, LocalDate date) {
}
