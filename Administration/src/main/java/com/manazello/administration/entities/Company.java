package com.manazello.administration.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="companies")
public class Company {
    @Id
    private String id;
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
    @Indexed(unique = true)
    private String matriculateFiscal;
    @NotBlank
    private String company;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private int postalCode;
    @NotBlank
    @Indexed(unique = true)
    private String matriculate;
    private String rentalRequestId;
}
