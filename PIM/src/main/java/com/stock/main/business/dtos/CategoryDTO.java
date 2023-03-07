package com.stock.main.business.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	
	private String categoryId;
	
	private String categoryCode;
	
	private String categoryName;
	
	private String categoryDesc;
        
        private Object addedBy;
	
	private Date categoryCreationDate;
	
	private boolean categoryState;
	
	public CategoryDTO() {
		super();
	}

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public Object getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Object addedBy) {
        this.addedBy = addedBy;
    }
    
        /**
     * @return the categoryCode
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * @param categoryCode the categoryCode to set
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * @return the categoryCreationDate
     */
    public Date getCategoryCreationDate() {
        return categoryCreationDate;
    }

    /**
     * @param categoryCreationDate the categoryCreationDate to set
     */
    public void setCategoryCreationDate(Date categoryCreationDate) {
        this.categoryCreationDate = categoryCreationDate;
    }
    
        /**
     * @return the categoryDesc
     */
    public String getCategoryDesc() {
        return categoryDesc;
    }

    /**
     * @param categoryDesc the categoryDesc to set
     */
    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    /**
     * @return the categoryState
     */
    public boolean isCategoryState() {
        return categoryState;
    }

    /**
     * @param categoryState the categoryState to set
     */
    public void setCategoryState(boolean categoryState) {
        this.categoryState = categoryState;
    }
        
        

}
