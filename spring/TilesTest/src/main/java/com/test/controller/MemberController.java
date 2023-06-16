package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@GetMapping("/info.do")
	public String info() {
		
		return "info";
	}
	
	@GetMapping("/history.do")
	public String history() {
		
		return "history";
	}
	
	@GetMapping("/favorite.do")
	public String favorite() {
		
		return "favorite";
	}
	
}
