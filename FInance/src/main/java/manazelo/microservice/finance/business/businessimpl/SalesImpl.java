package manazelo.microservice.finance.business.businessimpl;


import manazelo.microservice.finance.business.ibusiness.ISales;
import manazelo.microservice.finance.entities.*;
import manazelo.microservice.finance.entities.enums.QuoteStatus;
import manazelo.microservice.finance.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class SalesImpl implements ISales {

    private final RestTemplate restTemplate;
    private  final QuotesRep qR;
    private final PurchaseOrdersRep pOR;
    private final BillOfLadingRep blp;
    private final ProductsSalesImpl psi;

    Random rn = new Random();


    @Autowired
    public SalesImpl(RestTemplateBuilder builder, QuotesRep qR, PurchaseOrdersRep pOR, BillOfLadingRep blp, ProductsSalesImpl psi) {
        this.restTemplate = builder.build();
        this.qR = qR;
        this.pOR = pOR;
        this.blp = blp;
        this.psi = psi;

    }

    public Object[] retrieveAllRequests(){


        return restTemplate.getForObject
                ("https://manazello-crm.herokuapp.com/api/quotations/allPendingQuotations", Object[].class);
    }

    public Object retrieveRequestById( String id) {

        return restTemplate.getForObject("https://manazello-crm.herokuapp.com/api/quotations/quotation-by-id/"+id,Object.class);
    }
    HttpHeaders headers = new HttpHeaders();

    @Override
    public Object updateRequest(String id, Object request) {

        String resourceUrl =
                "https://manazello-crm.herokuapp.com/api/quotations/update-quotation-status/ " + id;
        HttpEntity<Object> requestUpdate = new HttpEntity<>(request,headers);
        restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
        return null;
    }

    @Override
    public Quote createQuote(Quote q) {
        float price = q.getPropertyPrice();
        float tax = (price * q.getTaxRate())/100;
        int minNumberPR = 100000;
        int maxNumberPR = 999999;
        int range = maxNumberPR - minNumberPR + 1;
        int randomPRNumber =  rn.nextInt(range) + minNumberPR;

        q.setReference("Q"+randomPRNumber);

        q.setFinalPrice(price+tax);
        return qR.save(q);
    }

    @Override
    public List<Quote> retrieveAllQuotes() {
        return qR.findAll();
    }

    @Override
    public Optional<Quote> retrieveQuoteById( String id) {

        return qR.findById(id);
    }



    @Override
    public Quote updateQuoteStatus(String id) throws NullPointerException{
        Quote quote = qR.findById(id).orElse(null);
        if (quote != null)
        {quote.setStatus("Validated");
        qR.save(quote);
            return quote;}
        else {throw new NullPointerException("this quote doesn't exist");}


    }

    @Override
    public Quote deleteQuote(String id) {
         qR.deleteById(id);
         return null;

    }

    @Override
    public PurchaseOrders createPurchaseOrder(PurchaseOrders po) {
        int minNumberPR = 100000;
        int maxNumberPR = 999999;
        int range = maxNumberPR - minNumberPR + 1;
        int randomPRNumber =  rn.nextInt(range) + minNumberPR;
        po.setPaymentStatus("Unpaid");

        po.setReference("PO"+randomPRNumber);
        float price = po.getPropertyPrice();
        float tax = (price * po.getTaxRate())/100;
        if (po.getAdvancePayment()==0) {
            po.setFinalPrice(price+tax+po.getServicesFees());

        }
        else {
            po.setFinalPrice((price+tax+po.getServicesFees())-po.getAdvancePayment());
        }
        float instalment =po.getFinalPrice() / po.getNumberOfMonths();
        po.setInstalmentAmount(instalment);
        return pOR.save(po);
    }

    @Override
    public List<PurchaseOrders> retrieveAllPurchaseOrders() {
        return pOR.findAll();
    }

    @Override
    public List<PurchaseOrders> retrievePendingPurchaseOrders() {
        return pOR.findPendingOrders();
    }

    @Override
    public PurchaseOrders deletePurchaseOrder(String id) {
         pOR.deleteById(id);
         return null;
    }

    @Override
    public PurchaseOrders updatePurchaseOrder(PurchaseOrders pr) {
        return pOR.save(pr);
    }

    @Override
    public PurchaseOrders changeOrderStatus(String id) {
        PurchaseOrders pr = pOR.findById(id).orElse(null);
        assert pr != null;

        pr.setOrderStatus("Validated");
        return pOR.save(pr);
    }

    @Override
    public List<PurchaseOrders> retrieveUnpaidOrders() {
        List<PurchaseOrders> list = pOR.findAll();
        List<PurchaseOrders> finalList = new ArrayList<>();
        for (PurchaseOrders po:list) {
            if (po.getPaymentStatus().equals("Unpaid")) {
                finalList.add(po);
            }
        }


        return finalList;
    }

    @Override
    public PurchaseOrders changeOrderPaymentStatus(String id) {
        PurchaseOrders found = pOR.findById(id).orElse(null);
        assert found != null;

        found.setPaymentStatus("Paid");

        return pOR.save(found);
    }

    @Override
    public BillOfLading createBillOfLading(BillOfLading bl) {
        int minNumberPR = 100000;
        int maxNumberPR = 999999;
        int range = maxNumberPR - minNumberPR + 1;
        int randomPRNumber =  rn.nextInt(range) + minNumberPR;
        bl.setDeliveryStatus("Undelivered");

        bl.setReference("B"+randomPRNumber);
        Date date = new Date();
        bl.setCreationDate(date);

        return blp.save(bl);
    }

    @Override
    public List<BillOfLading> retrieveAllBillOfLading() {
        return blp.findAll();
    }

    @Override
    public void deleteBill(String id) {
        blp.deleteById(id);

    }

    @Override
    public BillOfLading changeBillStatus(String id) {
        BillOfLading bill = blp.findById(id).orElse(null);
        assert bill != null;

        bill.setStatus("Validated");
        blp.save(bill);
        return null;
    }

    @Override
    public List<BillOfLading> retrieveUndeliveredBills() {
        List<BillOfLading> list = blp.findAll();
        List<BillOfLading> finalList = new ArrayList<>();
        for (BillOfLading bol :list) {
            if (bol.getDeliveryStatus().equals("Undelivered")){
                finalList.add(bol);
            }
        }


        return finalList;
    }

    @Override
    public BillOfLading changeBillDeliveryStatus(String id) {
        BillOfLading found = blp.findById(id).orElse(null);
        assert found != null;

        found.setDeliveryStatus("Delivered");
        return blp.save(found);    }

    @Override
    public int countAllUndeliveredBills() {
        int productsNumber = psi.retrieveUndeliveredBills().size();
        int properties = this.retrieveUndeliveredBills().size();
        return productsNumber+properties;
    }


    @Override
    public int countAllUnpaidCommands() {
        int productNumber = psi.retrieveUnpaidOrders().size();
        int properties = this.retrieveUnpaidOrders().size();

        return productNumber+properties;
    }




}
