package com.manazellocrm.customermanagement.controllers;

import com.manazellocrm.customermanagement.business.ibusiness.IDeliveryBusiness;
import com.manazellocrm.customermanagement.entities.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RequestMapping(path = { "/api/delivery" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DeliveryController {
    final IDeliveryBusiness iDeliveryBusiness;

    @GetMapping("/allDeliveries")
    public List<Delivery> findAllDeliveries(){
        return  iDeliveryBusiness.getAllDeliveries();
    }

    @PostMapping("/create-delivery/{idOrder}")
    public Delivery addDelivery(@RequestBody Delivery delivery, @PathVariable String idOrder) throws NoSuchAlgorithmException {
        return iDeliveryBusiness.addDelivery(delivery, idOrder);
    }

    @PutMapping("/edit-delivery/{id}")
    public Delivery updateDelivery(@RequestBody Delivery delivery, @PathVariable String id){
        return iDeliveryBusiness.updateDelivery(delivery,id);
    }
    @PutMapping("/validate-delivery")
    public Delivery validateDelivery(@RequestBody Delivery delivery){
        return iDeliveryBusiness.validateDelivery(delivery);
    }

    @PutMapping("/archive-delivery/{id}")
    public Delivery archiveDelivery(@RequestBody Delivery delivery, @PathVariable String id){
        return iDeliveryBusiness.archiveDelivery(delivery,id);
    }

    @PutMapping("/cancel-archive-delivery/{id}")
    public Delivery cancelArchiveDelivery(@RequestBody Delivery delivery, @PathVariable String id){
        return iDeliveryBusiness.cancelArchiveDelivery(delivery,id);
    }

    @GetMapping("/delivery-by-id/{id}")
    public Delivery getDeliveryById(@PathVariable String id){
        return iDeliveryBusiness.getDeliveryByID(id);
    }

    @GetMapping("/delivery-not-archived/{id}")
    public List<Delivery> getDeliveryNotArchived(@PathVariable String id){
        return iDeliveryBusiness.getAllDeliveriesNonArchived(id);
    }

    @GetMapping("/delivery-desc/{archive}")
    public List<Delivery> getAllDeliveriesDesc(@PathVariable String archive) {
        return iDeliveryBusiness.findAllDeliveryDESC(archive);
    }

    @GetMapping("/delivery-asc/{archive}")
    public List<Delivery> getAllDeliveriesAsc(@PathVariable String archive) {
        return iDeliveryBusiness.findAllDeliveryASC(archive);
    }
}
