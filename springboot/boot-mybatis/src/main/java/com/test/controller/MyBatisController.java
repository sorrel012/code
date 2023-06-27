package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyBatisController {

	@GetMapping("/ex01.do")
	public String ex01() {
		
		return "ex01";
	}
	
}
