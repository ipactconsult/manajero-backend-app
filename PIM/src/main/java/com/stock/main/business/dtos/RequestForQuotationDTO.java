package com.stock.main.business.dtos;

import java.util.Date;

import com.stock.main.entities.PurchaseRequisition;
import com.stock.main.entities.Supplier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestForQuotationDTO {
	
	private String rfqId;
	
	private String rfqNumber;
	
	private PurchaseRequisition pr;
	
	private Date quotationDeadline;
	
	private Date rfqCreationDate;
	
	private Supplier[] suppliers;
	
	private boolean rfqState;
	
	private Object user;
	
	public RequestForQuotationDTO() {
		super();
	}

    /**
     * @return the rfqId
     */
    public String getRfqId() {
        return rfqId;
    }

    /**
     * @param rfqId the rfqId to set
     */
    public void setRfqId(String rfqId) {
        this.rfqId = rfqId;
    }

    /**
     * @return the rfqNumber
     */
    public String getRfqNumber() {
        return rfqNumber;
    }

    /**
     * @param rfqNumber the rfqNumber to set
     */
    public void setRfqNumber(String rfqNumber) {
        this.rfqNumber = rfqNumber;
    }

    /**
     * @return the quotationDeadline
     */
    public Date getQuotationDeadline() {
        return quotationDeadline;
    }

    /**
     * @param quotationDeadline the quotationDeadline to set
     */
    public void setQuotationDeadline(Date quotationDeadline) {
        this.quotationDeadline = quotationDeadline;
    }
    
        /**
     * @return the pr
     */
    public PurchaseRequisition getPr() {
        return pr;
    }

    /**
     * @param pr the pr to set
     */
    public void setPr(PurchaseRequisition pr) {
        this.pr = pr;
    }

    /**
     * @return the suppliers
     */
    public Supplier[] getSuppliers() {
        return suppliers;
    }

    /**
     * @param suppliers the suppliers to set
     */
    public void setSuppliers(Supplier[] suppliers) {
        this.suppliers = suppliers;
    }
    
        /**
     * @return the rfqCreationDate
     */
    public Date getRfqCreationDate() {
        return rfqCreationDate;
    }

    /**
     * @param rfqCreationDate the rfqCreationDate to set
     */
    public void setRfqCreationDate(Date rfqCreationDate) {
        this.rfqCreationDate = rfqCreationDate;
    }

    /**
     * @return the rfqState
     */
    public boolean isRfqState() {
        return rfqState;
    }

    /**
     * @param rfqState the rfqState to set
     */
    public void setRfqState(boolean rfqState) {
        this.rfqState = rfqState;
    }

    /**
     * @return the user
     */
    public Object getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Object user) {
        this.user = user;
    }
        
        

}
