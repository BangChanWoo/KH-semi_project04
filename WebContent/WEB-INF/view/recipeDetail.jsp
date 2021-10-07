<%@page import="recipe_steps.vo.RecipeSteps"%>
<%@page import="ingredient.vo.Ingredient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="recipe.model.vo.Recipe"%>
<%@page import="user.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%
	User memberLoginInfo = (User)request.getSession().getAttribute("loginInfo");
	String id = null;
	if(memberLoginInfo != null){
		id = memberLoginInfo.getUid();
	}
	Recipe vo = (Recipe)request.getAttribute("vo");
	int rno = (int)request.getAttribute("rno");

	ArrayList<Ingredient> ingreList = (ArrayList<Ingredient>)request.getAttribute("ingreList");
	ArrayList<RecipeSteps> stepList = (ArrayList<RecipeSteps>)request.getAttribute("stepList");
	ArrayList<Recipe> commentList = (ArrayList<Recipe>)request.getAttribute("commentList");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <div id="detailImgContainer">
            <img src="<%=vo.getRec_img() %>" id="titleImg" alt="레시피 대표 사진">
            <c:if test="${id == vo.getUid() or id == 'admin'}">
            <a href="updateget?rno=<%=rno%>" id="updateRecipe"><i class="fas fa-edit"></i></a>
            <a href="#" onclick="deleteAlert()" id="deleteRecipe"><i class="fas fa-trash-alt"></i></a>
            </c:if>
            <c:if test="${not empty id}">
            <a href="#" id="likeRecipe"><i class="far fa-heart"></i></a>
            </c:if>
            <a href="#" id="shareRecipe"><i class="fas fa-share-square"></i></a>
        </div>
        <div id="detailTitleContainer">
            <h2 id="detailTitle" class="categoryRecipeTitle"><%=vo.getRec_title()%></h2>
            <p id="detailIntro"><%=vo.getRec_summary()%></p>
        </div>
        <div id="detailInfoContainer">
            <div>
                <p class="infoIcon"><i class="fas fa-users"></i></p>
                <p id="detailServing" class="infoText"><%=vo.getInfo_serving()%></p>
            </div>
            <div>
                <p class="infoIcon"><i class="fas fa-stopwatch"></i></p>
                <p id="detailTime" class="infoText"><%=vo.getInfo_time()%></p>
            </div>
            <div>
                <P class="infoIcon"><i class="fas fa-cookie-bite"></i></P>
                <p id="detailLevel" class="infoText"><%=vo.getInfo_level()%></p>
            </div>
        </div>
        <!-- 재료 리스트로 따로 가져와야함 -->
        <div id="detailIngreContainer">
            <h2>재료</h2>
            <ul id="detailIngre">
            <%if(ingreList != null){
	            for(Ingredient ingre : ingreList){ %>
                <li><p><%=ingre.getIngre_name()%></p><p><%=ingre.getIngre_unit()%></p></li>
            <%} } %>
            </div>
        </div>
        <!-- 레시피 순서 리스트로 따로 가져와야함 -->
        <div id="detailStepContainer">
            <h2>레시피 순서</h2>
            <ul id="detailStep">
            <%if(stepList != null){
	            for(RecipeSteps step : stepList){ %>
                <li>
                    <h2>Step <%=step.getStep_no()%></h2>
                    <div class="stepContent">
                        <p><%=step.getStep_content() %></p>
                        <img src="<%=step.getStep_img()%>" id="stepImg" alt="레시피 순서">
                    </div>
                </li>
            <%} } %>
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
    <%@ include file="riceThief_footer.jsp" %>
    <script type="text/javascript">
	function deleteAlert(){
		if (confirm("정말 게시글을 삭제하시겠습니까?") == true){
			//확인 버튼을 눌렀을 때 실행 할 코드
			location.href = "deleterecipe?rno=<%=rno%>&writer=<%=vo.getUid()%>"
			return true;
		}else{   
			alert("게시글 삭제를 취소하였습니다.")
			return false;
		}
	}
</script>
</body>
</html>