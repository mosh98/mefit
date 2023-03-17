package com.example.mefit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int id;

    @Column(length = 225)
    private String address;

    @Column(length = 10)
    private  String post_code;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id", referencedColumnName = "profile_id" )
    @JsonIgnore
    private  Profile profile;
}


