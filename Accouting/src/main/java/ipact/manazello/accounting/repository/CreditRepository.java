package ipact.manazello.accounting.repository;

import ipact.manazello.accounting.model.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreditRepository extends MongoRepository<Credit, String> {
    List<Credit> findAll();
}
