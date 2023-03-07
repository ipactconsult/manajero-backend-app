package ipact.manazello.accounting.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "creditPayment")
public class CreditPayment {

    @Id
    private String id;

    private float payment;

    @DocumentReference
    private Credit credit;

    private int period;

    private float presentValue;

    private float interest;

    private float balance;

    private float cumulativeInterest;

    private float taxValue;

    public CreditPayment(int period, float payment, float presentValue, float balance, Credit credit) {
        this.payment = payment;
        this.presentValue = presentValue;
        this.balance = balance;
        this.credit = credit;
        this.period = period;
    }

    public CreditPayment(float payment, Credit credit, int period, float presentValue, float interest, float balance, float cumulativeInterest, float taxValue) {
        this.payment = payment;
        this.credit = credit;
        this.period = period;
        this.presentValue = presentValue;
        this.interest = interest;
        this.balance = balance;
        this.cumulativeInterest = cumulativeInterest;
        this.taxValue =taxValue;
    }
}
