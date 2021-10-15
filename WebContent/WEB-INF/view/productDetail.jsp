<%@page import="product_post.vo.ProductPost"%>
<%@page import="product_img.vo.ProductImg"%>
<%@page import="product_option.vo.ProductOption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jquery -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->

<title>밥도둑_스토어 상품 상세조회</title>

</head>
<body>
<%
	//To-do : 로그인해야지만 장바구&바로구매 연결
	
	/* User memberLoginInfo = (User)request.getSession().getAttribute("loginInfo");
	String id = null;
	if(memberLoginInfo != null){
		id = memberLoginInfo.getUid();
	}
	*/
	
	ProductPost vo = (ProductPost)request.getAttribute("vo");
	int rno = (int)request.getAttribute("rno"); 
	
	ArrayList<ProductOption> optionList = (ArrayList<ProductOption>)request.getAttribute("optionList");
	ArrayList<ProductImg> proImgList = (ArrayList<ProductImg>)request.getAttribute("proImgList");
	
	//리뷰&후기
	//ArrayList<Comment> commentList = (ArrayList<Comment>)request.getAttribute("commentList");

	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");

%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <div id="detailImgContainer">
            <img src="<%=vo.getPro_img()%>" id="titleImg" alt="상품 대표 사진">
        </div>
        
        <!-- 화면구현 순서 : 상품명/가격(옆에 : 좋아요/공유)/별점/배송비/옵션/옵션이름/수량 (옆에: 가격)/ 밑줄/ 상품금액 / 합계금액 / 장바구니 버튼, 바로구매 버튼  -->
        
        <div>
     	    <h2 id="detailTitle" class="categoryProductTitle"><%=vo.getPro_title()%></h2>
     	</div>
     	<div>
     	    <h3 id="detailPrice" class="categoryProductPrice"><%=vo.getPro_price()%></h3>
     	       
            <c:if test="${not empty id}">
            <a href="#" id="likeProduct"><i class="far fa-heart"></i></a>
            </c:if>
            <a href="#" id="shareProduct"><i class="fas fa-share-square"></i></a> 	    
 	    </div>
 	    <div>
 	    	<!-- 별점 -->
 	    </div>
 	    <div>
 	    	<!-- 배송비 -->
 	    </div>
 	    
       
     </main>
    <%@ include file="riceThief_footer.jsp" %>
</body>
</html>
