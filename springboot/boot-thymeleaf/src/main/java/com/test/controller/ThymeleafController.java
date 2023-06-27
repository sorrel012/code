package com.test.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.domain.BoardDTO;
import com.test.mapper.ThymeleafMapper;

@Controller
public class ThymeleafController {

	@Autowired
	private ThymeleafMapper mapper;
	
	@GetMapping("/m1")
	public void m1() {
		
		//요청 메소드의 반환값 > void > m1.html (thymeleaf suffix 설정대로 호출)
		System.out.println("m1");
		
	}
	
	//페이지 요청
	//1. 동적 페이지("m2.html") > localhost:8092/m2
	//2. 정적 페이지("m2.html") > localhost:8092/m2.html
	// * 정적 페이지와 동적 페이지 url이 완전히 똑같아서 충돌할 땐 동적 페이지 win
	@GetMapping("/m2")
	public String m2() {
	
		//templates > m2.html
		return "m2";
	}
	
	@GetMapping("/m3")
	public String m3(Model model) {
	
		//단일값 출력
		int num = mapper.getNum();
		String txt = mapper.getTxt();
		BoardDTO dto = mapper.getDTO();
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("dog", "강아지");
		map.put("cat", "고양이");
				
		
		model.addAttribute("num", num);
		model.addAttribute("txt", txt);
		model.addAttribute("now", Calendar.getInstance());
		model.addAttribute("dto", dto);
		model.addAttribute("map", map);
			
		
		return "m3";
	}
	
	/*
	@GetMapping("/m")
	public String m() {
	
		return "m";
	}
	*/
}
