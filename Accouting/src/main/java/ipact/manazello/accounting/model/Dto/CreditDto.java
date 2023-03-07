package ipact.manazello.accounting.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditDto {

    @Id
    private String id;

    private float interestRate;

    private float inflationRate;

    private float initialCapital;

    private float v;

    private int periods;

    private float taxRate;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;

    private Instant nextPaymentDate;
}
