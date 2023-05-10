<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    <h1>시작 페이지</h1>
    
    <div>
    
    	<% if (session.getAttribute("id") == null) { %>
        <a href="login.jsp">로그인</a>
        <% } else { %>
        <a href="logout.jsp">로그아웃</a>
        
        <div class="panel">
        	<div>아이디: <%= session.getAttribute("id") %></div>
        	<div>이름: <%= session.getAttribute("name") %></div>
        	<div>등급: <%= session.getAttribute("lv").toString().equals("1") ? "일반회원" : "관리자" %></div>
        </div>        
        
        <% } %>
        
        <hr>
        
        <!-- 노출 제어 -->
        <% if (session.getAttribute("id") != null) { %>
        <a href="member.jsp">회원 전용 페이지</a>
        <% } %>
        
        <!-- 행동 제어 -->
        <% if (session.getAttribute("id") != null) { %>
        <a href="member.jsp">회원 전용 페이지</a>        
        <% } else { %>
        <a href="#!" onclick="alert('회원 전용 페이지입니다.\n 로그인하세요.'); location.href='login.jsp';" >회원 전용 페이지</a> <!-- 눌러도 아무런 이동x일 때 #! -->
        <% } %>
        
        
        
        
    </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
