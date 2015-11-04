package com.headhigh.seagullcare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the login page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Simply selects the login view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Model model, 
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "signOut", required = false) String signOut) {
		logger.info("login Screen");
		if (error != null) {
			model.addAttribute("error", "Invalid username and password.  Please try again.");
		}
		if (signOut != null) {
			model.addAttribute("msg", "Successfully Signed Out");
		}
		
		return "login";
	}
	
}
