<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/noticeboard.css" />
<%@page import="java.util.List"%>
<%@page import="notice.dao.NoticeDao"%>
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
<script type="text/javascript" src="./js/mypage.js"></script> 
<title>밥도둑 공지detailviewpage</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
Notice vo = (Notice)request.getAttribute("vo");
	int notice_num = (int)request.getAttribute("notice_num"); 


%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
	<div class="detailnotice">
		<table class="detailnotice_board">
			<caption>공지사항 상세목록</caption>
			<thead>
				<tr>
				<th>공지번호</th>
				<th>공지명</th>
				<th>공지날짜</th>
				<th>공지내용</th>
				</tr>
				</thead>
				<tbody>
        <tr>
            <td><%=vo.getNotice_num()%></td>
            <td><%=vo.getNotice_title()%></td>
            <td><%=vo.getNotice_time()%></td>
            <td><%=vo.getNotice_content()%></td>
        </tr>		
				</tbody>
				
		</table>					       
</div>
    <button onclick="location.href='usernotice'">게시물목록보기</button>   
    <button onclick="location.href='main'">홈으로 이동</button>
	<%@ include file="riceThief_footer.jsp" %>

</body>
</html>


