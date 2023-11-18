package com.codecool.sportbuddyfinder.model.DTO.activity;

import com.codecool.sportbuddyfinder.model.activity.Sport;
import lombok.Data;

@Data
public class NewActivityDTO {
    private String title;
    private String description;
    private Sport sport;
    private String location;
    private Integer minPeopleToFind;
    private Integer maxPeopleToFind;
    private long userId;
    private String image;
}
