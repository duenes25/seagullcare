package com.headhigh.seagullcare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the welcome page.
 */
@Controller
public class WelcomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	/**
	 * Simply selects the welcome view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		logger.info("Welcome Screen");
		
		return "welcome";
	}
	
}
