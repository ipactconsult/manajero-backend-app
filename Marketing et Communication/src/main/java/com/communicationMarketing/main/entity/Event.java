package com.communicationMarketing.main.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document(collection = "Event")
public class Event {
	
	@Id

	private String id;
	
	private String title;
	private String description ; 
	private Date  date;
    private float prix ;
    private String adresse ;
 
    private String  image ;
    private String  time ;
    private String  country ;
    private Long  nombre ;
	private boolean archive;
	@DocumentReference
    private List<Persona> personas;
	@DocumentReference
    private List<Parternership> partners;
	
    
    
	public Event() {
		super();
	}






	public Event(String id, String title, String description, Date date, float prix, String adresse, String image,
			String time, String country, Long nombre, boolean archive, List<Persona> personas,
			List<Parternership> partners) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.prix = prix;
		this.adresse = adresse;
		this.image = image;
		this.time = time;
		this.country = country;
		this.nombre = nombre;
		this.archive = archive;
		this.personas = personas;
		this.partners = partners;
	}






	public List<Persona> getPersonas() {
		return personas;
	}



	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}



	public List<Parternership> getPartners() {
		return partners;
	}



	public void setPartners(List<Parternership> partners) {
		this.partners = partners;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getNombre() {
		return nombre;
	}
	public void setNombre(Long nombre) {
		this.nombre = nombre;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

    
    


	
	
	
	
}
