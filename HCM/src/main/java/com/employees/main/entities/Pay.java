package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pay_hr")
public class Pay {

    @Id
    private String id;

    private float baseSalary;

    private float primeConventionnelle;

    private float primeNonConventionnelle;

    private float tfp;

    private float foprolos;

    private float salaryAnnual; // salaryAnnuel / 12 = Mensuel salaire

    private int taux;

    private float cnam;

    private float salaryCost;

    private float irpp;

    private float cnss;

    private float cnssAnnuel;

    private float netSalaryImposed;

    private float brutSalaryImposed;

    private float gain;

    private float css;

    private float netSalary;

    @DocumentReference
    private Contract contract;

    private String paymentMode;

    private String cancelUrl;

    private String successUrl;

    private String currency;

    private String isArchived;

}
