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


<title>밥도둑 자주묻는질문</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./js/mypage.js"></script>
</head>
<body>
<%
	ArrayList<Fquestion> volist = (ArrayList<Fquestion>)request.getAttribute("fquestionVoList");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
	<main>
		<h2>자주묻는질문</h2>
		<button id="NoticeBtn" class="headerBtnStyle" onclick="location.href='usernotice'">공지사항</button>
        <button id="FquestionBtn" class="headerBtnStyle" onclick="location.href='fquestionboard'">자주묻는질문</button>       	
        <button id="QuestionBtn" class="headerBtnStyle">1대1문의</button>	
 		
 		
        	<div class="fquestion_row">
        		<table class="fquestion_board">
        			<caption>자주묻는 질문목록</caption>
        			<thead>
        					<tr>
        						<th>번호</th>
        						<th>제목</th>
        				
        					</tr>
        					</thead>
        					
        					<tbody>
        					
					<%if(volist != null){
							for(int i =0; i<volist.size(); i++){
								%>
								<tr onclick="javascript:location.href='fquestiondetail?fquestion_no=<%=volist.get(i).getfquestion_no() %>'">
								<td><%=volist.get(i).getfquestion_no() %></td>
								<td><%=volist.get(i).getfquestion_title() %></td>						
								</tr>
								<%
							}
					}else{ 
					%>
						<tr>
						<td colspan="2">게시글이 없습니다.</td>
						</tr>
					<%
					}
					%>
        					</tbody>
        		</table>
        	</div>
 
 <div id="pageBtnAll">
        <%if(startPage > 1){%>
            <a class="pageBtn" href="fquestionboard?pagenum=<%=startPage-1%>"><i class="fas fa-chevron-left"></i></a>
            <%} %>
            <%for (int i = startPage; i <= endPage; i++) {%>
            <a id="pageBtn_<%=i%>" class="pageBtn" href="fquestionboard?pagenum=<%=i%>"><%=i%></a>
            <%} %>
            <%if(endPage < pageCount){%>
            <a class="pageBtn" href="fquestionboard?pagenum=<%=endPage+1%>"><i class="fas fa-chevron-right"></i></a>
           <%} %>
        </div>
	
	</main>
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>
	
</body>
</html>