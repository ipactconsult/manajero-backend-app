package ipact.manazello.accounting.business.businessimpl;

import ipact.manazello.accounting.business.ibusiness.IInvoiceBusiness;
import ipact.manazello.accounting.model.Invoice;
import ipact.manazello.accounting.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class InvoiceBusinessImpl implements IInvoiceBusiness {

    private final InvoiceRepository invoiceRepository;

    public InvoiceBusinessImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        Instant instanceNow = Instant.now();
        invoice.setCreatedAt(instanceNow);
        invoice.setArchived(false);
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(String id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Invoice> getByPastDue(boolean past) {
        return invoiceRepository.findByPastDueDate(past);
    }

    @Override
    public List<Invoice> getByPastDueAndRelance(boolean pastDueDate, boolean relance){
        return invoiceRepository.findByPastDueDateAndRelance(pastDueDate, relance);
    }

    @Override
    public Invoice updateRelance(String id) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);

        if (invoice.isRelance()){
            invoice.setRelance(false);
            return invoiceRepository.save(invoice);}

            invoice.setRelance(true);
            return invoiceRepository.save(invoice);
        }

    @Override
    public Invoice archive(String id) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        if(invoice.isArchived())
        {invoice.setArchived(false);}
        else{invoice.setArchived(true);}
        return invoiceRepository.save(invoice);
    }
}

