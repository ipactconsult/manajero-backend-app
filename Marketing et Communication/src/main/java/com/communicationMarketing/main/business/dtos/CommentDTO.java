package com.communicationMarketing.main.business.dtos;

import java.time.Instant;

import javax.persistence.Column;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.communicationMarketing.main.entity.PostData;

public class CommentDTO {

	
	private String id ;
	private String creatorId ;
    private String creatorName ;
	private String content;
	//@DocumentReference
    //private PostData postData;
	@Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;
    @Column(name = "modified_at")
	private Instant modifiedAt;
    
    
    
    
    
    
    
	public CommentDTO() {
		super();

	}







	public CommentDTO(String id, String creatorId, String creatorName, String content, Instant createdAt,
			Instant modifiedAt) {
		super();
		this.id = id;
		this.creatorId = creatorId;
		this.creatorName = creatorName;
		this.content = content;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}







	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getCreatorId() {
		return creatorId;
	}



	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}



	public String getCreatorName() {
		return creatorName;
	}



	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}







	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
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
    
    
		
		
		
		
}
