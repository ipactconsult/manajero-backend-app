package manazelo.microservice.finance.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private float expense;
    private float income;
    private float balance;
    private String details;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    private String type;
    private int year;
    private int month;

    private Object account;
    private Date addedAt;
    private Date updatedAt;
    private Boolean reconciled= Boolean.FALSE;
    private String stringDate;
    private int sortOrder;


    public Transaction(float expense, float income, float balance, String details, Date date, String type, Object account, int sortOrder) {
        this.expense = expense;
        this.income = income;
        this.balance = balance;
        this.details = details;
        this.date = date;
        this.type = type;
        this.account = account;
        this.sortOrder = sortOrder;
    }
}

