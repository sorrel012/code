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

	#form {
		border: 1px solid black;
		margin: 10px 15px;
		padding: 20px;
	}
	
	#btn {
		margin-top: 10px;
	}
	
	.long {
		width: 200px;
	}
	
	#form div {
		margin: 5px;
	}

</style>
</head>
<body>

	<h1>주소록</h1>
	
	<table id="list">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>전화</th>
				<th>주소</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
	         <tr>
	            <td>${dto.seq}</td>
	            <td>${dto.name}</td>
	            <td>${dto.tel}</td>
	            <td>${dto.address}</td>
	            <td>
	      			<input type="button" value="삭제하기" id="btnDel" onclick="del(${dto.seq});";>
	            </td>
	         </tr>
	         </c:forEach>
		</tbody>
	</table>
	
	<form id="form">
		<div>
			이름 : <input type="text" name="name" class="long" id="name">
		</div>
		<div>
			전화 : <input type="text" name="tel" class="long" id="tel">
		</div>
		<div>
			주소 : <input type="text" name="address" class="long" id="address">
		</div>
		
		<div>
	      <input type="button" value="입력하기" id="btn">
	   </div>
	</form>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	$('#address').keydown(()=>{
		if(event.keyCode == 13) {
		    $('#btn').click(); 
		} 
	});

    $('#btn').click(()=>{
	    
	    let name = $('#name').val();
	    let tel = $('#tel').val();
	    let address = $('#address').val();
        
	    $.ajax({
	         
	        type: 'POST',
	        url: '/ajax/q05add.do',	         
	        data: {
	            name: name,
	            tel: tel,
	            address: address
	        },
	        dataType: 'json',
	        success: (result)=>{
	             
	           if (result.result == 1) {
	              //테이블에 상품을 추가하기(출력)
	              let tr = `
	                 
	                 <tr>	               	
	                    <td>\${result.seq}</td>
	                    <td>\${$('#name').val()}</td>
	                    <td>\${$('#tel').val()}</td>
	                    <td>\${$('#address').val()}</td>
	    	            <td>
	    	      			<input type="button" value="삭제하기" id="btnDel" onclick="del(${dto.seq});";>
	    	            </td>
	                 </tr>
	             
	              `;
	             
	              $('#list tbody').prepend(tr);
	              
	              $('#name').val('');
	              $('#tel').val('');
	              $('#address').val('');            
	             
	           } else {
	              alert('failed');
	           }
	            
	        },
	        error: (a,b,c)=>console.log(a,b,c)
	         
	    });
	      
    });   
    
    function del(seq) {
        
        let tr = $(event.target).parent().parent();         
        
        $.ajax({
           type: 'POST',
           url: '/ajax/q05del.do',
           data: {
              seq: seq
           },
           dataType: 'json',
           success: (result)=>{
              
              if (result.result == 1) {
                 
                 $(tr).remove();
                 
              } else {
                 alert('failed');
              }
              
           },
           error: (a,b,c)=>console.log(a,b,c)
           
        });
        
     }

</script>
</body>
</html>
