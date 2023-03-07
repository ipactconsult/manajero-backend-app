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
@Document(collection = "productsPurchaseOrders")
public class ProductsPurchaseOrders {
    @Id
    private String id ;
    private Date creationDate;
    private String reference;
    private int quantity;
    private float unitPrice;
    private float totalPrice;
    private float taxRate;
    private float servicesFees;
    private float finalPrice;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerPhone;
    private String status="Pending";
    private float advancePayment;
    private String paymentMode;
    private String paymentMethod;
    private float numberOfMonths;
    private float instalmentAmount;
    private Date dueDate;
    private String enterpriseName;
    private String enterpriseAddress;
    private String enterpriseCity;
    private String image;
    private String productName;
    private String paymentStatus;
    private int enterprisePostalCode;
    private String signature;
    private String enterpriseTaxRegistrationNumber;




}
