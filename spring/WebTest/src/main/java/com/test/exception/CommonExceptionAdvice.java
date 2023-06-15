package com.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice //컨트롤러 작업 중 에러가 발생하면 이 클래스를 호출
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {
		
		log.error("예외 발생");
		
		model.addAttribute("code", "A001");
		model.addAttribute("e", e);
		
		return "error"; //error.jsp 페이지 호출
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notfound( NoHandlerFoundException e) {
				
		
		return "notfound";
	}
	
}
