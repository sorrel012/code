package com.test.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delok.do")
public class DelOk extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 데이터 가져오기(seq)
        //2. 파일 삭제
        //3. DB작업 > DAO 위임 > delete
        
        String seq = req.getParameter("seq");
        
        FileDAO dao = new FileDAO();
        
        //사진 삭제할 떄는 DB 작업 전에 먼저 지우기!
        FileDTO dto = dao.get(seq);
        
        try {
            
            File file = new File(req.getRealPath("/files") + "\\" + dto.getFilename());
            file.delete();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int result = dao.remove(seq);
        
        
        req.setAttribute("result", result);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/delok.jsp");
        dispatcher.forward(req, resp);

    }

}
