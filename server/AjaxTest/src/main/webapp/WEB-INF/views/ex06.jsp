<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body class="narrow">

	<h1>Ajax <small>jQuery</small></h1>
	
	<div>
		<input type="text" id="txt1">
		<input type="button" value="확인" id="btn1">
		<div id="div1"></div>
		<div id="div1"></div>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>


	$('').click(() => {
	//$('#btn1').click(() => {
	   
	    //ajax.send(); > 바로 요청
	    $.ajax({
	        
	        //페이지 요청 정보
	        type: 'GET',
	        url: '/ajax/ex06data.do',
	        
	        //데이터 전송(QueryString) > GET, POST 둘다
	        data: 'txt1=' + $('#txt1').val(),
	        
	        //데이터 수신
	        success: function(result) {
	            $('#div1').text(result);
	        },
	        
	        //ajax 예외 처리
	        error: function(a,b,c) {
	            console.log(a,b,c)
	        }
	        
	    });
	    
	});
	
	
	$('#btn1').click(() => {
	    
	    //Ajax, 비동기(async)
	    
	    $.ajax({
	        type: 'GET',
	        url: '/ajax/ex06data.do',
	        async: true, //true: 비동기, false: 동기
	        success: function(result) {
	        	$('#div1').text(result);
	        },
	        error: function(a,b,c) {
	            console.log(a,b,c)
	        }
	    });
	    
	});
	
	

</script>
</body>
</html>
