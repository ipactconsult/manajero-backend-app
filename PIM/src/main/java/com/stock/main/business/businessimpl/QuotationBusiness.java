package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IQuotationBusiness;
import com.stock.main.entities.Quotation;
import com.stock.main.repositories.QuotationRepository;

@Service
public class QuotationBusiness implements IQuotationBusiness {
	
	@Autowired
	private QuotationRepository quotationRepo;
	
	public List<Quotation> getAllQuotations() {
		List<Quotation> quotations = quotationRepo.findAll(
                    Sort.by(Sort.Direction.DESC, "quotationCreation")    
                );
		if (!quotations.isEmpty()) {
			return quotations;
		}
		return new ArrayList<>();
	}
	
	public List<Quotation> getAllQuotationsASC() {
		List<Quotation> quotations = quotationRepo.findAll(
				Sort.by(Sort.Direction.ASC, "quotationNumber"));
		if (!quotations.isEmpty()) {
			return quotations;
		}
		return new ArrayList<>();
	}
	
	public List<Quotation> getAllQuotationsDESC() {
		List<Quotation> quotations = quotationRepo.findAll(
				Sort.by(Sort.Direction.DESC, "quotationNumber"));
		if (!quotations.isEmpty()) {
			return quotations;
		}
		return new ArrayList<>();
	}
	
	public Quotation getOneQuotation(String quotationId) {
				Quotation existedQuotation = quotationRepo.findById(quotationId).orElse(null);
				if (existedQuotation != null) {
					return existedQuotation;
				} else {
					return null;
				}
	}
	
	public Quotation addNewQuotation(Quotation quotation) {
			quotation.setQuotationCreation(new Date());
			quotation.setQuotationState(true);
			quotation.getRfq().setSuppliers(null);
			quotationRepo.save(quotation);
			return quotation;
	}
	
	public Quotation archiveQuotation(String quotationId) {
				Quotation existedQuotation = quotationRepo.findById(quotationId).orElse(null);
				if (existedQuotation != null) {
					existedQuotation.setQuotationState(false);
					quotationRepo.save(existedQuotation);
					return existedQuotation;
				} else {
					return null;
				}
	}
	
	public Quotation restoreQuotation(String quotationId) {
		Quotation existedQuotation = quotationRepo.findById(quotationId).orElse(null);
		if (existedQuotation != null) {
			existedQuotation.setQuotationState(true);
			quotationRepo.save(existedQuotation);
			return existedQuotation;
		} else {
			return null;
		}
}
	
	public Quotation deleteQuotation(String quotationId) {
		Quotation existedQuotation = quotationRepo.findById(quotationId).orElse(null);
		if (existedQuotation != null) {
			quotationRepo.delete(existedQuotation);
			return existedQuotation;
		} else {
			return null;
		}
}

}
