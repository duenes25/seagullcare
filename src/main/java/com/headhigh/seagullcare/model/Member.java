package com.headhigh.seagullcare.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="Member")
public class Member implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private int enabled;
	private byte[] password;
	private byte[] salt;
	private String role;
	
	
	public Member() {
		super();
		
	}

	public Member(String memberName, String memberPhone, String memberEmail, int enabled) {
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.enabled = enabled;
		
	}
	public Member(Long id, String memberName, String memberPhone, String memberEmail, int enabled) {
		this.id = id;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.enabled = enabled;
		
	}
	
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}
	
	
	
	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public boolean hasallRequiredFields(){
		boolean isCorrect = false;
		if (getMemberEmail()!= null && !getMemberEmail().isEmpty() &&
				getMemberName()!= null && !getMemberName().isEmpty() &&
				getMemberPhone()!= null && !getMemberPhone().isEmpty()
				){
			isCorrect = true;
		}
		return isCorrect;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}
