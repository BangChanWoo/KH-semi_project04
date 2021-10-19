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
<title>Insert title here</title>
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
	/* TODO */
	/* ArrayList<Question> volist = (ArrayList<Question>)request.getAttribute("questionList");	 */
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
			<a href="fquestionboard?catenum=<%=1%>" id="1" class="cateBtn">자주묻는질문</a>
			<a href="questionboard?catenum=<%=2%>" id="2" class="cateBtn">1대1문의</a>
		</div>
		<div id="n2">
		<div class="question_title">
			<h2>1대1문의</h2>
		</div>
		
	</div>
	</main>
	
	<hr>
	<!-- 1대1문의 화면 -->
		<div class="container">
		<!-- TODO -->
			<%-- <div class="question_row">
				<table class="question board" style="text-align: center; border:1px solid#ddddd">
				<thead>
					<tr>
						<th colspan="5" style="background-color: #eeeeee; text-align: center;">질문목록</th>
					</tr>
					</thead>
					
					<tbody>
						<tr>
							<td style="background-color: #eeeeeee; text-align: center;">번호</td>
							<td style="background-color: #eeeeeee; text-align: center;">제목</td>
							<td style="background-color: #eeeeeee; text-align: center;">작성시간</td>
							<td style="background-color: #eeeeeee; text-align: center;">카테고리 번호</td>
					</tr>
					<%
						if(voList.size() > 0){
							for(int i =0; i<1; i++){
								%>
								<tr onclick="ShowDetail(<%=volist.get(i).getQue_no() %>)">
	         					<tr onclick="ShowDetail(<%=volist.get(i).getNotice_title() %>)">							
								<tr onclick="ShowDetail(<%=volist.get(i).getNotice_time() %>)">
								<tr onclick="ShowDetail(<%=volist.get(i).getNotice_cate_no() %>)">
								
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
        </div> --%>
	
	
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>

</body>
</html>