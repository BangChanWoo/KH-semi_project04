<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/productCategory.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/userlist.css" />
<%@page import="product_post.vo.ProductPost"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script type="text/javascript" src="./js/mypage.js"></script>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<title>관리자_상품리스트</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<% 
	ArrayList<ProductPost> volist = (ArrayList<ProductPost>)request.getAttribute("productVolist");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	int catenum = (int)request.getAttribute("catenum");
%>
<script>
var result33 = "${result33}";
console.log(result33);
if(result33 == "검색값없음"){
	alert("일치된 사용자 없음");
}
</script>
	<%@ include file="riceThief_adminHeader.jsp"%>
	<hr>
	<main>
		<h2>Store</h2>
		<div id="categoryBtnAll">
			<a href="adminProductListServlet?catenum=<%=0%>" id="0"
				class="categoryBtn selectBtnColor">전체</a> <a
				href="adminProductListServlet?catenum=<%=6001%>" id="6001" class="categoryBtn">국/찌개/탕</a>
			<a href="adminProductListServlet?catenum=<%=6002%>" id="6002"
				class="categoryBtn">김치/젓갈/반찬</a> <a
				href="adminProductListServlet?catenum=<%=6003%>" id="6003" class="categoryBtn">밀키트</a>
			<a href="adminProductListServlet?catenum=<%=6004%>" id="6004"
				class="categoryBtn">만두/돈까스</a> <a
				href="adminProductListServlet?catenum=<%=6005%>" id="6005" class="categoryBtn">치킨/피자/튀김</a>
			<a href="adminProductListServlet?catenum=<%=6006%>" id="6006"
				class="categoryBtn">냉동면류/냉동밥</a> <a
				href="adminProductListServlet?catenum=<%=6007%>" id="6007" class="categoryBtn">양념육/해물요리</a>
			<a href="adminProductListServlet?catenum=<%=6008%>" id="6008"
				class="categoryBtn">샐러드/도시락</a>
		</div>
		 <form action="updateGetProductServlet" method="get">
		<div class='right-box'>
			<input type="text" name = "pro_name" id="name1" placeholder="상품 명 검색">
			<input type="submit" id="product_search"value="검색" >
		</div>
		</form>
		<div class="board_list_wrap">
			<form method="get" action="updateGetProductServlet">
				<table class="board_list">
					<thead>
						<tr>
							<th>상품 이미지</th>
							<th>상품 번호</th>
							<th>상품 명</th>
							<th>상품 가격</th>
							<th>상세 정보 조회</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<%if(volist != null){
	            			for(ProductPost vo : volist){ %>
	            			<td><div><img src="<%=vo.getPro_img() %>" class="categoryImg" alt="추천 상품"></div></td>
							<td><%=vo.getPro_no() %></td>
							<td><%=vo.getPro_title() %></td>
							<td><%=vo.getPro_price() %></td>
							<td><button type="submit" class="info_btn" value="<%=vo.getPro_no()%>" name ="pro_no">수정 및 삭제</button></td>

						</tr>
						<%} } %>
					</tbody>
				</table>
			</form>
			<div class="paging">
				
				<%
					if (startPage > 1) {
				%>
				<a href="./SelectUserServlet?pagenum=<%=startPage - 1%>" class="num">이전</a>
				<%
					}
				%>
				<%
					for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="./selectsals?pagenum=<%=i%>" class="num"><%=i%></a>
				<%
					}
				%>
				<%
					if (endPage < pageCount) {
				%>
				<a href="./SelectUserServlet?pagenum=<%=endPage + 1%>" class="num">다음</a>
				<%
					}
				%>
				
			</div>
		</div>
	</main>
	<hr>
	<%@ include file="riceThief_footer.jsp"%>
	
</body>
</html>