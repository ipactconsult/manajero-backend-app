package com.manazellocrm.customermanagement.controllers;

import com.manazellocrm.customermanagement.business.ibusiness.IQuotationBusiness;
import com.manazellocrm.customermanagement.entities.Quotation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = { "/api/quotations" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuotationController {

  private final IQuotationBusiness iQuotationBusiness;

    public QuotationController(IQuotationBusiness iQuotationBusiness) {
        this.iQuotationBusiness = iQuotationBusiness;
    }

    @PostMapping("/demandQuotation")
    public Quotation addQuotation (@Valid @RequestBody Quotation quotation){
        return iQuotationBusiness.addQuotation(quotation);
    }

    @GetMapping("/allQuotations")
    public List<Quotation> getAllQuotations (){
        return iQuotationBusiness.getAllQuotations();
    }

    @GetMapping("/allPendingQuotations")
    public List<Quotation> getAllPendingQuotations (){
        return iQuotationBusiness.getQuotationsPending();
    }

    @PutMapping("/update-quotation/{id}")
    public Quotation updateQuotation(@RequestBody Quotation quotation){
        return iQuotationBusiness.updateQuotation(quotation);
    }
    @PutMapping("/update-quotation-status/{id}")
    public Quotation updateQuotationStatus(@RequestBody Quotation quotation, @PathVariable("id") String id){
        return iQuotationBusiness.updateQuotationStatus(quotation,id);
    }

    @GetMapping("/quotation-by-id/{id}")
    public Quotation getQuotationByID (@PathVariable("id") String id){
        return iQuotationBusiness.getQuotationByID(id);
    }

    @GetMapping("/quotation-by-id/{archive}")
    public List<Quotation> getQuotationNonArchived (@PathVariable("archive") String archive){
        return iQuotationBusiness.getQuotationsNonArchived(archive);
    }

}
