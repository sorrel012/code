package com.test.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//webapp > hello.jsp와 세트

public class Hello extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//비즈니스 코드 작성
		
		//서블릿 업무 종료 > JSP 호출하기
		//	- 서블릿 > (이동) > JSP
		//1. resonse.sendRedirect()
		//2. pageContext.forward()
		
		//경로 잘 잡기!!
		// 처음에 / 적기 > webbapp 폴더를 가리킨다.
		// /mvc/hello.jsp 보통은 이렇게 적는데 sendRedirect의 경우에는 루트 폴더(jsp)를 적어준다.
		resp.sendRedirect("/jsp/mvc/hello.jsp");
		
	}

}
