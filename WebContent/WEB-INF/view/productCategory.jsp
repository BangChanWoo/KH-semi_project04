<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/productCategory.css"/>
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
<title>밥도둑_스토어 카테고리</title>
</head>
<body>
<% 
	ArrayList<ProductPost> volist = (ArrayList<ProductPost>)request.getAttribute("productVolist");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	int catenum = (int)request.getAttribute("catenum");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <h2>Store</h2>
        <div id="categoryBtnAll">
            <a href="productboard?catenum=<%=0%>" id="0" class="categoryBtn selectBtnColor">전체</a>
            <a href="productboard?catenum=<%=6001%>" id="6001" class="categoryBtn">국/찌개/탕</a>
            <a href="productboard?catenum=<%=6002%>" id="6002" class="categoryBtn">김치/젓갈/반찬</a>
            <a href="productboard?catenum=<%=6003%>" id="6003" class="categoryBtn">밀키트</a>
            <a href="productboard?catenum=<%=6004%>" id="6004" class="categoryBtn">만두/돈까스</a>
            <a href="productboard?catenum=<%=6005%>" id="6005" class="categoryBtn">치킨/피자/튀김</a>
            <a href="productboard?catenum=<%=6006%>" id="6006" class="categoryBtn">냉동면류/냉동밥</a>
            <a href="productboard?catenum=<%=6007%>" id="6007" class="categoryBtn">양념육/해물요리</a>
            <a href="productboard?catenum=<%=6008%>" id="6008" class="categoryBtn">샐러드/도시락</a>
        </div>
         <div>
        	
            <!--일단 structure-->
            <div class="imgCenter">
	            <%if(volist != null){
	            	for(ProductPost vo : volist){ %>
	            <div>
                    <a href="selectproduct?rno=<%=vo.getPro_no()%>"><img src="<%=vo.getPro_img() %>" class="categoryImg" alt="추천 상품"></a>
                    <div class="categoryProductTitle"><a href="selectproduct?rno=<%=vo.getPro_no()%>"><%=vo.getPro_title() %></a></div>
                    <div class="categoryProductPrice"><a href="selectproduct?rno=<%=vo.getPro_no()%>"><%=vo.getPro_price() %></a>원</div>
                </div>
	            <% } }%>
            </div>
        </div>
        <div id="pageBtnAll">
        <%if(startPage > 1){%>
            <a class="pageBtn" href="productboard?catenum=<%=catenum%>&pagenum=<%=startPage-1%>"><i class="fas fa-chevron-left"></i></a>
            <%} %>
            <%for (int i = startPage; i <= endPage; i++) {%>
            <a id="pageBtn_<%=i%>" class="pageBtn" href="productboard?catenum=<%=catenum%>&pagenum=<%=i%>"><%=i%></a>
            <%} %>
            <%if(endPage < pageCount){%>
            <a class="pageBtn" href="prudctboard?catenum=<%=catenum%>&pagenum=<%=endPage+1%>"><i class="fas fa-chevron-right"></i></a>
            <%} %>
        </div>
        
        
    </main>
    <hr>
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>