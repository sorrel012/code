package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//- "/web/list.do"
	//- "/web/add.do"
	//- "/web/addok.do"
	
	//- "/web/board/list.do?
	

	@RequestMapping(value="/list.do")
	public String list() {
		
		return "list";
	}
	
	//doGet() 역할
	//@RequestMapping(value="/add.do", method= {RequestMethod.GET, RequestMethod.POST})
	@GetMapping(value="/add.do")
	public String add() {
		
		return "add";
	}
	
	//doPost() 역할
	//@RequestMapping(value="/addok.do", method=RequestMethod.POST)
	@PostMapping(value="addok.do")
	public String addok() {
		
		return "addok";
	}
	
}
