package ipact.manazello.accounting.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="invoice")
public class Invoice {
    @Id
    private String id;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    private String title;
    
    private String clientName;

    private String clientEmail;

    private String clientPhone;

    private String clientAddress;

    private String url;

    private int code;


    private Date dueDate;

    private int invoiceNumber;

    private String currency;

    private float subTotal;

    private float totalTax;

    private float total;

    private boolean paidStatus;

    private boolean pastDueDate;

    private boolean relance;

    private boolean archived;

}
