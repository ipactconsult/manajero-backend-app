package com.example.litigerecouvrement.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    private String id;

    private Instant createdAt;

    private String title ;

    private String clientName;

    private String clientEmail;

    private String clientPhone;

    private String clientAddress;

    private int code;

    private Instant dueDate;

    private int invoiceNumber;

    private String currency;

    private float subTotal;

    private float totalTax;

    private float total;

    private boolean paidStatus;

    private boolean pastDueDate;
}
