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

@WebServlet("/addok.do")
public class AddOk extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 파일 업로드 처리
        //2. DB 처리
        
        String name = "";
        String filename = "";
        
        //1. 파일 업로드 처리
        try {
            
            MultipartRequest multi = new MultipartRequest(
                                        req,
                                        req.getRealPath("/files"),
                                        1024 * 1024 * 100,
                                        "UTF-8",
                                        new DefaultFileRenamePolicy()
                                    );
            //System.out.println(req.getRealPath("/files"));
            
            filename = multi.getFilesystemName("attach");
            name = multi.getParameter("name");
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //2. DB처리
        
        FileDAO dao = new FileDAO();
        FileDTO dto = new FileDTO();
        
        dto.setName(name);
        dto.setFilename(filename);
        
        int result = dao.add(dto); //성공(1), 실패(0)
        
        req.setAttribute("result", result);
        

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/addok.jsp");
        dispatcher.forward(req, resp);

    }

}
