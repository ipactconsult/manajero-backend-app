package com.manazello.administration.entities;

import com.manazello.administration.entities.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentalRequest {
    @Id
    private String id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @Email
    private String secondEmail;
    @NotBlank
    private String phone;
    private String secondPhone;
    @NotBlank
    private String address;
    @NotBlank
    private String matriculateFiscal;
    @NotBlank
    private String company;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private int postalCode;
    private String webSiteLink;
    private String linkedinUrl;
    private Status status;
    private boolean archived;


}
