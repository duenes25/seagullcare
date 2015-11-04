package com.headhigh.seagullcare.model;

public class ContactUs {

	private String contactName;
	private String contactEmail;
	private String contactPhone;
	private String contactComments;
	
	
	
	
	public ContactUs() {
		super();

	}

	public ContactUs(String contactName, String contactEmail,
			String contactPhone, String contactComments) {
		super();
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.contactComments = contactComments;
	}
	
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactComments() {
		return contactComments;
	}
	public void setContactComments(String contactComments) {
		this.contactComments = contactComments;
	}
	
	
	
	
	
}
