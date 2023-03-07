package ipact.manazello.accounting.repository;


import ipact.manazello.accounting.model.Tax;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaxRepository extends MongoRepository<Tax, String> {

    List<Tax> findByName(String name);
    List<Tax> findByTypeContaining(String type);
}
