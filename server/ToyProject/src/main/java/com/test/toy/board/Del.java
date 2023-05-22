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

@WebServlet("/board/del.do")
public class Del extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(Auth.check(req, resp)) {
            return;
        }
        
        String seq = req.getParameter("seq");
        
        req.setAttribute("seq", seq);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/del.jsp");
        dispatcher.forward(req, resp);

    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String seq = req.getParameter("seq");
        
        BoardDAO dao = new BoardDAO();
        
        int result = dao.del(seq);
        
        if (result == 1) {
            resp.sendRedirect("/toy/board/board.do");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed)';history.back();</script>");
            writer.close();
        }
        
    }

}

