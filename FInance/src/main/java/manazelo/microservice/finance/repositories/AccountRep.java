package manazelo.microservice.finance.repositories;

import manazelo.microservice.finance.entities.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Qualifier("account")
@Repository
public interface AccountRep extends MongoRepository<Account,String> {

    @Query("{ 'code' : ?0  }")
    Account findBankAccountByCode (String code);
}
