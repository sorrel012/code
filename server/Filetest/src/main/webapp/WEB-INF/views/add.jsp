<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Viewer</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>

	<h1>Image Viewer</h1>
	
	<form method="POST" action="/file/addok.do" enctype="multipart/form-data">
	<table>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="name" class="short" required autofocus></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input type="file" name="attach" required></td>
		</tr>		
	</table>
	
	<div>
		<input type="button" value="돌아가기" onclick="history.back();">
		<input type="submit" value="등록하기">
	</div>	
	</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
