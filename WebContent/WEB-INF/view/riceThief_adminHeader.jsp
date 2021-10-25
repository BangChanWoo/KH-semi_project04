<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div>
		<a href="./adminMainServlet"><img src="./css/밥도둑 로고.png" id="logoImg"></a>
        <div id="headerBtn">
        	
        	<c:choose>
        	<c:when test="${not empty sessionID}">
        	<a href="#"> <i class="far fa-user"></i> ${sessionNickname} 님</a>
			<button class="headerBtnStyle" onclick="location.href='logout'">로그아웃</button>
        	</c:when>
        	</c:choose>
        	 
        </div>
        <nav>
        	<ul>
        		<li id="navRecipe"><a href="adminRecipeList">레시피</a></li>
        		<li id="navStore"><a href="adminProductListServlet">스토어</a></li>
        		<li id="navUser_admin"><a href="SelectUserServlet">회원관리</a></li>
        		<li id="navSale_admin"><a href="selectsals">매출관리</a></li>
        		<li id="navService_admin"><a href="adminnoticeservlet">고객센터</a></li>
        	</ul>
        </nav>
    </div>
</header>