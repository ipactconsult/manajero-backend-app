package com.communicationMarketing.main.business.dtos;



public class ParternershipDTO {
	


	private String id;
    private String ParternershipName;

	private String parternershipLogo ; 
	private String ParternershipDomain ;
	private String ParternershipWebSiteLink ;
	
	private String ParternershipEmail ;
	private String ParternershipAdresse ;
	private String ParternershipLinkedin ;
	private Long ParternershipPhone ;
	private String description ;
	private String country ;
	 private boolean archive;
	
	public ParternershipDTO() {
		super();
	}







	public ParternershipDTO(String id, String parternershipName, String parternershipLogo, String parternershipDomain,
			String parternershipWebSiteLink, String parternershipEmail, String parternershipAdresse,
			String parternershipLinkedin, Long parternershipPhone, String description, String country,
			boolean archive) {
		super();
		this.id = id;
		ParternershipName = parternershipName;
		this.parternershipLogo = parternershipLogo;
		ParternershipDomain = parternershipDomain;
		ParternershipWebSiteLink = parternershipWebSiteLink;
		ParternershipEmail = parternershipEmail;
		ParternershipAdresse = parternershipAdresse;
		ParternershipLinkedin = parternershipLinkedin;
		ParternershipPhone = parternershipPhone;
		this.description = description;
		this.country = country;
		this.archive = archive;
	}







	public boolean isArchive() {
		return archive;
	}







	public void setArchive(boolean archive) {
		this.archive = archive;
	}







	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParternershipName() {
		return ParternershipName;
	}

	public void setParternershipName(String parternershipName) {
		ParternershipName = parternershipName;
	}

	public String getParternershipLogo() {
		return parternershipLogo;
	}

	public void setParternershipLogo(String parternershipLogo) {
		this.parternershipLogo = parternershipLogo;
	}

	public String getParternershipDomain() {
		return ParternershipDomain;
	}

	public void setParternershipDomain(String parternershipDomain) {
		ParternershipDomain = parternershipDomain;
	}

	public String getParternershipWebSiteLink() {
		return ParternershipWebSiteLink;
	}

	public void setParternershipWebSiteLink(String parternershipWebSiteLink) {
		ParternershipWebSiteLink = parternershipWebSiteLink;
	}

	public String getParternershipEmail() {
		return ParternershipEmail;
	}

	public void setParternershipEmail(String parternershipEmail) {
		ParternershipEmail = parternershipEmail;
	}

	public String getParternershipAdresse() {
		return ParternershipAdresse;
	}

	public void setParternershipAdresse(String parternershipAdresse) {
		ParternershipAdresse = parternershipAdresse;
	}

	public String getParternershipLinkedin() {
		return ParternershipLinkedin;
	}

	public void setParternershipLinkedin(String parternershipLinkedin) {
		ParternershipLinkedin = parternershipLinkedin;
	}

	public Long getParternershipPhone() {
		return ParternershipPhone;
	}

	public void setParternershipPhone(Long parternershipPhone) {
		ParternershipPhone = parternershipPhone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	

}
