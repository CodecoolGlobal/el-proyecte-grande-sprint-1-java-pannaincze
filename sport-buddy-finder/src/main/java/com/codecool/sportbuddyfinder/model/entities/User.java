package com.codecool.sportbuddyfinder.model.entities;

import com.codecool.sportbuddyfinder.model.activity.Activity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder
@Table(name = "app_user")

public class User implements UserDetails {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String profilePicURL;
    @ManyToMany
    private final Set<Sport> interests;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private final Set<Activity> postedActivities;
    @ManyToMany
    private final Set<Activity> appliedActivities;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
        this.profilePicURL = "https://thumbs.dreamstime.com/b/head-silhouette-face-front-view-human-elegant-part-human-vector-illustration-79409597.jpg";
        this.postedActivities = new HashSet<>();
        this.appliedActivities = new HashSet<>();
        this.interests = new HashSet<>();
        this.role = Role.USER;
    }

    public User(String name, String email, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.profilePicURL = "https://thumbs.dreamstime.com/b/head-silhouette-face-front-view-human-elegant-part-human-vector-illustration-79409597.jpg";
        this.postedActivities = new HashSet<>();
        this.appliedActivities = new HashSet<>();
        this.interests = new HashSet<>();
        this.role = Role.USER;
    }

    public Set<Sport> getInterests() {
        return new HashSet<>(interests);
    }

    public void addInterest(Sport sport) {
        interests.add(sport);
    }

    public void addInterests(Sport[] interests) {
        this.interests.addAll(Arrays.asList(interests));
    }

    public void addPostedActivity(Activity activity) {
        postedActivities.add(activity);
    }

    public void addPostedActivities(Set<Activity> activities) {
        this.postedActivities.addAll(activities);
    }
    public void setInterests(Sport interest){
        this.interests.add(interest);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
