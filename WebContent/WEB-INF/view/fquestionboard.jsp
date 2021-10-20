<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- ���� css -->
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


<title>�䵵�� ���ֹ�������</title>
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
		<h2>���ֹ�������</h2>
		<button id="NoticeBtn" class="headerBtnStyle" onclick="location.href='usernotice'">��������</button>
        <button id="FquestionBtn" class="headerBtnStyle" onclick="location.href='fquestionboard'">���ֹ�������</button>       	
        <button id="QuestionBtn" class="headerBtnStyle">1��1����</button>	
 		
 		<div id="fcateBtnAll">
            <a href="fquestionboard?catenum=<%=0%>" id="0" class="categoryBtn">��ü</a>
            <a href="fquestionboard?catenum=<%=1%>" id="1" class="categoryBtn">�ֹ�����</a>
            <a href="fquestionboard?catenum=<%=2%>" id="2" class="categoryBtn">���</a>
            <a href="fquestionboard?catenum=<%=3%>" id="3" class="categoryBtn">���/ȯ��</a>
            <a href="fquestionboard?catenum=<%=4%>" id="4" class="categoryBtn">��ǰ/��ȯ</a>
            <a href="fquestionboard?catenum=<%=5%>" id="5" class="categoryBtn">����/����Ʈ</a>
            <a href="fquestionboard?catenum=<%=6%>" id="5" class="categoryBtn">ȸ������</a>
        </div>
        
        <!-- TODO -->
        	<div class="fquestion_row">
        		<table class="fquestion_board">
        			<caption>���ֹ��� �������</caption>
        			<thead>
        					<tr>
        						<th>��ȣ</th>
        						<th>����</th>
        						<th>�ۼ���</th>
        					</tr>
        					</thead>
        					
        					<tbody>
        						<%
					if(volist != null){
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
						<td colspan="2">�Խñ��� �����ϴ�.</td>
						</tr>
					<%
					}
					%>
        					</tbody>
        		</table>
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