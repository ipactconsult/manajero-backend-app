package com.communicationMarketing.main.business.dtos;

import org.springframework.data.annotation.Id;

public class GlobalCharterDTO {
	@Id
	String id ; 
	
	String title ;
	String module ;
	String description;
	String file ; 
	String logo ;
	String typo ;
	String couleurs ;
	String icon ;
	String template ;
	String templateName ;
	boolean archive;
	
	public GlobalCharterDTO() {
		super();

	}



	public GlobalCharterDTO(String id, String title, String module, String description, String file, String logo,
			String typo, String couleurs, String icon, String template, String templateName, boolean archive) {
		super();
		this.id = id;
		this.title = title;
		this.module = module;
		this.description = description;
		this.file = file;
		this.logo = logo;
		this.typo = typo;
		this.couleurs = couleurs;
		this.icon = icon;
		this.template = template;
		this.templateName = templateName;
		this.archive = archive;
	}



	public String getTemplateName() {
		return templateName;
	}



	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTypo() {
		return typo;
	}

	public void setTypo(String typo) {
		this.typo = typo;
	}

	public String getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(String couleurs) {
		this.couleurs = couleurs;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}


	
	

}
