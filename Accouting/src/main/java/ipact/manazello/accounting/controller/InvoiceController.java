package ipact.manazello.accounting.controller;

import ipact.manazello.accounting.business.ibusiness.IInvoiceBusiness;
import ipact.manazello.accounting.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final IInvoiceBusiness ib;

    @Autowired
    public InvoiceController(IInvoiceBusiness ib) {
        this.ib = ib;
    }

    @PostMapping(value="/add")
    public Invoice createInvoice(@RequestBody Invoice invoice){
        return ib.addInvoice(invoice);
    }
    @GetMapping("/getpastdue")
    public List<Invoice> findByPastDue() {
        return ib.getByPastDue(true);
    }

    @GetMapping("/getbyid/{id}")
    public Invoice getById(@PathVariable("id") String id){
        return ib.getInvoiceById(id);
    }

    @GetMapping("/getall")
    public List<Invoice> getAll(){
        return ib.getAllInvoice();
    }

    @GetMapping("/getpastdue-relance")
    public List<Invoice> findByPastDueAndRelance(){
        return ib.getByPastDueAndRelance(true, false);
    }

    @PutMapping("/updaterelance/{id}")
    public Invoice updateInvoiceRelance(@PathVariable("id") String id){
        return ib.updateRelance(id);
    }

    @PutMapping("/archive/{id}")
    public Invoice archive(@PathVariable("id") String id){
        return ib.archive(id);
    }
}
