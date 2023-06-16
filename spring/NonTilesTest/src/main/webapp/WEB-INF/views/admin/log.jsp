<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>log.jsp</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	
	<header>
		<h1>Tiles</h1>
		<%@include file="/WEB-INF/views/inc/main_menu.jsp" %>
		<%@include file="/WEB-INF/views/inc/admin_menu.jsp" %>
	</header>
	
	<h1>관리자 <small>로그</small></h1>
	
	<pre style="padding:1rem; white-space: pre-wrap">
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping - Mapped "{[/member/history.do],methods=[GET]}" onto public java.lang.String com.test.controller.MemberController.history()
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping - Mapped "{[/member/favorite.do],methods=[GET]}" onto public java.lang.String com.test.controller.MemberController.favorite()
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter - Looking for @ControllerAdvice: WebApplicationContext for namespace 'appServlet-servlet': startup date [Fri Jun 16 15:42:14 KST 2023]; parent: Root WebApplicationContext
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter - Looking for @ControllerAdvice: WebApplicationContext for namespace 'appServlet-servlet': startup date [Fri Jun 16 15:42:14 KST 2023]; parent: Root WebApplicationContext
INFO : org.springframework.web.servlet.handler.SimpleUrlHandlerMapping - Mapped URL path [/resources/**] onto handler 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0'
INFO : org.springframework.web.servlet.DispatcherServlet - FrameworkServlet 'appServlet': initialization completed in 1137 ms
	</pre>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
