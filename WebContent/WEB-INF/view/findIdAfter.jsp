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

<title>아이디 찾기</title>
<style>
	*{
	margin:0 auto;
	padding:0;
	text-align:center;
	}
	
</style>
</head>
<body>
<%@ include file="riceThief_header.jsp" %>
	<hr>
<%
	request.setCharacterEncoding("utf-8");
	User u=(User)request.getAttribute("vo");
	
%>
	<div class="wrap">
		<div id="userId">아이디는[<%=u.getUid() %>]입니다.</div>
		<button id="button" onclick="location.href='login'">로그인Go</button>
	</div>
	<hr>
	<%@ include file="riceThief_footer.jsp" %>
</body>

	
</html>