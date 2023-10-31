package com.codecool.sportbuddyfinder.model;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.activity.Sport;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import java.util.Objects;

import java.util.HashSet;
import java.util.Set;

import java.util.UUID;
@Setter
@Getter
public class User {
    private String name;
    private UUID userID;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String profilePicURL;
    private final Set<Sport> interests;
    private final Set<Activity> postedActivities;

    public User() {
        this.profilePicURL = "https://thumbs.dreamstime.com/b/head-silhouette-face-front-view-human-elegant-part-human-vector-illustration-79409597.jpg";
        this.interests = new HashSet<>();
        this.userID = UUID.randomUUID();
        this.postedActivities = new HashSet<>();
    }

    public User(String name, String email, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.profilePicURL = "https://thumbs.dreamstime.com/b/head-silhouette-face-front-view-human-elegant-part-human-vector-illustration-79409597.jpg";
        this.interests = new HashSet<>();
        this.userID = UUID.randomUUID();
        this.postedActivities = new HashSet<>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }
    public Set<Sport> getInterests() {
        return new HashSet<>(interests);
    }
    public void addInterest(Sport sport){
        interests.add(sport);
    }
    public void addInterests(Set<Sport> interests){
        this.interests.addAll(interests);
    }
    public void addPostedActivity(Activity activity){
        postedActivities.add(activity);
    }
    public void addPostedActivities(Set<Activity> activities){
        this.postedActivities.addAll(activities);
    }
    public Set<Activity> getActivityPosts(){
        return new HashSet<>(postedActivities);

    }
}
