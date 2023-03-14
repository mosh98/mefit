package com.example.mefit.models.dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String password; // TODO dont show
    private String e_mail;
    private String first_name;
    private String last_name;
    private int profile;

    private String userType;
}
