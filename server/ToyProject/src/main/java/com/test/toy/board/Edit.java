package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.toy.board.repository.BoardDAO;
import com.test.toy.board.repository.BoardDTO;

@WebServlet("/board/edit.do")
public class Edit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 데이터 가져오기(글번호)
        //2. DB 작업 > select
        //3. 결과 > JSP 호출
        
        String seq = req.getParameter("seq");
        
        BoardDAO dao = new BoardDAO();
        BoardDTO dto = dao.get(seq);
        
        req.setAttribute("dto", dto);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
        dispatcher.forward(req, resp);

    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //EditOk.java
        //1. 데이터 가져오기(수정할 값)
        //2. DB 작업 > update
        //3. 결과
        
        String seq = req.getParameter("seq");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        
        BoardDAO dao = new BoardDAO();
        
        BoardDTO dto = new BoardDTO();
        dto.setSeq(seq);
        dto.setSubject(subject);
        dto.setContent(content);
        
        int result = dao.edit(dto);
        
        if (result == 1) {
            resp.sendRedirect("/toy/board/view.do?seq=" + seq);
        } else {
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed');history.back();</script>");
            writer.close();
        }
        
    }

}
