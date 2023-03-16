package com.example.mefit.models.dto;

import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String address;
    private String post_code;
    private String city;
    private String country;

    private int profile;

}
