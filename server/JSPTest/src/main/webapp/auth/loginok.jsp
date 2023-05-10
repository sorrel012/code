<%@page import="com.test.my.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%
    /* 
	    1. 데이터 가져오기(id,pw)
	    2. DB 작업 > select
	    3. 확인 결과
	      3.1 확인O
	        - 인증 티켓 발급(★★★★★) > 세션 or 쿠키
	          - 개인적(다른 유저의 티켓과는 독립적으로 관리가 가능)
	          - 이동 자유(a.jsp > b.jsp)
	      3.2 확인X > 내보내기
     */
     
     
     //1.
     String id = request.getParameter("id");
     String pw = request.getParameter("pw");
     
     //2.
     Connection con = null;
     PreparedStatement pstat = null;
     ResultSet rs = null;
    
     con = DBUtil.open();
     
     //로그인 SQL
     String sql = "select * from tblUser where id= ? and pw = ?";
     
     pstat = con.prepareStatement(sql);
     
     pstat.setString(1, id);
     pstat.setString(2, pw);
     
     rs = pstat.executeQuery();
     
     if(rs.next()) {
         //로그인 성공
         //인증 티켓 발급
         //session.setAttribute("num", 100); 
         session.setAttribute("id", id); //여기에서만!!!
         
         //로그인한 회원의 부가 정보
         session.setAttribute("name", rs.getString("name"));
         session.setAttribute("lv", rs.getString("lv"));
         
     } else {
    	 //로그인 실패
         
     }
     
     rs.close();
     pstat.close();
     con.close();
    
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

    <h1>로그인</h1>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	<% if (session.getAttribute("id") != null ) { %>
		location.href = 'index.jsp';
		
	<% } else { %>
	
		alert('로그인 실패');
		history.back();
		
	<% } %>

</script>
</body>
</html>
