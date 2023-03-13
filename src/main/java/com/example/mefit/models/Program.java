package com.example.mefit.models;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "program_id")
    private int id;
    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String category;

    //TODO: problem, one program cannot have many of one workouts.

    @ManyToMany
    @JoinTable(
            name = "program_workout",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "workout_id")
    )
    private Set<Workout> workouts;


}

