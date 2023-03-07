package manazelo.microservice.finance.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Document(collection = "files")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Files {
    @Id
    private String id;
    private String differenciator;

    private String title;
    @Lob
    private Binary file;
    private String transactionDetails;
    private Date transactionDate;
    private String fileType;



}
