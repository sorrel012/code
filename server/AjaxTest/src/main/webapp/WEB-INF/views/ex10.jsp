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
	
	<form id="form1">
		<div>
			<input type="text" name="txt1" id="txt1" value="강아지">
		</div>
		<div>
			<input type="text" name="txt2" id="txt2" value="고양이">
		</div>
		<div>
			<input type="text" name="txt3" id="txt3" value="토끼">
		</div>
		<div>
			<input type="text" name="txt4" id="txt4" value="사자">
		</div>
		<div>
			<input type="text" name="txt5" id="txt5" value="호랑이">
		</div>
		<div>
			<input type="submit" value="보내기" id="btn1">
		</div>
	</form>
	
	<hr>
	
	<div>
		<input type="button" value="가져오기" id="btn2">
	</div>
	<div id="result" class="panel" title="result"></div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	/*
		복붙용 폼
	
		$('#form1').submit(()=>{
	    
		    $.ajax({
		    	type: 'GET',
		    	url: '/ajax/ex10data.do',
		    	data: '',
		    	success: (result)=>{},
		    	error: (a,b,c)=>console.log(a,b,c)
		    });
		    
		    event.preventDefault();
		    return false;
	    
		});
	*/
	
	
	/*
	$('#form1').submit(()=>{
	    
	    //쿼리 스트링 전송
	    let data = 'txt1=' + $('#txt1').val() 
	    		+ '&txt2=' + $('#txt2').val()
	    		+ '&txt3=' + $('#txt3').val()
	    		+ '&txt4=' + $('#txt4').val()
	    		+ '&txt5=' + $('#txt5').val();
	    
	    $.ajax({
	    	type: 'GET',
	    	url: '/ajax/ex10data.do',
	    	data: data,
	    	success: (result)=>{},//보내기만 할 거라 사실상 필요 없음
	    	error: (a,b,c)=>console.log(a,b,c)
	        
	    });
	    
	    
	    event.preventDefault();
	    return false;
	    
	})
	*/
	
	
	/*
	$('#form1').submit(()=>{
	    
	    //객체 전송
	    const obj = {
	        txt1: $('#txt1').val(),
	        txt2: $('#txt2').val(),
	        txt3: $('#txt3').val(),
	        txt4: $('#txt4').val(),
	        txt5: $('#txt5').val()
	    };
	    
	    $.ajax({
	    	type: 'GET',
	    	url: '/ajax/ex10data.do',
	    	data: obj,
	    	success: (result)=>{},
	    	error: (a,b,c)=>console.log(a,b,c)
	    });
	    
	    event.preventDefault();
	    return false;
	    
	});
	*/
	
	
	/*
	$('#form1').submit(()=>{
	    
	    //객체를 data에 바로 전송	    
	    $.ajax({
	    	type: 'GET',
	    	url: '/ajax/ex10data.do',
	    	data: {
		        txt1: $('#txt1').val(),
		        txt2: $('#txt2').val(),
		        txt3: $('#txt3').val(),
		        txt4: $('#txt4').val(),
		        txt5: $('#txt5').val()
		    },
	    	success: (result)=>{},
	    	error: (a,b,c)=>console.log(a,b,c)
	    });
	    
	    event.preventDefault();
	    return false;
	    
	});
	*/
	
	
	/*
	$('#form1').submit(()=>{
		
	    //쿼리 스트링 더 간편하게 전송(input 태그의 name이 꼭 있어야 함)
	    //alert($('#form1').serialize());
	    
	    $.ajax({
	    	type: 'GET',
	    	url: '/ajax/ex10data.do',
	    	data: $('#form1').serialize(),
	    	success: (result)=>{},
	    	error: (a,b,c)=>console.log(a,b,c)
	    });
	    
	    event.preventDefault();
	    return false;
	    
	});
	
	
	
	//1. Object	> 권장
	//2. QueryString > serialize()
	
	
	/*
	$('#form1').submit(()=>{
		
	    //배열 전송
		const list = ['사과', '바나나', '딸기', '포도', '귤'];
		
	    $.ajax({
	    	type: 'GET',
	    	url: '/ajax/ex10data.do',
	    	traditional: true, //true여야 배열 전송 가능
	    	data: {	// Object형이어야 배열 전송 가능
	    		list: list  
	    	},
	    	success: (result)=>{},
	    	error: (a,b,c)=>console.log(a,b,c)
	    });
	    
	    event.preventDefault();
	    return false;
	    
	});
	*/
	
	/*
	$('#form1').submit(()=>{
	    
	    //JSON 전송
	    const obj = {
	        txt1: $('#txt1').val(),
	        txt2: $('#txt2').val(),
	        txt3: $('#txt3').val(),
	        txt4: $('#txt4').val(),
	        txt5: $('#txt5').val()
	    };
	    
	    //aler(JSON.stringify(obj));
	    
	    $.ajax({
	    	type: 'POST', // JSON으로 보낼 때는 GET 불가
	    	url: '/ajax/ex10data.do',	    	
	    	contentType: 'application/json', //클라이언트 -> 서버
	    	//dataType: 'json', //서버 -> 클라이언트
	    	data: JSON.stringify(obj),
	    	success: (result)=>{},
	    	error: (a,b,c)=>console.log(a,b,c)
	    });
	    
	    event.preventDefault();
	    return false;
	    
	});
	*/
	
	
	$('#btn2').click(()=>{
		
	    $.ajax({
			type: 'GET',
			url: '/ajax/ex10data.do',
			
			dataType: 'json',
	    	success: (result)=>{
	    	   //$('#result').append('<div>' + result.seq + '</div>');
	    	   // $('#result').append('<div>' + result.question + '</div>');
	    	   
	    	   $(result).each((index, item)=>{
	    	       $('#result').append('<div>' + item.name + '')	    	       
	    	       $('#result').append('<div>' + item.age + '')	    	       
	    	       $('#result').append('<div>' + item.address + '')	    	       
	    	       $('#result').append('<hr>')    	       
	    	   })
	    	},
	    	error: (a,b,c)=>console.log(a,b,c)
			
	    });	
	});

</script>
</body>
</html>
