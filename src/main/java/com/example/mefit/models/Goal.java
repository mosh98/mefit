package com.example.mefit.models;

import jakarta.persistence.*;

import java.util.Date;




@Entity
public class Goal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int id;

    @Column(length = 225)
    private Date end_date;

    @Column(length = 225)
    private boolean achieved;

    @Column(length = 225)
    private boolean active;


    //TODO: list of workouts




}


