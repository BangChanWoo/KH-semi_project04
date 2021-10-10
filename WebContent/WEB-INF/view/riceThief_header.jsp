<%@page import="user.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	/* User memberLoginInfo = (User)request.getSession().getAttribute("loginInfo");
String id = null;
if(memberLoginInfo != null){
	id = memberLoginInfo.getUid();
} */
/* request.getSession().setAttribute("id", "admin");
request.getSession().getAttribute("id"); */
%>
<header>
	<div>
		<a href="./main"><img src="./css/밥도둑 로고.png" id="logoImg"></a>
		<div id="headerBtn">
			<a href="#" id="searchBtn"><i class="fas fa-search"></i></a>



			<button id="loginBtn" class="headerBtnStyle">
				로그인<a href="login"></a>
			</button>
			<c:if test="${sessionID != null }">
	${sessionID } 환영합니다.
	<a href="logout"><button>로그아웃</button></a>
</c:if>
			<button id="enrollBtn" class="headerBtnStyle">
				회원가입<a href="joinuser"></a>
			</button>

			<button id="serviceBtn" class="headerBtnStyle">고객센터</button>
		</div>
		<nav>
			<ul>
				<li id="navRecipe"><a href="recipeboard">레시피</a></li>
				<li id="navStore"><a href="productboard">스토어</a></li>
			</ul>
			<c:if test="${not empty id}">
				<a id="cart" class="loginAfterBtn" href="#"><i
					class="fas fa-shopping-cart"></i></a>
				<a id="recipeWrite" class="loginAfterBtn" href="insertrecipe"><i
					class="fas fa-edit"></i></a>
			</c:if>
		</nav>
	</div>
</header>