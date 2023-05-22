<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	#content {
		height: 215px;
	}
	
	#comment td:nth-child(1) { width: auto; }
	#comment td:nth-child(2) { 
		width: 150px;
		text-align: center; 
	}
	
	#addcomment td:nth-child(1) { width: auto; }
	#addcomment td:nth-child(2) { 
		width: 150px;
		text-align: center; 
	}
	
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>	

	<main id="main">
		<h1>게시판 <small>글보기</small></h1>
		
		<form method="POST" action="/toy/board/add.do">
		<table class="vertical">
			<tr>
				<th>번호</th>
				<td>${dto.seq}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${dto.name}(${dto.id})</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.subject}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td id="content">${dto.content}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${dto.regdate}</td>
			</tr>
			<tr>
				<th>읽음</th>
				<td>${dto.readcount}</td>
			</tr>
		</table>
		
		<table id="comment">
			<tr>	
				<td>댓글 내용입니다.</td>
				<td>
					<div>이름(아이디)</div>
				</td>
			</tr>
			<tr>	
				<td>댓글 내용입니다.</td>
				<td>
					<div>이름(아이디)</div>
				</td>
			</tr>
			<tr>	
				<td>댓글 내용입니다.</td>
				<td>
					<div>이름(아이디)</div>
				</td>
			</tr>
		</table>
		</form>
		
		<form method="POST" action="/toy/board/comment.do">
		<table id="addcomment">
			<tr>
				<td><input type="text" name="comment" class="full" required></td>
				<td>
					<button type="submit" class="comment">댓글쓰기</button>
				</td>
			</tr>
		</table>
		</form>
		
		<div>
			<button type="button" class="back" onclick="location.href='/toy/board/board.do';">돌아가기</button>
			<c:if test="${not empty id && (id == dto.id || lv == 3)}">
			<button type="button" class="edit" onclick="location.href='/toy/board/edit.do?seq=${dto.seq}';">수정하기</button>
			<button type="button" class="del" onclick="location.href='/toy/board/del.do?seq=${dto.seq}';">삭제하기</button>
			</c:if>
		</div>
		
	</main>
	
</body>

<script>

</script>
</html>
