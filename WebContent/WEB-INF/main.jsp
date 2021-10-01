<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/mainpage.css"/>
<title>밥도둑_메인</title>
</head>
<body>
	<%@ include file="../WEB-INF/riceThief_header.jsp" %>

	<main>
        <div>
            <img src="./css/alt.JPG" id="slideImg" alt="slide show">
        </div>
        <div>
            <h2 class="title-font">추천 레시피</h2>
            <div id="recommendRecipe">
                <!--여기 java에서 for문으로 사진 <5 으로 5개까지 데이터 들고옴-->
                <!--일단 structure-->
                <img src="./css/alt.JPG" class="recommendImg" alt="추천 레시피">
                <img src="./css/alt.JPG" class="recommendImg" alt="추천 레시피">
                <img src="./css/alt.JPG" class="recommendImg" alt="추천 레시피">
                <img src="./css/alt.JPG" class="recommendImg" alt="추천 레시피">
                <img src="./css/alt.JPG" class="recommendImg" alt="추천 레시피">
            </div>
        </div>
        <div id="prContainer">
            <h2 class="title-font">인기 레시피</h2>
            <div id="popularRecipe">
                <img src="./css/alt.JPG" class="popularImg" alt="추천 레시피">
            </div>
        </div>
        <div>
            <h2 class="title-font">인기 상품</h2>
            <img src="./css/alt.JPG" alt="인기 상품">
        </div>
    </main>
    <hr>

	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>
