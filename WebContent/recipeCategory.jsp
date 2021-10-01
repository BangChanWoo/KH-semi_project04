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
	<%@ include file="../WEB-INF/riceThief_header.jsp" %>
	<hr>
    <main>
        <h2>Recipe</h2>
        <div id="categoryBtnAll">
            <button type="button" id="all" class="categoryBtn selectBtnColor">전체</button>
            <button type="button" id="63" class="categoryBtn">밑반찬</button>
            <button type="button" id="56" class="categoryBtn">메인반찬</button>
            <button type="button" id="54" class="categoryBtn">국/탕</button>
            <button type="button" id="55" class="categoryBtn">찌개</button>
            <button type="button" id="60" class="categoryBtn">디저트</button>
            <button type="button" id="53" class="categoryBtn">면/만두</button>
            <button type="button" id="52" class="categoryBtn">밥/죽/떡</button>
            <button type="button" id="61" class="categoryBtn">퓨전</button>
            <button type="button" id="57" class="categoryBtn">김치/젓갈/장류</button>
            <button type="button" id="58" class="categoryBtn">양념/소스/잼</button>
            <button type="button" id="65" class="categoryBtn">양식</button>
            <button type="button" id="64" class="categoryBtn">샐러드</button>
            <button type="button" id="68" class="categoryBtn">스프</button>
            <button type="button" id="66" class="categoryBtn">빵</button>
            <button type="button" id="69" class="categoryBtn">과자</button>
            <button type="button" id="59" class="categoryBtn">차/음료/술</button>
            <button type="button" id="62" class="categoryBtn">기타</button>
        </div>
        <div>
            <!--여기 java에서 for문으로 사진 <5 으로 5개까지 데이터 들고옴-->
            <!--일단 structure-->
            <div class="imgCenter">
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
                <div>
                    <img src="./css/alt.JPG" class="categoryImg" alt="추천 레시피">
                    <p class="categoryRecipeTitle">레시피이름</p>
                </div>
            </div>
        </div>
        <div id="pageBtnAll">
            <button type="button" id="" class="pageBtn"><i class="fas fa-chevron-left"></i></button>
            <button type="button" id="" class="pageBtn selectBtnColor">1</button>
            <button type="button" id="" class="pageBtn">2</button>
            <button type="button" id="" class="pageBtn">3</button>
            <button type="button" id="" class="pageBtn">4</button>
            <button type="button" id="" class="pageBtn">5</button>
            <button type="button" id="" class="pageBtn"><i class="fas fa-chevron-right"></i></button>
        </div>
    </main>
    <hr>
	<%@ include file="../WEB-INF/riceThief_footer.jsp" %>
</body>
</html>