<%@page import="comment.vo.Comment"%>
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
<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/recipeDetail.css"/>
<title>밥도둑_레시피 상세조회</title>
<%
	String msg = (String)request.getAttribute("msg");
%>
<script type="text/javascript">
    <%if(msg != null){%>
    	alert("<%=msg%>");
    <%}%>
</script>
</head>
<body>
<%
	Recipe vo = (Recipe)request.getAttribute("vo");
	int rno = (int)request.getAttribute("rno");
	
	ArrayList<Ingredient> ingreList = (ArrayList<Ingredient>)request.getAttribute("ingreList");
	ArrayList<RecipeSteps> stepList = (ArrayList<RecipeSteps>)request.getAttribute("stepList");
	ArrayList<Comment> commentList = (ArrayList<Comment>)request.getAttribute("commentList");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <div id="detailImgContainer">
            <img src="<%=vo.getRec_img() %>" id="titleImg" alt="레시피 대표 사진">
            <c:if test="${sessionID == vo.getUid() or sessionID == 'admin'}">
            <a href="updateget?rno=<%=rno%>" id="updateRecipe"><i class="fas fa-edit"></i></a>
            <a href="#" onclick="deleteAlert()" id="deleteRecipe"><i class="fas fa-trash-alt"></i></a>
            </c:if>
            <c:if test="${not empty sessionID}">
	            <c:if test="${like == 'yes'}">
	            	<a href="likeornot?like=yes&rno=<%=rno%>" id="likeRecipe"><i class="fas fa-heart"></i></a>
	            </c:if>
	            <c:if test="${like == null}">
	            	<a href="likeornot?rno=<%=rno%>" id="likeRecipe"><i class="far fa-heart"></i></a>
	            </c:if>
            </c:if>
            <a href="#" onclick="recipeShare()" id="shareRecipe"><i class="fas fa-share-square"></i></a>
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
        <c:if test="${not empty vo.getRec_tip()}">
        <hr style="margin: 3rem 0">
        <div style="width: 100%; margin: 3rem 0;">
        	<h2>레시피 Tip</h2>
        	<p style="margin: 0.5em auto; font-size: 1.2rem;"><%=vo.getRec_tip()%></p>
        </div>
        </c:if>
        <c:if test="${not empty vo.getRec_video()}">
        <hr style="margin: 3rem 0">
        <div style="width: 100%; margin: 3rem 0; text-align: center;">
        	<h2 style="margin: 2rem 0; text-align: left;">레시피 동영상</h2>
        	<iframe src="<%=vo.getRec_video()%>" frameborder="0" allowfullscreen style="width: 60%; aspect-ratio: 16/9;"></iframe>
        </div>
        </c:if>
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
	            //for(RecipeSteps step : stepList){ 
	            for(int i=0; i<stepList.size(); i++){%>
                <li>
                    <h2>Step <%=i+1%></h2>
                    <div class="stepContent">
                        <p><%=stepList.get(i).getStep_content() %></p>
                        <img src="<%=stepList.get(i).getStep_img()%>" id="stepImg" alt="레시피 순서">
                    </div>
                </li>
            <%} } %>
            </ul>
        </div>
        <div id="detailCommentContainer">
            <c:if test="${not empty sessionID}">
            <h2>댓글 남기기</h2>
			<form method="post" action="insertcomment" id="commentFrm">
                <input type="hidden" name="rno" value="<%=rno%>" readonly="readonly">
                <input type='hidden' name='level' value='0' readonly='readonly'>
                <textarea name="commentInput" id="commentInput" required="required"></textarea>
				<button type="submit" id="commentSubmitBtn">등록</button>
			</form>
            </c:if>
            <ul>
                <%for(Comment cm : commentList){ %>
                <li>
                	<%if(cm.getCom_level() == 0){ %>
                	<div>
	                	<hr class="clear" style="margin-top:1rem">
	                    <div class="commentUser">
	                        <i class="far fa-comment"></i>
	                        <p><%=cm.getUid()%></p>
	                    </div>
	                    <p class="commentContent"><%=cm.getCom_content()%></p>
                    </div>
                    <c:set var="getId" value="<%=cm.getUid() %>"/>
		            <c:if test="${sessionID == getId or sessionID == 'admin'}">
		            <a href="#" onclick="updateCommentToggle('recomUpdate_<%=cm.getComment_no()%>')" class="updateToggle"><i class="fas fa-edit"></i></a>
		            <a href="#" onclick="deleteCommentAlert(<%=cm.getComment_no()%>)"><i class="fas fa-trash-alt"></i></a>
		            <div id="recomUpdate_<%=cm.getComment_no()%>" style="display: none;">
			            	<hr class="clear">
							<form method="post" action="updatecomment" id="comUpdateFrm">
								<h4>댓글 수정하기</h4>
								<input type="hidden" name="rno" value="<%=rno%>">
								<input type="hidden" name="comno" value="<%=cm.getComment_no()%>">
								<textarea name='commentInput'><%=cm.getCom_content()%></textarea>
								<button type="submit">수정</button>
							</form>
			            </div>
		            </c:if>
		            <c:if test="${sessionID == vo.getUid() or sessionID == 'admin'}">
		            	<p><a href="#" onclick="recomment('recomField_<%=cm.getComment_no()%>')" class="recommentToggle"><i class="fas fa-comment"></i> 답글쓰기</a></p>
		            </c:if>
		            <div id="recomField_<%=cm.getComment_no()%>" style="display: none;">
		            	<hr class="clear">
			            <form method='post' action='insertcomment' id='commentFrm'>
				            <input type='hidden' name='rno' value='<%=rno%>' readonly='readonly'>
				            <input type='hidden' name='level' value='1' readonly='readonly'>
				            <input type='hidden' name='origin' value='<%=cm.getComment_no()%>' readonly='readonly'>
				            <textarea name='commentInput' id='commentInput' required='required'></textarea>
				            <button type='submit' id='commentSubmitBtn'>등록</button>
			            </form>
		            </div>
                    
		            <% } %>
		            <%if(cm.getCom_level() == 1){ %>
		            <div class="recommentStyle">
	                    <div class="commentUser">
	                        <i class="fas fa-comment"></i>
	                        <p><%=cm.getUid()%></p>
	                    </div>
	                    <p class="commentContent"><%=cm.getCom_content()%></p>
	                    <c:set var="getId" value="<%=cm.getUid() %>"/>
			            <c:if test="${sessionID == getId or sessionID == 'admin'}">
			            <a href="#" onclick="updateCommentToggle('recomUpdate_<%=cm.getComment_no()%>')" class="updateToggle"><i class="fas fa-edit"></i></a>
			            <a href="#" onclick="deleteCommentAlert(<%=cm.getComment_no()%>)"><i class="fas fa-trash-alt"></i></a>
			            <div id="recomUpdate_<%=cm.getComment_no()%>" style="display: none;">
			            	<hr class="clear">
							<form method="post" action="updatecomment" id="comUpdateFrm">
								<h4>댓글 수정하기</h4>
								<input type="hidden" name="rno" value="<%=rno%>">
								<input type="hidden" name="comno" value="<%=cm.getComment_no()%>">
								<textarea name='commentInput'><%=cm.getCom_content()%></textarea>
								<button type="submit">수정</button>
							</form>
			            </div>
			            </c:if>
	                    <hr class="clear">
	                </div>
		            <%} %>
                </li>
                <%} %>
            </ul>
            <hr class="clear" style="border: 0;">
            <div id="pageBtnAll">
	        	<%if(startPage > 1){%>
	            <a class="pageBtn" href="selectrecipe?rno=<%=rno%>&pagenum=<%=startPage-1%>"><i class="fas fa-chevron-left"></i></a>
	            <%} %>
	            <%for (int i = startPage; i <= endPage; i++) {%>
	            <a id="pageBtn_<%=i%>" class="pageBtn" href="selectrecipe?rno=<%=rno%>&pagenum=<%=i%>"><%=i%></a>
	            <%} %>
	            <%if(endPage < pageCount){%>
	            <a class="pageBtn" href="selectrecipe?rno=<%=rno%>&pagenum=<%=endPage+1%>"><i class="fas fa-chevron-right"></i></a>
	            <%} %>
	        </div>
        </div>
    </main>
    <hr>
    <%@ include file="riceThief_footer.jsp" %>
    <script type="text/javascript">
	function deleteAlert(){
		if (confirm("정말 게시글을 삭제하시겠습니까?") == true){
			//확인 버튼을 눌렀을 때 실행 할 코드
			location.href = "deleterecipe?rno=<%=rno%>&writer=<%=vo.getUid()%>";
			return true;
		}else{   
			alert("게시글 삭제를 취소하였습니다.")
			return false;
		}
	}
	function deleteCommentAlert(comno){
		if (confirm("정말 댓글을 삭제하시겠습니까?") == true){
			//확인 버튼을 눌렀을 때 실행 할 코드
			location.href = "deletecomment?rno=<%=rno%>&comno="+comno;
			return true;
		}else{   
			alert("게시글 댓글 삭제를 취소하였습니다.")
			return false;
		}
	}
	$('.recommentToggle').click(function(e){ e.preventDefault(); });
	function recomment(id){
		$("#"+id).toggle();
	}
	$('.updateToggle').click(function(e){ e.preventDefault(); });
	function updateCommentToggle(id){
		$("#"+id).toggle();
	}
	function recipeShare(){
		var url = '';
		var textarea = document.createElement("textarea");
		document.body.appendChild(textarea);
		url = window.document.location.href;
		textarea.value = url;
		textarea.select();
		document.execCommand("copy");
		document.body.removeChild(textarea);
		alert("URL이 복사되었습니다.")
	}
</script>
</body>
</html>