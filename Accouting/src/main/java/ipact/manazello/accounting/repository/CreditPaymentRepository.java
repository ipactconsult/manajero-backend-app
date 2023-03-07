package ipact.manazello.accounting.repository;


import ipact.manazello.accounting.model.CreditPayment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditPaymentRepository extends MongoRepository<CreditPayment, String> {
    List<CreditPayment> findAllByCredit_Id(ObjectId id);
}
