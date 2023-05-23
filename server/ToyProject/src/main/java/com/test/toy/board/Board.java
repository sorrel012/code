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

        test(req, resp);

    }
    
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	test(req, resp);
    	
    }
    
    

	private void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. DB 작업 > select
        //2. 결과 반환
        
        HttpSession session = req.getSession();
        
        //읽음 제어
        session.setAttribute("read", "n");
        
        //?page=5 > null
        //?page=5&column=&word=	> ""
        //?page=5&column=subject&word=자바	> "subject"
        
        
        String page = req.getParameter("page");

        //페이징
        int nowPage = 0;	//현재 페이지 번호
        int totalCount = 0;	//총 게시물 수
        int pageSize = 10;	//한 페이지에 출력할 게시물 수
        int totalPage = 0;	//총 페이지 수
        int begin = 0;
        int end = 0;
        int n = 0;
        int loop = 0;
        int blockSize = 10; //한번에 보여질 페이지 개수

        
        //board.do
        //voard.do?page=1
        
        if(page == null || page == "") {
        	nowPage = 1;
        } else {
        	nowPage = Integer.parseInt(page);
        }
        
        //nowPage > 현재 보려는 페이지 번호
        
        begin = ((nowPage - 1) * pageSize) + 1;
        end = begin + pageSize - 1;
        
        
        //2가지 용도로 호출
        //1. 일반 목록 보기 > board.do
        //2. 검색 결과 보기 > board.do?column=subject&word=test
        
        String column = req.getParameter("column");
        String word = req.getParameter("word");
        String search = "n"; //검색중(O,X)r
        
        HashMap<String, String> map = new HashMap<String, String>();
        
        if ((column == null && word == null)
                || (column.endsWith("") && word.equals(""))) {
            search = "n";
         } else {
            search = "y";
         }
        
        map.put("column", column);
        map.put("word", word);
        map.put("search", search);
        
        map.put("begin", begin + "");
        map.put("end", end + "");
        
        
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
            
            //제목 검색 중이면 검색어를 강조
            if(search.equals("y") && column.equals("subject")) {
            	
            	//검색어에 <span>태그 붙이기
            	// 새글입니다
            	// <span style="background-color:yellow;color:red;">새글</span>입니다.
            	subject = subject.replace(word, "<span style=\"background-color:yellow;color:tomato;\">" + word + "</span>");
            	
            }
            
            
            dto.setSubject(subject);
            
        }
        
        
        //총 게시물
        //총 페이지
        totalCount = dao.getTotalCount(map);
        totalPage = (int)Math.ceil((double)totalCount / pageSize);
        
        
        StringBuilder sb = new StringBuilder();
        
        /*
        for(int i=1; i<=totalPage; i++) {
        	
        	if( i == nowPage) {
        		sb.append(String.format(" <a href=\"#!\" style='color:tomato;'>%d</a> ", i));
        	} else {
        		sb.append(String.format(" <a href=\"/toy/board/board.do?page=%d\">%d</a> ", i, i));
        	}
        }
        */
        
        
        //board.do?page=1
        //1 2 3 4 5 6 7 8 9 10
        
        //board.do?page=5
        //1 2 3 4 5 6 7 8 9 10
                
        //board.do?page=11
        //11 12 13 14 15 16 17 18 19 20
        
        loop = 1; //루프 변수(10바퀴)
        n = ((nowPage - 1) / blockSize) * blockSize + 1; //페이지 번호
        
        
        //이번 10페이지
        if (n == 1) {
        	sb.append(String.format("<a href=\"#!\">[이전 %d페이지]</a>", blockSize));
        } else {
        	sb.append(String.format("<a href=\"/toy/board/board.do?page=%d\">[이전 %d페이지]</a>", n-1, blockSize));
        }
        
        
        while(!(loop > blockSize || n > totalPage)) {
        	
        	if(n == nowPage) {
        		sb.append(String.format(" <a href=\"#!\" style='color:tomato;'>%d</a> ", n));
        	} else {
        		sb.append(String.format(" <a href=\"/toy/board/board.do?page=%d\">%d</a> ", n, n));
        	}
        	
        	loop++;
        	n++;
        }
        
        
        //다음 10페이지
        if(n > totalPage) {
        	sb.append(String.format("<a href=\"#!\">[다음 %d페이지]</a>", blockSize));
        } else {
        	sb.append(String.format("<a href=\"/toy/board/board.do?page=%d\">[다음 %d페이지]</a>", n, blockSize));
        }
        
        
        req.setAttribute("list", list);
        req.setAttribute("map", map);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("nowPage", nowPage);
        req.setAttribute("pagination", sb);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/board.jsp");
        dispatcher.forward(req, resp);
	}

}
