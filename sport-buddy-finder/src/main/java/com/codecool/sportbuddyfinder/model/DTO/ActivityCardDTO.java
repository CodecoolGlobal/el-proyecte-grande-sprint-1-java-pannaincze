package com.codecool.sportbuddyfinder.model.DTO;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.activity.Sport;
import lombok.Getter;


@Getter
public class ActivityCardDTO {

    private final long id;
    private final String image;
    private final String title;
    private final Sport sport;
    private final String location;
    private final Integer maxPeopleToFind;
    private final Integer minPeopleToFind;

    public ActivityCardDTO(long id, String image, String title, Sport sport, String location, Integer maxPeopleToFind, Integer minPeopleToFind) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.sport = sport;
        this.location = location;
        this.maxPeopleToFind = maxPeopleToFind;
        this.minPeopleToFind = minPeopleToFind;
    }

    public ActivityCardDTO(Activity activity) {
        this.id = activity.getId();
        this.image = activity.getImage();
        this.title = activity.getTitle();
        this.sport = activity.getSport();
        this.location = activity.getLocation();
        this.maxPeopleToFind = activity.getMaxPeopleToFind();
        this.minPeopleToFind = activity.getMinPeopleToFind();
    }
}
