package ipact.manazello.accounting.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.time.Instant;


@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="tax")
public class Tax {
    @Id
    private String id;

    private String type;

    private String name;

    private String status;

    private String reportTaxType;

    private boolean canApplyToAssets;

    private boolean canApplyToEquity;

    private boolean canApplyToExpenses;

    private boolean canApplyToLiabilities;

    private boolean canApplyToRevenue;

    private String displayTaxRate;

    private float effectiveRate;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;

}
