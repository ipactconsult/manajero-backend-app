package manazelo.microservice.finance.repositories;

import manazelo.microservice.finance.entities.ForecastMoneyFlow;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ForecastRep extends MongoRepository<ForecastMoneyFlow,String> {


    @Aggregation(pipeline = "{'$group': {_id: { direction :'$direction', year :'$year',differenciator:'$differenciator'},'january': { '$sum': '$january' },'february': { '$sum': '$february' },'march':{'$sum' :'$march'},'april':{'$sum' :'$april'},'may':{'$sum' :'$may'},'june':{'$sum' :'$june'},'july':{'$sum' :'$july'},'august':{'$sum' :'$august'},'september':{'$sum' :'$september'},'october':{'$sum' :'$october'},'november':{'$sum' :'$november'},'december':{'$sum' :'$december'},'total' {'$sum' :'$total'}}}}")
    List<ForecastMoneyFlow> computeTotalYearly();

    @Aggregation(pipeline = "{'$group': {_id: { direction :'$direction', year :'$year',type:'$type'},'january': { '$sum': '$january' },'february': { '$sum': '$february' },'march':{'$sum' :'$march'},'april':{'$sum' :'$april'},'may':{'$sum' :'$may'},'june':{'$sum' :'$june'},'july':{'$sum' :'$july'},'august':{'$sum' :'$august'},'september':{'$sum' :'$september'},'october':{'$sum' :'$october'},'november':{'$sum' :'$november'},'december':{'$sum' :'$december'},'total' {'$sum' :'$total'}}}}")
    List<ForecastMoneyFlow> computeTotalByType();

    @Query("{ $and :[ {'differenciator' : ?0} ,{'year': ?1} ] }")
    ForecastMoneyFlow findFmfByDifferenciatorAndYear (String differenciator , int year);


    @Query("{ 'year' : ?0  }")
    List<ForecastMoneyFlow> findFmfByYear (int year);
    @Query("{ $and :[ {'type' : ?0} ,{'year': ?1} ] }")
    ForecastMoneyFlow findFmfByTypeAndYear (String type,int year);

    @Aggregation(pipeline = {
            "{$match: { $and :[ {'type' : ?0} ,{'year': ?1} ]}}",
            "{$group: { _id: '', january: {$sum: $january}, february: {$sum: $february}, march: {$sum: $march}, april: {$sum: $april}, may: {$sum: $may}, june: {$sum: $june}, july: {$sum: $july}, august: {$sum: $august}, september: {$sum: $september}, october: {$sum: $october}, november: {$sum: $november}, december: {$sum: $december}, total: {$sum: $total}}}"
    })
    ForecastMoneyFlow computeTotalsByType(String type,int year);

}
