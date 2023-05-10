<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
    /* 
    body {
        background-image: url(images/rect_icon01.png);
    }
     */
    table {
        background-color: white;
    }

</style>
</head>
<body>

    <h1>쿠키, Cookie</h1>
    
    <h2>배경화면 선택(테마)</h2>
    
    <table>
        <tr>
            <td><img src="images/rect_icon01.png"></td>
            <td><input type="radio" name="background" value="rect_icon01.png" checked></td>
        </tr>
        <tr>
            <td><img src="images/rect_icon02.png"></td>
            <td><input type="radio" name="background" value="rect_icon02.png"></td>
        </tr>
        <tr>
            <td><img src="images/rect_icon03.png"></td>
            <td><input type="radio" name="background" value="rect_icon03.png"></td>
        </tr>
    </table>    
    
    <hr>
    
    <div style="background-color: white;">
        <a href="ex20_cookie_one.jsp">첫 번째 페이지></a>
        <a href="ex20_cookie_two.jsp">두 번째 페이지></a>
        <a href="ex20_cookie_three.jsp">세 번째 페이지></a>
    </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="js/cookie.js"></script>
<script>

    //document.cookie = 100;    
    //console.log(document.cookie);
    
    //key = value
    
    setCookie('name', '홍길동');
    
    console.log(getCookie('name'));
    
    if(getCookie('background') == '') {
        //첫 방문
        setCookie('background', 'rect_icon01.png', 365);
    
    } else {
        //재방문
        $('body').css('background-image', `url(images/\${getCookie('background')})`);
        
        $('input[name=background]').each((index, item) => {
            if ($(item).val() == getCookie('background')) {
                $(item).prop('checked', true);
            } else {
                $(item).prop('checked', false);
            }
        });
        
    }
    
    $('input[name=background]').change(function() {
        
        //alert($(this).val());
        $('body').css('background-image', `url(images/\${$(this).val()})`);
        
        //선택한 테마 > 쿠키 지정        
        setCookie('background', $(this).val(), 365);
        
    });
    
</script>
</body>
</html>
