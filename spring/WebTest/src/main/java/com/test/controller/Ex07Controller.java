package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex07Controller {

	@RequestMapping(value="/ex07.do", method=RequestMethod.GET)
	public String ex07(@RequestParam(value="num", defaultValue = "10") int num, Model model) {
		
		//ex07.do?num=100
		
		model.addAttribute("result", 100 / num);
		
		return "ex07";
	}
	
}
