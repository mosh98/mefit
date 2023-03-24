package com.example.mefit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

@Entity
public class Goal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int id;

    @Column(length = 200)
    private String endDate;

    @Column(name="achieved", nullable = false, columnDefinition = "boolean default false")
    private boolean achieved;

    @Column(name="active", nullable = false, columnDefinition = "boolean default false")
    private boolean active;


    //TODO: list of workouts

    /**
     * The cascade attribute specifies
     * that any changes made to a Goal entity should be cascaded to its associated Workout entities,
     * and the orphanRemoval attribute specifies that any Workout entities
     * that are no longer associated with a Goal entity should be removed from the database
     */
    //Remove orphanRemoval = true  put does not work with this.
    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Workout> workouts;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="profile_id", referencedColumnName = "profile_id" )
    private  Profile profile;


}


