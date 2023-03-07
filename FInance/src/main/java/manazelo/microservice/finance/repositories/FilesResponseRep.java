package manazelo.microservice.finance.repositories;

import manazelo.microservice.finance.entities.FileResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilesResponseRep extends MongoRepository<FileResponse,String> {

    @Query(value="{ $and: [ { 'month' : ?0 }, { 'year' : ?1 } ] }")
    List<FileResponse> findFileResponseByMonthAndYear(int month, int year);
    @Query("{'reconciled' : true}")
    List<FileResponse> findReconciledFiles ();
    @Query("{'reconciled' : false}")
    List<FileResponse> findnonReconciledFiles ();
    @Query("{$and :[{'stringDate' : ?0},{'details' : ?1}]}")
    List<FileResponse> findFilesByDateAndDetails (String date,String details);
}
