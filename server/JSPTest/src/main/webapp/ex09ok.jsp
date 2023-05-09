<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

    request.setCharacterEncoding("UTF-8");
    
    String width = request.getParameter("width");
    String height = request.getParameter("height");    
    String txt = request.getParameter("txt");    
    
    int ea = Integer.parseInt(request.getParameter("ea"));
    
    String color1 = request.getParameter("color1");
    String color2 = request.getParameter("color2");
    String fontSize = request.getParameter("fontSize");
    
    String range1 = request.getParameter("range1");
    String range2 = request.getParameter("range2");
    
    String borderWidth = request.getParameter("borderWidth");
    String borderColor = request.getParameter("borderColor");
    String sel = request.getParameter("sel");
    String radius = request.getParameter("radius");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
    #main .btn {
        width: <%= width %>px;
        height: <%= height %>px;
        background-color: <%= color1 %>;
        color: <%= color2 %>;
        font-size: <%= fontSize %>px;
        margin: <%= range1 %>px  <%= range2 %>px;
        border: <%= borderWidth %>px <%= sel %><%= borderColor %>;      
        border-radius: <%= radius %>px;
    }
</style>
</head>
<body id="main">

    <h1>결과</h1>
    
    <div class="panel full">
    <% for (int i=0; i<ea; i++) { %>
        <input type="button" class="btn" value="<%= txt %>">
    <% } %>
    </div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
