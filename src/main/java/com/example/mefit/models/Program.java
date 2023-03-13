package com.example.mefit.models;

import jakarta.persistence.*;

import java.util.Set;

public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int id;
    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String category;
    @ManyToMany
    private Set<Workout> workouts;
}

