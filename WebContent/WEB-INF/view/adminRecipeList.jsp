<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<!-- footer css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/recipeCategory.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/userlist.css" />
<%@page import="recipe.model.vo.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/mypage.js"></script>
<title>관리자_레시피 리스트</title>
</head>
<body>
	<% 
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	ArrayList<Recipe> volist = (ArrayList<Recipe>)request.getAttribute("recipeVoList");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	int catenum = (int)request.getAttribute("catenum");
%>
<script>
var result33 = "${result33}";
console.log(result33);
if(result33 == "검색값없음"){
	alert("일치된 레시피 없음");
}
</script>
	<%@ include file="riceThief_adminHeader.jsp"%>
	<hr>
	<main>
		<h2>Recipe</h2>
		<div id="categoryBtnAll">
			<a href="adminRecipeList?catenum=<%=0%>" id="0"class="categoryBtn selectBtnColor">전체</a> 
			<a href="adminRecipeList?catenum=<%=63%>" id="63" class="categoryBtn">밑반찬</a>
			<a href="adminRecipeList?catenum=<%=56%>" id="56" class="categoryBtn">메인반찬</a>
			<a href="adminRecipeList?catenum=<%=54%>" id="54" class="categoryBtn">국/탕</a>
			<a href="adminRecipeList?catenum=<%=55%>" id="55" class="categoryBtn">찌개</a>
			<a href="adminRecipeList?catenum=<%=60%>" id="60" class="categoryBtn">디저트</a>
			<a href="adminRecipeList?catenum=<%=53%>" id="53" class="categoryBtn">면/만두</a>
			<a href="adminRecipeList?catenum=<%=52%>" id="52" class="categoryBtn">밥/죽/떡</a>
			<a href="adminRecipeList?catenum=<%=61%>" id="61" class="categoryBtn">퓨전</a>
			<a href="adminRecipeList?catenum=<%=57%>" id="57" class="categoryBtn">김치/젓갈/장</a>
			<a href="adminRecipeList?catenum=<%=58%>" id="58" class="categoryBtn">양념/소스/잼</a>
			<a href="adminRecipeList?catenum=<%=65%>" id="65" class="categoryBtn">양식</a>
			<a href="adminRecipeList?catenum=<%=64%>" id="64" class="categoryBtn">샐러드</a>
			<a href="adminRecipeList?catenum=<%=68%>" id="68" class="categoryBtn">스프</a>
			<a href="adminRecipeList?catenum=<%=66%>" id="66" class="categoryBtn">빵</a>
			<a href="adminRecipeList?catenum=<%=69%>" id="69" class="categoryBtn">과자</a>
			<a href="adminRecipeList?catenum=<%=59%>" id="59" class="categoryBtn">차/음료/술</a>
			<a href="adminRecipeList?catenum=<%=62%>" id="62" class="categoryBtn">기타</a>
		</div>
		
		<form action="selectrecipe" method="get">
			<div class='right-box'>
				<input type="text" name="recipe_name" id="name1" placeholder="레시피 검색">
				<input type="submit" id="recipe_name" value="검색">
			</div>
		</form>
		<div class="board_list_wrap">
			<form method="get" action="selectrecipe">
				<table class="board_list">
					<thead>
						<tr>
							<th>레시피 이미지</th>
							<th>레시피 번호</th>
							<th>레시피 제목</th>
							<th>작성자</th>
							<th>상세 정보 조회</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<%if(volist != null){
	            	for(Recipe vo : volist){ %>
	            			<td><div><img src="<%=vo.getRec_img() %>" class="categoryImg" alt="추천 상품"></div></td>
	            			<td><%=vo.getRecipe_no() %></td>
	            			<td><%=vo.getRec_title() %></td>
	            			<td><%=vo.getUid()%></td>
	            			
	            			<td><button type="submit" class="info_btn" value="<%=vo.getRecipe_no()%>" name ="rno">수정 </button>
	            			</td>
						
						</tr>
						<%} } %>
					</tbody>
				</table>
			</form>
			<div class="paging">

				<%
					if (startPage > 1) {
				%>
				<a href="./adminRecipeList?pagenum=<%=startPage - 1%>" class="num">이전</a>
				<%
					}
				%>
				<%
					for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="./adminRecipeList?pagenum=<%=i%>" class="num"><%=i%></a>
				<%
					}
				%>
				<%
					if (endPage < pageCount) {
				%>
				<a href="./adminRecipeList?pagenum=<%=endPage + 1%>" class="num">다음</a>
				<%
					}
				%>

			</div>
		</div>
	</main>
	<hr>
	<%@ include file="riceThief_footer.jsp"%>