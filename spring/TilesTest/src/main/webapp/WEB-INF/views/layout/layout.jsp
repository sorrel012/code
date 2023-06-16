<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layout.jsp</title>
<tiles:insertAttribute name="asset" />
<style>

</style>
</head>
<body>

	<header>
		<h1>Tiles</h1>
		<tiles:insertAttribute name="main_menu" />
		<tiles:insertAttribute name="sub_menu" />
	</header>
	
	<tiles:insertAttribute name="content" />
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






