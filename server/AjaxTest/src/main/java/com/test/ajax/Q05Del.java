package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/q05del.do")
public class Q05Del extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String seq = req.getParameter("seq");
        
        AjaxDAO dao = new AjaxDAO();
        int result = dao.delAddress(seq);
        
        JSONObject obj = new JSONObject();
        obj.put("result", result);
        
        resp.setContentType("application/json");
        
        PrintWriter writer = resp.getWriter();
        writer.print(obj);
        writer.close();

    }

}
