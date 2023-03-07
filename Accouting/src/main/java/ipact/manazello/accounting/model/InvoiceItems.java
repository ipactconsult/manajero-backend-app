package ipact.manazello.accounting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Column;
import java.time.Instant;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="invoiceItems")
public class InvoiceItems {

    @Id
    private String id;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    private String description;

    private int quantity;

    private float unitPrice;

    private float total;

    @DocumentReference
    private Invoice invoice;
}
