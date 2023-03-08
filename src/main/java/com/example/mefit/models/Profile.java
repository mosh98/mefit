package com.example.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profile_id")
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    // TODO we need to delete nullable=true
    @JoinColumn(name="profile_id", referencedColumnName = "id",nullable = true )
    private User user;
    //private Address address;
    @Column(length = 225)
    private String profile_img;
    @Column(length = 10, nullable = true)
    private int weight;
    @Column(length = 10, nullable = true)
    private int height;

    @Column(length = 225, nullable = true)
    private String medical_condition;
    @Column(length = 225, nullable = true)
    private String disabilities;
}