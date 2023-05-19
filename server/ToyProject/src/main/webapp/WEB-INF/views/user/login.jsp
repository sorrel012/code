<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	#login { width: 350px; }
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>	

	<main id="main">
		<h1>회원 <small>로그인</small></h1>
		
		<form method="POST" action="/toy/user/login.do">
		<table id="login" class="vertical">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id" required class="short"></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="pw" id="pw" required class="short"></td>
			</tr>			
		</table>
		<div>
			<button type="button" class="back" onclick="location.href='/toy/index.do';">돌아가기</button>
			<button type="submit" class="login primary">로그인</button>
		</div>
		</form>
		
		<hr>
		
		<div style="display: flex; justify-content: space-around;">
		<form method="POST" action="/toy/user/login.do">
			<input type="hidden" name="id" value="hong">
			<input type="hidden" name="pw" value="1111">
			<input type="submit" value="홍길동(hong)">
		</form>
		
		<form method="POST" action="/toy/user/login.do">
			<input type="hidden" name="id" value="sorrel012">
			<input type="hidden" name="pw" value="1234">
			<input type="submit" value="한효원(sorrel012)">
		</form>
		
		<form method="POST" action="/toy/user/login.do">
			<input type="hidden" name="id" value="haerin77">
			<input type="hidden" name="pw" value="1234">
			<input type="submit" value="강해린(haerin77)">
		</form>
		
		<form method="POST" action="/toy/user/login.do">
			<input type="hidden" name="id" value="admin">
			<input type="hidden" name="pw" value="1111">
			<input type="submit" value="관리자(admin)">
		</form>
		</div>
	</main>
	
</body>

<script>

</script>
</html>
