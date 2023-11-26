package com.codecool.sportbuddyfinder.model.DTO.activity;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.activity.Sport;
import lombok.Data;

@Data
public class ActivityCardDTO {
    private long id;
    private String title;
    private Sport sport;
    private String location;
    private Integer minPeopleToFind;
    private Integer maxPeopleToFind;
    private String image;
    private Integer numberOfAppliedUsers;

    public ActivityCardDTO(Activity activity) {
        this.id = activity.getId();
        this.title = activity.getTitle();
        this.sport = activity.getSport();
        this.location = activity.getLocation();
        this.minPeopleToFind = activity.getMinPeopleToFind();
        this.maxPeopleToFind = activity.getMaxPeopleToFind();
        this.image = activity.getImage();
        this.numberOfAppliedUsers = activity.getAppliedUsers().size();
    }
}
