package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex05Controller {

	@GetMapping("/ex05.do")
	public String ex05() {
		
		//글쓰기 페이지(add.do 역할)
		return "ex05";
	}
	
	//데이터 수신
	// - 기존: req.getParameter("")

	/*
	@PostMapping("/ex05ok.do")
	public String ex05ok(HttpServletRequest req) {
		
		//System.out.println(req == null);
		//System.out.println(resp == null);
		//System.out.println(session == null);
		
		String data = req.getParameter("data");
		
		req.setAttribute("data", data);
		
		//글 쓴 후 확인 페이지(addok.do 역할)
		return "ex05ok";
	}
	*/
	
	/* 복사용
	@PostMapping("ex05ok.do")
	public String ex05ok() {

		return "ex05ok";
	}
	*/
	
	/*
	@PostMapping("ex05ok.do")
	public String ex05ok(@RequestParam("data") String data, Model model) {
		
		//String data = req.getParameter("data");   == @RequestParam("data") String data
		
		//System.out.println(data);
		
		//ModelAndView > Model
		
		model.addAttribute("data", data); //req.setAttribute
		
		return "ex05ok";
	}
	*/
	
	/*
	@PostMapping("ex05ok.do")
	public String ex05ok(Model model, String data) {

		//@RequestParam("data") 생략 가능!
		
		//System.out.println(data);
		
		model.addAttribute("data", data);
		
		return "ex05ok";
	}
	*/
	
	//복합 데이터 전송
	/*
	@PostMapping("ex05ok.do")
	public String ex05ok(
							Model model,
							@RequestParam("name") String name,
							@RequestParam("age") String age,
							@RequestParam("address") String address
						) {
		
		SpringDTO dto = new SpringDTO();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		model.addAttribute("dto", dto);

		return "ex05ok";
	}
	*/
	
	/*
	@PostMapping("ex05ok.do")
	public String ex05ok(
							Model model,
							String name,
							String age,
							String address
						) {
		
		SpringDTO dto = new SpringDTO();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		model.addAttribute("dto", dto);

		return "ex05ok";
	}
	*/

	/*
	@PostMapping("ex05ok.do")
	public String ex05ok(Model model, SpringDTO dto, String seq) {

		//System.out.println(dto);
		
		model.addAttribute("dto", dto);
		
		System.out.println(seq);
		
		return "ex05ok";
	}
	*/
	
	
	//다중 데이터 받는 법
	
	@PostMapping("ex05ok.do")
	public String ex05ok(Model model,
						//@RequestParam("cb") String[] cb
						String[] cb
						//@RequestParam("cb") List<String> cb
						//List<String> cb  > 동작(X)
						) {

		//String[] list = req.getParameterValues("cb")
		
		model.addAttribute("cb", cb);
		
		return "ex05ok";
	}
	
	
	/*
	@PostMapping("ex05ok.do")
	public String ex05ok(@ModelAttribute("data") String data) {
		
		//@ModelAttribute("data") String data
		// = model.addAttribute("data", data)

		return "ex05ok";
	}
	*/
	
	/*
	@PostMapping("ex05ok.do")
	public String ex05ok(@ModelAttribute("dto") SpringDTO dto) {
		
		//1. <input type="text" name="name">
		//2. req.getParameter("name")
		//3. dto.setName("");
		
		//System.out.println(dto);
		
		return "ex05ok";
	}
	*/
}
