package com.headhigh.seagullcare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.headhigh.seagullcare.helper.SeagullConstants;
import com.headhigh.seagullcare.model.Company;
import com.headhigh.seagullcare.model.Member;
import com.headhigh.seagullcare.model.StatusModel;
import com.headhigh.seagullcare.service.ContactService;
import com.headhigh.seagullcare.service.MemberService;

/**
 * Handles requests for the welcome page.
 */
@Controller
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	
	@Autowired
	public MemberService memberService;
	
	@Autowired
	public ContactService contactService;
	
	/**
	 * Simply selects the register view to render by returning its name.
	 */
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String register(Model model) {
		logger.info("Register Screen");
		
		Company newCompany = new Company();
		Member newMember = new Member();
		
		model.addAttribute("newCompany", newCompany);
		model.addAttribute("newMember", newMember);
		
		return "register";
	}
	
	
	/**
	 * Simply registers new Member of Company.
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNew(Model model, 
			@ModelAttribute("newCompany")Company newCompany, 
			@ModelAttribute("newMember")Member newMember) {
		logger.info("Register Screen");
		
		if(newCompany.hasallRequiredFields()){
			logger.info("Creating new Company");
			
			//StatusModel status = companyService.registerCompany(newCompany);
			StatusModel status = new StatusModel();
			if (status.isError()){
				logger.error(" Error Occurred: " + status.getErrorMessage());
				//Send notification to support
				
				model.addAttribute("error","Failed to Register.  Please try again or send us a notification via the Contact us Tab.");
				model.addAttribute("newCompany", newCompany);
			}else{
				model.addAttribute("msg","Registered successfully.  You will receive an email with further instructions.  Thank You");
				newCompany = new Company();
				model.addAttribute("newCompany", newCompany);
			}
			
		}else if(newMember.hasallRequiredFields()){
			//Registered as member
			logger.info("Creating new Member");

			StatusModel status = memberService.registerMember(newMember);
			
			
			if (status.isError()){
				logger.error(" Error Occurred: " + status.getErrorMessage());
				
				contactService.sendEmail(newMember.getMemberName(), newMember.getMemberPhone(), "Failure To Register", status.getErrorMessage(), newMember.getMemberEmail());
				
				model.addAttribute("error",status.getErrorMessage());
				model.addAttribute("newMember", newMember);
			}else{
				model.addAttribute("msg","Registered successfully.  You will receive an email with further instructions.  Thank You");
				newMember = new Member();
				model.addAttribute("newMember", newMember);
			}
		}else{
			logger.error(" Error Occurred: missing required fields");
			model.addAttribute("error",SeagullConstants.POPULATE_REQUIRED_FIELDS);
			model.addAttribute("newMember", newMember);
			model.addAttribute("newCompany", newCompany);
		}
		
		return "register";
	}
	
	
}
