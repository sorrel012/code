package com.test.toy.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.repository.BoardDAO;
import com.test.toy.board.repository.BoardDTO;
import com.test.toy.board.repository.CommentDTO;

@WebServlet("/board/view.do")
public class View extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 데이터 가져오기(seq)
        //2. DB 작업 > select
        //3. 결과 > JSP 호출하기
        
        HttpSession session = req.getSession();
                
        
        //요청 헤더 > referer > 이전 페이지 주소
        //String referer = req.getHeader("referer");
        //System.out.println(referer);
        
        String seq = req.getParameter("seq");
        
        BoardDAO dao = new BoardDAO();
        
        //조회수(읽음) 증가
        if(session.getAttribute("read") == null
                || session.getAttribute("read").toString().equals("n")) {
            dao.updateReadcount(seq);
            session.setAttribute("read", "y");
        }
        
        BoardDTO dto = dao.get(seq);
        
        String content = dto.getContent();
        String subject = dto.getSubject();
        
        // <> 처리
        content = content.replace("<", "&lt;").replace(">", "&gt;");
        subject = subject.replace("<", "&lt;").replace(">", "&gt;");
        
        //글 내용 개행 문자 처리
        content = content.replace("\r\n", "<br>");
        
        
        dto.setContent(content);
        dto.setSubject(subject);
        
        
        
        //댓글 목록 가져오기
        List<CommentDTO> clist = dao.clist(seq);
        
        
        req.setAttribute("dto", dto);
        req.setAttribute("clist", clist);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/view.jsp");
        dispatcher.forward(req, resp);

    }

}
