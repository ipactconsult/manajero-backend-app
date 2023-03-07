package com.communicationMarketing.main.entity;

import java.time.Instant;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "PostData")
public class PostData {
	@Id
private  String id ;
  private String  description;

  private String  creatorId;
  private String  imageUrl;
  private String  name;
  
  
  @Column(name = "created_at", updatable = false, nullable = false)
	 private Instant createdAt;


	@Column(name = "modified_at")
	private Instant modifiedAt;
	
	@DocumentReference
    private List<Comment> comments;
	
	@DocumentReference
    private List<Like> likes;


	public PostData() {
		super();
	}




	public PostData(String id, String description, String creatorId, String imageUrl, String name, Instant createdAt,
			Instant modifiedAt, List<Comment> comments, List<Like> likes) {
		super();
		this.id = id;
		this.description = description;
		this.creatorId = creatorId;
		this.imageUrl = imageUrl;
		this.name = name;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.comments = comments;
		this.likes = likes;
	}















	public String getName() {
		return name;
	}















	public void setName(String name) {
		this.name = name;
	}















	public List<Like> getLikes() {
		return likes;
	}



	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}




	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCreatorId() {
		return creatorId;
	}


	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
