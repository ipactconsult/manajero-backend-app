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


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "delivery")
public class Delivery {

    @Id
    private String id;

    @Indexed(unique = true)
    private String shipCode;

    private String shipMode;

    private Date shipDate;

    private String shipInfos;

    private String billingAddress;

    private String phone;

    private  String notesShipping;

    private Double shippingPrice;

    private Status shippingStatus;
    private String currency;
    @DocumentReference
    private Order order;

    private String user;

    private Boolean archive;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;
}
