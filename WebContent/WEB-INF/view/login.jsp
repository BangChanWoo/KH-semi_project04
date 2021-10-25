<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/riceThief_footer.css" />
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
section {
	text-align: center;
}
h2{
	text-align: center;
	margin: 5rem 0 0 0;
}
.id, .pw {
	font-size: 1rem;
	padding: 0.5rem;
}

.vv {
	margin-left: 20px;
}
#ckid{
	margin-left:30px;
}
#frmCon{
	width: 100%;
	text-align: center;
	margin: auto;
}
form{
	display: inline-block;
	margin: 3rem 0 0 0;
}
button:hover{
	background-color: #9a7b6c;
}
#loginbtn1{
	width: 100%;
	padding: 0.5rem 0;
	margin: 1rem 0 0.5rem 0;
	background-color: #CFB9AF;
	border: 0;
	border-radius: 5px;
}
#ckid, #ckpw{
	margin: 0 0 1rem 0.5rem;
	background-color: white;
	border: 0;
}
#ckpw{
	border-left: solid 1.5px black;
	padding: 0 0.6rem;
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
		<h2>로그인</h2>
		<br>
		<div id="frmCon">
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
		</div>
		<button id="ckid" onclick="location.href='checkid'">아이디 찾기</button>
		<button id="ckpw" onclick="location.href='checkpw'">비밀번호 찾기</button>
	</section>

	<footer>
		<hr>
		<%@ include file="riceThief_footer.jsp"%>
	</footer>


</body>
</html>