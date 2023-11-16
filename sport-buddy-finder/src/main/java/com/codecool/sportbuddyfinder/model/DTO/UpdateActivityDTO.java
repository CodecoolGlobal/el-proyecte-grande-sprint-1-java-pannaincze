package com.codecool.sportbuddyfinder.model.DTO;

import com.codecool.sportbuddyfinder.model.activity.Sport;
import com.codecool.sportbuddyfinder.model.activity.Status;
import lombok.Data;

@Data
public class UpdateActivityDTO {
    private long id;
    private String title;
    private String description;
    private Sport sport;
    private String location;
    private Integer minPeopleToFind;
    private Integer maxPeopleToFind;
    private String image;
    private Status postStatus;
}
