<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit.jsp</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Board <small>edit</small></h2>
	
	<form method="POST" action="/board/editok.do">
	<table class="vertical">
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" class="full" required value="${dto.subject}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" class="full" required>${dto.content}</textarea></td>
		</tr>
	</table>
	<div>
		<button type="button" class="back" onclick="location.href='/board/view.do?seq=${dto.seq}';">돌아가기</button>
		<button type="submit" class="edit">수정하기</button>
	</div>	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" name="id" value="<sec:authentication property="principal.username"/>">	
	<input type="hidden" name="seq" value="${dto.seq}">
	</form>	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>