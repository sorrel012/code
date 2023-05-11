<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("id") == null
			|| !session.getAttribute("lv").toString().equals("2")) {
		
		//미인증 유저 또는 일반회원		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script>alert('관리자만 접근이 가능합니다.'); location.href='index.jsp';</script>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>

	<h1>관리자 전용 페이지</h1>
	
	<p>관리자만 접근이 가능합니다.</p>
	<p>로그인한 사용자라도, 관리자 권한이 없으면 접근이 불가능합니다.</p>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
