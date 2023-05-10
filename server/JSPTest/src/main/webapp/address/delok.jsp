<%@page import="com.test.my.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //1. 데이터 가져오기
    //2. DB 작업 > delete
    //3. 피드백
    
    //1.
    request.setCharacterEncoding("UTF-8");
    
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String tel = request.getParameter("tel");
    String address = request.getParameter("address");
    String seq = request.getParameter("seq");
    
    //2.
    Connection con = null;
    PreparedStatement pstat = null;
    
    con = DBUtil.open();
    
    String sql = "delete from tblAddress where seq = ?";
    
    pstat = con.prepareStatement(sql);
    
    pstat.setString(1, seq);
    
    int result = pstat.executeUpdate();
    
    pstat.close();
    con.close();
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address</title>
<%@ include file="inc/asset.jsp" %>
<style>

</style>
</head>
<body>

    <%@ include file="inc/header.jsp" %>
    
    <div>
    
    
        <%--
        <% if(result == 1) { %>
        <div>추가했습니다.</div>
        <div><a href="list.jsp">목록보기</a></div>
        <% } else { %>
        <div>실패했습니다.</div>
        <div><a href="add.jsp">돌아가기</a></div>
        <% } %>
        --%>        
         
    </div>

<script>

    <% if(result == 1) { %>
       //alert('추가했습니다.');
       location.href = 'list.jsp';
    <% } else { %>
       alert('실패했습니다.');
       history.back();
    <% } %>

</script>
</body>
</html>
