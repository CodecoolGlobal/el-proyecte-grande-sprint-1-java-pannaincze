package com.codecool.sportbuddyfinder.model.activity;

import com.codecool.sportbuddyfinder.model.User;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Setter
public class Activity {
    private final UUID uuid;
    private String title;
    private String description;
    private Sport sport;
    private String location;
    private Integer minPeopleToFind;
    private Integer maxPeopleToFind;
    private User user;
    private final Set<User> appliedUsers;
    private Status postStatus;

    public Activity() {
        this.uuid = UUID.randomUUID();
        this.postStatus = Status.OPEN;
        this.appliedUsers = new HashSet<>();
    }

    public Activity(User user, String title, String description, Sport sport, String location, Integer minPeopleToFind, Integer maxPeopleToFind) {
        this.user = user;
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.sport = sport;
        this.location = location;
        this.minPeopleToFind = minPeopleToFind;
        this.maxPeopleToFind = maxPeopleToFind;
        this.postStatus = Status.OPEN;
        this.appliedUsers = new HashSet<>();
    }

    public boolean addUserToAppliedSet(User user) {
        if (appliedUsers.size() < maxPeopleToFind) {
            appliedUsers.add(user);
            return true;
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public Set<User> getAppliedUsers() {
        return appliedUsers;
    }

    public Status getPostStatus() {
        return postStatus;
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
