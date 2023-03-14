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

    @Column(name="achieved", nullable = false, columnDefinition = "boolean default false")
    private boolean achieved;

    @Column(name="active", nullable = false, columnDefinition = "boolean default false")
    private boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id", referencedColumnName = "profile_id" )
    private  Profile profile;

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


