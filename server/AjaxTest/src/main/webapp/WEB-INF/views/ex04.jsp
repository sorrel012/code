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
<body>

	<h1>Ajax</h1>
	
	<div>
		<input type="text" id="txt1" class="short">
		<input type="button" value="버튼" id="btn1">
		<div id="div1"></div>
	</div>
	
	<hr>
	
	<div>
		다른 작업: <input type="text">
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	/* Ajax 구현 */
	
	const txt1 = document.getElementById('txt1');
	const btn1 = document.getElementById('btn1');
	const div1 = document.getElementById('div1');
	
	btn1.addEventListener('click', function() {
	    
	    //요청 > 서버로부터 데이터를 받아오기
	    
	    //Ajax 요청 
	    const ajax = new XMLHttpRequest(); // > ajax 객체 > 서버와 통신하는 도구(전화기보단 편지에 가깝..)
	    
	    ajax.onreadystatechange = function() {
	        
	    	/* 
	        console.log(ajax.readyState);
	        console.log(ajax.status);
	        console.log(' ')
	         */
	         
	        if (ajax.readyState == 4 && ajax.status == 200) {
	            //서버로부터 안전하게 데이터를 수신했다!!
	            div1.textContent = ajax.responseText;
	        } 
	         
	    };
	    
	    //<form method='GET' action='페이지'>
	    ajax.open('GET', '/ajax/ex04.txt'); //호출 X, 설정 O	    
	    ajax.send(); //실제 연결&호출 == submit
	    
	});

</script>
</body>
</html>
