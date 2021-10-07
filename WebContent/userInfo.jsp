<%@page import="java.util.ArrayList"%>
<%@page import="user.vo.*"%>
<%@page import="admin.user.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%ArrayList<User> volist1 = (ArrayList<User>) request.getAttribute("adminUserList1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js"
	crossorigin="anonymous"></script>

<title>사용자 상세정보</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<script>
	
</script>
	
	
	<h1>회원 상세 정보</h1>

	<%
	if (volist1 != null) {
	for (User vo : volist1) {
							
						%>

	<form method="get" action="userUpdate">
	아이디 :
	<input type="text" name="id" value="<%=vo.getUid() %>" readonly>
	<br> 패스워드 :
	<input type="text" name="pw" value="<%=vo.getPw() %>">
	<br> 이름 :
	<input type="text" name="uname" value="<%=vo.getUname() %>">
	<br> 별명 :
	<input type="text" name="nickname" value="<%=vo.getNickname() %>">
	<br> 나이 :
	<input type="text" name="age" value="<%=vo.getAge() %>">
	<br> 성별 :
	<input type="text" name="gender" value="<%=vo.getGender() %>">
	<br> 이메일 :
	<input type="text" name="email" value="<%=vo.getEmail() %>">
	<br> 전화번호 :
	<input type="text" name="phone" value="<%=vo.getPhone() %>">
	<br> 주소 :
	<input type="text" name="address" value="<%=vo.getAddress() %>">
	<br> 가입날짜 :
	<input type="text" value="<%=vo.getJoin_date() %>">
	<br> 포인트 :
	<input type="text" name="point" value="<%=vo.getPoint() %>">
	<br> 사용자 종류 :
	<input type="text" name="type" value="<%=vo.getType() %>">
	<br>
	

	


	<input type="button" value="확인" onclick="window.close();"><br>
	
	
	<input type="submit" value="수정"  class="update_btn" onclick="SelectUserServlet" >
	
		</form>
		
		<form method="get" action="userDelete">
		<input type="text" name="id" value="<%=vo.getUid()%>"id="text_box" readonly>
		
		<input type="submit" value="삭제" class="delete_btn" onclick="SelectUserServlet">
		
	</form>
	<script>
	$(".update_btn").click(function(){
		alert("수정 성공");
		RequestDispatcher rd = request.getRequestDispatcher("adminMemberManagement.jsp"); //중요한 메소드!
		rd.forward(request, response);
	});

	$(".delete_btn").click(function(){
		alert("삭제 성공");
	});
	
	
	</script>
<%} }%>

	
<script>
		$("#text_box").hide();
		</script>
</body>
</html>