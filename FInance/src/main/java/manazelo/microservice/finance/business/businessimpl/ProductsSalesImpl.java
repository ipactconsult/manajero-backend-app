package manazelo.microservice.finance.business.businessimpl;

import manazelo.microservice.finance.business.ibusiness.IProductsSales;
import manazelo.microservice.finance.entities.*;
import manazelo.microservice.finance.repositories.ProductsBillOFLadingRep;
import manazelo.microservice.finance.repositories.ProductsPurchaseOrdersRep;
import manazelo.microservice.finance.repositories.ProductsQuotesRep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ProductsSalesImpl implements IProductsSales {

    final  ProductsQuotesRep pqr;
    final ProductsPurchaseOrdersRep ppor;
    final ProductsBillOFLadingRep pbp;

    public ProductsSalesImpl(ProductsQuotesRep pqr, ProductsPurchaseOrdersRep ppo, ProductsBillOFLadingRep pbp) {
        this.pqr = pqr;
        this.ppor = ppo;
        this.pbp = pbp;
    }
    Random rn = new Random();


    //Quotes
    @Override
    public ProductsQuotes createPquote(ProductsQuotes pq) {
        int minNumberPR = 100000;
        int maxNumberPR = 999999;
        int range = maxNumberPR - minNumberPR + 1;
        int randomPRNumber =  rn.nextInt(range) + minNumberPR;

        pq.setReference("Q"+randomPRNumber);
        Date date = new Date();
        pq.setCreationDate(date);
        pq.setTotalPrice(pq.getUnitPrice()*pq.getQuantity());

        float taxPart = (pq.getTotalPrice()+pq.getServicesFees()) * pq.getTaxRate()/100;
        pq.setFinalPrice(taxPart+pq.getTotalPrice()+pq.getServicesFees());


        return pqr.save(pq);
    }

    @Override
    public ProductsQuotes updatePquote(ProductsQuotes pq) {

        return pqr.save(pq);
    }

    @Override
    public ProductsQuotes deletePquote(String id) {
        pqr.deleteById(id);
        return null;
    }

    @Override
    public List<ProductsQuotes> getAllPquotes() {
        return pqr.findAll();
    }

    @Override
    public ProductsQuotes validateQuote(String id) {
        ProductsQuotes quoteFound = pqr.findById(id).orElse(null);
        assert quoteFound != null;

        quoteFound.setStatus("Validated");
       return pqr.save(quoteFound);
    }

    //Purchase Orders
    @Override
    public ProductsPurchaseOrders createPpo(ProductsPurchaseOrders pq) {
        int minNumberPR = 100000;
        int maxNumberPR = 999999;
        int range = maxNumberPR - minNumberPR + 1;
        int randomPRNumber =  rn.nextInt(range) + minNumberPR;
        pq.setPaymentStatus("Unpaid");

        pq.setReference("PO"+randomPRNumber);
        Date date = new Date();
        pq.setCreationDate(date);
        pq.setTotalPrice(pq.getUnitPrice()*pq.getQuantity());


        float taxPart = (pq.getTotalPrice()+pq.getServicesFees()) * pq.getTaxRate()/100;
        pq.setFinalPrice(taxPart+pq.getTotalPrice()+pq.getServicesFees()-pq.getAdvancePayment());
        float instalment =pq.getFinalPrice() / pq.getNumberOfMonths();
        pq.setInstalmentAmount(instalment);

        return ppor.save(pq);
    }

    @Override
    public ProductsPurchaseOrders updatePpo(ProductsPurchaseOrders pq) {

        return ppor.save(pq);
    }

    @Override
    public ProductsPurchaseOrders deletePpo(String id) {
        ppor.deleteById(id);
        return null;
    }

    @Override
    public ProductsPurchaseOrders validatedOrder(String id) {
       ProductsPurchaseOrders orderFound= ppor.findById(id).orElse(null);
        assert orderFound != null;

        orderFound.setStatus("Validated");
       ppor.save(orderFound);
        return null;
    }

    @Override
    public List<ProductsPurchaseOrders> getAllPpo() {
        return ppor.findAll();
    }

    @Override
    public ProductsBillOfLading createBill(ProductsBillOfLading pb) {
        int minNumberPR = 100000;
        int maxNumberPR = 999999;
        int range = maxNumberPR - minNumberPR + 1;
        int randomPRNumber =  rn.nextInt(range) + minNumberPR;
        pb.setDeliveryStatus("Undelivered");

        pb.setReference("PB"+randomPRNumber);
        Date date = new Date();
        pb.setCreationDate(date);
        return pbp.save(pb);
    }

    @Override
    public ProductsBillOfLading deleteBill(String id) {
        pbp.deleteById(id);
        return null;
    }

    @Override
    public ProductsBillOfLading validateBill(String id) {
        ProductsBillOfLading billFound = pbp.findById(id).orElse(null);
        assert billFound != null;

        billFound.setStatus("Validated");
        pbp.save(billFound);
        return null;
    }

    @Override
    public List<ProductsBillOfLading> getAllBills() {
        return pbp.findAll();
    }

    @Override
    public List<ProductsPurchaseOrders> retrieveUnpaidOrders() {
        List<ProductsPurchaseOrders> list = ppor.findAll();
        List<ProductsPurchaseOrders> finalList = new ArrayList<>();
        for (ProductsPurchaseOrders po:list) {
            if (po.getPaymentStatus().equals("Unpaid")) {
                finalList.add(po);
            }
        }


        return finalList;    }

    @Override
    public List<ProductsBillOfLading> retrieveUndeliveredBills() {
        List<ProductsBillOfLading> list = pbp.findAll();
        List<ProductsBillOfLading> finalList = new ArrayList<>();
        for (ProductsBillOfLading bol :list) {
            if (bol.getDeliveryStatus().equals("Undelivered")){
                finalList.add(bol);
            }
        }


        return finalList;    }

    @Override
    public ProductsPurchaseOrders changeOrderPaymentStatus(String id) {
        ProductsPurchaseOrders found = ppor.findById(id).orElse(null);
        assert found != null;

        found.setPaymentStatus("Paid");

        return ppor.save(found);
    }

    @Override
    public ProductsBillOfLading changeBillDeliveryStatus(String id) {
        ProductsBillOfLading found = pbp.findById(id).orElse(null);
        assert found != null;

        found.setDeliveryStatus("Delivered");
        return pbp.save(found);
    }


}
