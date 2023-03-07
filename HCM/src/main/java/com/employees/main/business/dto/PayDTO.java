package com.employees.main.business.dto;

import com.employees.main.entities.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayDTO {


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

    private Contract contract;

    private String paymentMode;

    private String cancelUrl;

    private String successUrl;

    private String currency;

    private String isArchived;

}
