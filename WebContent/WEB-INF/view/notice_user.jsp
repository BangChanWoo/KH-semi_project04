<%@page import="notice.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/recipeCategory.css"/>
<!-- TODO -->
<title>밥도둑 공지사항</title>
<% String msg = (String)request.getAttribute("msg");%>
<script type="text/javascript">
	<%if(msg != null){%>
		alert("<%=msg%>");
	<%}%>
</script>	
</head>
<body>
<%
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	ArrayList<Notice> volist = (ArrayList<Notice>)request.getAttribute("noticeVoList");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	int catenum = (int)request.getAttribute("catenum");
	
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
	<main>
		<h2>Notice</h2>
		<div id="cateBtnAll">
			<a href="noticeboard?catenum=<%=0%>" id="0" class="cateBtn selectBtncolor">공지사항</a>
			<a href="noticeboard?catenum=<%=1%>" id="1" class="cateBtn">자주묻는질문</a>
			<a href="noticeboard?catenum=<%=2%>" id="2" class="cateBtn">1대1문의</a>
		</div>
		<div>
		
		</div>
	</main>
	<hr>
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>
	
</body>
</html>