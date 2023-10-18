package com.codecool.sportbuddyfinder.model;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.codecool.sportbuddyfinder.model.activity.Sport;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class User {
    private String name;
    private final UUID userID;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String profilePicURL;
    private final Set<Sport> interests;
    private Set<Activity> postedActivities;
    public User(String name, String email, String password, LocalDate birthDate, List<Sport> interests) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.profilePicURL = "https://thumbs.dreamstime.com/b/head-silhouette-face-front-view-human-elegant-part-human-vector-illustration-79409597.jpg";
        this.interests = new HashSet<>(interests);
        this.userID = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }

    public Set<Sport> getInterests() {
        return interests;
    }
    public void addInterest(Sport sport){
        interests.add(sport);
    }
    public void addInterests(Set<Sport> interests){
        this.interests.addAll(interests);
    }
}
