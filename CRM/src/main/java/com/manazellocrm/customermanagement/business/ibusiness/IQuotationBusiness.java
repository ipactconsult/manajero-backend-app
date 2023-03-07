package com.manazellocrm.customermanagement.business.ibusiness;

import com.manazellocrm.customermanagement.entities.Quotation;

import java.util.List;

public interface IQuotationBusiness {

    Quotation addQuotation (Quotation quotation);
    Quotation updateQuotation (Quotation quotation);
    Quotation updateQuotationStatus(Quotation quotation, String id) ;
    List<Quotation> getAllQuotations ();
    Quotation getQuotationByID(String id);
    List<Quotation> getQuotationsNonArchived(String archive);
    List<Quotation> getQuotationsPending();
}
