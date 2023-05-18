package com.test.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/q04data.do")
public class Q04Data extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String id = req.getParameter("id");
        
        Q04DTO dto = new Q04DTO();
        
        dto.setX(x);
        dto.setY(y);
        dto.setId(id);
        
        AjaxDAO dao = new AjaxDAO();
        
        dao.setPosition(dto);

    }


}
