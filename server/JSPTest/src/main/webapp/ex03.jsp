<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@page import="java.util.Calendar"%>
    
<% 

    Calendar now = Calendar.getInstance();
    
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <h1>현재 시각</h1>
    
    <p>오늘은 <%= String.format("%qtF", now) %>입니다.</p>
    <p>지금은 <%= String.format("%tT", now) %>입니다.</p>
    
    <%@ include file="inc/sub.jsp" %>
    
</body>
</html>