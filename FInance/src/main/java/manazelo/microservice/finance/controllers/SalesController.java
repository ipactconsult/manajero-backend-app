package manazelo.microservice.finance.controllers;


import manazelo.microservice.finance.business.businessimpl.SalesImpl;
import manazelo.microservice.finance.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class SalesController {

    private final SalesImpl sSales;
    @Autowired
    public SalesController(SalesImpl sSales) {
        this.sSales= sSales;
    }

    @GetMapping("/sales/retrievePendingQuotations")
    @ResponseBody
    public ResponseEntity<Object[]> getQuoRequests() {
        Object[] pendingQuo = sSales.retrieveAllRequests();


        return new ResponseEntity<>(pendingQuo, HttpStatus.OK);
    }
    @GetMapping("/sales/retrievePendingQuotationById/{id}")
    @ResponseBody
    public ResponseEntity<Object> getQuoRequestById( @PathVariable("id") String id) {
        Object pendingQuo = sSales.retrieveRequestById(id);


        return new ResponseEntity<>(pendingQuo, HttpStatus.OK);
    }

    @PutMapping("/sales/updateRequest/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateRequest(@PathVariable("id") String id ,@RequestBody Object request) {
        Object updatedRequest = sSales.updateRequest(id,request);
        return new ResponseEntity<>(updatedRequest,HttpStatus.OK);
    }


    @PostMapping("/sales/createQuote")
    @ResponseBody
    public ResponseEntity<Quote> addQuote(@RequestBody Quote q) {
         Quote instance = sSales.createQuote(q);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @GetMapping("/sales/retrieveAllQuotes")
    @ResponseBody
    public ResponseEntity<List<Quote>> getQuotes() {
        List<Quote> list = sSales.retrieveAllQuotes();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/sales/retrieveQuoteById/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Quote>> getQuoteById(@PathVariable("id") String id) {
        Optional<Quote> list = sSales.retrieveQuoteById(id);


        return new ResponseEntity<>(list, HttpStatus.OK);
    }


   @PutMapping("/sales/updateQuoteStatus/{id}")
    @ResponseBody
    public ResponseEntity<Quote> updateQuoteStatus(@PathVariable String id) throws NullPointerException {
        Quote updatedQuote = sSales.updateQuoteStatus(id);
        return new ResponseEntity<>(updatedQuote,HttpStatus.OK);
    }

    @DeleteMapping("sales/deleteQuote/{id}")
    @ResponseBody
    public ResponseEntity<Quote> deleteQuote(@PathVariable String id) {
        Quote deletedQuote = sSales.deleteQuote(id);
        return new ResponseEntity<>(deletedQuote,HttpStatus.OK);
    }


    //Purchase Orders

    @PostMapping("/sales/createPurchaseOrder")
    @ResponseBody
    public ResponseEntity<PurchaseOrders> createPurchaseOrder(@RequestBody PurchaseOrders po) {
        PurchaseOrders createdPurchaseOrder = sSales.createPurchaseOrder(po);
        return new ResponseEntity<>(createdPurchaseOrder,HttpStatus.OK);
    }

    @GetMapping("/sales/retrievePurchaseOrders")
    @ResponseBody
    public ResponseEntity<List<PurchaseOrders>> getPurchaseOrders() {
        List<PurchaseOrders> list = sSales.retrieveAllPurchaseOrders();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/sales/retrievePendingPurchaseOrders")
    @ResponseBody
    public ResponseEntity<List<PurchaseOrders>> getPurchasePendingOrders() {
        List<PurchaseOrders> list = sSales.retrievePendingPurchaseOrders();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PutMapping("/sales/validatePurchaseOrder/{id}")
    @ResponseBody
    public ResponseEntity<PurchaseOrders> updateOrderStatus(@PathVariable("id") String id ) {
        PurchaseOrders updated = sSales.changeOrderStatus(id);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
    @DeleteMapping("sales/deletePurchaseOrder/{id}")
    @ResponseBody
    public ResponseEntity<PurchaseOrders> deletePurchaseOrder(@PathVariable String id) {
        PurchaseOrders deletedOrder = sSales.deletePurchaseOrder(id);
        return new ResponseEntity<>(deletedOrder,HttpStatus.OK);
    }

//Bill Of Lading

    @PostMapping("/sales/createBill")
    @ResponseBody
    public ResponseEntity<BillOfLading> createBill(@RequestBody BillOfLading bl) {
        BillOfLading created = sSales.createBillOfLading(bl);
        return new ResponseEntity<>(created,HttpStatus.OK);
    }

    @GetMapping("/sales/retrieveBills")
    @ResponseBody
    public ResponseEntity<List<BillOfLading>> getBills() {
        List<BillOfLading> list = sSales.retrieveAllBillOfLading();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PutMapping("/sales/validateBill/{id}")
    @ResponseBody
    public ResponseEntity<BillOfLading> validateBill(@PathVariable("id") String id ) {
        BillOfLading updated = sSales.changeBillStatus(id);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
    @DeleteMapping("sales/deleteBill/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteBill(@PathVariable String id) {
         sSales.deleteBill(id);
        return new ResponseEntity<>("Bill Deleted",HttpStatus.OK);
    }

    @GetMapping("/sales/countUndeliveredBills")
    @ResponseBody
    public int numberOfUndeliveredBills() {
        return sSales.countAllUndeliveredBills();
    }
    @GetMapping("/sales/countUnpaidCommands")
    @ResponseBody
    public int numberOfUnpaidBills() {
        return sSales.countAllUnpaidCommands();
    }


    //risk management
    @GetMapping("/sales/retrieveUndeliveredBills")
    @ResponseBody
    public ResponseEntity<List<BillOfLading>> getUnpaidBills() {
        List<BillOfLading> list = sSales.retrieveUndeliveredBills();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/sales/retrieveUnpaidPurchaseOrders")
    @ResponseBody
    public ResponseEntity<List<PurchaseOrders>> getUnpaidPurchaseOrders() {
        List<PurchaseOrders> list = sSales.retrieveUnpaidOrders();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PutMapping("/sales/deliverBill/{id}")
    @ResponseBody
    public ResponseEntity<BillOfLading> deliverBill(@PathVariable String id) {
        BillOfLading validatedBill = sSales.changeBillDeliveryStatus(id);
        return new ResponseEntity<>(validatedBill,HttpStatus.OK);
    }

    @PutMapping("/sales/payOrder/{id}")
    @ResponseBody
    public ResponseEntity<PurchaseOrders> payOrder(@PathVariable String id) {
        PurchaseOrders paidOrder =  sSales.changeOrderPaymentStatus(id);
        return new ResponseEntity<>(paidOrder,HttpStatus.OK);
    }
}
