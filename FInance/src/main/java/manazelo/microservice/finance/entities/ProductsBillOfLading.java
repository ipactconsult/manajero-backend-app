package manazelo.microservice.finance.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productsBillOfLading")
public class ProductsBillOfLading {
    @Id
    private String id;
    private Date creationDate;
    private String reference;
    private String productName;
    private int quantity;
    private float finalPrice;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerPhone;
    private String status="Pending";
    private String enterpriseName;
    private String enterpriseAddress;
    private String enterpriseCity;
    private int enterprisePostalCode;
    private float taxRate;
    private float servicesFees;
    private float advancePayment;
    private String image;
    private Date orderDate;
    private Date shipmentDate;
    private Date deliveryDate;
    private String deliveryStatus;
    private String signature;
    private String enterpriseTaxRegistrationNumber;

}
