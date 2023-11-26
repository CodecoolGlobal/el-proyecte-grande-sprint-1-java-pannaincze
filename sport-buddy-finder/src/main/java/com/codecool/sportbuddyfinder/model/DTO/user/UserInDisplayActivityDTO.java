package com.codecool.sportbuddyfinder.model.DTO.user;

import com.codecool.sportbuddyfinder.model.entities.User;
import lombok.Data;

@Data
public class UserInDisplayActivityDTO {
    private long id;
    private String name;

    public UserInDisplayActivityDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
