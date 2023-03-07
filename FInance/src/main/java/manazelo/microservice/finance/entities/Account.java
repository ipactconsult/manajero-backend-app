package manazelo.microservice.finance.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "account")
public class Account {
    @Id
    private String id;
    private String code;
    private String name;
    private Date createdAt;
    private  Date updatedAt;
    private float balance;

}
