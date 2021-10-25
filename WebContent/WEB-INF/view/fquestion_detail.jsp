<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->

<%@page import="java.util.List"%>
<%@page import="frequency.dao.FrequencyDao"%>
<%@page import="frequency.vo.Fquestion"%>
<%@page import="java.util.ArrayList"%>
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
main {
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
#notice_h2{
	margin: 5rem 0 0 0;
}
button{
	background-color: #cfb9af;
	border: 0;
	border-radius: 7px;
	padding: 0.4rem;
	font-size: 1rem;
	margin: 0 1rem 5rem 1rem;
}
button:hover{
	background-color: #ebded4;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<%@ include file="riceThief_header.jsp" %>
<main>
	<hr>
	<h2 id="notice_h2">자주묻는질문</h2>
<% 
Fquestion vo = (Fquestion)request.getAttribute("vo");
int f_question_num = (int)request.getAttribute("f_question_num"); 
%>

<br><br>
		<div id = "detailContent" style= 
		"margin: 3em auto;
	    padding: 2rem;
	    background-color: #ebded4;
	    border-radius: 5px;">
				<h2 id ="detailContent class="noticeTitle">질문: <%=vo.getfquestion_title()%></h2>
				<br><br><br>
				<p id="detailContent">답변: <%=vo.getfquestion_content()%></p>
				
			</div>
			
			<br><br><br>
			</div>
			 <button onclick="location.href='fquestionboard'">목록보기</button>   
	    <button onclick="location.href='main'">홈으로 이동</button>
	</main>
	<hr>
    <%@ include file="riceThief_footer.jsp" %>
</body>
</html>