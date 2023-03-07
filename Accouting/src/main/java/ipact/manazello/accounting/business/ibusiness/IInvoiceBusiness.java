package ipact.manazello.accounting.business.ibusiness;

import ipact.manazello.accounting.model.Invoice;

import java.util.List;

public interface IInvoiceBusiness {

    Invoice addInvoice(Invoice invoice);
    List<Invoice> getAllInvoice();
    Invoice getInvoiceById(String id);
    List<Invoice> getByPastDue(boolean past);
    List<Invoice> getByPastDueAndRelance(boolean pastDueDate, boolean relance);
    Invoice updateRelance(String id);
    Invoice archive(String id);
}
