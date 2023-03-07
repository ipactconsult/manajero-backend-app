package manazelo.microservice.finance.repositories;

import manazelo.microservice.finance.entities.ProductsQuotes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsQuotesRep extends MongoRepository<ProductsQuotes,String> {
}
