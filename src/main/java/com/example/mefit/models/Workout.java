package com.example.mefit.models;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
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

    @Column(name="completed", nullable = false, columnDefinition = "boolean default false")
    private boolean completed;


    @ManyToMany(mappedBy = "workouts")
    private Set<Program> programs;


    //TODO cannot create workout without excercises
    @OneToMany(mappedBy = "workout")
    private Set<Exercise> exercises;

    @ManyToOne
    @JoinColumn(name = "goal_id",referencedColumnName = "goal_id")
    private Goal goal;

//    private String workoutCategory;
//skapa workouts med olika categorier: BUILD & LOSE


    //TODO: experience level
    @Column(length = 100)
   private String experienceLevel;




}


