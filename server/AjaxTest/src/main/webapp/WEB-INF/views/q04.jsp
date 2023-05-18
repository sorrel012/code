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
	#cat1 {
		position:absolute;
		left: 0px;
		top: 0px;
	}

</style>
</head>
<body>
	
	<img src="/ajax/images/catty18.png" id="cat1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="/ajax/js/jquery-ui.js"></script>
<script>


	$('#cat1').draggable(
	    
	    /*
	    $.ajax({
	    	type:'POST',
	    	url:'/ajax/q04data.do',
	    	dataType: 'json',
			data: {			    
			    x: x,
			    y: y,
			    id: 'cat'			    
			},
			error: (a,b,c)=>console.log(a,b,c)
		});*/
	    
	);
	
	//TODO draggable()에 ajax 넣지 말고 mouse로 별도로 뺴기
	
	//console.log($('#cat1').css('left'));

</script>
</body>
</html>
