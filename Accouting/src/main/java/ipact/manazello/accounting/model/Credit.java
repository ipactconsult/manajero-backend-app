package ipact.manazello.accounting.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.time.Instant;


@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="credit")
public class Credit {
    @Id
    private String id;

    private String clientName;

    private String clientEmail;

    private String clientPhone;

    private String clientAddress;

    private float interestRate;

    private float inflationRate;

    private float initialCapital;

    private float v;

    private int periods;

    private float taxRate;

    private String frequency;

    private String currency;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;

    private Instant nextPaymentDate;

    private int nextPaymentPeriod;

    private boolean archived;
}
