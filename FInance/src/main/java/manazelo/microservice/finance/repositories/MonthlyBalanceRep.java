package manazelo.microservice.finance.repositories;
import manazelo.microservice.finance.entities.MonthlyBalanceChart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MonthlyBalanceRep extends MongoRepository<MonthlyBalanceChart,String> {
    @Query (value="{ $and: [ { 'month' : ?0 }, { 'year' : ?1 } ] }")
    List<MonthlyBalanceChart> findMbcByMonthAndYear(int month, int year);
    @Query("{'date' : ?0}")
    MonthlyBalanceChart findMbcByDate(Date date);

}
