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
	
	<div>
		검색어(동입력) : 
		<input type="text" id="dong">
		<input type="button" id="btn1" value="우편번호 검사하기">
	</div>
	<div>
		검색 결과 :
		<select id="sel">
			<option>검색해주세요</option>
		</select>
	</div>	
	<div>
		나머지 주소 : 
		<input type="text" id="add">
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	$('#btn1').click(()=>{	 
	    
	    $.ajax({
	    
	        type: 'GET',
	        url: '/ajax/q02data.do',
	        data: 'dong=' + $('#dong').val(),
	        dataType: 'json',
	        
	        success: (result)=> {		               
	            
	            if (result.none!= "true") {	           
					$('option').remove();
		            
		            $(result).each((index, item) => {
		                $('#sel').append(
		                 	`
		                 		<option>\${item.zip} \${item.sido} \${item.gugun} \${item.dong}</option>
		                	`
		                )	                
		                
		            });  		            
	        	} else {
	            	alert('검색 결과가 없습니다.');
	        	}
                        
	            
	        },
	        
	        error: (a,b,c)=>console.log(a,b,c)	    	
	    
	    });
	    
	});

</script>
</body>
</html>
