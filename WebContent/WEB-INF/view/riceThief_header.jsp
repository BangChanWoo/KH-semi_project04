<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div>
		<a href="./main"><img src="./css/밥도둑 로고.png" id="logoImg"></a>
        <div id="headerBtn">
        	<a href="#" id="searchBtn"><i class="fas fa-search"></i></a>
        	<c:if test="${ empty sessionID }">
        		<button id="loginBtn" class="headerBtnStyle" onclick="location.href='login'">로그인</button>
        	<button id="enrollBtn" class="headerBtnStyle" onclick="location.href='joinuser'">회원가입</button>
        	</c:if>
        	<c:if test="${not empty sessionID }">
        	${sessionID}님 
        		<button onclick="location.href='logout'">로그아웃</button>
        	</c:if>
        	<button id="serviceBtn" class="headerBtnStyle">고객센터</button> 
        </div>
        <nav>
        	<ul>
        		<li id="navRecipe"><a href="recipeboard">레시피</a></li>
        		<li id="navStore"><a href="productboard">스토어</a></li>
        	</ul>
        	<c:if test="${not empty sessionID}">
        	<a id="cart" class="loginAfterBtn" href="#"><i class="fas fa-shopping-cart"></i></a>
        	<a id="recipeWrite" class="loginAfterBtn" href="insertrecipe"><i class="fas fa-edit"></i></a>
        	</c:if>
        </nav>
    </div>
</header>