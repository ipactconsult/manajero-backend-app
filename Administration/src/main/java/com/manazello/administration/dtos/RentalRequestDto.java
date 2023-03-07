package com.manazello.administration.dtos;

import com.manazello.administration.entities.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentalRequestDto {
    private String id;
    private String firstName;
    private String lastName;
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
    private String webSiteLink;
    private String linkedinUrl;
    private Status status=Status.PENDING;
    private boolean archived=false;



}
