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

	<h1>결과</h1>
	
	<div class="message" title="데이터">
		${data}
	</div>


	<h1>결과</h1>
	
	<div class="message" title="DTO">
		<div>${dto.name}</div>
		<div>${dto.age}</div>
		<div>${dto.address}</div>
	</div>
	
	
	<h1>결과</h1>
	
	<div class="list">
		<c:forEach items="${cb}" var="item">
			<div>${item}</div>
		</c:forEach>
	</div>
	
	<div class="list">
		<c:forEach items="${dto}" var="item">
			<div>${item}</div>
		</c:forEach>
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>