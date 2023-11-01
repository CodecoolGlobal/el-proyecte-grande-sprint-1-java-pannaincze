package com.codecool.sportbuddyfinder.model.activity;

import com.codecool.sportbuddyfinder.model.entities.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Activity {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    private Sport sport;
    private String location;
    private Integer minPeopleToFind;
    private Integer maxPeopleToFind;

    @ManyToOne
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id"
    )
    @Cascade(CascadeType.MERGE)
    private User user;

    @ManyToMany
    private final Set<User> appliedUsers;
    private Status postStatus;

    public Activity() {
        this.postStatus = Status.OPEN;
        this.appliedUsers = new HashSet<>();
    }

    public Activity(User user, String title, String description, Sport sport, String location, Integer minPeopleToFind, Integer maxPeopleToFind) {
        this.user = user;
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

}
