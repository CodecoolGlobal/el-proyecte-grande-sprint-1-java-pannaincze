package com.codecool.sportbuddyfinder.model.entities;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String profilePicURL;
    @OneToMany
    private final Set<Sport> interests;
    @OneToMany(mappedBy = "user")
    private final Set<Activity> postedActivities;
    @ManyToMany
    private final Set<Activity> appliedActivities;
    public User() {
        this.profilePicURL = "https://thumbs.dreamstime.com/b/head-silhouette-face-front-view-human-elegant-part-human-vector-illustration-79409597.jpg";
        this.interests = new HashSet<>();
        this.postedActivities = new HashSet<>();
        this.appliedActivities = new HashSet<>();
    }

    public User(String name, String email, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.profilePicURL = "https://thumbs.dreamstime.com/b/head-silhouette-face-front-view-human-elegant-part-human-vector-illustration-79409597.jpg";
        this.interests = new HashSet<>();
        this.postedActivities = new HashSet<>();
        this.appliedActivities = new HashSet<>();
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
