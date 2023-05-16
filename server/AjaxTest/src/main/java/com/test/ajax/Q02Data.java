package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/q02data.do")
public class Q02Data extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dong = req.getParameter("dong");
        
        ZipcodeDAO dao = new ZipcodeDAO();
        
        List<ZipcodeDTO> address = dao.search(dong);
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = resp.getWriter();
        
        String tmp = "";
        
        tmp += "[";
        
        for (ZipcodeDTO dto : address) {
           tmp += "{";
           tmp += String.format("\"zip\": \"%s\",", dto.getZip());
           tmp += String.format("\"sido\": \"%s\",", dto.getSido());
           tmp += String.format("\"gugun\": \"%s\",", dto.getGugun());
           tmp += String.format("\"dong\": \"%s\"", dto.getDong());
           tmp += "}";
           tmp += ",";
        }
        
        tmp = tmp.substring(0, tmp.length()-1);
        
        tmp += "]";
        
        if(tmp.equals("]")) {
            tmp = "{\"none\":\"true\"}";
        }
        
        writer.write(tmp);
        
        writer.close();
    }

}

