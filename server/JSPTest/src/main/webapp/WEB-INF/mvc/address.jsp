<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

	<h1>Address</h1>
	
	<div>
		<div>주소록 총 인원수: <%= request.getAttribute("count") %></div>
		<div>주소록 총 인원수: ${count}</div>
		
		<div>주소록 총 인원수: <%= (int)request.getAttribute("count") *2 %></div>
		<div>주소록 총 인원수: ${count*2}</div>
		
		<hr>
		
		<!-- 리터럴 표현 -->
		<div>${100}</div>
		<div>${3.14}</div>
		<div>${"홍길동"}</div>
		<div>${'홍길동'}</div>
		<div>${true}</div>
		<div>${null}</div>
		
		<hr>
		
		<!-- 배열 -->
		<div>${ nums }</div>
		<div>${ nums[0] }</div>
		
		<hr>
		
		<!-- List -->
		<div>${ nums2 }</div>
		<div>${ nums2[0] }</div>
		
		<hr>
		
		<!-- Map -->
		<div>${ nums3 }</div>		
		<div>${ nums3["math"] }</div>
		<div>${ nums3.get("kor") }</div>
		<div>${ nums3.eng }</div>
		
		<hr>
		
		<!-- Object -->
		<div>${ vo }</div>
		<div>${ vo.seq }</div>
		<div>${ vo.getName() }</div>
		<div>${ vo["name"] }</div>
		<div>${ vo.name }</div>
		<div>${ vo.age }</div>
		<div>${ vo.tel }</div>
		<div>${ vo.address }</div>
		
		
		<hr>
		
		<!--  연산자 -->
		<div>a: ${a}</div>
		<div>b: ${b}</div>
		
		<div>a + b: <%= (int)request.getAttribute("a") + (int)request.getAttribute("b") %></div>
		<div>a + b: ${a + b}</div>
		<div>a - b: ${a - b}</div>
		<div>a * b: ${a * b}</div>
		<div>a / b: ${a / b}</div>
		<div>a div b: ${a div b}</div>
		<div>a % b: ${a % b}</div>
		<div>a mod b: ${a mod b}</div>
		
		<hr>
		
		<div>${a > b}</div>
		<div>${a gt b}</div>
		<div>${a >= b}</div>
		<div>${a ge b}</div>
		<div>${a < b}</div>
		<div>${a lt b}</div>
		<div>${a <= b}</div>
		<div>${a le b}</div>
		<div>${a == b}</div>
		<div>${a eq b}</div>
		<div>${a != b}</div>
		<div>${a ne b}</div>
		
		<hr>
		
		<div>${a > 10 && b < 5 }</div>
		<div>${a > 10 and b < 5 }</div>
		<div>${a > 10 || b < 5 }</div>
		<div>${a > 10 or b < 5 }</div>
		<div>${!(a > 10)}</div>
		<div>${not(a > 10)}</div>
		
		<hr>
		
		<div>${a > 0 ? "양수" : "음수" }</div>
		
		<hr>
		
		<%
		
			//pageContext > request > session > application
			
			pageContext.setAttribute("age", 20);
			request.setAttribute("age", 30);
			session.setAttribute("age", 40);
			application.setAttribute("age", 50);
		
		%>
		<div>나이: <%= pageContext.getAttribute("age") %></div>
		<div>나이: <%= request.getAttribute("age") %></div>
		
		<hr>
		
		<div>나이: ${pageScope.age}</div>
		<div>나이: ${requestScope.age}</div>
		<div>나이: ${sessionScope.age}</div>
		<div>나이: ${applicationScope.age}</div>		
		
		<!-- 		
			JSTL, JSP Standard Tag Library		
		 -->
		 
		 <!-- 값 출력 명령 -->
		 <c:out value="안녕하세요"></c:out>		 
		 
		 <c:out value="${count}"></c:out>		 
		 
		 ${count}
		 
		 <c:out value="${count2}">값이 없음</c:out>
		 
		 ${count2}
		 
		 <hr>
		 
		 <!-- 변수 생성(pageContext 내장 변수) -->
		 
		 
		 <c:set var="n1" value="100"></c:set>
		 
		 <%-- 
		 <c:set var="n1" value="100" scope="request"></c:set>
		 <c:set var="n1" value="100" scope="session"></c:set>
		 <c:set var="n1" value="100" scope="application"></c:set>
		  --%>
		 
		 ${n1}		 
		 
		 <div>${pageScope.n1}</div>
		 <div>${requestScope.n1}</div>
		 <div>${sessionScope.n1}</div>
		 <div>${applicationScope.n1}</div>
		 
		 
		 <!-- 변수 수정 -->
		 <c:set var="age" value="11"></c:set>
		 <c:set var="age" value="22"></c:set>
		 
		 <div>${age}</div>
		 
		 
		 <!-- 변수 삭제 -->
		 <c:remove var="age"></c:remove>
		 
		 <div>age: ${empty age}</div>
		 
		 <hr>
		 
		 
		 <!-- <c:set var="num" value="10" /> -->
		 <c:set var="num" value="-10" />
		 
		 
		 <!-- 조건문(if) -->
		 <c:if test="${num > 0}">
		 	<div>${num}은 양수입니다.</div>
		 </c:if>
		 <c:if test="${num <= 0}">
		 	<div>${num}은 양수가 아닙니다.</div>
		 </c:if>
		 
		 
		 <hr>
		 
		 
		 <!-- 조건문(choose - when) -->
		 <c:choose>
		 	<c:when test="${num > 0 }">양수</c:when>
		 	<c:when test="${num < 0 }">음수</c:when>
		 	<c:when test="${num == 0 }">제로</c:when>
		 	<c:otherwise>기본값</c:otherwise>
		 </c:choose>		 
		 
		 
		 <hr>
		 
		 
		 <!-- 반복문 -->
		 
		 <!--  for(String name : names) -->
		 <c:forEach items="${names}" var="name"> <!-- itemts랑 var 순서 바뀌어도 된다. -->
		 	<div>${name }</div>
		 </c:forEach>
		 
		 <hr>		 
		 
		 <c:forEach var="i" begin="1" end="5" step="1"> <!-- step 음수 불가 -->
		 	<div>${i}</div>
		 </c:forEach>
		 
		 <hr>
		 
		 <c:forEach items="${names}" var="name" begin="2" end="4">		 
		 	<div>${name }</div>
		 </c:forEach>
		 
		 <hr>
		 
		 <c:forEach items="${names}" var="name" varStatus="status">
		 	<div>
		 		${status.index}. 
		 		${status.count}.
		 		${status.first}.
		 		${status.last}.
		 		${name}
		 	</div>
		 </c:forEach>
		 
		 <hr>
		 
		 <c:forEach items="${colors}" var="name">
		 	<div>${name}</div>
		 </c:forEach>
		 
		 <hr>
		 
		 <c:forTokens items="${colors}" delims=":" var="name">
		 	<div>${name}</div>
		 </c:forTokens>
		 
		 
		 <hr>
		 
		 <c:url var="link" value="http://localhost:8090/view.do">
		 	<c:param name="name" value="hong"></c:param>
		 	<c:param name="age" value="20"></c:param>
		 	<c:param name="address" value="서울"></c:param>
		 </c:url>
		 
		 <a href="${link}">링크</a>
		 
		 <!--  resonse.sendRediruct(URL)로 변환  -->
		 
		 <hr>
		 
		 
		 <div>내 생일: <fmt:formatDate value="${birthday.time}" pattern="yyyy-MM-dd E a HH:mm:ss"/></div>
		 
		 
		 <hr>
		 
		 <c:set var="price" value="10000" />
		 
		 <div>가격: ${price}원</div>
		 <div>가격: <fmt:formatNumber value="${price}"/>원</div>
		 
		 
		 <hr>
		 
		 <table>
		 	<tr>
		 		<th>번호</th>
		 		<th>이름</th>
		 		<th>나이</th>
		 		<th>전화</th>
		 		<th>주소</th>
		 	</tr>
		 	<c:forEach items="${list}" var="vo">
		 	<tr>
		 		<td>${vo.seq}</td>		 		
		 		<td>${vo.name}</td>
		 		<td>${vo["age"]}</td>
		 		<td>${vo.getTel()}</td>
		 		<td>${vo.address}</td>
		 	</tr>
		 	</c:forEach>
		 </table>
		 
		 
	</div>
	<br><br><br><br><br><br>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>
