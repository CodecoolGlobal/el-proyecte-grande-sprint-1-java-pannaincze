package com.codecool.sportbuddyfinder.model.DTO.user;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record NewUserDTO(String name, String email, String password, int[] interests, LocalDate date) {
}
