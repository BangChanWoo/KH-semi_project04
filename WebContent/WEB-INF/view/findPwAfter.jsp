<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/riceThief_footer.css" />
<%@page import="user.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<title>비밀번호 재설정</title>
<style>
        body{  text-align: center; }
        div{ margin: 2rem; }
        .vv{ width:200px; }
        </style>
</head>
<body>
	<header>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    </header>
    <section>
    <%
	request.setCharacterEncoding("utf-8");
	User u=(User)request.getAttribute("vo");
	
%>
    	<div class="wrap">
		<div id="userPw">비밀번호는[<%=u.getPw() %>]입니다.</div>
		<button id="button" onclick="location.href='login'">로그인Go</button>
	</div>
    </section>
    <footer>
	<hr>
        <%@ include file="riceThief_footer.jsp" %>
    </footer>
</body>
</html>