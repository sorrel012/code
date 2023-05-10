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
    
    <div style="background-color: white;">
        <a href="ex20_cookie_one.jsp">첫 번째 페이지></a>
        <a href="ex20_cookie_two.jsp">두 번째 페이지></a>
        <a href="ex20_cookie_three.jsp">세 번째 페이지></a>
    </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="js/cookie.js"></script>
<script>


    $('body').css('background-image', `url(images/\${getCookie('background')})`);

</script>
</body>
</html>
