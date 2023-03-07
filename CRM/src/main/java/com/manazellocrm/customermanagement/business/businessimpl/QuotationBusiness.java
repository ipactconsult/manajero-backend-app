package com.manazellocrm.customermanagement.business.businessimpl;

import com.manazellocrm.customermanagement.business.ibusiness.IQuotationBusiness;
import com.manazellocrm.customermanagement.entities.Quotation;
import com.manazellocrm.customermanagement.repositories.QuotationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuotationBusiness implements IQuotationBusiness {

    private final QuotationRepository quotationRepository;

    @Override
    public Quotation addQuotation(Quotation quotation) {
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        quotation.setStatus("PENDING");
        quotation.setArchive("No");
        quotation.setCreatedAt(instanceNow);
        return quotationRepository.save(quotation);
    }

    @Override
    public Quotation updateQuotation(Quotation quotation) {
        return quotationRepository.save(quotation);
    }

    @Override
    public Quotation updateQuotationStatus(Quotation quotation, String id) {
        Optional<Quotation> quotationOptional= quotationRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        quotation.setModifiedAt(dateToUpdate);
        quotation.setStatus("Validated");
        return (quotationOptional.isPresent() ?
                quotationRepository.save(quotation)
                : null);
    }

    @Override
    public List<Quotation> getAllQuotations() {
        return quotationRepository.findAll();
    }

    @Override
    public Quotation getQuotationByID(String id) {
        return quotationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Quotation> getQuotationsNonArchived(String archive) {
        return quotationRepository.findQuotationsByArchive("False");
    }

    @Override
    public List<Quotation> getQuotationsPending() {
        return quotationRepository.findQuotationsByStatus("PENDING");
    }


}
