<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template_header.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template_footer.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/mainpage.css" />  <!-- 내파일 css -->

<!-- jquey -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- title -->
<title>Insert title here</title>
</head>
<body>
	<%@ include file="riceThief_header.jsp" %>
	
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