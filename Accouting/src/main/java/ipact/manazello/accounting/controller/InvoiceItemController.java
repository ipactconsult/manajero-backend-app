package ipact.manazello.accounting.controller;


import ipact.manazello.accounting.business.ibusiness.IInvoiceItemsBusiness;
import ipact.manazello.accounting.model.InvoiceItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
@RestController
@RequestMapping("/invoiceitem")
@EnableCaching
public class InvoiceItemController {

    private final IInvoiceItemsBusiness iib;


    @Autowired
    public InvoiceItemController(IInvoiceItemsBusiness iib) {
        this.iib = iib;
    }

    @PostMapping(value="/add")
    public InvoiceItems createInvoice(@RequestBody InvoiceItems invoiceItems){
        return iib.addInvoiceItem(invoiceItems);
    }

    @GetMapping("/invoiceItems/{id}")
    public List<InvoiceItems> getByInvoice(@PathVariable("id") String id){
            return iib.findByInvoice(id);
    }

    @GetMapping("/getall")
    public List<InvoiceItems> getAll(){
        return iib.findAll();
    }

    @GetMapping("/topdf/{id}")
    public List<InvoiceItems> exportToPDF(@PathVariable("id") String id){
        return iib.exportItemsPDF(id);
    }


}
