package ipact.manazello.accounting.business.ibusiness;

import ipact.manazello.accounting.model.InvoiceItems;

import java.util.List;

public interface IInvoiceItemsBusiness {
    InvoiceItems addInvoiceItem(InvoiceItems invoiceItem);
    List<InvoiceItems> findByInvoice(String id);

    List<InvoiceItems> exportItemsPDF(String id);
    List<InvoiceItems> findAll();
}
