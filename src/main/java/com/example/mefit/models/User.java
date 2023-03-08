package com.example.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fit_me_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(length = 100)
    private String e_mail;

    @Column(length = 50)
    private String password;

    @Column(length = 50)
    private String first_name;
    @Column(length = 50)
    private String last_name;
    @OneToOne(cascade = CascadeType.ALL)
    // TODO we need to delete nullable=true
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = true)
    private Profile profile;

    // private Boolean isContributor;
    // private Boolean isAdmin;
}
