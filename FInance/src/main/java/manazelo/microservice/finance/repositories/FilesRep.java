package manazelo.microservice.finance.repositories;
import manazelo.microservice.finance.entities.Files;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Qualifier("files")

@Repository
public interface FilesRep extends MongoRepository<Files,String> {


}
