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

</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>	

	<main id="main">
		<h1 class="page">장소 <small>등록하기</small></h1>
		
		<form method="POST" action="/toy/place/addplace.do" enctype="multipart/form-data">
		<table>
			<tr>
				<th>장소명</th>
				<td><input type="text" name="name" required class="full"></td>
			</tr>
			<tr>
				<th>설명</th>
				<td><textarea name="content" required class="full"></textarea></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="pic" required class="full"></td>
			</tr>			
		</table>
		<div>
			<button class="add primary"
				onclick="location.href='/toy/place/place.do';">돌아가기</button>
			<button type="submit" class="add primary">등록하기</button>
		</div>		
		
		</form>
		
	</main>
	
</body>

<script>

</script>
</html>
