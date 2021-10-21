<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/fquestionboard.css" />
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
<title>자주묻는질문 읽기페이지</title>
<%
	String msg = (String)request.getAttribute("msg");
%>
<script type="text/javascript">
    <%if(msg != null){%>
    	alert("<%=msg%>");
    <%}%>
</script>

</head>
<body>
<%
Fquestion vo = (Fquestion)request.getAttribute("vo");
int f_question_num = (int)request.getAttribute("f_question_num"); 
%>
<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
    <div class="detailfquestion">
    	<table class="detailfquestion_board">
    		<caption>자주묻는질문 읽기 목록</caption>
    		<thead>
    			<tr>
    			<th>자주묻는질문 제목</th>
    			<th>자주묻는질문 내용</th>
    			</tr>
    			</thead>
    			<tbody>
    				<tr>
    					<td><%=vo.getfquestion_title()%></td>
    					<td><%=vo.getfquestion_content()%></td>  
    				</tr>  					
    			</tbody>
    	</table>
    </div>
    <button onclick="location.href='fquestionboard'">목록보기</button>   
    <button onclick="location.href='main'">홈으로 이동</button>
    <%@ include file="riceThief_footer.jsp" %>
</body>
</html>