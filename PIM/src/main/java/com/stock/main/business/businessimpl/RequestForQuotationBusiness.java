package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IRequestForQuotationBusiness;
import com.stock.main.entities.RequestForQuotation;
import com.stock.main.repositories.RequestForQuotationRepository;

@Service
public class RequestForQuotationBusiness implements IRequestForQuotationBusiness {
	
	@Autowired
	private RequestForQuotationRepository rfqRepo;
	
	public List<RequestForQuotation> getAllRFQ() {
		List<RequestForQuotation> rfqs = rfqRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "rfqCreationDate")
                );
		if (!rfqs.isEmpty()) {
			return rfqs;
		}
		return new ArrayList<>();
	}
	
	public List<RequestForQuotation> getAllRFQASC() {
		List<RequestForQuotation> rfqs = rfqRepo.findAll(
				Sort.by(Sort.Direction.ASC, "rfqNumber"));
		if (!rfqs.isEmpty()) {
			return rfqs;
		}
		return new ArrayList<>();
	}
	
	public List<RequestForQuotation> getAllRFQDESC() {
		List<RequestForQuotation> rfqs = rfqRepo.findAll(
				Sort.by(Sort.Direction.DESC, "rfqNumber"));
		if (!rfqs.isEmpty()) {
			return rfqs;
		}
		return new ArrayList<>();
	}
	
	public RequestForQuotation getOneRFQ(String rfqId) {
				RequestForQuotation existedRFQ = rfqRepo.findById(rfqId).orElse(null);
				if (existedRFQ != null) {
					return existedRFQ;
				} else {
					return null;
				}
	}
	
	public RequestForQuotation addNewRFQ(RequestForQuotation rfq) throws MessagingException {
			rfq.setRfqCreationDate(new Date());
			rfq.setRfqState(true);
			rfqRepo.save(rfq);
			return rfq;
	}
	
	public RequestForQuotation archiveRFQ(String rfqId) {
				RequestForQuotation existedRFQ = rfqRepo.findById(rfqId).orElse(null);
				if (existedRFQ != null) {
					existedRFQ.setRfqState(false);
					rfqRepo.save(existedRFQ);
					return existedRFQ;
				}
				
			return null;
	}
	
	public RequestForQuotation restoreRFQ(String rfqId) {
		RequestForQuotation existedRFQ = rfqRepo.findById(rfqId).orElse(null);
		if (existedRFQ != null) {
			existedRFQ.setRfqState(true);
			rfqRepo.save(existedRFQ);
			return existedRFQ;
		}
		
	return null;
}
	
	public RequestForQuotation deleteRFQ(String rfqId) {
		RequestForQuotation existedRFQ = rfqRepo.findById(rfqId).orElse(null);
		if (existedRFQ != null) {
			rfqRepo.delete(existedRFQ);
			return existedRFQ;
		}
	return null;
}

}
