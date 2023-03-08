package com.example.mefit.models;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(length = 100,nullable = false)
    private String e_mail;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50,nullable = false)
    private String first_name;
    @Column(length = 50,nullable = false)
    private String last_name;
    //@OneToOne(cascade = CascadeType.ALL)
    // TODO we need to delete nullable=true
    //@JoinColumn(name="profile_id", referencedColumnName = "id", nullable = true)
    //private Profile profile;

   // private Boolean isContributor;
   // private Boolean isAdmin;
}

