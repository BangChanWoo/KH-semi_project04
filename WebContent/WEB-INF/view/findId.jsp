<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" /> <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<script src="https://kit.fontawesome.com/616f27e0c4.js"
	crossorigin="anonymous"></script>

<style>
body {
	text-align: center;
}

.lo1, .lo2 {
	margin-top: 2rem;
	margin-bottom: 2rem;
}
.vv{ margin-left:40px; }
.vv1{ margin-left:10px; }

 
</style>
</head>
<body>
	<header>
		<a href="main.jsp" target="_self"> <img src="./css/밥도둑 로고.png"></a>
		<hr>
	</header>

	<section>
	<br>
	<h1>아이디 찾기</h1>
		<form>
			<div class="lo1">
				<i class="fas fa-exclamation-circle" style="font: 1px 1px;"></i>
				회원정보에 등록한 이름과 핸드폰 번호를 입력해주세요.<br>
				 <label>이름</label><input type="text" class="vv"  placeholder="이름을 입력하세요."><br>
				 <label>핸드폰번호</label><input type="text"  placeholder="번호를 입력하세요."><br>
			</div>
			<div class="lo1">
				<i class="fas fa-exclamation-circle" style="font: 1px 1px;"></i>
				회원정보에 등록한 이름과 핸드폰 번호를 입력해주세요.<br>
				 <label>이름<input type="text" class="vv1"  placeholder="이름을 입력하세요."></label><br>
				 <label>이메일<input type="text"  placeholder="이메일을 입력하세요."></label><br>
			</div>
			

			<button id="findbtn">찾기</button>




		</form>

	</section>
	
	<footer>
	<hr>
       <%@ include file="riceThief_footer.jsp" %>
	</footer>
</body>
</html>