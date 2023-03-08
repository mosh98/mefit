package com.example.mefit.models.dto;

import lombok.Data;

@Data
public class UserDTO {

    private int id;
    private String password;
    private String e_mail;
    private String first_name;
    private String last_name;
    private int profile;
}
