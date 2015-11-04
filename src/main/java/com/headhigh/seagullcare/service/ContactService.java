package com.headhigh.seagullcare.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headhigh.seagullcare.model.StatusModel;

public class ContactService {
	
	private EmailService emailService;
	
	private static final Logger logger = LoggerFactory.getLogger(ContactService.class);
	
	
	public StatusModel sendEmail(String customerName, String customerPhone, String subject, String body, String toEmail){
		logger.info("Entering Contact Service");
		StatusModel status = emailService.sendContactUsEmail(customerName, customerPhone, subject, body, toEmail);
		return status;
	}
	
	

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	

}
