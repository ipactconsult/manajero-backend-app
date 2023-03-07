package manazelo.microservice.finance.repositories;

import manazelo.microservice.finance.entities.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface QuotesRep extends MongoRepository <Quote,String>{


}
