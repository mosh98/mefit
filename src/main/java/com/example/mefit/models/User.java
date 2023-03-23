package com.example.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_mefit")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(length = 100)
    private String e_mail;

    //TODO: rethink password with keyload & auth
    @Column(length = 50)
    private String password;

    @Column(length = 50)
    private String first_name;
    @Column(length = 50)
    private String last_name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Profile profile;

    @Column(length = 15)
    private String userType;

    @Column(length = 250,unique=true)
    private String keyCloakId;

}
