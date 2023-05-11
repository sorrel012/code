package com.test.file;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/filetestok.do")
public class FileTestOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//문자열 데이터 가져오기
		//첨부파일 가져오기
		
		//System.out.println("문자열: " + req.getParameter("txt"));
		
		//cos.jar
		//- Request > (교체) > MultipartRequest
		
		
		req.setCharacterEncoding("UTF-8");
		
		try {
			
//			System.out.println(req.getRealPath("/uploads"));
			
			//MultipartRequest 객체가 생성되는 순간 파일 업로드 완료!
			MultipartRequest multi = new MultipartRequest(
											req,
											req.getRealPath("/uploads"),
											1024 * 1024 * 100,
											"UTF-8",
											new DefaultFileRenamePolicy()
									);
			
			//데이터 가져오기
			String txt = multi.getParameter("txt");
			
			String orgfilename = multi.getOriginalFileName("attach"); //내가 올린 이름
			String filename = multi.getFilesystemName("attach");	  //시스템이 설정한 이름(중복 방지)
			
			req.setAttribute("txt", txt);
			req.setAttribute("orgfilename", orgfilename);
			req.setAttribute("filename", filename);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/file/filetestok.jsp");
		dispatcher.forward(req, resp);

	}

}

