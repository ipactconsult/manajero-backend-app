package manazelo.microservice.finance.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "filesResponses")

public class FileResponse {
    @Id
    private String id;
    private Date date;
    private String details;
    private String title;
    private Boolean reconciled=Boolean.FALSE;
    private String fileId;
    private String stringDate;
    private int month;
    private int year;

}
