<%@page import="product_post.vo.ProductPost"%>
<%@page import="recipe.model.vo.Recipe"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/search.css"/>
<title>밥도둑_검색</title>
</head>
<body>
<% 
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	ArrayList<Recipe> recipeRecommendList = (ArrayList<Recipe>)request.getAttribute("recipeRecommendList");
	ArrayList<ProductPost> productRecommendList = (ArrayList<ProductPost>)request.getAttribute("productRecommendList");
	ArrayList<Recipe> recipeSearchList = (ArrayList<Recipe>)request.getAttribute("recipeSearchList");
	ArrayList<ProductPost> productSearchList = (ArrayList<ProductPost>)request.getAttribute("productSearchList");
	int r_startPage = (int)request.getAttribute("r_startPage");
	int r_endPage = (int)request.getAttribute("r_endPage");
	int r_pageCount = (int)request.getAttribute("r_pageCount");
	int p_startPage = (int)request.getAttribute("p_startPage");
	int p_endPage = (int)request.getAttribute("p_endPage");
	int p_pageCount = (int)request.getAttribute("p_pageCount");
	String searchField = (String)request.getAttribute("searchField");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
    	<div id="searchContainer">
    		<form method="post" action="search" id="searchFrm">
	    		<c:if test="${not empty searchField}">
	    			<input name="searchField" id="searchField" value="${searchField}">
	    		</c:if>
	    		<c:if test="${empty searchField}">
	    			<input name="searchField" id="searchField">
	    		</c:if>
	    		<button type="submit" id="searchBtn"><i class="fas fa-search"></i></button>
	    	</form>
    	</div>
    	<hr class="clear" style="margin-bottom: 1rem">
    	<c:choose>
    	<c:when test="${empty check}">
	    	<input type="radio" id="rd_recipe" name="tab" checked>
		    <input type="radio" id="rd_store" name="tab">
    	</c:when>
    	<c:when test="${check == 'recipe'}">
	    	<input type="radio" id="rd_recipe" name="tab" checked>
		    <input type="radio" id="rd_store" name="tab">
    	</c:when>
    	<c:when test="${check == 'product'}">
	    	<input type="radio" id="rd_recipe" name="tab">
		    <input type="radio" id="rd_store" name="tab" checked>
    	</c:when>
    	</c:choose>
	    <label for="rd_store" id="storeBtn">스토어</label>
	    <label for="rd_recipe" id="recipeBtn">레시피</label>
        <c:if test="${not empty recipeRecommendList}">
        	<div id="recipeList" class="tab_item">
	        	<h2>인기 레시피</h2>
	            <div class="imgCenter">
		            <%if(recipeRecommendList != null){
		            	for(Recipe vo : recipeRecommendList){ %>
		            <div>
	                    <a href="selectrecipe?rno=<%=vo.getRecipe_no()%>"><img src="<%=vo.getRec_img() %>" class="categoryImg" alt="인기레시피"></a>
	                    <div class="categoryRecipeTitle"><a href="selectrecipe?rno=<%=vo.getRecipe_no()%>"><%=vo.getRec_title() %></a></div>
	                </div>
		            <% } }%>
	            </div>
	        </div>
	        <div id="storeList" class="tab_item">
	        	<h2>인기 상품</h2>
	            <div class="imgCenter">
		            <%if(productRecommendList != null){
		            	for(ProductPost vo : productRecommendList){ %>
		            <div>
	                    <a href="#"><img src="<%=vo.getPro_img()%>" class="categoryImg" alt="인기 상품"></a>
	                    <div class="categoryRecipeTitle"><a href="#"><%=vo.getPro_title() %></a></div>
	                </div>
		            <% } }%>
	            </div>
	        </div>
        </c:if>
        <c:if test="${not empty recipeSearchList}">
        	<div id="recipeList" class="tab_item">
	        	<h2>레시피</h2>
	            <div class="imgCenter">
		            <%if(recipeSearchList != null){
		            	for(Recipe vo : recipeSearchList){ %>
		            <div>
	                    <a href="selectrecipe?rno=<%=vo.getRecipe_no()%>"><img src="<%=vo.getRec_img() %>" class="categoryImg" alt="검색 레시피"></a>
	                    <div class="categoryRecipeTitle"><a href="selectrecipe?rno=<%=vo.getRecipe_no()%>"><%=vo.getRec_title() %></a></div>
	                </div>
		            <% } }%>
	            </div>
	            <div id="pageBtnAll">
		        <%if(r_startPage > 1){%>
		            <a class="pageBtn" href="search?searchField=<%=searchField%>&r_pagenum=<%=r_startPage-1%>&check=recipe"><i class="fas fa-chevron-left"></i></a>
		            <%} %>
		            <%for (int i = r_startPage; i <= r_endPage; i++) {%>
		            <a id="pageBtn_<%=i%>" class="pageBtn" href="search?searchField=<%=searchField%>&r_pagenum=<%=i%>&check=recipe"><%=i%></a>
		            <%} %>
		            <%if(r_endPage < r_pageCount){%>
		            <a class="pageBtn" href="search?searchField=<%=searchField%>&r_pagenum=<%=r_endPage+1%>&check=recipe"><i class="fas fa-chevron-right"></i></a>
		            <%} %>
		        </div>
	        </div>
	        <div id="storeList" class="tab_item">
	        	<div class="imgCenter">
		            <%if(productSearchList != null){
		            	for(ProductPost vo : productSearchList){ %>
		            <div>
	                    <a href="#"><img src="<%=vo.getPro_img()%>" class="categoryImg" alt="검색 상품"></a>
	                    <div class="categoryRecipeTitle"><a href="#"><%=vo.getPro_title()%></a></div>
	                </div>
		            <% } }%>
	            </div>
	            <div id="pageBtnAll">
		        <%if(r_startPage > 1){%>
		            <a class="pageBtn" href="search?searchField=<%=searchField%>&p_pagenum=<%=p_startPage-1%>&check=product"><i class="fas fa-chevron-left"></i></a>
		            <%} %>
		            <%for (int i = p_startPage; i <= p_endPage; i++) {%>
		            <a id="pageBtn_<%=i%>" class="pageBtn" href="search?searchField=<%=searchField%>&p_pagenum=<%=i%>&check=product"><%=i%></a>
		            <%} %>
		            <%if(p_endPage < p_pageCount){%>
		            <a class="pageBtn" href="search?searchField=<%=searchField%>&p_pagenum=<%=p_endPage+1%>&check=product"><i class="fas fa-chevron-right"></i></a>
		            <%} %>
		        </div>
	        </div>
        </c:if>
    </main>
    <hr>
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>