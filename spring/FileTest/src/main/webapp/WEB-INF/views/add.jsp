<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<h1>파일 업로드</h1>
	
	<form method="POST" action="/file/addok.do" enctype="multipart/form-data">
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><input type="file" name="attach"></td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>
	</form>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	function checkFile(filename, filesize) {
	    
	    const maxsize = 10485760;	//10MB
	    const regex = /(.*?)\.(exe|sh)$/gi;
	    
	    if (filesize >= maxsize) {
	        alert('단일 파일의 크기는 10MB 이하만 가능합니다.');
	        return false;
	    }
	    
	    if (regex.test(filename)) {	        
	        alert('해당 파일은 업로드할 수 없습니다.');
	        return false;	        
	    }
	    
	    return true;	    
	}

	//전송되기 바로 직전에 발생하는 이벤트
	$('form').submit(function() {
	    
	    let filename = $('input[name=attach]')[0].files[0].name;
	    alert(filename);
	    
	    let filesize = $('input[name=attach]')[0].files[0].size;
	    alert(filesize);
	
	    if(!checkFile(filename, filesize)) {
	        
	        //전송 금지!
	        event.preventDefault();
	        return false;
	    }
	    
	});

</script>
</body>
</html>