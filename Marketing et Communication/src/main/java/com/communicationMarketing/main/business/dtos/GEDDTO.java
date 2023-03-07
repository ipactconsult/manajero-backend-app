package com.communicationMarketing.main.business.dtos;

import java.io.File;
import java.sql.Date;
import java.time.Instant;

import javax.persistence.Column;

public class GEDDTO {


private String id;
private String title ;
private String description ;
private Date dateCreation;
private String Content ; 
private String ContentType ;
private String fileName ; 
private  File fileGed;

@Column(name = "created_at", updatable = false, nullable = false)
	 private Instant createdAt;


	@Column(name = "modified_at")
	private Instant modifiedAt;
	
	
	private boolean archive;

	
	
	public GEDDTO() {
		super();
	}





	public GEDDTO(String id, String title, String description, Date dateCreation, String content, String contentType,
			String fileName, File fileGed, Instant createdAt, Instant modifiedAt, boolean archive) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateCreation = dateCreation;
		Content = content;
		ContentType = contentType;
		this.fileName = fileName;
		this.fileGed = fileGed;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.archive = archive;
	}


	public boolean isArchive() {
		return archive;
	}





	public void setArchive(boolean archive) {
		this.archive = archive;
	}





	public Instant getCreatedAt() {
		return createdAt;
	}






	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}






	public Instant getModifiedAt() {
		return modifiedAt;
	}






	public void setModifiedAt(Instant modifiedAt) {
		this.modifiedAt = modifiedAt;
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getContentType() {
		return ContentType;
	}

	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public File getFileGed() {
		return fileGed;
	}

	public void setFileGed(File fileGed) {
		this.fileGed = fileGed;
	}




}
