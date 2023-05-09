<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
   
       //클라이언트(브라우저)가 전송한 데이터를 수신하기(가져오기)
       
       //doGet(HttpServletRequest request, )
       
       //request 역할 2. POST 방식으로 전달된 데이터를 UTF-8 방식으로 인코딩 처리해라 
       request.setCharacterEncoding("UTF-8");
       
       String name = request.getParameter("name"); //request 역할 1.
       
   %>
   
   <div>결과: <%= name %></div>
    
</body>
</html>