package com.manazello.administration.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private String id;
    private String email;
    private String secondEmail;
    private String phone;
    private String secondPhone;
    private String address;
    private String matriculateFiscal;
    private String company;
    private String country;
    private String city;
    private int postalCode;
    private String matriculate;
}
