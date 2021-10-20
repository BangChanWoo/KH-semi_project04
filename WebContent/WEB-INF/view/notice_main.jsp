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
<title>밥도둑 공지사항</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<%
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	ArrayList<Notice> volist = (ArrayList<Notice>)request.getAttribute("noticeVoList");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
	<main>
		<h2>Notice</h2>
		<button id="NoticeBtn" class="headerBtnStyle" onclick="location.href='usernotice'">공지사항</button>
        <button id="FquestionBtn" class="headerBtnStyle" onclick="location.href='fquestionboard'">자주묻는질문</button>       	
        <button id="QuestionBtn" class="headerBtnStyle">1대1문의</button>	
		
		
		
			<div class="notice_row">
				<table class="notice_board">
				<caption>게시판목록</caption>
				<thead>			
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성시간</th>
						</tr>											
				</thead>					
				<tbody>
					<%
					if(volist != null){
							for(int i =0; i<volist.size(); i++){
								%>
								<tr onclick="javascript:location.href='userdetailnotice?notice_num=<%=volist.get(i).getNotice_num() %>'">
								<td><%=volist.get(i).getNotice_num() %></td>
								<td><%=volist.get(i).getNotice_title() %></td>
								<td><%=volist.get(i).getNotice_time() %></td>								
								</tr>
								<%
							}
					}else{ 
					%>
						<tr>
						<td colspan="3">게시글이 없습니다.</td>
						</tr>
					<%
					}
					%>
					</tbody>	
					</table>
			</div>
		</div>
		   <div id="pageBtnAll">
        <%if(startPage > 1){%>
            <a class="pageBtn" href="usernotice?pagenum=<%=startPage-1%>"><i class="fas fa-chevron-left"></i></a>
            <%} %>
            <%for (int i = startPage; i <= endPage; i++) {%>
            <a id="pageBtn_<%=i%>" class="pageBtn" href="usernotice?pagenum=<%=i%>"><%=i%></a>
            <%} %>
            <%if(endPage < pageCount){%>
            <a class="pageBtn" href="usernotice?pagenum=<%=endPage+1%>"><i class="fas fa-chevron-right"></i></a>
           <%} %>
        </div>
	
	</main>
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>
	
</body>
</html>