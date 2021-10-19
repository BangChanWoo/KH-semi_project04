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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/basic.css" />  <!-- ���� css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/riceThief_footer.css" /><!-- footer css -->
<!-- TODO -->
<title>�䵵�� ��������</title>
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
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	ArrayList<Fquestion> volist = (ArrayList<Fquestion>)request.getAttribute("noticeVoList");
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
			<a href="noticeboard?catenum=<%=0%>" id="0" class="cateBtn selectBtncolor">��������</a>
			<a href="fquestionboard?catenum=<%=1%>" id="1" class="cateBtn">���ֹ�������</a>
			<a href="questionboard?catenum=<%=2%>" id="2" class="cateBtn">1��1����</a>
		</div>
		<div id="n0">
		<div class="notice_title">
			<h2>��������</h2>
		</div>
		
		
		<!--TODO -->
		<div class="notice_category">
			<ul class="nbc">
				<li class="nbc_active on" onclick="documemt.all.notice_category.value=''; Search(0);">��ü</li>
				<li class onclick="document.all.notice_category.value='������Ʈ����';Search(0);">������Ʈ����</li>
				<li class onclick="document.all.notice_category.value='��������';Search(0);">��������</li>
				<li class onclick="document.all.notice_category.value='����';Search(0);">���˳���</li>
				
			</ul>
		</div>
	</div>
	</main>
	
	<hr>
	<!-- �Խ��� ȭ�� -->
		<div class="container">
			<div class="notice_row">
				<table class="notice board" style="text-align: center; border:1px solid#ddddd">
				<thead>
					<tr>
						<th colspan="5" style="background-color: #eeeeee; text-align: center;">�Խ��Ǹ��</th>
					</tr>
					</thead>
					
					<tbody>
						<tr>
							<td style="background-color: #eeeeeee; text-align: center;">��ȣ</td>
							<td style="background-color: #eeeeeee; text-align: center;">����</td>
							<td style="background-color: #eeeeeee; text-align: center;">�ۼ��ð�</td>
							<td style="background-color: #eeeeeee; text-align: center;">ī�װ� ��ȣ</td>
					</tr>
					<!-- TODO -->
					<%-- <%
						if(volist.size() > 0){
							for(int i =0; i<1; i++){
								%>
								<tr onclick="ShowDetail(<%=volist.get(i).getNotice_num() %>)">
	         					<tr onclick="ShowDetail(<%=volist.get(i).getNotice_title() %>)">							
								<tr onclick="ShowDetail(<%=volist.get(i).getNotice_time() %>)">
								<tr onclick="ShowDetail(<%=volist.get(i).getNotice_cate_no() %>)">
								
								</tr>
								<%
								}
								}else{ 
								%>
								<tr>
									<td colspan="3">�Խñ��� �����ϴ�.</td>
									</tr>
						<%
						}
					%> --%>
					</tbody>	
			</div>
		</div>
		   <div id="pageBtnAll">
        <%if(startPage > 1){%>
            <a class="pageBtn" href="fquestionboard?catenum=<%=catenum%>&pagenum=<%=startPage-1%>"><i class="fas fa-chevron-left"></i></a>
            <%} %>
            <%for (int i = startPage; i <= endPage; i++) {%>
            <a id="pageBtn_<%=i%>" class="pageBtn" href="fquestionboard?catenum=<%=catenum%>&pagenum=<%=i%>"><%=i%></a>
            <%} %>
            <%if(endPage < pageCount){%>
            <a class="pageBtn" href="fquestionboard?catenum=<%=catenum%>&pagenum=<%=endPage+1%>"><i class="fas fa-chevron-right"></i></a>
            <%} %>
        </div>
	
	
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>
	
</body>
</html>