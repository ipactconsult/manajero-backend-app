package manazelo.microservice.finance.repositories;

import manazelo.microservice.finance.entities.BillOfLading;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillOfLadingRep extends MongoRepository<BillOfLading,String> {
}
