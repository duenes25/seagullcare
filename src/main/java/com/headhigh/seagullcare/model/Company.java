package com.headhigh.seagullcare.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String companyName;
	private String companyPhone;
	private String companyAddress;
	private String pointOfContactName;
	private String pointOfContactEmail;
	private String pointOfContactPhone;
	private String password;
	
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Company(String companyName, String companyPhone,
			String companyAddress, String pointOfContactName,
			String pointOfContactEmail, String pointOfContactPhone) {
		this.companyName = companyName;
		this.companyPhone = companyPhone;
		this.companyAddress = companyAddress;
		this.pointOfContactName = pointOfContactName;
		this.pointOfContactEmail = pointOfContactEmail;
		this.pointOfContactPhone = pointOfContactPhone;
	}



	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyPhone() {
		return companyPhone;
	}


	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}


	public String getCompanyAddress() {
		return companyAddress;
	}


	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}


	public String getPointOfContactName() {
		return pointOfContactName;
	}


	public void setPointOfContactName(String pointOfContactName) {
		this.pointOfContactName = pointOfContactName;
	}


	public String getPointOfContactEmail() {
		return pointOfContactEmail;
	}


	public void setPointOfContactEmail(String pointOfContactEmail) {
		this.pointOfContactEmail = pointOfContactEmail;
	}


	public String getPointOfContactPhone() {
		return pointOfContactPhone;
	}


	public void setPointOfContactPhone(String pointOfContactPhone) {
		this.pointOfContactPhone = pointOfContactPhone;
	}
	
	
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean hasallRequiredFields(){
		boolean isCorrect = false;
		if (getCompanyName()!= null && !getCompanyName().isEmpty() &&
				getCompanyAddress()!= null && !getCompanyAddress().isEmpty() &&
				getCompanyPhone()!= null && !getCompanyPhone().isEmpty() &&
				getPointOfContactEmail()!= null && !getPointOfContactEmail().isEmpty() &&
				getPointOfContactName()!= null && !getPointOfContactName().isEmpty() &&
				getPointOfContactPhone()!= null && !getPointOfContactPhone().isEmpty()
				){
			isCorrect = true;
		}
		return isCorrect;
	}
	
	public String generatePassword(){
		setPassword("randomNumber");
		return getPassword();
	}
}
