<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/mypage.js"></script>
<title>밥도둑 자주묻는질문 카테고리</title>
</head>
<body>
<% 
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	/* TODO */
	/* ArrayList<Fquestion> volist = (ArrayList<Fquestion>) request.getAttribute("fquestionVoList"); */
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	int catenum = (int)request.getAttribute("catenum");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <h2>fquestion</h2>
        <div id="categoryBtnAll">
            <a href="fquestionboard?catenum=<%=0%>" id="0" class="categoryBtn selectBtnColor">전체</a>
            <a href="fquestionboard?catenum=<%=%>" id="" class="categoryBtn">결제취소/배송</a>
            <a href="fquestionboard?catenum=<%=%>" id="" class="categoryBtn">환불/반품</a>
            <a href="fquestionboard?catenum=<%=%>" id="" class="categoryBtn">구매/결제/포인트</a>
            <a href="fquestionboard?catenum=<%=%>" id="" class="categoryBtn">회원/기타</a>
        </div>
        <div>
            <div class="fquestionboard">
	          <%--   <%if(volist != null){
	            	for(frequencyquestion vo : volist){ %>
	            <div>
                    <a href="selectfquestion?fqno=<%=vo.getfquestion_no()%>"></a>
                    <div class="categoryfquestionTitle"><a href="selectfquestion?fqno=<%=vo.getfquestion_no()%>"><%=vo.getfquestion_title() %></a></div>
                </div>
	            <% } }%> --%>
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
    </main>
    <hr>
	<%@ include file="riceThief_footer.jsp" %>

</body>
</html>