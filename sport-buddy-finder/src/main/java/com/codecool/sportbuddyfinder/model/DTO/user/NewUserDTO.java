package com.codecool.sportbuddyfinder.model.DTO.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record NewUserDTO(String name, String email, String password, int[] interests,
                         @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING) LocalDate date) {
}
