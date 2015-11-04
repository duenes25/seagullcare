package com.headhigh.seagullcare.service;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headhigh.seagullcare.helper.SeagullConstants;
import com.headhigh.seagullcare.model.StatusModel;

public class EmailService {
	private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
    private String fromEmail;//= "duenes2525@gmail.com";
	private String pwd;// = "25E25e2144";

	
	
	/**
	 * 
	 * If the toEmail is missing, then we send to ouselves.
	 * @param customerName
	 * @param customerPhone
	 * @param subject
	 * @param body
	 * @param toEmail
	 * @return
	 */
	public StatusModel sendContactUsEmail(String customerName, String customerPhone, String subject, String body, String customerEmail){
    	// Get system properties
    	Properties properties = System.getProperties();

    	// Setup mail server
    	properties.put("mail.smtp.host", "smtp.gmail.com");
    	properties.put("mail.smtp.socketFactory.port", "465");
    	properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
    	properties.put("mail.smtp.auth", "true");
    	properties.put("mail.smtp.port", "465");

    	StatusModel status = new StatusModel();
    	
    	try{
	    	// Get the Session object.
			Session session = Session.getDefaultInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(getFromEmail(),getPwd());
					}
				});
	
			logger.info("Connected");
	
	    	
			body = "Customer Name: " + customerName + "\nEmail: " + customerEmail + "\nCustomer Phone Number: " + customerPhone + "\n" + body; 
	    	
    	
	    	
    		// Create a default MimeMessage object.
    		MimeMessage message = new MimeMessage(session);

    		
    		// Set From: header field of the header.
    		message.setFrom(new InternetAddress(getFromEmail()));
    		
    		
    		// Set To: header field of the header.
    		message.addRecipient(Message.RecipientType.TO, new InternetAddress(getFromEmail()));

	       // Set Subject: header field
	       message.setSubject(subject);
	
	       // Now set the actual message
	       message.setText(body);
	       
	       logger.info("Sending Message");
	       // Send message
	       Transport.send(message);
	       status.setError(false);
	       logger.info("Sent Email successfully....");
	    }
    	catch (Exception ex) {
	       ex.printStackTrace();
	       status.setError(true);
	       status.setErrorMessage(SeagullConstants.FAILED_TO_SEND_EMAIL);
	    }
    	return status;
    }
	
	public StatusModel sendCustomerEmail(String customerName, String customerPhone, String subject, String body, String toEmail){
    	// Get system properties
    	Properties properties = System.getProperties();

    	// Setup mail server
    	properties.put("mail.smtp.host", "smtp.gmail.com");
    	properties.put("mail.smtp.socketFactory.port", "465");
    	properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
    	properties.put("mail.smtp.auth", "true");
    	properties.put("mail.smtp.port", "465");

    	StatusModel status = new StatusModel();
    	
    	try{
	    	// Get the Session object.
			Session session = Session.getDefaultInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(getFromEmail(),getPwd());
					}
				});
	
			logger.info("Connected");
	
	    	
	    		
    		// Create a default MimeMessage object.
    		MimeMessage message = new MimeMessage(session);

    		
    		// Set From: header field of the header.
    		message.setFrom(new InternetAddress(getFromEmail()));
    		
    		
    		// Set To: header field of the header.
    		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

	       // Set Subject: header field
	       message.setSubject(subject);
	
	       // Now set the actual message
	       message.setText(body);
	       
	       logger.info("Sending Message");
	       // Send message
	       Transport.send(message);
	       status.setError(false);
	       logger.info("Sent Email successfully....");
	    }
    	catch (Exception ex) {
	       ex.printStackTrace();
	       status.setError(true);
	       status.setErrorMessage(SeagullConstants.FAILED_TO_SEND_EMAIL);
	    }
    	return status;
    }
	
	public String getFromEmail() {
		return fromEmail;
	}


	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
