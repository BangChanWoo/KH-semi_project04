<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/riceThief_footer.css" />
<!-- footer css -->
<title>로그인</title>
<style>
body {
	text-align: center;
}

#loginbtn {
	width: 140px;
	margin-left:1px;
}

.id, .pw {
	width: 150px;
}

.vv {
	margin-left: 20px;
}
</style>
<script src="https://kit.fontawesome.com/616f27e0c4.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<header>
			<a href="#" target="_self"> <img src="./css/밥도둑 로고.png"></a>
			<hr>
		</header>

		<section>
		<br>
			<form>
				<i class="far fa-user" style="font-size: 1px 1px;"></i> <input
					type="text" class="id" placeholder="UserId"><br> <br>
					<i class="fas fa-key" style="font-size: 1px 1px;"></i> <input
					type="password" class="pw" placeholder="Password"><br> <br>
				<div class="vv">
					<button  type="submit" id="loginbtn1">로그인</button>
					<br>

					<button id="ckid">
						아이디 찾기<a href="findId.jsp" target="_self"></a>
					</button>
					<button id="ckpw">
						비밀번호 찾기<a href="findpw.jsp"></a>
					</button>
				</div>

			</form>


		</section>

		<footer>
			<hr>
			<%@ include file="../WEB-INF/riceThief_footer.jsp"%>
		</footer>
		
	
</body>
</html>