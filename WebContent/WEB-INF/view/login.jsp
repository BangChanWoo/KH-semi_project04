<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/riceThief_footer.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- footer css -->
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
body {
	text-align: center;
}

#loginbtn {
	width: 140px;
	margin-left: 1px;
}

.id, .pw {
	width: 150px;
}

.vv {
	margin-left: 20px;
}
#ckid{
	margin-left:30px;
}
</style>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

</head>
<body>
<script>
var result1 = "${result1}";
console.log(result1);
if(result1 == "로그인 실패했습니다."){
	alert("로그인 실패");
}
</script>
	<header>
		<%@ include file="riceThief_header.jsp"%>
		<hr>
	</header>

	<section>
		<br>
		<form action="login" method="POST">
			<i class="far fa-user" style="font-size: 1px 1px;"></i> <input
				type="text" class="id" name="uid" placeholder="UserId"><br> <br>
			<i class="fas fa-key" style="font-size: 1px 1px;"></i> <input
				type="password" class="pw" name="pw" placeholder="Password"><br>
			<br>
			<div class="vv">
				<button type="submit" id="loginbtn1">로그인</button>
				

				<br>

				<!-- <button id="ckid" onclick="location.href='checkid'">
					아이디 찾기
				</button>
				<button id="ckpw">
					비밀번호 찾기
				</button> -->
			</div>

		</form>
		<button id="ckid" onclick="location.href='checkid'">
					아이디 찾기
				</button>
				<button id="ckpw" onclick="location.href='checkpw'">
					비밀번호 찾기
				</button>


	</section>

	<footer>
		<hr>
		<%@ include file="riceThief_footer.jsp"%>
	</footer>


</body>
</html>