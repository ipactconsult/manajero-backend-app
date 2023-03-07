package com.stock.main.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "category")
@Getter
@Setter
public class Category {
	
	@Id
	private String categoryId;
	
	private String categoryCode;
	
	private String categoryName;
	
	private String categoryDesc;
	
	private Date categoryCreationDate;
	
	private Boolean categoryState;
        
        private Object addedBy;
	
	public Category() {
		super();
	}
        
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    
    public Object getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Object addedBy) {
        this.addedBy = addedBy;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public Date getCategoryCreationDate() {
        return categoryCreationDate;
    }

    public void setCategoryCreationDate(Date categoryCreationDate) {
        this.categoryCreationDate = categoryCreationDate;
    }

    public Boolean getCategoryState() {
        return categoryState;
    }

    public void setCategoryState(Boolean categoryState) {
        this.categoryState = categoryState;
    }
        
        
}
