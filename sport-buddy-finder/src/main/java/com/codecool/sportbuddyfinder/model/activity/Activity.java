package com.codecool.sportbuddyfinder.model.activity;

import java.util.Objects;
import java.util.UUID;

public class Activity {
    private final UUID uuid;
    private String title;
    private String description;
    private final Sport sport;
    private final String location;
    private Integer minPeopleToFind;
    private Integer maxPeopleToFind;

    public Activity(String title, String description, Sport sport, String location, Integer minPeopleToFind, Integer maxPeopleToFind) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.sport = sport;
        this.location = location;
        this.minPeopleToFind = minPeopleToFind;
        this.maxPeopleToFind = maxPeopleToFind;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Sport getSport() {
        return sport;
    }

    public String getLocation() {
        return location;
    }

    public Integer getMinPeopleToFind() {
        return minPeopleToFind;
    }

    public Integer getMaxPeopleToFind() {
        return maxPeopleToFind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(uuid, activity.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
