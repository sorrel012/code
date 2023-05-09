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

    <h1>버튼 만들기</h1>
    
    <form method="POST" action="ex09ok.jsp">    
    
    <table>
        <tr>
            <th>너비(px)</th>
            <td><input type="number" min="20" max="300" step="10" name="width" value="100"></td>
        </tr>
        <tr>
            <th>높이(px)</th>
            <td><input type="number" min="10" max="200" step="10" name="height" value="50"></td>
        </tr>    
        <tr>
            <th>텍스트</th>
            <td><input type="text" name="txt"></td>
        </tr>    
        <tr>
            <th>개수</th>
            <td>
                <input type="number" name="ea" value="1" min="1" max="30">
            </td>
        </tr>    
        <tr>
            <th>배경색</th>
            <td><input type="color" name="color1"></td>
        </tr>    
        <tr>
            <th>글자색</th>
            <td><input type="color" name="color2"></td>
        </tr>    
        <tr>
            <th>글자 크기(px)</th>
            <td><input type="number" name="fontSize" value="16" min="10" max="100"></td>
        </tr>    
        <tr>
            <th>버튼 간격</th>
            <td>
                <div>좌우 간격: <input type="range" name="range1"></div>
                <div>상하 간격: <input type="range" name="range2"></div>
            </td>
        </tr>    
        <tr>
            <th>테두리</th>
            <td>
                <div>두께(px): <input type="number" name="borderWidth" value="1" min="0" max="10"></div>
                <div>색상: <input type="color" name="borderColor"></div>
                <div>스타일: 
	                <select name="sel">
                        <option value="solid">실선</option>
                        <option value="dashed">쇄선</option>
                        <option value="dotted">점선</option>
                    </select>
                </div>
                <div>모서리(px): <input type="number" name=radius value="0" min="0" max="50"></div>
            </td>
        </tr>    
    </table>
    
    <div>
        <input type="submit" value="만들기">
    </div>
    
    </form>
    

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
