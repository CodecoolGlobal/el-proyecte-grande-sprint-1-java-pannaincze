package com.codecool.sportbuddyfinder.model.DTO.user;

import com.codecool.sportbuddyfinder.model.entities.Sport;
import com.codecool.sportbuddyfinder.model.entities.User;
import lombok.Data;

import java.util.Set;

@Data
public class GetUserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private String profilePicURL;
    private Set<Sport> interests;

    public GetUserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.profilePicURL = user.getProfilePicURL();
        this.interests = user.getInterests();         //probably should change to a DTO
    }
}
