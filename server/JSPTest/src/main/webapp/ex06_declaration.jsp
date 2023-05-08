<%@page import="com.test.jsp.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%
	    //자바 영역??
	    
	    //무슨 변수??
	    int a = 10;
        /* System.out.println(this.a); */
        /* 
	    public void test() {
	        
		} */
	    
	%>
	
	<%!
	
        //클래스 멤버 변수
	    int b = 20;
	    int a = 30;
	    
	    public int add(int x, int y) {
	        return x + y;
	    }
	
	%>
	
	결과: <%= add(100,200) %>
	
	<hr>
	
	결과: <%= Util.add(100,200) %>
    
    
</body>
</html>