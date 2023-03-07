package com.communicationMarketing.main.business.dtos;



public class GraphicalCharterDTO {
	 
	

	 private String id;
	 private String color ;
	 private String texType ;
	 private String description ;
	 private String reference  ; 
	 private String formaText ;
	 private String title ;

	 
	public GraphicalCharterDTO() {
		super();

	}


	public GraphicalCharterDTO(String id, String color, String texType, String description, String reference,
			String formaText, String title) {
		super();
		this.id = id;
		this.color = color;
		this.texType = texType;
		this.description = description;
		this.reference = reference;
		this.formaText = formaText;
		this.title = title;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getTexType() {
		return texType;
	}


	public void setTexType(String texType) {
		this.texType = texType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getFormaText() {
		return formaText;
	}


	public void setFormaText(String formaText) {
		this.formaText = formaText;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	
	
	

}
