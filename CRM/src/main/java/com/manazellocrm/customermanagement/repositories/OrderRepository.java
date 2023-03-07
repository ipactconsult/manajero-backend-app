package com.manazellocrm.customermanagement.repositories;

import com.manazellocrm.customermanagement.entities.Contract;
import com.manazellocrm.customermanagement.entities.Order;
import com.manazellocrm.customermanagement.entities.Status;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

    List<Order> findOrdersByArchive(String archive);
    List<Order> findOrdersByArchiveOrderByCreatedAtDesc(String archive);
    List<Order> findOrdersByArchiveOrderByCreatedAtAsc(String archive);
    List<Order> findOrdersByContractNull();
    List<Order> findOrdersByContractNotNull();
    List<Order> findOrdersByStatus(Status status);
    @Aggregation(pipeline ={" {$unwind:$contract},{$group: {_id:$contract}}" })
   List<Order> getOrdersWithNoContracts();

    Order findOrderByContract(Contract contract);

}
