package ipact.manazello.accounting.repository;

import ipact.manazello.accounting.model.InvoiceItems;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceItemsRepository extends MongoRepository<InvoiceItems, String> {
    List<InvoiceItems> findByInvoice_Id(ObjectId id);
}
