package com.stock.main.business.ibusiness;

import java.util.List;

import javax.mail.MessagingException;

import com.stock.main.entities.RequestForQuotation;

public interface IRequestForQuotationBusiness {
	
	public List<RequestForQuotation> getAllRFQ();
	public List<RequestForQuotation> getAllRFQASC();
	public List<RequestForQuotation> getAllRFQDESC();
	public RequestForQuotation getOneRFQ(String rfqId);
	public RequestForQuotation addNewRFQ(RequestForQuotation rfq) throws MessagingException;
	public RequestForQuotation archiveRFQ(String rfqId);
	public RequestForQuotation restoreRFQ(String rfqId);
	public RequestForQuotation deleteRFQ(String rfqId);

}
