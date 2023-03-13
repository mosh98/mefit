package com.example.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Getter
@Setter

@Entity
public class Goal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int id;

    @Column(length = 225)
    private Date endDate;

    @Column(length = 225)
    private boolean achieved;

    @Column(length = 225)
    private boolean active;


    //TODO: list of workouts

    /**
     * The cascade attribute specifies
     * that any changes made to a Goal entity should be cascaded to its associated Workout entities,
     * and the orphanRemoval attribute specifies that any Workout entities
     * that are no longer associated with a Goal entity should be removed from the database
     */
    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Workout> workouts;





}


