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

	<h1>데이터 전송</h1>
	
	<form method="POST" action="/web/ex05ok.do">
		<div><input type="text" name="data"></div>
		<div><input type="submit" value="보내기"></div>
	</form>
	
	<h1>복합 데이터 전송</h1>
	<form method="POST" action="/web/ex05ok.do">
		<div><input type="text" name="name"></div>
		<div><input type="text" name="age"></div>
		<div><input type="text" name="address"></div>
		<div><input type="submit" value="보내기"></div>
		
		<input type="hidden" name="seq" value="10">
	</form>
	
	<h1>다중 데이터 전송</h1>
	
	<form method="POST" action="/web/ex05ok.do">
		<div><input type="checkbox" name="cb" value="1">사과</div>
		<div><input type="checkbox" name="cb" value="2">바나나</div>
		<div><input type="checkbox" name="cb" value="3">딸기</div>
		<div><input type="checkbox" name="cb" value="4">귤</div>
		<div><input type="checkbox" name="cb" value="5">포도</div>
		<div><input type="submit" value="보내기"></div>
	</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>