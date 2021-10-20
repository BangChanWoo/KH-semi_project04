<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<%@page import="recipe.model.vo.Recipe"%>
<%@page import="interset_recipe.vo.IntersetRecipe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<title>마이페이지_관심 레시피</title>
</head>
<body>
<%
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	Recipe vo = (Recipe)request.getAttribute("vo");
	int rno = (int)request.getAttribute("rno");
	ArrayList<Recipe> interRecList = (ArrayList<Recipe>)request.getAttribute("interRecipe");
	for(int i=0; i<interRecList.size(); i++){
%>
	
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <h2>관심 레시피</h2>
			<div class="imgCenter">
			<%if(interRecList != null){
	            	for(Recipe co : interRecList){ %>
			 <div>
                    <a href="selectrecipe?rno=<%=interRecList.get(i).getRecipe_no()%>"><img src="<%=interRecList.get(i).getRec_img() %>" class="categoryImg" alt="추천 레시피"></a>
                    <div class="categoryRecipeTitle"><a href="selectrecipe?rno=<%=interRecList.get(i).getRecipe_no()%>"><%=interRecList.get(i).getRec_title() %></a></div>
                </div>
	            <% } }%>
            </div>
		
	<%
		}
	%>
			 
			 
	
    </main>
    <hr>
	<%@ include file="riceThief_footer.jsp" %>    
        
        
</body>
</html>