<%@page import="product_post.vo.ProductPost"%>
<%@page import="java.util.ArrayList"%>
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
<title>밥도둑_스토어 상품 상세조회</title>
</head>
<body>
<%
	User memberLoginInfo = (User)request.getSession().getAttribute("loginInfo");
	String id = null;
	if(memberLoginInfo != null){
		id = memberLoginInfo.getUid();
	}
	ProductPost vo = (ProductPost)request.getAttribute("vo");
	int rno = (int)request.getAttribute("rno");

%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <div id="detailImgContainer">
            <img src="<%=vo.getPro_img() %>" id="titleImg" alt="상품 대표 사진">
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
            <h2 id="detailTitle" class="categoryRecipeTitle"><%=vo.getPro_title()%></h2>
        </div>
        
       
       	<!--  -->
   
    <%@ include file="riceThief_footer.jsp" %>
</body>
</html>