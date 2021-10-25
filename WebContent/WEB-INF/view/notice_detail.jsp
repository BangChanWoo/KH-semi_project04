<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/basic.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<%@page import="java.util.ArrayList"%>
<%@page import="notice.vo.Notice"%>
<%@page import="notice.dao.NoticeDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./js/mypage.js"></script> 
<title>Insert title here</title>
<style>
body {
	text-align: center;
}

#id {
	margin-left: 10px;
}

.in {
	margin: 7px;
	width: 200px;
}

.btnContainer {
	clear: both;
	margin: 5rem;
	text-align: center;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<%@ include file="riceThief_header.jsp" %>
<hr>
<h2>공지사항</h2>

<% 
Notice vo = (Notice)request.getAttribute("vo");
int notice_num = (int)request.getAttribute("notice_num"); 


%>

	<br><br>
		<div id = "detailContent" style= 
	"margin: 3em auto;
    padding: 2rem;
    background-color: #ebded4;
    border-radius: 5px;">
			<h2 id ="detailContent class="noticeTitle">제목: <%=vo.getNotice_title()%></h2>
			<br><br><br>
			<p id="detailContent"><%=vo.getNotice_content()%></p>
			<br><br>
			<p id="detailDate"><%=vo.getNotice_time()%></p>
		</div>
		
		<br><br><br>
		<button onclick="location.href='usernotice'">게시물목록보기</button>   
    <button onclick="location.href='main'">홈으로 이동</button>
	<%@ include file="riceThief_footer.jsp" %>

</body>
</html>
