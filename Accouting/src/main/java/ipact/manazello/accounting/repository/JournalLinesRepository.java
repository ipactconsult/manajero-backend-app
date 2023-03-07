package ipact.manazello.accounting.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ipact.manazello.accounting.model.JournalLines;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalLinesRepository extends MongoRepository<JournalLines, String> {
    List<JournalLines> findAllByJournal_Id(ObjectId id);
    List<JournalLines> findAllByAccount_Id(ObjectId id);
}
