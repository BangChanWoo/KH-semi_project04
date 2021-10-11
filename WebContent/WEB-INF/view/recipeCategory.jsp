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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/recipeCategory.css"/>
<title>밥도둑_레시피 카테고리</title>
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
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <h2>Recipe</h2>
        <div id="categoryBtnAll">
            <a href="recipeboard?catenum=<%=0%>" id="0" class="categoryBtn selectBtnColor">전체</a>
            <a href="recipeboard?catenum=<%=63%>" id="63" class="categoryBtn">밑반찬</a>
            <a href="recipeboard?catenum=<%=56%>" id="56" class="categoryBtn">메인반찬</a>
            <a href="recipeboard?catenum=<%=54%>" id="54" class="categoryBtn">국/탕</a>
            <a href="recipeboard?catenum=<%=55%>" id="55" class="categoryBtn">찌개</a>
            <a href="recipeboard?catenum=<%=60%>" id="60" class="categoryBtn">디저트</a>
            <a href="recipeboard?catenum=<%=53%>" id="53" class="categoryBtn">면/만두</a>
            <a href="recipeboard?catenum=<%=52%>" id="52" class="categoryBtn">밥/죽/떡</a>
            <a href="recipeboard?catenum=<%=61%>" id="61" class="categoryBtn">퓨전</a>
            <a href="recipeboard?catenum=<%=57%>" id="57" class="categoryBtn">김치/젓갈/장</a>
            <a href="recipeboard?catenum=<%=58%>" id="58" class="categoryBtn">양념/소스/잼</a>
            <a href="recipeboard?catenum=<%=65%>" id="65" class="categoryBtn">양식</a>
            <a href="recipeboard?catenum=<%=64%>" id="64" class="categoryBtn">샐러드</a>
            <a href="recipeboard?catenum=<%=68%>" id="68" class="categoryBtn">스프</a>
            <a href="recipeboard?catenum=<%=66%>" id="66" class="categoryBtn">빵</a>
            <a href="recipeboard?catenum=<%=69%>" id="69" class="categoryBtn">과자</a>
            <a href="recipeboard?catenum=<%=59%>" id="59" class="categoryBtn">차/음료/술</a>
            <a href="recipeboard?catenum=<%=62%>" id="62" class="categoryBtn">기타</a>
        </div>
        <div>
            <!--여기 java에서 for문으로 사진 <5 으로 5개까지 데이터 들고옴-->
            <!--일단 structure-->
            <div class="imgCenter">
	            <%if(volist != null){
	            	for(Recipe vo : volist){ %>
	            <div>
                    <a href="selectrecipe?rno=<%=vo.getRecipe_no()%>"><img src="<%=vo.getRec_img() %>" class="categoryImg" alt="추천 레시피"></a>
                    <div class="categoryRecipeTitle"><a href="selectrecipe?rno=<%=vo.getRecipe_no()%>"><%=vo.getRec_title() %></a></div>
                </div>
	            <% } }%>
            </div>
        </div>
        <div id="pageBtnAll">
        <%if(startPage > 1){%>
            <a class="pageBtn" href="recipeboard?catenum=<%=catenum%>&pagenum=<%=startPage-1%>"><i class="fas fa-chevron-left"></i></a>
            <%} %>
            <%for (int i = startPage; i <= endPage; i++) {%>
            <a id="pageBtn_<%=i%>" class="pageBtn" href="recipeboard?catenum=<%=catenum%>&pagenum=<%=i%>"><%=i%></a>
            <%} %>
            <%if(endPage < pageCount){%>
            <a class="pageBtn" href="recipeboard?catenum=<%=catenum%>&pagenum=<%=endPage+1%>"><i class="fas fa-chevron-right"></i></a>
            <%} %>
        </div>
    </main>
    <hr>
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>