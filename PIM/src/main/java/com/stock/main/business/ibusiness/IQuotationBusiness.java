package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.Quotation;

public interface IQuotationBusiness {
	
	public List<Quotation> getAllQuotations();
	public List<Quotation> getAllQuotationsASC();
	public List<Quotation> getAllQuotationsDESC();
	public Quotation getOneQuotation(String quotationId);
	public Quotation addNewQuotation(Quotation quotation);
	public Quotation archiveQuotation(String quotationId);
	public Quotation restoreQuotation(String quotationId);
	public Quotation deleteQuotation(String quotationId);

}
