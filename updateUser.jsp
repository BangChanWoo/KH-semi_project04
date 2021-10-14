<%@page import="user.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% User user=(User)request.getAttribute("user"); %>
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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/main.css" />
<title>회원 정보 수정</title>
</head>
<body>
	<header>
		<%@ include file="riceThief_header.jsp"%>
		<hr>
	</header>
	<section>
		<br>
		<h1 class="line">회원 정보 수정</h1>
		<br>
		<form method="post" action="/updateuser">
			<table class="line">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" value="#" readonly></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="repw"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="nickname"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>핸드폰 번호</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="radio" name="gender" value="M" checked>남자
						<input type="radio" name="gender" value="F">여자</td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" id="agenum" name="age" class="in" min="12" max="99" step="1" name="age"></td>
				</tr>
			</table>
			<button type="submit" id="updateuserbtn" class="line">수정확인</button>
			<button>회원탈퇴</button>
		</form>
	</section>

	<footer>
		<hr>
		<%@ include file="riceThief_footer.jsp"%>
	</footer>
</body>
</html>