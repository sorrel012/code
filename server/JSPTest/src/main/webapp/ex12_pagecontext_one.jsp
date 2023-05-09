<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    /*  
    
        서버측 자원의 생명 주기
        - 서블릿 or JSP > 여러 가지 자원 > 언제 생성 ~ 소멸
        - 현재 JSP 페이지가 실행 중일 때 > JSP 페이지 처리 종료 > 자원 소멸
        
    */
    
    int a = 10;
        
    pageContext.setAttribute("b", 20); //pageContext 변수
    request.setAttribute("c", 30); //request 변수
    
    //링크, response.sendRedirect
    //    - 클라이언트측 이동 
    
    //pageContext
    //    - 서버측 이동
    
    /* response.sendRedirect("ex12_pagecontext_two.jsp"); */ //http://localhost:8090/jsp/ex12_pagecontext_two.jsp
    pageContext.forward("ex12_pagecontext_two.jsp"); //http://localhost:8090/jsp/ex12_pagecontext_one.jsp
        
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
    
    <div>a: <%= a %></div>
    
    <div>b: <%= pageContext.getAttribute("b") %></div>
    
    <div>c: <%= request.getAttribute("c") %></div>    
    
    <a href="ex12_pagecontext_two.jsp?a=<%= a %>">두 번째 페이지로 이동하기</a>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
