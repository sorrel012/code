package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex07data.do")
public class Ex07Data extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type = req.getParameter("type");
        
        if(type.equals("1")) {
            m1(req, resp);
        } else if(type.equals("2")) {
            m2(req, resp);
        } else if(type.equals("3")) {
            m3(req, resp);
        }

    }

    private void m1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        AjaxDAO dao = new AjaxDAO();
        
        int count = dao.count();
        
        
        //서버가 브라우저(Ajax)에게 건내는 데이터가 이런 형식이다~ 알려주는 작업
        resp.setContentType("text/plain"); //텍스트 형식
        resp.setCharacterEncoding("UTF-8");
        
        
        PrintWriter writer = resp.getWriter();
        
        writer.print(count + "");
        writer.close();
        
    }
    
    private void m2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        AjaxDAO dao = new AjaxDAO();
        
        List<AddressDTO> list = dao.listAddress();
        
        //CSV
        String tmp = "";
        
        for (AddressDTO dto : list) {
            tmp += String.format("%s,%s,%s,%s,%s\r\n"
                                    , dto.getSeq()
                                    , dto.getName()
                                    , dto.getAge()
                                    , dto.getTel()
                                    , dto.getAddress());
        }
        
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = resp.getWriter();
        
        writer.print(tmp);
        
        writer.close();
        
    }
    
    private void m3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
    }

}

