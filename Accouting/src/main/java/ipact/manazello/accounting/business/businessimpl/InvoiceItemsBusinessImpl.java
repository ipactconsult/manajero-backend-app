package ipact.manazello.accounting.business.businessimpl;

import ipact.manazello.accounting.business.ibusiness.IInvoiceItemsBusiness;
import ipact.manazello.accounting.model.Invoice;
import ipact.manazello.accounting.model.InvoiceItems;
import ipact.manazello.accounting.repository.InvoiceItemsRepository;
import ipact.manazello.accounting.repository.InvoiceRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceItemsBusinessImpl implements IInvoiceItemsBusiness {

    private final InvoiceItemsRepository invoiceItemsRepository;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceItemsBusinessImpl(InvoiceItemsRepository invoiceItemsRepository, InvoiceRepository invoiceRepository) {
        this.invoiceItemsRepository = invoiceItemsRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public InvoiceItems addInvoiceItem(InvoiceItems invoiceItem) {
        Instant instanceNow = Instant.now();
        invoiceItem.setCreatedAt(instanceNow);
        invoiceItem.setTotal(invoiceItem.getQuantity() * invoiceItem.getUnitPrice());
        return invoiceItemsRepository.save(invoiceItem);
    }

    @Override
    public List<InvoiceItems> findByInvoice(String id) {
        return invoiceItemsRepository.findByInvoice_Id(new ObjectId(id));
    }

    @Override
    public List<InvoiceItems> exportItemsPDF(String id) {
        List<InvoiceItems> items = invoiceItemsRepository.findByInvoice_Id(new ObjectId(id));
        float total =0.0f;
        for (int i = 0; i < items.size(); i++)
            total = total + items.get(i).getTotal();

        try{

            Invoice invoice = invoiceRepository.findById(id).orElse(null);
            String filePath = "D:\\internship_Ipact\\accounting\\src\\main\\resources\\templates\\Invoice.jrxml";
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("invoiceNumber",invoice.getInvoiceNumber());
            parameters.put("totalinvoice",total);
            parameters.put("clientName",invoice.getClientName());
            parameters.put("clientEmail",invoice.getClientEmail());
            parameters.put("clientPhone",invoice.getClientPhone());
            parameters.put("clientAddress",invoice.getClientAddress());

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);

            JasperReport report = JasperCompileManager.compileReport(filePath);

            JasperPrint print = JasperFillManager.fillReport(report,parameters,dataSource);

            JasperExportManager.exportReportToPdfFile(print,"D:\\internship_Ipact\\reportspdf\\Invoice_"
                    +invoice.getTitle()+"_"+invoice.getInvoiceNumber()+".pdf" );


        }catch (Exception e) {
            return items;
        }


        return items;
    }

    @Override
    public List<InvoiceItems> findAll() {
        return invoiceItemsRepository.findAll();
    }
}
