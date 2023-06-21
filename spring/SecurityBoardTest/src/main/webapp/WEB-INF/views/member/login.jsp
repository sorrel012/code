<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Member <small>Login</small></h2>
	
	<form method="POST" action="/login">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="password" required></td>
			</tr>
		</table>
		<div>
			<button type="submit" class="in">로그인</button>
		</div>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
	</form>	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Member <small>Login</small></h2>
	
	<form method="POST" action="/login">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="password" required></td>
			</tr>
		</table>
		<div>
			<button type="submit" class="in">로그인</button>
		</div>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
	</form>	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
>>>>>>> branch 'main' of https://github.com/sorrel012/code
</html>