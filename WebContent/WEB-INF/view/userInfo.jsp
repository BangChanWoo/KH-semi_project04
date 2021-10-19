<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/basic.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<%@page import="java.util.ArrayList"%>
<%@page import="user.vo.*"%>
<%@page import="admin.user.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js"
	crossorigin="anonymous"></script>

<!-- footer css -->
<%ArrayList<User> volist1 = (ArrayList<User>) request.getAttribute("adminUserList1");
%>
<title>사용자 상세정보</title>
<style>
body {
	text-align: center;
}

#id {
	margin-left: 10px;
}

.in {
	margin: 7px;
	width: 200px;
}

.btnContainer {
	clear: both;
	margin: 5rem;
	text-align: center;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@ include file="riceThief_adminHeader.jsp"%>
	<hr>
	<h1>회원 상세 정보</h1>

	<%
	if (volist1 != null) {
	for (User vo : volist1) {
							
						%>

	<form method="post" action="userUpdate">

		<div class="filedlable">
			<label class="io1">아이디</label>
		</div>
		<div class="formlable">
			<input type="text" name="id" id="id" value="<%=vo.getUid() %>" readonly>
		</div>

		<div class="filedlable">
			<label class="io1">비밀번호</label>
		</div>
		<div class="formlable">
			<input type="text" name="pw" value="<%=vo.getPw() %>">
		</div>

		<div class="filedlable">
			<label class="io1">이름</label>
		</div>
		<div class="formlable">
			<input type="text" name="uname" value="<%=vo.getUname() %>">
		</div>

		<div class="filedlable">
			<label class="io1">별명</label>
		</div>
		<div class="formlable">
			<input type="text" name="nickname" value="<%=vo.getNickname() %>">
		</div>

		<div class="filedlable">
			<label class="io1">나이</label>
		</div>
		<div class="formlable">
			<input type="text" name="age" value="<%=vo.getAge() %>">
		</div>

		<div class="filedlable">
			<label class="io1">성별</label>
		</div>
		<div class="formlable">
			<input type="text" name="gender" value="<%=vo.getGender() %>">
		</div>

		<div class="filedlable">
			<label class="io1">이메일</label>
		</div>
		<div class="formlable">
			<input type="text" name="email" value="<%=vo.getEmail() %>">
		</div>

		<div class="filedlable">
			<label class="io1">전화번호</label>
		</div>
		<div class="formlable">
			<input type="text" name="phone" value="<%=vo.getPhone() %>">
		</div>

		<div class="filedlable">
			<label class="io1">주소</label>
		</div>
		<div class="formlable">
			<input type="text" name="address" value="<%=vo.getAddress() %>">
		</div>

		<div class="filedlable">
			<label class="io1">가입날짜</label>
		</div>
		<div class="formlable">
			<input type="text" value="<%=vo.getJoin_date() %>">
		</div>

		<div class="filedlable">
			<label class="io1">포인트</label>
		</div>
		<div class="formlable">
			<input type="text" name="point" value="<%=vo.getPoint() %>">
		</div>

		<div class="filedlable">
			<label class="io1">사용자 종류</label>
		</div>
		<div class="formlable">
			<input type="text" name="type" value="<%=vo.getType() %>">
		</div>
			<!-- <input type="button" value="삭제" class="delete_btn" > -->
			<div class="btnContainer">
	<input type="submit" value="확인" class="update_btn"> 
	
	<input type="submit" value="삭제" class="delete_btn" onclick="SelectUserServlet">
	</div>
	</form>
	
	<%} }%>
	<footer>
		<hr>
		<%@ include file="riceThief_footer.jsp"%>
	</footer>

<script>

$(".delete_btn").click(function(){
	var a = document.getElementById("id");
	console.log(a);
})
</script>
</body>
</html>