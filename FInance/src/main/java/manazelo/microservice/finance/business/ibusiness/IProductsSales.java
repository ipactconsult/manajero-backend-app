package manazelo.microservice.finance.business.ibusiness;


import manazelo.microservice.finance.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductsSales {
    ProductsQuotes createPquote( ProductsQuotes pq);
    ProductsQuotes updatePquote (ProductsQuotes pq);
    ProductsQuotes deletePquote( String id );
    List<ProductsQuotes> getAllPquotes();
    ProductsQuotes validateQuote(String id);

    ProductsPurchaseOrders createPpo(ProductsPurchaseOrders pq);
    ProductsPurchaseOrders updatePpo (ProductsPurchaseOrders pq);
    ProductsPurchaseOrders deletePpo( String id );
    ProductsPurchaseOrders validatedOrder (String id);
    List<ProductsPurchaseOrders> getAllPpo();

    ProductsBillOfLading createBill(ProductsBillOfLading pb);
    ProductsBillOfLading deleteBill( String id );
    ProductsBillOfLading validateBill(String id);

    List<ProductsBillOfLading> getAllBills();
    //risk

    List<ProductsPurchaseOrders> retrieveUnpaidOrders();
    List<ProductsBillOfLading> retrieveUndeliveredBills();
    ProductsPurchaseOrders changeOrderPaymentStatus(String id);
    ProductsBillOfLading changeBillDeliveryStatus(String id);


}
