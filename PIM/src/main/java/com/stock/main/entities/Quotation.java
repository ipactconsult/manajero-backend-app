package com.stock.main.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "quotation")
@Getter
@Setter
public class Quotation {
	
	@Id
	private String quotationId;
	
	private String quotationNumber;
	
	private Date quotationCreation;
	
	private boolean quotationState;
	
	private Supplier supplier;
	
	private RequestForQuotation rfq;
	
	public Quotation() {
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
        
        
}
