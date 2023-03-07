package com.stock.main.business.dtos;

import java.util.Date;

import com.stock.main.entities.RequestForQuotation;
import com.stock.main.entities.Supplier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuotationDTO {
	
	private String quotationId;
	
	private String quotationNumber;
	
	private Date quotationCreation;
	
	private boolean quotationState;
	
	private Supplier supplier;
	
	private RequestForQuotation rfq;
	
	public QuotationDTO() {
		super();
	}

    /**
     * @return the quotationId
     */
    public String getQuotationId() {
        return quotationId;
    }

    /**
     * @param quotationId the quotationId to set
     */
    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    /**
     * @return the quotationNumber
     */
    public String getQuotationNumber() {
        return quotationNumber;
    }

    /**
     * @param quotationNumber the quotationNumber to set
     */
    public void setQuotationNumber(String quotationNumber) {
        this.quotationNumber = quotationNumber;
    }

    /**
     * @return the quotationState
     */
    public boolean isQuotationState() {
        return quotationState;
    }

    /**
     * @param quotationState the quotationState to set
     */
    public void setQuotationState(boolean quotationState) {
        this.quotationState = quotationState;
    }
    
        /**
     * @return the quotationCreation
     */
    public Date getQuotationCreation() {
        return quotationCreation;
    }

    /**
     * @param quotationCreation the quotationCreation to set
     */
    public void setQuotationCreation(Date quotationCreation) {
        this.quotationCreation = quotationCreation;
    }

    /**
     * @return the rfq
     */
    public RequestForQuotation getRfq() {
        return rfq;
    }

    /**
     * @param rfq the rfq to set
     */
    public void setRfq(RequestForQuotation rfq) {
        this.rfq = rfq;
    }
    
        /**
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
        
        

}
