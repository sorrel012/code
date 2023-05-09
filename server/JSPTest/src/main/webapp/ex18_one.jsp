<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

    //상태 유지를 하고 싶다!!
    // one.jsp -> (이동) -> two.jsp
    
    //1. 지역변수
    int a = 10;
    
    //3. pageContext
    pageContext.setAttribute("c", 30);
    
    //4. request
    request.setAttribute("d", 40);
    
    //5. session
    session.setAttribute("e", 50);
    
    //6. application
    application.setAttribute("f", 60);
    
    pageContext.forward("ex18_two.jsp");
%>
<%!
    //2. 멤버 변수
    int b = 20;
%>
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

    <h1>첫 번째 페이지</h1>
    
    <a href="ex18_two.jsp">이동하기</a>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
