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
@Document(collection = "forecastFlow")
public class ForecastMoneyFlow {

    @Id
    private String id;
    private String direction;
    private String type;
    private String description;
    private int year;
    private float january ;
    private float february ;
    private float march ;
    private float april ;
    private float may ;
    private float june ;
    private float july ;
    private float august ;
    private float september ;
    private float october ;
    private float november ;
    private float december ;
    private float total;
    private String differenciator;
    private int sortOrder;

}
