package manazelo.microservice.finance.business.ibusiness;

import manazelo.microservice.finance.entities.BillOfLading;
import manazelo.microservice.finance.entities.ProductsBillOfLading;
import manazelo.microservice.finance.entities.PurchaseOrders;
import manazelo.microservice.finance.entities.Quote;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ISales {
    //pendingQuotes
    Object[] retrieveAllRequests();
    Object retrieveRequestById(String id);
    Object updateRequest(String id,Object request);

    //Quotes
    Quote createQuote( Quote q);
    List<Quote>  retrieveAllQuotes();
    Optional<Quote> retrieveQuoteById (String id);
    Quote updateQuoteStatus (String id) throws NullPointerException;
    Quote deleteQuote (String id);

    //purchase Orders

    PurchaseOrders createPurchaseOrder(PurchaseOrders po);
    List<PurchaseOrders> retrieveAllPurchaseOrders();
    List<PurchaseOrders> retrievePendingPurchaseOrders();
    PurchaseOrders deletePurchaseOrder(String id);
    PurchaseOrders updatePurchaseOrder(PurchaseOrders pr);
    PurchaseOrders changeOrderStatus(String id);
    List<PurchaseOrders> retrieveUnpaidOrders();
    PurchaseOrders changeOrderPaymentStatus(String id);

     //Bills Of Lading
    BillOfLading createBillOfLading(BillOfLading bl);
    List<BillOfLading> retrieveAllBillOfLading();
    void deleteBill(String id);
    BillOfLading changeBillStatus(String id);
    List<BillOfLading> retrieveUndeliveredBills();
    BillOfLading changeBillDeliveryStatus(String id);
    int countAllUndeliveredBills();

    int countAllUnpaidCommands();





}
