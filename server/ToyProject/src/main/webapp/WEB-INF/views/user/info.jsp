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
	#info img {
		border: 1px solid #AAA;
		padding: 3px;
		width: 150px;
		height: 180px;
		object-fit:cover;
	}
	
	#pic {
		width: 170px;
		text-align: center;
	}
	
	#info th:nth-child(2), 
	#info th:nth-child(4) { width: 90px; } 
	
	#info td:nth-child(3), 
	#info td:nth-child(5) { width: 193px; } 
	
	#count th { width: 170px; }
	#count td { width: 170px; }
	
	body {
		padding-bottom: 500px;
	}
	
	
	#log {
		display: flex;
		align-items: flex-start;
	}
	
	#calendar {
		width: 200px;
		border: 1px solid #BBB;
		font-size: 14px;
		padding: 0px;
	}
	
	#calendar > div:first-child {
		display: flex;
		padding: .5rem 1rem;
		justify-content: space-between;
		border-bottom: 1px solid #BBB
	}
	
	#calendar > div:last-child {
		display: grid;
		grid-template-columns: repeat(7, 1fr);
		padding: 1rem;
	}
	
	#calendar > div:last-child > div {
		font-size: 13px;
		margin: 1px;
		border-radius: 50%;
		/* background-color: #DDD; */
		width: 22px;
		height: 22px;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	#calendar > div > div {
		cursor: pointer;
	}
	
	#time {
		width: 220px;
		margin-left: 10px;
	}
	
	#time tbody td:first-child { width: 50px; text-align:center;}
	#time tbody td:last-child { width: 150px;}
	
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp" %>	

	<main id="main">
		<h1>회원 정보 <small>이것 저것</small></h1>
		
		<table id="info">
			<tr>
				<td rowspan="3" id="pic"><img src="/toy/asset/pic/${dto.pic}"></td>
				<th>이름</th>
				<td>${dto.name}</td>
				<th>아이디</th>
				<td>${dto.id}</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>${dto.lv == '1' ? '일반회원' : '관리자'}</td>
				<th>이메일</th>
				<td>${dto.email}</td>
				
			</tr>		
			<tr>
				<td colspan="4">${dto.profile}</td>				
			</tr>	
		</table>
		
		<h2>활동 내역</h2>
		
		<table id="count">
			<tr>
				<th>게시물수</th>
				<td>${map.bcount}회</td>
				<th>댓글 수</th>
				<td>${map.ccount}회</td>
			</tr>
		</table>
		
		<div id="log">
			<div id="calendar">
				<div>
					<div>&lt;&lt;</div>
					<div></div>
					<div>&gt;&gt;</div>
				</div>
				<div></div>
			</div>
			<table id="time">
				<thead>
					<tr>
						<th colspan="2">시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" begin="0" end="23">
					<tr>
						<td>${i}</td>
						<td></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</main>
	
</body>

<script>

	let year, month;
	
	let now = new Date();
	
	year = now.getFullYear();
	month = now.getMonth();
	
	function createCalendar(year, month) {
	    
	    $('#calendar > div:eq(0) > div:eq(1)').text(year + '.' + String(month + 1).padStart(2, '0'));
	    
	    let lastDate = new Date(year, month + 1, 0).getDate();
	    let firstDay = new Date(year, month, 1).getDay();
	    
	    let tmp = '';
	    
	    for (let i=0; i<firstDay; i++) {
	        tmp += '<div></div>';
	    }
	    
	    for(let i=1; i<=lastDate; i++) {
	    	tmp += `<div class="item">\${i}</div>`;
	    }
	    
	    $('#calendar > div:last-child').html(tmp);
	    
	}
	
	createCalendar(year, month); //현재 달 출력
	
	$('#calendar > div:eq(0) > div:eq(0)').click(()=>{
		now.setMonth(now.getMonth() - 1);
		year = now.getFullYear();
		month= now.getMonth();
		createCalendar(year, month);
	});
	
	$('#calendar > div:eq(0) > div:eq(2)').click(()=>{
		now.setMonth(now.getMonth() + 1);
		year = now.getFullYear();
		month= now.getMonth();
		createCalendar(year, month);
	});
	
	function showLog(year, month, date) {
	    
	    $.ajax({
	    	type: 'POST',
	    	url: '/toy/user/log.do',
	    	data: {
	    	    year: year,
	    	    month: month + 1,
	    	    date: date
	    	},
	    	dataType: 'json',
	    	success: result=>{
	    	    
	    	    $('#time tbody tr td:last-child').html(''); //초기화
	    	    
	    	    $(result.list).each((index,item)=>{
	    	       	
	    	        //item = {"hour":"1", "cnt":"0"}
	    	        if(item.cnt > 0) {
	    	        	$('#time tbody tr').eq(item.hour).children().eq(1).append(`<span class="material-symbols-outlined">pending_actions</span> \${item.cnt}`);
	    	        }
	    	    });
	    	    
				$(result.clist).each((index,item)=>{
	    	       	
	    	        //item = {"hour":"1", "cnt":"0"}
	    	        if(item.cnt > 0) {
	    	        	$('#time tbody tr').eq(item.hour).children().eq(1).append(` <span class="material-symbols-outlined">comment</span> \${item.cnt}`);
	    	        }
	    	    });
	    	    
				$(result.plist).each((index,item)=>{
	    	       	
	    	        //item = {"hour":"1", "cnt":"0"}
	    	        if(item.cnt > 0) {
	    	        	$('#time tbody tr').eq(item.hour).children().eq(1).append(` <span class="material-symbols-outlined">location_on</span> \${item.cnt}`);
	    	        }
	    	    });
	    	    
	    	},
	    	error: (a,b,c)=>console.log(a,b,c)
	    })
	}
	
	showLog(now.getFullYear(), now.getMonth(), now.getDate());	
	

	$('#calendar .item').click(function() {
	   
	    //alert($(this).text());
	    
	    $('#calendar .item').css('outline', 'none');
	    $(this).css('outline', '1px solid blue');
	    
	    showLog(now.getFullYear(), now.getMonth(), $(this).text());
	});
	
	function checkLog(year, month) {

	    $.ajax({
	        type: 'POST',
	        url: '/toy/user/checklog.do',
	        data: {
	            year: year,
	            month: month + 1
	        },
	        dataType: 'json',
	        success: result=>{
	            //console.log(result)	            
	            
	            $(result).each((index,item)=>{
	                if (item.cnt > 0) {
		                $('#calendar .item').eq(item.dd-1).css('font-weight', 'bold');
		                $('#calendar .item').eq(item.dd-1).css('color', 'tomato');
		            } 
	            });
	                
	            $('#calendar .item').eq(now.getDate()-1).css('background-color', 'gold');
	            
	        },
	        error: (a,b,c)=>console.log(a,b,c)
	    })
	    
	}
	
	checkLog(now.getFullYear(), now.getMonth());
	
</script>
</html>
