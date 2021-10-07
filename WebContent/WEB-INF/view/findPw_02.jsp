<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" /> <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<title>비밀번호 재설정</title>
<style>
        body{  text-align: center; }
        div{ margin: 2rem; }
        .vv{ width:200px; }
        </style>
</head>
<body>
	<header>
	<a href="main.jsp" target="_self"> <img src="./css/밥도둑 로고.png"></a>
        <hr>
    </header>
    <section>
    <br>
        <i class="fas fa-user-lock">재설정하실 비밀번호 입력해주세요.</i><br>
        <div><p>대문자/소문자/숫자 3가지 포함하여 6자리 이상 16자리 이하</p><br>
        <input type="text" class="vv" placeholder="재설정 비밀번호 입력"><br>
        </div>
        <div>
        <p>비밀번호 확인</p>
        <input type="text" class="vv" placeholder="재설정 비밀번호 확인">
        </div>
        <button type="submit">변경하기</button>
    </section>
    <footer>
	<hr>
        <%@ include file="../WEB-INF/riceThief_footer.jsp" %>
    </footer>
</body>
</html>