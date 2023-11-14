package com.codecool.sportbuddyfinder.model.payload;

import com.codecool.sportbuddyfinder.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenAndUserResponse {
    private String token;
    private User user;
}
