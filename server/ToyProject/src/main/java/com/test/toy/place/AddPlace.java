package com.test.toy.place;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.toy.place.repository.PlaceDAO;
import com.test.toy.place.repository.PlaceDTO;

@WebServlet("/place/addplace.do")
public class AddPlace extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/place/addplace.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 try {
	            
	            MultipartRequest multi = new MultipartRequest(
	                                        
	                                        req,
	                                        req.getRealPath("/asset/place"),
	                                        1024 * 1024 * 10,
	                                        "UTF-8",
	                                        new DefaultFileRenamePolicy()
	                    
	                                    );
	            
	            //System.out.println(req.getRealPath("/asset/place"));
	            //C:\OneDrive\class\code\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ToyProject\asset\place
	            
	            HttpSession session = req.getSession();
	            
	            String name = multi.getParameter("name");
	            String content = multi.getParameter("content");
	            String pic = multi.getFilesystemName("pic");
	            
	            PlaceDAO dao = new PlaceDAO();
	            PlaceDTO dto = new PlaceDTO();
	            
	            dto.setName(name);
	            dto.setContent(content);
	            dto.setPic(pic);
	            dto.setId((String)session.getAttribute("id"));
	            
	            int result = dao.addPlace(dto);
	            
	            if (result == 1) {
	                resp.sendRedirect("/toy/place/place.do");
	            } else {
	                PrintWriter writer = resp.getWriter();
	                writer.print("<script>alert('failed');history.back();</script>");
	                writer.close();
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
		
	}

}
