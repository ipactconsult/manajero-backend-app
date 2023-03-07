package com.communicationMarketing.main.entity;

import org.springframework.stereotype.Component;

@Component
public class Usemail {
	private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
