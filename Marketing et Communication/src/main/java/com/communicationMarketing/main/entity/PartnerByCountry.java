package com.communicationMarketing.main.entity;

public class PartnerByCountry { 
	private String name;
private int value;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public PartnerByCountry(String name, int value) {
	super();
	this.name = name;
	this.value = value;
}
public PartnerByCountry() {
	super();
	// TODO Auto-generated constructor stub
}


}
