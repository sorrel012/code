<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <h1>두 번째 페이지</h1>
    
    <%-- <div>a: <%= a %></div> --%>
    
    <div>a: <%= request.getParameter("a") %></div>    
    
    <div>b: <%= pageContext.getAttribute("b") %></div>
    
    <div>c: <%= request.getAttribute("c") %></div>    
    

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
