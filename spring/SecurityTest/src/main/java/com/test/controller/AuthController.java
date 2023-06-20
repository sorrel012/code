package com.test.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class AuthController {

	@GetMapping("/accesserror.do")
	public String accesserror(Authentication auth, Model model) {
		
		log.info("Access Denied: " + auth);
		
		model.addAttribute("msg", "Access Denied: " + auth);
		
		return "accesserror";
	}
	
	@GetMapping("/customlogin.do")
	public String customlogin(String error, String logout, Model model) {
		
		log.error("error: " + error) ;
		log.info("logout: " + logout);
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		
		return "customlogin";
	}
	
	@GetMapping("/customlogout.do")
	public String customlogout() {
		
		log.info("custom logout");
		
		return "customlogout";
	}
	
}
