package com.test.toy.board;

import java.io.IOException;
import java.util.HashMap;
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

@WebServlet("/board/board.do")
public class Board extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. DB 작업 > select
        //2. 결과 반환
        
        HttpSession session = req.getSession();
        
        //읽음 제어
        session.setAttribute("read", "n");

        
        //2가지 용도로 호출
        //1. 일반 목록 보기 > board.do
        //2. 검색 결과 보기 > board.do?column=subject&word=test
        
        String column = req.getParameter("column");
        String word = req.getParameter("word");
        String search = "n"; //검색중(O,X)r
        
        HashMap<String, String> map = new HashMap<String, String>();
        
        if (column != null && word != null) {
            search = "y";
        }
        
        map.put("column", column);
        map.put("word", word);
        map.put("search", search);
        
        
        BoardDAO dao = new BoardDAO();
        
        List<BoardDTO> list = dao.list(map);
        
        //데이터 조작
        for (BoardDTO dto : list) {
            
            //날짜 자르기(기준: 당일)
            // - 년월일
            // - 시분초
            //dto.setRegdate(dto.getRegdate().substring(0, 10));
            
            //태그 이스케이프
            String subject = dto.getSubject();
            
            subject = subject.replace("<", "&lt;").replace(">", "&gt;");
            dto.setSubject(subject);
            
        }
        
        req.setAttribute("list", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/board.jsp");
        dispatcher.forward(req, resp);

    }

}
