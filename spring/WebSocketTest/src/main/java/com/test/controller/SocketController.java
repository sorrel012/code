package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocketController {

	@GetMapping("/test.do")
	public String test() {
		
		return "test";
	}
	
	@GetMapping("/admin.do")
	public String admin() {
		
		return "admin";
	}
	
	@GetMapping("/user.do")
	public String user() {
		
		return "user";
	}
	
}
