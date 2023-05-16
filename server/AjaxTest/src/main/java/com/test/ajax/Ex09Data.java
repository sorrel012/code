package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex09data.do")
public class Ex09Data extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dong = req.getParameter("dong");
        
        AjaxDAO dao = new AjaxDAO();
        
        List<ZipCode> list = dao.search(dong);
        
        /*
            [
                "",
                "",
                "",
                "",
                "",
            ]
        */
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = resp.getWriter();
        
        String tmp = "[";
        
        for(ZipCode dto : list) {
            
            tmp += String.format("\"[%s] %s %s %s\","
                                    , dto.getZip()
                                    , dto.getSido()
                                    , dto.getGugun()
                                    , dto.getDong());
            
        }
        
        tmp = tmp.substring(0, tmp.length()-1);
        
        tmp += "]";
        
        writer.write(tmp);
        
        writer.close();

    }

}
