package ipact.manazello.accounting.repository;

import ipact.manazello.accounting.model.FilesProof;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesProofRepository extends MongoRepository<FilesProof, String> {
}
