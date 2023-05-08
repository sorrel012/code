<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

    String name = "홍길동";
    int age = 20;
    String color = "orange";
    String txt = "<input type='text'>";
    String attr = "background-color";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    div {
        color: <%= color %>;
        <%= attr %>: beige;
    }
    
</style>
</head>
<body>

    <%
    
        //자바 영역
        int a = 10;
        int b = 20;
        int c = a + b;
        
        String str = name;
    
    %>
    
    <div><%= a %> + <%= b %> = <%= c %></div>

    <div><%= name %></div>
    
    <input type="text" value="<%= age %>">
    
    <hr>
    
    <%= txt %>
    
    <input type="button" value="확인" id="btn1" style="color:<%= color %>">
    
    <script>
    
        document.getElementById('btn1').onclick = function() {
            //alert(<%= age %>);
            alert('<%= name %>');
        };
    
    </script>
    
</body>
</html>