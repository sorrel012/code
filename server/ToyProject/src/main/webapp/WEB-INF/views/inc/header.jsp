<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header id="header">	
	<h1>
		<c:if test="${empty id}">
		<span>Toy</span>
		</c:if>
		
		<c:if test="${not empty id}">
			<span class="material-symbols-outlined">toys</span>
		</c:if>
		
		<c:if test="${not empty id and lv == '1' }">
		<span style="color: cornflowerblue;">Toy</span>
		</c:if>
		<c:if test="${not empty id and lv == '3' }">
		<span style="color: tomato;">Toy</span>
		</c:if>		
		Project
	</h1>
	<nav>
		<a href="/toy/index.do">Home</a>
		
		<!-- 로그인 안 했을 때 보여야 함 -->
		<c:if test="${empty id}">
		<a href="/toy/user/register.do">Register</a>
		<a href="/toy/user/login.do">Login</a>
		</c:if>
		
		<!-- 로그인 했을 때 보여야 함 -->
		<c:if test="${not empty id}">
		<a href="/toy/user/register.do">Unregister</a>		
		<a href="/toy/user/logout.do">Logout</a>
		
		<a href="/toy/board/list.do">Board</a>
		</c:if>
	</nav>
</header>