package com.codecool.sportbuddyfinder.model.DTO.activity;

import com.codecool.sportbuddyfinder.model.DTO.user.UserInDisplayActivityDTO;
import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.activity.Sport;
import com.codecool.sportbuddyfinder.model.activity.Status;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class DisplayActivityDTO {
    private long id;
    private String title;
    private String description;
    private Sport sport;
    private String location;
    private Integer minPeopleToFind;
    private Integer maxPeopleToFind;
    private String image;
    private Status postStatus;
    private UserInDisplayActivityDTO user;
    private Set<UserInDisplayActivityDTO> appliedUsers;

    public DisplayActivityDTO(Activity activity) {
        this.id = activity.getId();
        this.title = activity.getTitle();
        this.description = activity.getDescription();
        this.sport = activity.getSport();
        this.location = activity.getLocation();
        this.minPeopleToFind = activity.getMinPeopleToFind();
        this.maxPeopleToFind = activity.getMaxPeopleToFind();
        this.image = activity.getImage();
        this.postStatus = activity.getPostStatus();
        this.user = new UserInDisplayActivityDTO(activity.getUser());
        this.appliedUsers = activity.getAppliedUsers().stream()
                .map(UserInDisplayActivityDTO::new).collect(Collectors.toSet());;
    }
}
