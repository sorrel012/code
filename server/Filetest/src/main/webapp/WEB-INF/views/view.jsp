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

	img {
		display: block;
		margin: 20px auto;
		max-width: 700px;
	}
	
</style>
</head>
<body>

	<h1>Image Viewer</h1>
	
	<table>
		<tr>
			<td colspan="2"><img src="/file/files/${dto.filename}"></td>
		</tr>
		<tr>
			<td>${dto.name}</td>
			<td>${dto.regdate}</td>
		</tr>
	</table>

	<div>
		<input type="button" value="돌아가기" onclick="location.href='/file/list.do';">
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
