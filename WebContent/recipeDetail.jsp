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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/recipeDetail.css"/>
<title>밥도둑_레시피 상세조회</title>
</head>
<body>
	<%@ include file="../WEB-INF/riceThief_header.jsp" %>
	<hr>
    <main>
        <div id="detailImgContainer">
            <img src="./css/alt.JPG" id="titleImg" alt="레시피 대표 사진">
            <a href="#" id="updateRecipe"><i class="fas fa-edit"></i></a>
            <a href="#" id="deleteRecipe"><i class="fas fa-trash-alt"></i></a>
            <a href="#" id="likeRecipe"><i class="far fa-heart"></i></a>
            <a href="#" id="shareRecipe"><i class="fas fa-share-square"></i></a>
        </div>
        <div id="detailTitleContainer">
            <h2 id="detailTitle" class="categoryRecipeTitle">레시피이름</h2>
            <p id="detailIntro">레시피 소개 [레시피 소개글이 문장형태로 와르르르르 적혀있을 겁니다. 더미로 넣는 텍스트 이니 신경쓰지 마세요.]</p>
        </div>
        <div id="detailInfoContainer">
            <div>
                <p class="infoIcon"><i class="fas fa-users"></i></p>
                <p id="detailServing" class="infoText">1인분</p>
            </div>
            <div>
                <p class="infoIcon"><i class="fas fa-stopwatch"></i></p>
                <p id="detailTime" class="infoText">30분 이내</p>
            </div>
            <div>
                <P class="infoIcon"><i class="fas fa-cookie-bite"></i></P>
                <p id="detailLevel" class="infoText">초급</p>
            </div>
        </div>
        <div id="detailIngreContainer">
            <h2>재료</h2>
            <ul id="detailIngre">
                <li><p>식빵</p><p>1장</p></li>
                <li><p>식빵</p><p>1장</p></li>
                <li><p>식빵</p><p>1장</p></li>
                <li><p>식빵</p><p>1장</p></li>
                <li><p>식빵</p><p>1장</p></li>
                <li><p>식빵</p><p>1장</p></li>
                <li><p>식빵</p><p>1장</p></li>
            </div>
        </div>
        <div id="detailStepContainer">
            <h2>레시피 순서</h2>
            <ul id="detailStep">
                <li>
                    <h2>Step 1</h2>
                    <div class="stepContent">
                        <p>먼저 식빵을 가위로 잘게 잘라 줍니다.먼저 식빵을 가위로 잘게 잘라 줍니다.먼저 식빵을 가위로 잘게 잘라 줍니다.먼저 식빵을 가위로 잘게 잘라 줍니다.먼저 식빵을 가위로 잘게 잘라 줍니다.</p>
                        <img src="./css/alt.JPG" id="stepImg" alt="레시피 순서">
                    </div>
                </li>
                <li>
                    <h2>Step 1</h2>
                    <div class="stepContent">
                        <p>먼저 식빵을 가위로 잘게 잘라 줍니다.먼저 식빵을 가위로 잘게 잘라 줍니다.먼저 식빵을 가위로 잘게 잘라 줍니다.먼저 식빵을 가위로 잘게 잘라 줍니다.먼저 식빵을 가위로 잘게 잘라 줍니다.</p>
                        <img src="./css/alt.JPG" id="stepImg" alt="레시피 순서">
                    </div>
                </li>
            </ul>
        </div>
        <div id="detailCommentContainer">
            <h2>댓글 남기기</h2>
			<form method="get" action="#" id="commentFrm">
                <input type="hidden" name="bno" readonly>
                <input type="hidden" name="comment"  value="comment" readonly>
                <textarea name="content" id="commentInput" required="required"></textarea>
				<button type="submit" id="commentSubmitBtn">등록</button>
			</form>
            <ul>
                <hr>
                <li>
                <hr class="clear">
                    <div class="commentUser">
                        <i class="far fa-comment"></i>
                        <p>user1</p>
                    </div>
                    <p class="commentContent">댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용</p>
                </li>
                <hr class="clear">
                <li>
                    <div class="commentUser">
                        <i class="far fa-comment"></i>
                        <p>user1</p>
                    </div>
                    <p class="commentContent">댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용</p>
                </li>
                <hr class="clear">
                <li>
                    <div class="commentUser">
                        <i class="far fa-comment"></i>
                        <p>user1</p>
                    </div>
                    <p class="commentContent">댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용</p>
                </li>
                <hr class="clear">
            </ul>
        </div>
    </main>
    <hr>
    <%@ include file="../WEB-INF/riceThief_footer.jsp" %>
</body>
</html>