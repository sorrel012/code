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
	
	#list th:nth-child(1) { width: 50px; }
	#list th:nth-child(2) { width: auto; }
	#list th:nth-child(3) { width: 70px; }
	#list th:nth-child(4) { width: 120px; }
	#list th:nth-child(5) { width: 50px; }
	
	#list td { text-align: center; }
	#list td:nth-child(2) { text-align: left; }
	
	.isnew {
		font-size: 14px;
		color: tomato;
	}
	
	.comment-count {
		font-size: 12px;
		color: #777;
	}
	
	#searchForm {
		margin-bottom: 15px;
		text-align: center;
	}

</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>	

	<main id="main">
		<h1>게시판 <small>목록</small></h1>
		
		<table id="list">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>날짜</th>
				<th>읽음</th>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.seq}</td>
				<td>
					<!-- 제목(링크) -->
					<a href="/toy/board/view.do?seq=${dto.seq}">${dto.subject}</a>
					
					<!-- 댓글 개수 -->
					<c:if test="${dto.ccnt > 0}">
					<span class="comment-count">(${dto.ccnt})</span>
					</c:if>
					
					<!-- 새 글 표시 -->
					<c:if test="${dto.isnew < 30 / 24 / 60}"> <!-- 30분이 안 된 글들은 옆에 new가 뜬다. -->
						<span class="isnew">new</span>
					</c:if>
				</td>
				<td>${dto.name}</td>
				<td>${dto.regdate}</td>
				<td>${dto.readcount}</td>
			</tr>
			</c:forEach>
		</table>
		
		<!-- 몇 안 되는 form 태그에 GET을 쓰는 경우 -->
		<form id="searchForm" action="/toy/board/board.do" method="GET">
			<select name="column">
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="name">이름</option>
			</select>
			<input type="text" name="word" class="long" required>
			<input type="submit" value="검색하기">
		</form>		
		
		<div>
			<c:if test="${not empty id}">
			<button type="button" class="add primary"
				onclick="location.href='/toy/board/add.do';">글쓰기</button>
			</c:if>
		</div>
		
	</main>
	
</body>

<script>

</script>
</html>
