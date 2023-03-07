package manazelo.microservice.finance.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "quotes")

public class Quote {
    @Id
    private String id;
    private String reference;
    private Date quoteDate;
    private String propertyName;
    private String propertySurface;
    private String propertyPieces;
    private String propertyRooms;
    private String propertyCity;
    private String propertyCountry;
    private float propertyPrice;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerPhone;
    private float taxRate;
    private float servicesFees;
    private float finalPrice;
    private String status= "Pending";
    private String image;
    private String enterpriseName;
    private String enterpriseAddress;
    private String enterpriseCity;
    private int enterprisePostalCode;
    private String signature;
    private String enterpriseTaxRegistrationNumber;













    public void setId(String id) {
        this.id = id;
    }

    @javax.persistence.Id
    public String getId() {
        return id;
    }
}
