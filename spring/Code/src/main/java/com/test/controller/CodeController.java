package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.CodeDTO;
import com.test.persistence.CodeDAO;

@Controller
public class CodeController {

	@Autowired
	private CodeDAO dao;

	@GetMapping("/list.do")
	public String list(Model model) {
		
		List<CodeDTO> list = dao.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping("/add.do")
	public String add(Model model) {
		return "add";
	}
	
	@PostMapping("/addok.do")
	public String addok(CodeDTO dto) {
		
		int result = dao.add(dto);
		
		if (result == 1) {
			return "redirect:/list.do";
		} else {
			return "redirect:/add.do";
		}
		
	}
	
	@GetMapping("/view.do")
	public String view(Model model, String seq) {
		
		CodeDTO dto = dao.view(seq);
		
		model.addAttribute("dto", dto);
		
		return "view";
	}
	
}
