package com.codecool.sportbuddyfinder.model.DTO;

import com.codecool.sportbuddyfinder.model.entities.Sport;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Builder
public record NewUserDTO(String name, String email, String password, int[] interests, LocalDate date) {
}
