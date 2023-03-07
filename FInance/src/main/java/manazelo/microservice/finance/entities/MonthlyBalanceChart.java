package manazelo.microservice.finance.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document("monthlyBalanceCharts")
public class MonthlyBalanceChart {
    @Id
    private String id;
    private float balance;
    private Date date;
    private int year;
    private  int month;


}
