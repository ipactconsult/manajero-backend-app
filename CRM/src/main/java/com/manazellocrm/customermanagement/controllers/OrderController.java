package com.manazellocrm.customermanagement.controllers;

import com.manazellocrm.customermanagement.business.ibusiness.IOrdersBusiness;
import com.manazellocrm.customermanagement.entities.Contract;
import com.manazellocrm.customermanagement.entities.Order;
import com.manazellocrm.customermanagement.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RequestMapping(path = { "/api/orders" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderController {

    final IOrdersBusiness iOrdersBusiness;

    final OrderRepository orderRepository;

    @GetMapping("/allOrders")
    public List<Order> findAllOrders(){
        return  iOrdersBusiness.getAllOrders();
    }

    @PostMapping("/create-order/{idProduct}")
    public Order addOrder(@RequestBody Order order, @PathVariable String idProduct) throws NoSuchAlgorithmException {
        return iOrdersBusiness.addOrder(order, idProduct);
    }

    @PutMapping("/edit-order/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable String id){
        return iOrdersBusiness.updateOrder(order,id);
    }
    @PutMapping("/validate-order/{id}")
    public Order validateOrder(@RequestBody Order order, @PathVariable String id){
        return iOrdersBusiness.validateOrder(order,id);
    }

    @PutMapping("/sale-order/{id}")
    public Order saleOrder(@RequestBody Order order, @PathVariable String id){
        return iOrdersBusiness.saleOrder(order,id);
    }
    @PutMapping("/deliver-order/{id}")
    public Order deliverOrder(@RequestBody Order order, @PathVariable String id){
        return iOrdersBusiness.deliverOrder(order,id);
    }

    @PutMapping("/progress-order/{id}")
    public Order progressOrder(@RequestBody Order order, @PathVariable String id){
        return iOrdersBusiness.inProgressOrder(order,id);
    }

     @PutMapping("/assign-contract-order/{id}")
    public Order assignContractToOrder( @PathVariable String id, @RequestBody Contract contract){
        return iOrdersBusiness.assignContractToOrder(id,contract);
    }

    @PutMapping("/archive-order/{id}")
    public Order archiveOrder(@RequestBody Order order, @PathVariable String id){
        return iOrdersBusiness.archiveOrder(order,id);
    }

    @PutMapping("/cancel-archive-order/{id}")
    public Order cancelArchiveOrder(@RequestBody Order order, @PathVariable String id){
        return iOrdersBusiness.cancelArchiveOrder(order,id);
    }

    @GetMapping("/order-by-id/{id}")
    public Order getOrderById(@PathVariable String id){
        return iOrdersBusiness.getOrderByID(id);
    }

    @GetMapping("/order-not-archived")
    public List<Order> getOrderNotArchived(){
        return iOrdersBusiness.getAllOrdersNonArchived();
    }

    @GetMapping("/orders-archived")
    public List<Order> getOrdersArchived(){
        return iOrdersBusiness.getAllOrdersArchived();
    }

    @GetMapping( "/contracts-null")
    public ResponseEntity<List<Order>> listOrdersNonContracts(){
        return new ResponseEntity<>(iOrdersBusiness.findOrdersContractsNull() , HttpStatus.OK);
    }
    @GetMapping( "/contracts-not-null")
    public ResponseEntity<List<Order>> listOrdersWithContracts(){
        return new ResponseEntity<>(iOrdersBusiness.findOrdersContractsNotNull() , HttpStatus.OK);
    }

    @GetMapping("/orders-desc")
    public List<Order> getAllOrdersDesc() {
        return iOrdersBusiness.findAllOrderDESC();
    }

    @GetMapping("/orders-asc")
    public List<Order> getAllOrdersAsc() {
        return iOrdersBusiness.findAllOrderASC();
    }

    @GetMapping("/orders-sale")
    public List<Order> getAllOrdersRented() {
        return iOrdersBusiness.findAllOrdersConfirmed();
    }
}
