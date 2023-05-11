package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//webapp > hello.jsp와 세트

//Controller > 컨트롤러
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
//		resp.sendRedirect("/jsp/mvc/hello.jsp");
		
		int count = 10; //DB 작업 결과물
		
		req.setAttribute("count", count); // req : 데이터를 전송하는 역할 > Model > 모델
		//session이나 application으로 해도 되지만 그렇게는 안 함(오래 보관하고 있을 필요가 없음)

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/mvc/hello.jsp");

		//pageContext.forward() 역할
		dispatcher.forward(req, resp);
		
	}

}
