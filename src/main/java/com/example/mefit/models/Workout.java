package com.example.mefit.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private int id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String type; // leg,core, upperbody, lower body etc

    @Column(length = 100, nullable = false)
    private boolean completed = false;


    @ManyToMany(mappedBy = "workouts")
    private Set<Program> programs;
}


