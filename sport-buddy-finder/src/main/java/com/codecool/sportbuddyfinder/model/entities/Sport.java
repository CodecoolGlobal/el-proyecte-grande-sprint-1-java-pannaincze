package com.codecool.sportbuddyfinder.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sport")
public class Sport {

    @Id
    @GeneratedValue
    @Column(name = "sport_id")
    private long id;
    private String name;
}
