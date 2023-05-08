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
       String name = request.getParameter("name");
       
   %>
   
   <div>결과: <%= name %></div>
    
</body>
</html>