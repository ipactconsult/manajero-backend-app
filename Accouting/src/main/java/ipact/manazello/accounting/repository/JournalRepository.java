package ipact.manazello.accounting.repository;


import ipact.manazello.accounting.model.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends MongoRepository<Journal, String>{
    List<Journal> findByName(String name);
}
