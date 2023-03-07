package manazelo.microservice.finance.repositories;

import manazelo.microservice.finance.entities.Transaction;
import manazelo.microservice.finance.entities.TransactionResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Qualifier("transactions")

@Repository
public interface TransactionRep extends MongoRepository<Transaction,String> {
    @Query(value = "{'date' : ?0}")
    List<Transaction> findTransactionByDate(Date date);

    @Query("{'type' : ?0}")
    List<Transaction> findTransactionByType(String type);
    @Query (value="{  'reconciled' : false }")
    List<Transaction> findNonReconciledTransactions();
    @Query (value="{ 'reconciled' : true  }")
    List<Transaction> findReconciledTransactions();

    //each month's transactions of the chosen year
    @Query (value="{ $and: [ { 'month' : ?0 }, { 'year' : ?1 } ] }")
    List<Transaction> findTransactionByMonth(int month,int year);
    //end

    //by year
    @Query (" { '$expr': { '$eq': [{ '$year': '$date'}, ?0] } } ")
    List <Transaction> findTransactionByYear (int year);
    //end by year


    //for the global calculation*

    @Aggregation(pipeline = "{'$group': {_id: { month :'$month', year :'$year'},'totalincome': { '$sum': '$income' },'totalexpense': { '$sum': '$expense' },'totalbalance':{'$sum' :'$balance'}}}}")
    List<TransactionResponse> findTransactionByMonthAndYear( int year,int month);
    void deleteById(String id);


    // find operating transactions

    @Aggregation(pipeline = "{'$group': {_id: { month :'$month', year :'$year',type :'$type'},'totalincome': { '$sum': '$income' },'totalexpense': { '$sum': '$expense' },'totalbalance':{'$sum' :'$balance'}}}}")
    List <TransactionResponse> findOperatingTransactions ();

}
