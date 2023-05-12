package com.test.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/multifileok.do")
public class MultiFileOk extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        
        List<String> olist = new ArrayList<String>();
        List<String> flist = new ArrayList<String>();

        try {

            MultipartRequest multi = new MultipartRequest(
                                        req,
                                        req.getRealPath("/files"),
                                        1024 * 1024 * 100,
                                        "UTF-8",
                                        new DefaultFileRenamePolicy()
                                     );


//            System.out.println(req.getRealPath("/files"));

            //<input type="file" name="attach"
            //String orgfilename = multi.getOriginalFileName("attach");
           // String filename = multi.getFilesystemName("attach");
            
            
            Enumeration e = multi.getFileNames();
            
            while(e.hasMoreElements()) {
                //System.out.println(e.nextElement());
                
                String file = e.nextElement().toString();
                
                String orgfilename = multi.getOriginalFileName(file);
                String filename = multi.getFilesystemName(file);
                
                //System.out.println(orgfilename);
                //System.out.println(filename);
                
                olist.add(orgfilename);
                flist.add(filename);
                
                req.setAttribute("olist", olist);
                req.setAttribute("flist", flist);
                
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/multifileok.jsp");
        dispatcher.forward(req, resp);

    }

}
