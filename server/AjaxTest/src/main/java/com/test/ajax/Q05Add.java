package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/q05add.do")
public class Q05Add extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String address = req.getParameter("address");

        AddressDTO dto = new AddressDTO();

        dto.setName(name);
        dto.setTel(tel);
        dto.setAddress(address);

        AjaxDAO dao = new AjaxDAO();

        int result = dao.addAddress(dto);

        String newSeq = dao.getAddress(); //방금 등록한 주소 가져오기

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        JSONObject obj = new JSONObject();
        obj.put("result", result);
        obj.put("seq", newSeq);

        writer.print(obj);

        writer.close();


    }

}
