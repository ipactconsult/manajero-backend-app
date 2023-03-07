package ipact.manazello.accounting.repository;

import ipact.manazello.accounting.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, String> {

    List<Invoice> findByPastDueDate(boolean past);
    List<Invoice> findByPastDueDateAndRelance(boolean pastDueDate, boolean relance);
}
