<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/productCategory.css" />
<%@page import="product_post.vo.ProductPost"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script type="text/javascript" src="./js/mypage.js"></script>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<title>마이페이지_관심 상품</title>
</head>
<body>
<%
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	
	ArrayList<ProductPost> interProList = (ArrayList<ProductPost>)request.getAttribute("interProduct");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <h2>관심 상품</h2>
			<div class="imgCenter">
	            <%if(interProList != null){
	            	for(ProductPost vo : interProList){ %>
	            <div>
                    <a href="selectproduct?rno=<%=vo.getPro_no()%>"><img src="<%=vo.getPro_img() %>" class="categoryImg" alt="추천 상품"></a>
                    <div class="categoryProductTitle"><a href="selectproduct?rno=<%=vo.getPro_no()%>"><%=vo.getPro_title() %></a></div>
                    <div class="categoryProductPrice"><a href="selectproduct?rno=<%=vo.getPro_no()%>"><%=vo.getPro_price() %></a>원</div>
                </div>
	            <% } }%>
            </div>
    </main>
    <hr>
	<%@ include file="riceThief_footer.jsp" %>    
        
        
</body>
</html>