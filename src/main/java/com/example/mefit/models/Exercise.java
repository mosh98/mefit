package com.example.mefit.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 250,nullable = true)
    private String description;


    @Column(length = 100, nullable = false)
    private String muscleGroup; //enum????
    // chest, arms, legs, back, core, shoulders, abs, glutes, etc

    @Column(length = 100,nullable = true)
    private String exerciseImageLink;


    @Column(length = 100,nullable = true)
    private String videoLink;


    @Column(length = 3)
    private int reps;

    @Column(length = 3)
    private int sets;

    @Column(name = "completed",nullable = false, columnDefinition = "boolean default false")
    private boolean completed;


    //aka user level
    @Column(length = 250,nullable = false)
    private String userExperience;


    //map many to map to different excercises
    @ManyToOne
    @JoinColumn(name = "workout_id",referencedColumnName = "workout_id")
    private Workout workout;

}


