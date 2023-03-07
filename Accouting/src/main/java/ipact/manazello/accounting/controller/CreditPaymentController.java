package ipact.manazello.accounting.controller;

import ipact.manazello.accounting.business.ibusiness.ICreditPaymentBusiness;
import ipact.manazello.accounting.model.CreditPayment;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})

@RestController
@RequestMapping("/creditpayment")
@EnableCaching
public class CreditPaymentController {
    private final ICreditPaymentBusiness cpb;

    public CreditPaymentController(ICreditPaymentBusiness cpb) {
        this.cpb = cpb;
    }

    @GetMapping("/getbycredit/{id}")
    public ResponseEntity<List<CreditPayment>> getByCredit(@PathVariable("id") String id){
        try {
            List<CreditPayment> creditPayment = cpb.findByCredit(id);

            if (creditPayment.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(creditPayment, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
