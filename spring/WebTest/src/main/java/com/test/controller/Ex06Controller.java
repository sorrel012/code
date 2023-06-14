package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.domain.SpringDTO;

@Controller
public class Ex06Controller {

	//요청 메소드의 반환 자료형
	
	//1. String			> 가장 많이 사용
	//	- JSP 파일명
	//	- ViewResolver
	/*
	@GetMapping("/ex06.do")
	public String test() {
	
		return "ex06";
	}
	*/
	
	
	//2. void
	//	- 요청 주소와 동일한 이름의 JSP 페이지를 자동으로 호출한다.
	//	- 관리하기 불편..
	/*
	@GetMapping("/ex06.do")
	public void test() {
	}
	*/
	
	
	//3. String + 키워드
	//	- "redirect: URL"
	//	- "forward: URL"
	/*
	@GetMapping("/ex06.do")
	public String test() {
	
		// = response.sendRedirect()
		//return "redirect:/ex05.do";> 종종 사용
		
		// = pageContext.forward() > 쓸일이 많지 X
		return "forward:/ex05.do";
	}
	*/
	
	/*
	@GetMapping("/ex06.do")
	public String test(RedirectAttributes rttr) {
	
		String seq = "5";
		String type= "1";
		
		rttr.addAttribute("seq", seq);
		rttr.addAttribute("type", type);
		
		//return "redirect:/ex05.do?seq=" + seq + "&type=" + type;
		return "redirect:/ex05.do";
		
	}
	*/
	
	
	//4. 객체
	//	- @ResponseBody : JSON 반환값을 생성하는 어노테이션(JSON을 돌려준다.)	> ajax 사용할 떄
	
	/*
	@GetMapping("/ex06.do")
	public @ResponseBody SpringDTO test() {
		
		SpringDTO dto = new SpringDTO();
		
		dto.setName("홍길동");
		dto.setAge("20");
		dto.setAddress("서울시");
		
		return dto;
	}
	*/
	
	@GetMapping("/ex06.do")
	public @ResponseBody List<SpringDTO> test() {
		
		List<SpringDTO> list = new ArrayList<SpringDTO>();
		
		SpringDTO dto = new SpringDTO();
		
		dto.setName("홍길동");
		dto.setAge("20");
		dto.setAddress("서울시");
		
		list.add(dto);
		
		return list;
	}
	
}