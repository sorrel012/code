package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 서블릿 클래스 선언
public class Ex02 extends HttpServlet{
    
    //2. doGet/doPost 메소드 선언
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        
        response.setCharacterEncoding("UTF-8");
        // 3. 동적 HTML 문서 작성
        PrintWriter writer = response.getWriter();
        
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset='UTF-8'>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>서블릿 페이지</h1>");
        writer.println("<p>서블릿을 사용해서 만들었습니다.</p>");
        writer.println("</body>");
        writer.println("</html>");
        
        writer.close();
        
        // Ctrl + F11
        // 자바 파일(class)은 웹(http://)에서 호출이 불가능하다.
        // 자바 파일을 브라우저를 통해 웹에서 호출할 수 있는 방법이 필요하다.
        // - 가상 주소
        
    }
    
}
