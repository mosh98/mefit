package com.example.mefit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profile { //table name : profile
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profile_id")
    private int id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    @Column(length = 225)
    private String profileImg;
    @Column(length = 10, nullable = true)
    private Integer weight;
    @Column(length = 10, nullable = true)
    private Integer height;

    @Column(length = 225, nullable = true)
    private String medicalCondition;
    @Column(length = 225, nullable = true)
    private String disabilities;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="address_id", referencedColumnName = "address_id")
    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private Address address;


    //, fetch = FetchType.LAZY, cascade = CascadeType.ALL
    @OneToOne(mappedBy = "profile")
    //@JoinColumn(name="goal_id", referencedColumnName = "goal_id")
    //@JsonIgnore
    private Goal goal;




}