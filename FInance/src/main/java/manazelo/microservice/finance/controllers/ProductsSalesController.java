package manazelo.microservice.finance.controllers;


import manazelo.microservice.finance.business.businessimpl.ProductsSalesImpl;
import manazelo.microservice.finance.entities.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
public class ProductsSalesController {

    private final ProductsSalesImpl psi;

    public ProductsSalesController(ProductsSalesImpl psi) {
        this.psi = psi;
    }


    //Quotes
    @PostMapping("/sales/createProductsQuote")
    @ResponseBody
    public ResponseEntity<ProductsQuotes> addProductQuote(@RequestBody ProductsQuotes q) {
        ProductsQuotes instance = psi.createPquote(q);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @PutMapping("/sales/validateProductQuote/{id}")
    @ResponseBody
    public ResponseEntity<ProductsQuotes> updateProductQuote(@PathVariable String id) {
        ProductsQuotes validatedQuote = psi.validateQuote(id);
        return new ResponseEntity<>(validatedQuote,HttpStatus.OK);
    }
    @DeleteMapping("/sales/removeProductQuote/{id}")
    @ResponseBody
    public ResponseEntity<String> removeProductQuote(@PathVariable("id") String id) {
         psi.deletePquote(id);
        return new ResponseEntity<>("quote deleted",HttpStatus.OK);
    }
    @GetMapping("/sales/retrieveProductsQuotes")
    @ResponseBody
    public ResponseEntity<List<ProductsQuotes>> getProductsQuotes() {
        List<ProductsQuotes> productsQuotes= psi.getAllPquotes();


        return new ResponseEntity<>(productsQuotes, HttpStatus.OK);
    }

    //Purchase Orders
    @PostMapping("/sales/createProductPurchaseOrder")
    @ResponseBody
    public ResponseEntity<ProductsPurchaseOrders> addProductQuote(@RequestBody ProductsPurchaseOrders q) {
        ProductsPurchaseOrders instance = psi.createPpo(q);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @PutMapping("/sales/validateProductPurchaseOrder/{id}")
    @ResponseBody
    public ResponseEntity<ProductsPurchaseOrders> updateProductOrder(@PathVariable String id) {
        ProductsPurchaseOrders validatedOrder = psi.validatedOrder(id);
        return new ResponseEntity<>(validatedOrder,HttpStatus.OK);
    }
    @DeleteMapping("/sales/removeProductPurchaseOrder/{id}")
    @ResponseBody
    public ResponseEntity<String> removeProductPurchaseOrder(@PathVariable("id") String id) {
        psi.deletePpo(id);
        return new ResponseEntity<>("Order deleted",HttpStatus.OK);
    }
    @GetMapping("/sales/retrieveProductsPurchaseOrders")
    @ResponseBody
    public ResponseEntity<List<ProductsPurchaseOrders>> getProductsPurchaseOrders() {
        List<ProductsPurchaseOrders> productsPurchaseOrders = psi.getAllPpo();

        return new ResponseEntity<>(productsPurchaseOrders, HttpStatus.OK);
    }

    //Bill Of Lading
    @PostMapping("/sales/createProductBill")
    @ResponseBody
    public ResponseEntity<ProductsBillOfLading> addProductQuote(@RequestBody ProductsBillOfLading pb) {
        ProductsBillOfLading instance = psi.createBill(pb);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }

    @DeleteMapping("/sales/removeProductBillOfLading/{id}")
    @ResponseBody
    public ResponseEntity<String> removeProductBill(@PathVariable("id") String id) {
        psi.deleteBill(id);
        return new ResponseEntity<>("Bill deleted",HttpStatus.OK);
    }
    @GetMapping("/sales/retrieveProductsBills")
    @ResponseBody
    public ResponseEntity<List<ProductsBillOfLading>> getProductsBills() {
        List<ProductsBillOfLading> bills = psi.getAllBills();

        return new ResponseEntity<>(bills, HttpStatus.OK);
    }
    @PutMapping("/sales/validateProductBill/{id}")
    @ResponseBody
    public ResponseEntity<ProductsBillOfLading> validatedBill(@PathVariable String id) {
        ProductsBillOfLading validatedBill = psi.validateBill(id);
        return new ResponseEntity<>(validatedBill,HttpStatus.OK);
    }

    //risk management
    @GetMapping("/sales/retrieveUndeliveredProductsBills")
    @ResponseBody
    public ResponseEntity<List<ProductsBillOfLading>> getUnpaidBills() {
        List<ProductsBillOfLading> list = psi.retrieveUndeliveredBills();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/sales/retrieveUnpaidProductsPurchaseOrders")
    @ResponseBody
    public ResponseEntity<List<ProductsPurchaseOrders>> getUnpaidPurchaseOrders() {
        List<ProductsPurchaseOrders> list = psi.retrieveUnpaidOrders();


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PutMapping("/sales/deliverProductBill/{id}")
    @ResponseBody
    public ResponseEntity<ProductsBillOfLading> deliverBill(@PathVariable String id) {
        ProductsBillOfLading validatedBill = psi.changeBillDeliveryStatus(id);
        return new ResponseEntity<>(validatedBill,HttpStatus.OK);
    }

    @PutMapping("/sales/payProductOrder/{id}")
    @ResponseBody
    public ResponseEntity<ProductsPurchaseOrders> payOrder(@PathVariable String id) {
        ProductsPurchaseOrders paidOrder =  psi.changeOrderPaymentStatus(id);
        return new ResponseEntity<>(paidOrder,HttpStatus.OK);
    }

}
