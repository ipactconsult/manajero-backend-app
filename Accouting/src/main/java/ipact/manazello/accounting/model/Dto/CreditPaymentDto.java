package ipact.manazello.accounting.model.Dto;


import ipact.manazello.accounting.model.Credit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditPaymentDto {

    @Id
    private String id;
    private float payment;
    @DocumentReference
    private Credit credit;
    private float interestRate;
    private float inflationRate;
    private float initialCapital;
    private float periods;
    private float taxRate;
    private int period;
    private float presentValue;
    private float v;
    private float interest;
    private float balance;
    private float cumulativeInterest;
}
