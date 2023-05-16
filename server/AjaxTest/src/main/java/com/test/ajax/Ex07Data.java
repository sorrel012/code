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
        } else if(type.equals("4")) {
            m4(req, resp);
        } else if(type.equals("5")) {
            m5(req, resp);
        } else if(type.equals("6")) {
            m6(req, resp);
        }

    }
    
    private void m6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        AjaxDAO dao = new AjaxDAO();
        
        List<AddressDTO> list = dao.listAddress();
        
        
        /*
        
        {
            "seq": "",
            "name": "",
            "age": "",
            "tel": "",
            "address": ""
        }
        ,
        {
            "seq": "",
            "name": "",
            "age": "",
            "tel": "",
            "address": ""
        }
        
         */
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = resp.getWriter();
        
        String tmp = "";
        
        tmp += "[";
        
        for (AddressDTO dto : list) {
           tmp += "{";
           tmp += String.format("\"seq\": \"%s\",", dto.getSeq());
           tmp += String.format("\"name\": \"%s\",", dto.getName());
           tmp += String.format("\"age\": %s,", dto.getAge());
           tmp += String.format("\"tel\": \"%s\",", dto.getTel());
           tmp += String.format("\"address\": \"%s\"", dto.getAddress());
           tmp += "}";
           tmp += ",";
        }
        
        tmp = tmp.substring(0, tmp.length()-1);
        
        tmp += "]";
        
        writer.write(tmp);
        
        writer.close();
        
    }
    
    private void m5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        AjaxDAO dao = new AjaxDAO();
        ResearchDTO dto = dao.getResearch(1);
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = resp.getWriter();
        writer.print("{");
        writer.printf("\"question\":\"%s\"", dto.getQuestion());
        writer.print("}");
        
        writer.close();
        
        
        
    }
    
    private void m4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        AjaxDAO dao = new AjaxDAO();
        
        List<AddressDTO> list = dao.listAddress();
        
        /*
        
            <?xml version='1.0' encoding='UTF-8'?>
            <list>
                <item>
                    <seq>1</seq>
                    <name>홍길동</name>
                    <age>20</age>
                    <tel></tel>
                    <address>서울시</address>
                </item>
            </list>
        
        */
        
        resp.setContentType("text/xml");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();
        
        writer.print("<?xml version='1.0' encoding='UTF-8' ?>");
        
        writer.print("<list>");
        
        for(AddressDTO dto : list) {
            writer.print("<item>");
                writer.printf("<seq>%s</seq>", dto.getSeq());
                writer.printf("<name>%s</name>", dto.getName());
                writer.printf("<age>%s</age>", dto.getAge());
                writer.printf("<tel>%s</tel>", dto.getTel());
                writer.printf("<address>%s</address>", dto.getAddress());
            writer.print("</item>");
        }
        
        writer.print("</list>");
        
        writer.close();
        
    }
    
    private void m3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        AjaxDAO dao = new AjaxDAO();
        
        ResearchDTO dto = dao.getResearch(1);
        
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/xml");
        
        PrintWriter writer = resp.getWriter();
        
        writer.print("<?xml version='1.0' encoding='UTF-8' ?>");
        writer.printf("<question id='q1'>%s</question>", dto.getQuestion());
        
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

}

