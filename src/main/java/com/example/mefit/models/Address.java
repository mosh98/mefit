package com.example.mefit.models;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int id;

    @Column(length = 225)
    private String address;

    @Column(length = 225)
    private  String post_code;

    @Column(length = 225)
    private String city;
}


