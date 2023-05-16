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
	
	<h1>Ajax <small>응답 데이터 형식</small></h1>
	
	<div>
	
		<h2>Text</h2>
		<input type="button" value="확인" id="btn1">
		<div id="div1"></div>
		
		<hr>
	
		<h2>XML</h2>
		<input type="button" value="확인" id="btn2">
		<div id="div2"></div>
		
		<hr>
	
		<h2>JSON(***)</h2>
		<input type="button" value="확인" id="btn3">
		<div id="div3"></div>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	//$('#btn1').click(() => {
	$('').click(() => {
	    
	    $.ajax({
	       	type: 'GET',
	       	url: '/ajax/ex07data.do',
	       	data: 'type=1',
	       	dataType: 'text', //서버가 Ajax에게 돌려주는 데이터 형식(text, xml, json)
	       	success: (result) => {
	       	    $('#div1').text(result);
	       	},
	       	error: (a,b,c) => console.log(a,b,c)
	    });
	    
	});
	
	$('#btn1').click(() => {
	    
	    $.ajax({
	       	type: 'GET',
	       	url: '/ajax/ex07data.do',
	       	data: 'type=2',
	       	dataType: 'text', 
	       	success: (result) => {
	       	   
	       	    const lines = result.split('\r\n');
	       	    
	       	    lines.forEach(line => {
	       	    	const items = line.split(',');
	       	    	
	       	    	$('#div1').append(
	       	    		`
	       	    			<div>\${items[1]} - \${items[4]}</div>
	       	    	    `	       	    	        
	       	    	);
	       	    });
	       	    
	       	},
	       	error: (a,b,c) => console.log(a,b,c)
	    });
	    
	});

	$('#btn2').click(() => {
	    
	});

	$('#btn3').click(() => {
	    
	});

</script>
</body>
</html>
