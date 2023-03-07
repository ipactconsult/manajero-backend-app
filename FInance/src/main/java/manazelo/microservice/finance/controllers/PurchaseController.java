package manazelo.microservice.finance.controllers;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@Controller
public class PurchaseController {

    private final RestTemplate restTemplate;

    public PurchaseController( RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }


    @GetMapping("/purchases/retrievePendingPurchaseRequests")
    @ResponseBody
    public ResponseEntity<Object[]> getPurchaseRequests() {
        Object[] pendingQuo = restTemplate.getForObject
                ("https://pim-manazello-backend.herokuapp.com/pr/pending-prs", Object[].class);


        return new ResponseEntity<>(pendingQuo, HttpStatus.OK);
    }
    @GetMapping("/purchases/getPendingPurchaseOrders")
    @ResponseBody
    public ResponseEntity<Object[]> getPendingPo() {
        Object[] pendingQuo = restTemplate.getForObject
                ("https://pim-manazello-backend.herokuapp.com/po/pending-pos", Object[].class);


        return new ResponseEntity<>(pendingQuo, HttpStatus.OK);
    }

    @PutMapping("/purchases/approvePurchaseRequest/{id}")
    @ResponseBody
    public String approveRequest(@PathVariable("id") String id ) {
        HttpHeaders headers = new HttpHeaders();

        String resourceUrl =
                "https://pim-manazello-backend.herokuapp.com/pr/approve/" + id;
        HttpEntity<Object> requestUpdate = new HttpEntity<>(headers);
        restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
        return "Success";
    }
    @PutMapping("/purchases/approvePurchaseOrder/{id}")
    @ResponseBody
    public String approvePurchaseOrder(@PathVariable("id") String id ) {
        HttpHeaders headers = new HttpHeaders();

        String resourceUrl =
                "https://pim-manazello-backend.herokuapp.com/po/approve/" + id;
        HttpEntity<Object> requestUpdate = new HttpEntity<>(headers);
        restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
        return "Success";
    }
    @PutMapping("/purchases/rejectPurchaseOrder/{id}")
    @ResponseBody
    public ResponseEntity<String> rejectPurchaseOrder(@PathVariable("id") String id ) {
        HttpHeaders headers = new HttpHeaders();

        String resourceUrl =
                "https://pim-manazello-backend.herokuapp.com/po/reject/" + id;
        HttpEntity<Object> requestUpdate = new HttpEntity<>(headers);
        restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
    @PutMapping("/purchases/rejectPurchaseRequest/{id}")
    @ResponseBody
    public ResponseEntity<String> rejectPurchaseRequest(@PathVariable("id") String id ) {
        HttpHeaders headers = new HttpHeaders();

        String resourceUrl =
                "https://pim-manazello-backend.herokuapp.com/pr/reject/" + id;
        HttpEntity<Object> requestUpdate = new HttpEntity<>(headers);
        restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }


}
