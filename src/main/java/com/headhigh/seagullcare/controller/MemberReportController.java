package com.headhigh.seagullcare.controller;

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
public class MemberReportController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberReportController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/memberReport"}, method = RequestMethod.GET)
	public String memberReport(Model model) {
		logger.info("Welcome to the member Report page!");
		
		
		return "memberReport";
		
	}
	
}
