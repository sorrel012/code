<%@page import="com.test.my.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

    //1. 데이터 가져오기(edit.jsp?seq=10)
    //2. DB 작업 > select .. where seq = 10
    //3. 결과 > 컨트롤 입력
    
    //1.
    String seq = request.getParameter("seq");
    
    //2.
    Connection con = null;
    PreparedStatement pstat = null;
    ResultSet rs = null;
    
    con = DBUtil.open();
    
    String sql = "select * from tblAddress where seq = ?";
    
    pstat = con.prepareStatement(sql);
    
    pstat.setString(1, seq);
    
    rs = pstat.executeQuery();
    
    String name = "";
    String age = "";
    String tel = "";
    String address = "";
    
    if(rs.next()) {
        name = rs.getString("name");
        age = rs.getString("age");
        tel = rs.getString("tel");
        address = rs.getString("address");
    }
    
    rs.next();
    
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
        
        <h3>수정하기</h3>

        <form method="POST" action="editok.jsp">

            <table class="vertical">
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="name" required class="short"
                        autocomplete="off" value="<%= name %>"></td>
                </tr>
                <tr>
                    <th>나이</th>
                    <td><input type="number" name="age" required class="short"
                        autocomplete="off" min="1" max="150"></td>
                </tr>
                <tr>
                    <th>전화</th>
                    <td><input type="tel" name="tel" required></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td><input type="text" name="address" required class="long"
                        autocomplete="off"></td>
                </tr>
            </table>

            <div>
                <button type="button" onclick="location.href='list.jsp';">
                    <span class="material-symbols-outlined">list</span> 목록보기
                </button>
                <button type="submit">
                    <span class="material-symbols-outlined">edit_square</span> 수정하기
                </button>
            </div>
            
            <input type="hidden" name="seq" value="<%=seq %>">

        </form>
        
    </div>

<script>

    $('input[name=age]').val("<%= age %>");
    $('input[name=tel]').val("<%= tel %>");
    $('input[name=address]').val("<%= address %>");

</script>
</body>
</html>
