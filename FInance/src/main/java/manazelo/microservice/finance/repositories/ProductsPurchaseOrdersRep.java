package manazelo.microservice.finance.repositories;

import manazelo.microservice.finance.entities.ProductsPurchaseOrders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsPurchaseOrdersRep extends MongoRepository<ProductsPurchaseOrders,String> {
}
