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
@Document(collection = "purchaseOrders")

public class PurchaseOrders {
    @Id
    private String id;
    private String reference;
    private Date orderDate ;
    private String propertyName;
    private String propertySurface;
    private String propertyPieces;
    private String propertyRooms;
    private String propertyCity;
    private String propertyCountry;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerPhone;
    private float propertyPrice;
    private float taxRate;
    private float servicesFees;
    private float finalPrice;
    private float advancePayment;
    private String paymentMode;
    private String paymentMethod;
    private float numberOfMonths;
    private float instalmentAmount;
    private Date dueDate;
    private String orderStatus= "Pending";
    private String image;
    private String enterpriseName;
    private String enterpriseAddress;
    private String enterpriseCity;
    private int enterprisePostalCode;
    private String paymentStatus;
    private String signature;
    private String enterpriseTaxRegistrationNumber;


}
