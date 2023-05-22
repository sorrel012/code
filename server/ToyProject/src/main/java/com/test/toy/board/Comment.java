package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.toy.board.repository.BoardDAO;
import com.test.toy.board.repository.CommentDTO;

@WebServlet("/board/comment.do")
public class Comment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        
        String comment = req.getParameter("comment");
        String bseq = req.getParameter("bseq");
        
        BoardDAO dao = new BoardDAO();
        CommentDTO cdto = new CommentDTO();
        
        cdto.setContent(comment);
        cdto.setBseq(bseq);
        cdto.setId((String)session.getAttribute("id"));
        
        int result = dao.addComment(cdto);
        
        if (result == 1) {
            resp.sendRedirect("/toy/board/view.do?seq=" + bseq);
        } else {
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed)';history.back();</script>");
            writer.close();
        }
        
    }

}
