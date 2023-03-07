package com.communicationMarketing.main.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "Publication")

public class Publication {
	
	@Id
	private String id ;
	private String title ; 
	private String description ; 

	private String hastag ; 
	private String content ; 
	private String briefingType ; 
	private String tags ; 
	private String socialMedia ; 
	private Date dateDebut ; 
	private Date dateFin ; 
	private String type ;
	@DocumentReference
    private List<Persona> personas;
	@DocumentReference
    private GraphicalCharter graphicalCharter;

	
	private boolean archive;

	
	public Publication() {
		super();
	}


	public Publication(String id, String title, String description, String hastag, String content, String briefingType,
			String tags, String socialMedia, Date dateDebut, Date dateFin, String type, List<Persona> personas,
			GraphicalCharter graphicalCharter, boolean archive) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.hastag = hastag;
		this.content = content;
		this.briefingType = briefingType;
		this.tags = tags;
		this.socialMedia = socialMedia;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.type = type;
		this.personas = personas;
		this.graphicalCharter = graphicalCharter;
		this.archive = archive;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getHastag() {
		return hastag;
	}


	public void setHastag(String hastag) {
		this.hastag = hastag;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getBriefingType() {
		return briefingType;
	}


	public void setBriefingType(String briefingType) {
		this.briefingType = briefingType;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	public String getSocialMedia() {
		return socialMedia;
	}


	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<Persona> getPersonas() {
		return personas;
	}


	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}


	public GraphicalCharter getGraphicalCharter() {
		return graphicalCharter;
	}


	public void setGraphicalCharter(GraphicalCharter graphicalCharter) {
		this.graphicalCharter = graphicalCharter;
	}


	public boolean isArchive() {
		return archive;
	}


	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	
	

	

}
