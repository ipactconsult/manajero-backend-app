package manazelo.microservice.finance.repositories;


import manazelo.microservice.finance.entities.ProductsBillOfLading;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsBillOFLadingRep  extends MongoRepository<ProductsBillOfLading,String> {
}
