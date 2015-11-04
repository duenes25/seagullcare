package com.headhigh.seagullcare.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headhigh.seagullcare.dao.SeagullCareDAO;
import com.headhigh.seagullcare.helper.EncryptionHelper;
import com.headhigh.seagullcare.helper.SeagullConstants;
import com.headhigh.seagullcare.model.Member;
import com.headhigh.seagullcare.model.StatusModel;

public class MemberService {
	
	
	private SeagullCareDAO seagullCareDAO;
	
	private EmailService emailService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	
	
	public List<Member> getMembers(){
		List<Member> memberList = new ArrayList<Member>();
		try{
			memberList = seagullCareDAO.getMembers();
			
		}catch (Exception e){
			logger.error(e.getMessage());
		}
		return memberList;
	}
	
	public Member getMemberInformation(final Member memberToRetrieve){
		Member getMember = new Member();
		try{
			getMember = seagullCareDAO.getMemberInformation(memberToRetrieve);
		}catch (Exception e){
			logger.error(e.getMessage());
		}
       return getMember;
	}
	/**
	 * This method will take of the registration process of the member
	 * @param memberToRegister
	 * @return StatusModel
	 */
	public StatusModel registerMember(final Member memberToRegister){
		logger.info("Registering new memebr");
		StatusModel status = new StatusModel();
		try{
			
			//Generate Random Password
			int i = EncryptionHelper.randInt(100000, 999999);
			
			//generate Salt for user
			byte[] saltByteArray = EncryptionHelper.generateSalt();
			
			
			//encrypt the password
			byte[] encryptedPwdByteArray = EncryptionHelper.getEncryptedPassword(Integer.toString(i), saltByteArray);
			
			logger.info("Done creating and encrypting password");
			memberToRegister.setSalt(saltByteArray);
			memberToRegister.setPassword(encryptedPwdByteArray);
			memberToRegister.setEnabled(1);
			memberToRegister.setRole("ROLE_MEMBER");
			
			status = seagullCareDAO.saveOrUpdateMember(memberToRegister);
			
			//Send email notification to member
			if(!status.isError()){
				String subject = SeagullConstants.APPLICATION_NAME +" Registration Confirmation"; 
				String body = memberToRegister.getMemberName() + " Thank You for registering." +
						"\nBelow please find your SignIn credentials." +
						"\n\n  username: " + memberToRegister.getMemberEmail() +
						"\n  password: " + Integer.toString(i) +
						"\n\nTo Sign in, click the following link, or copy/paste into your browser: " + SeagullConstants.APPLICATION_URL + 
						"\nSincerely, "+
						"\nThe " + SeagullConstants.APPLICATION_NAME+ " Team"; 
				status = emailService.sendCustomerEmail(memberToRegister.getMemberName(), memberToRegister.getMemberPhone(), subject, body, memberToRegister
						.getMemberEmail());
			}
			
		}catch (Exception e){
			logger.error(e.getMessage());
			status.setError(true);
			status.setErrorMessage(e.getMessage());
		}
		return status;
	}
	
	public StatusModel saveOrUpdateMember(final Member memberToSaveUpdate){
		StatusModel status = new StatusModel();
		try{
			status = seagullCareDAO.saveOrUpdateMember(memberToSaveUpdate);
			//Send email notification to member
			
		}catch (Exception e){
			logger.error(e.getMessage());
			status.setError(true);
			status.setErrorMessage(e.getMessage());
		}
		return status;
	}
	
	public StatusModel deleteMember(final Member memberToDelete){
		StatusModel status = new StatusModel();
		try{
			status = seagullCareDAO.deleteMember(memberToDelete);
		}catch (Exception e){
			logger.error(e.getMessage());
			status.setError(true);
			status.setErrorMessage(e.getMessage());
		}
		return status;
	}

	public byte[] generateSalt(){
		logger.info("Generating Salt");
		byte[] saltByteArray = null;
		try {
			saltByteArray =  EncryptionHelper.generateSalt();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saltByteArray;
	}
	
	public byte[] generateEncryptedPassword(byte[] saltByteArray){
		int i = EncryptionHelper.randInt(100000, 999999);
		byte[] encryptedPwdByteArray = null;
		try {
			encryptedPwdByteArray = EncryptionHelper.getEncryptedPassword(Integer.toString(i), saltByteArray);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encryptedPwdByteArray;
	}
	
	public SeagullCareDAO getSeagullCareDAO() {
		return seagullCareDAO;
	}

	public void setSeagullCareDAO(SeagullCareDAO seagullCareDAO) {
		this.seagullCareDAO = seagullCareDAO;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}


}
