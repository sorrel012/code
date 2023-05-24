<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/toy/asset/css/tagify.css">
<style>
	#pic {
		width: 550px;
		display: block;
	}
	
	#map {
		width: 550px;
		height: 400px;
	}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>	

	<main id="main">
		<h1 class="page">장소 <small>보기</small></h1>
		
		<form method="POST" action="/toy/place/addplace.do" enctype="multipart/form-data">
		<table class="vertical">
			<tr>
				<th>장소명</th>
				<td>${dto.name}</td>
			</tr>
			<tr>
				<th>설명</th>
				<td>${dto.content}</td>
			</tr>	
			<tr>
				<th>작성</th>
				<td>${dto.name}(${dto.id}) ${dto.regdate}</td>
			</tr>
			<tr>
				<th>사진</th>
				<td><img src="/toy/asset/place/${dto.pic}" id="pic"></td>
			</tr>
			<c:if test="${not empty lat && not empty lng}">
			<tr>
				<th>위치</th>
				<td><div id="map"></div></td>
			</tr>
			</c:if>				
			<tr>
				<th>해시태그</th>
				<td>
					<input type="text" id="hashtag" readonly>
				</td>
			</tr>	
		</table>
		<div>
			<button type="button" class="add primary"
				onclick="location.href='/toy/place/place.do';">돌아가기</button>
		</div>		
		
		</form>
		
	</main>
	
</body>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	6d88daddca380ab9ff45e48fab144915"></script>
<script src="/toy/asset/js/jQuery.tagify.min.js"></script>
<script>

	<c:if test="${not empty lat and not empty lng}">
	var container = document.getElementById('map'); 
	var options = { 
		center: new kakao.maps.LatLng(${lat}, ${lng}),
		level: 3 
	};
	
	var map = new kakao.maps.Map(container, options); 
	
	var m = new kakao.maps.Marker({
	    position: new kakao.maps.LatLng(${lat}, ${lng})
	});
	
	m.setMap(map);
	</c:if>
	
	let tmp = '';
	
	<c:forEach items="${dto.hashtag}" var="tag">
		tmp += '${tag},'
	</c:forEach>	
	
	$('#hashtag').val(tmp);
	
	/*
	$('#hashtag').tagify().on('click', function(e) {
	    alert(e.detail);
	});
	*/
	
	const tagify = new Tagify(document.querySelector('#hashtag'), {});
	   
	tagify.on('click', test);
	
	function test(e) {
	    alert(e.detail.data.value);   
	}
	   
</script>
</html>
