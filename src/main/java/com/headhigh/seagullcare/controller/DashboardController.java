package com.headhigh.seagullcare.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DashboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome to the dashboard!");
		
		//Check Whether its a Company of Member, and respond accordingly
//		if(isCompany){
//			logger.debug("redirect to Company Dashboard");
//			model.addAttribute("retrievedCompany", retrievedCompany );
//			
//			return "companyDashboard";
//		}else{
//			logger.debug("redirect to Member Dashboard"
//			model.addAttribute("retrievedMember", retrievedMember );
//			return "memberDashboard";
//		}
		
		
		return "memberDashboard";
		
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/companyDashboard"}, method = RequestMethod.GET)
	public String companyDashboard(Model model) {
		logger.info("Welcome to the company dashboard!");
		
		//Check Whether its a Company of Member, and respond accordingly
//		if(isCompany){
//			logger.debug("redirect to Company Dashboard");
//			model.addAttribute("retrievedCompany", retrievedCompany );
//			
//			return "companyDashboard";
//		}else{
//			logger.debug("redirect to Member Dashboard"
//			model.addAttribute("retrievedMember", retrievedMember );
//			return "memberDashboard";
//		}
		
		
		return "companyDashboard";
		
	}
	
}
