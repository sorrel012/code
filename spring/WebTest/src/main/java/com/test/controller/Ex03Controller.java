package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 구현
//1. Controller 인터페이스 구현
//2. @Controller 어노테이션 사용

@Controller
@RequestMapping(value="/ex03.do")
public class Ex03Controller {

	//요청 메소드(핸들러) > 맘대로 만들기
	@RequestMapping
	public String test() {
		
		
		//No mapping found for HTTP request with URI [/web/ex03.do] in DispatcherServlet with name 'appServlet'  >> 스프링이 bean으로 인식하지 못해서 생기는 에러
		
		
		//업무 코드
		
		//뷰 호출하기
		
		//JSP 페이지 이름 > ViewResolver
		// >> "WEB-INF/view/ex03.jsp"
		return "ex03"; //JSP 페이지 이름
		
	}
	
}
