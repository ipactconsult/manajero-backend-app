package manazelo.microservice.finance.entities;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "moneyFlow")
public class MoneyFlow {
    @Id
    private String id;
    private String category;
    private float actual;
    private float budget;
    private float difference;
    private String direction;
    private String subCategory;
    private int year;
    private int sortOrder;
    private String month;
    private String type;

    public MoneyFlow(String category, float actual, float budget, float difference, String direction, String subCategory, int year, int sortOrder, String month, String type) {
        this.category = category;
        this.actual = actual;
        this.budget = budget;
        this.difference = difference;
        this.direction = direction;
        this.subCategory = subCategory;
        this.year = year;
        this.sortOrder = sortOrder;
        this.month = month;
        this.type = type;
    }
}
