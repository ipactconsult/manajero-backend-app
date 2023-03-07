package manazelo.microservice.finance.repositories;


import manazelo.microservice.finance.entities.MoneyFlow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoneyFlowRep extends MongoRepository<MoneyFlow,String> {

    @Query(value = "{ $and: [ { 'direction' : ?0 }, { 'year' : ?1 }, {'month' : ?2 }, { 'type' : ?3 } ] }")
    List<MoneyFlow> findMoneyFlowByDirectionAndYearAndMonthAndType(String direction,int year, String month, String type);
    @Query(value = "{ $and: [ { 'id' : ?0 }, { 'year' : ?1 }, { 'month' : ?2 }, { 'type' : ?3 } ] }")
    MoneyFlow findMoneyFlowByIdAndYear(String id,int year, String month, String type);
    @Query (value = "{ $and: [ { 'direction' : ?0 }, { 'year' : ?1 }, { 'type' : ?2 } ] }")
    List<MoneyFlow> findMoneyFlowByDirectionAndYearAndType (String direction,int year ,String type);
    @Query(value = "{ $and: [ { 'direction' : ?0 }, { 'year' : ?1 } ] }")
    List<MoneyFlow> findMoneyFlowByDirectionAndYear(String direction,int year);
    @Query (value = "{ $and: [ { 'category' : ?0 }, { 'year' : ?1 }, { 'type' : ?2 } ] }")
    List<MoneyFlow> findMoneyFlowByCategoryAndYearAndType (String category,int year ,String type);
    @Query (value = "{ $and: [ { 'category' : ?0 }, { 'year' : ?1 }, { 'type' : ?2 } ] }")
    Optional<MoneyFlow> findOneMoneyFlowByCategoryAndYearAndType (String category, int year , String type);
    @Query (value = "{ $and: [ { 'category' : ?0 }, { 'year' : ?1 }, { 'month' : ?2 },{ 'direction' : ?3 } ] }")
    List<MoneyFlow> findMoneyFlowByCategoryAndYearAndMonthAndDirection ( String category, int year , String month , String direction);






}
