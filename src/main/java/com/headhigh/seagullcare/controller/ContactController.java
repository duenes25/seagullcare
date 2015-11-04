package com.headhigh.seagullcare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.headhigh.seagullcare.model.ContactUs;
import com.headhigh.seagullcare.model.StatusModel;
import com.headhigh.seagullcare.service.ContactService;
import com.headhigh.seagullcare.service.EmailService;

/**
 * Handles requests for the welcome page.
 */
@Controller
public class ContactController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	public ContactService contactService;
	

	/**
	 * Simply selects the contact view to render by returning its name.
	 */
	@RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
	public String contact(Model model) {
		logger.info("Contact Screen");
		
		ContactUs newContact = new ContactUs();
		
		model.addAttribute("newContact", newContact);
		return "contact";
	}
	
	/**
	 * Simply responds to the contact us post message and displays information whether it was success or not.
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String sendContactUsMessage(Model model, @ModelAttribute("newContact")ContactUs newContact) {
		logger.info("Sending ContactUs information!");
		
		StatusModel status = contactService.sendEmail(newContact.getContactName(), newContact.getContactPhone(), "New Seagull Care info request", newContact.getContactComments(), newContact.getContactEmail());
		
		if (status.isError()){
			logger.error(" Error Occurred: " + status.getErrorMessage());
			model.addAttribute("error",status.getErrorMessage());
			model.addAttribute("newContact", newContact);
		}else{
			model.addAttribute("msg","Message delivered successfully.  We will respond to your inquiry with highest priority.  Thank You");
			ContactUs newerContact = new ContactUs();
			
			model.addAttribute("newContact", newerContact);
		}
		
		
		
		return "contact";
	}
	

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
}
