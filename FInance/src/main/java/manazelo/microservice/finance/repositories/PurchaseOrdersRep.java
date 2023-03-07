package manazelo.microservice.finance.repositories;

import manazelo.microservice.finance.entities.PurchaseOrders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrdersRep extends MongoRepository<PurchaseOrders,String> {

    @Query("{'orderStatus' : 'PENDING'}")
    List<PurchaseOrders> findPendingOrders ();
}
