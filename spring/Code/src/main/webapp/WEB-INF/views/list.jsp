<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
	.main {
		display: grid;
		grid-template-columns: 1fr 1fr 1fr;
	}
	
	.item {
		width: 235px;
		border: 1px solid #AAA;
		margin: 10px;
		cursor: pointer;
	}
	
	.item > div:nth-child(1) {
		padding: .5rem;
		
	}
	
	.item > div:nth-child(2) {
		min-height: 150px;
		display: flex;
		justify-content: center;
		align-items: center;
		border-top: 1px solid #AAA;
		border-bottom: 1px solid #AAA;
	}
	
	.item > div:nth-child(3) {
		padding: .5rem;
		font-size: 14px;
		text-align: right;
	}

</style>
</head>
<body>

	<h1>Code <small>목록보기</small></h1>
	
	<div class="main">
		<c:forEach items="${list}" var="dto">
		<div class="item" onclick="location.href='/view.do?seq=${dto.seq}';">
		
			<c:choose>
				<c:when test="${dto.language =='java'}">
					<c:set var="color" value="tomato"/>
				</c:when>
				<c:when test="${dto.language =='sql'}">
					<c:set var="color" value="gold"/>
				</c:when>
				<c:when test="${dto.language =='html'}">
					<c:set var="color" value="cornflowerblue"/>
				</c:when>
			</c:choose>
			<div style="background-color:${color}">${dto.language}</div>
			<div>${dto.subject}</div>
			<div>${dto.regdate}</div>
		</div>
		</c:forEach>
	</div>
		
	<div>
		<button type="button" class="add" onclick="location.href='/add.do';">추가하기</button>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>