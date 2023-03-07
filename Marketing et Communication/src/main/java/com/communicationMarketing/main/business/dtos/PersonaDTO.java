package com.communicationMarketing.main.business.dtos;

import java.util.Date;

public class PersonaDTO {

	

	private String id;
	private String title ;

	private Long age ;
	private String localisation ; 
	private String   motivation ;
	private String   interset ;
	private String gender ;

	private String job ;
	private String situation ;
	private String technologie ;
	private String goals ;
	private String softSkills ;
	private String hardSkills ;
	private String description ;
	private String nom ;
	private String prenom ;
	private String email ;
	private String image  ;
	private   String dateofBirth ;
	private String frustrations  ;
	private String personality  ;
	private String bio  ;
	private Long phone  ;
	private String languages  ;
	private long numberOfChildren ;
	private String nationality ; 
	private String adresse;
	public PersonaDTO() {
		super();

	}



	
	


	public PersonaDTO(String id, String title, Long age, String localisation, String motivation, String interset,
			String gender, String job, String situation, String technologie, String goals, String softSkills,
			String hardSkills, String description, String nom, String prenom, String email, String image,
			String dateofBirth, String frustrations, String personality, String bio, Long phone, String languages,
			long numberOfChildren, String nationality, String adresse) {
		super();
		this.id = id;
		this.title = title;
		this.age = age;
		this.localisation = localisation;
		this.motivation = motivation;
		this.interset = interset;
		this.gender = gender;
		this.job = job;
		this.situation = situation;
		this.technologie = technologie;
		this.goals = goals;
		this.softSkills = softSkills;
		this.hardSkills = hardSkills;
		this.description = description;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.image = image;
		this.dateofBirth = dateofBirth;
		this.frustrations = frustrations;
		this.personality = personality;
		this.bio = bio;
		this.phone = phone;
		this.languages = languages;
		this.numberOfChildren = numberOfChildren;
		this.nationality = nationality;
		this.adresse = adresse;
	}







	public String getNationality() {
		return nationality;
	}




	public void setNationality(String nationality) {
		this.nationality = nationality;
	}






	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}





	public long getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(long numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}



	public Long getPhone() {
		return phone;
	}




	public void setPhone(Long phone) {
		this.phone = phone;
	}




	public String getLanguages() {
		return languages;
	}




	public void setLanguages(String languages) {
		this.languages = languages;
	}






	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}







	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getFrustrations() {
		return frustrations;
	}






	public void setFrustrations(String frustrations) {
		this.frustrations = frustrations;
	}






	public String getPersonality() {
		return personality;
	}






	public void setPersonality(String personality) {
		this.personality = personality;
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

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}


	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getInterset() {
		return interset;
	}

	public void setInterset(String interset) {
		this.interset = interset;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getTechnologie() {
		return technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public String getSoftSkills() {
		return softSkills;
	}

	public void setSoftSkills(String softSkills) {
		this.softSkills = softSkills;
	}

	public String getHardSkills() {
		return hardSkills;
	}

	public void setHardSkills(String hardSkills) {
		this.hardSkills = hardSkills;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
