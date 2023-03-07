package com.manazellocrm.customermanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    @Indexed(unique = true)
    private String orderCode;

    private String orderName;

    private String otherInfosOrder;

    private Date orderDate;

    private Status status;

    private Object product;

    private String orderType;

    private String particular;

    private Object purchaseOrder;

    private String archive;

    private Double orderPaid;

    private String paymentMethod;

    private String paymentStatus;

    private Double subTotal;

    private String notes;

    private String invoice;

    private String currency;

    @DocumentReference
    private Deals deals;

    @DocumentReference
    private Contract contract;

    private long quantity;

    private String user;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;
}
