package com.example.mefit.models;

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

    // TODO we need to delete nullable=true
    // JoinColumn and refrerencedColumnName should not be the same it should refer to the primary key of the other table
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "user_id" )
    private User user;
    @Column(length = 225)
    private String profile_img;
    @Column(length = 10, nullable = true)
    private Integer weight;
    @Column(length = 10, nullable = true)
    private Integer height;

    @Column(length = 225, nullable = true)
    private String medical_condition;
    @Column(length = 225, nullable = true)
    private String disabilities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", referencedColumnName = "address_id")
    private Address address;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="goal_id", referencedColumnName = "goal_id")
    private Goal goal;




}