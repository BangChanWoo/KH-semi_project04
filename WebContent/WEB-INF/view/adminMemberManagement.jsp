<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<!-- footer css -->
<!--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/recipeCategory.css" />-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/userlist.css" />
<%@page import="java.util.ArrayList"%>
<%@page import="user.vo.*"%>
<%@page import="admin.user.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	ArrayList<User> volist = (ArrayList<User>) request.getAttribute("adminUserList");
	ArrayList<User> volist1 = (ArrayList<User>) request.getAttribute("adminUserList1");
	ArrayList<User> volist3 = (ArrayList<User>) request.getAttribute("getUserId");
	//ArrayList<User> volist2 = (ArrayList<User>) request.getAttribute("getUserAge");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount");
	int bCount = (int) request.getAttribute("bCount");
	int genderCount = (int) request.getAttribute("genderCount");
	//나이 불러오는 것
	int age11 = (int) request.getAttribute("age11");
	int age22 = (int) request.getAttribute("age22");
	int age33 = (int) request.getAttribute("age33");
	int age44 = (int) request.getAttribute("age44");
	int age55 = (int) request.getAttribute("age55");
	int age66 = (int) request.getAttribute("age66");
	int age00 = (int) request.getAttribute("age00");
	String id = (String) request.getAttribute("id");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js"
	crossorigin="anonymous"></script>



<title>관리자_회원관리</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
	<%@ include file="riceThief_adminHeader.jsp" %>
	<hr>
	<main>
		<h2>회원관리</h2>
		<form method="get" action="userInfo">
		<div class='right-box'>
			<input type="text" name = "id" id="name1" placeholder="사용자 아이디 입력">
			<input type="submit" id="user_search"value="검색" >
		</div>
		</form>
		<div class="board_list_wrap">
			<table class="board_list">
				<caption>회원 목록</caption>
				<thead>
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>가입 날짜</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
							int bCount1 = bCount;
						if (volist != null) {
							for (User vo : volist) {
						%>
						<%
							//for(int i=1;i<=bCount;i++){
						if (bCount != 0) {
							//bCount=1;
							bCount1 += 1;
						%>

						<td><%=bCount1 - bCount%></td>
						<form method="get" action="userInfo" >
							<td><button type="submit" class="info_btn" name="id" value="<%=vo.getUid()%>" id="name2"><%=vo.getUid()%></button></td>
						</form>

						<!--<td><button type="submit" id="info_btn" onclick="javascript:location.href='./userInfo.jsp?type=<%=vo.getUid()%>'" ><%=vo.getUid()%></button></td>-->
						<!--<td><button type="button" id="info_btn" onclick="popup()"><%=vo.getUid()%></button></td> -->
						<td><%=vo.getUname()%></td>
						<td><%=vo.getJoin_date() %> <%
							}
						%>
					</tr>
					<%
						}
					}
					%>
				</tbody>
			</table>
			<div class="paging">
				<a href="#" class="bt">첫 페이지</a> 
				<a href="#" class="bt">이전 페이지</a>
				<%
					if (startPage > 1) {
				%>
				<a href="./SelectUserServlet?pagenum=<%=startPage - 1%>"
					class="num on"></a>
				<%
					}
				%>
				<%
					for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="./SelectUserServlet?pagenum=<%=i%>" class="num"><%=i%></a>
				<%
					}
				%>
				<%
					if (endPage < pageCount) {
				%>
				<a href="./SelectUserServlet?pagenum=<%=endPage + 1%>" class="num"></a>
				<%
					}
				%>
				<a href="#" class="bt">다음 페이지</a> <a href="#" class="bt">마지막 페이지</a>
			</div>
		</div>
		<div class="gender">
			<table class="gender_table">
				<thead>
					<tr>
						<th></th>
						<th>남자</th>
						<th>여자</th>
						<th>총</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
							double checkPerc = 0.0;
						checkPerc = 100 * genderCount / bCount;
						int female = bCount - genderCount;
						%>
						<td>남녀 성비</td>

						<td><%=checkPerc + "%" + " (" + genderCount + "명)"%></td>
						<td><%=100 - checkPerc + "%" + " (" + female + "명)"%></td>
						<td><%="100%" + " (" + bCount + "명)"%></td>

					</tr>
				</tbody>
			</table>
		</div>

		<div class="age_group">
			<table class="age_group_table">
				<thead>
					<tr>
						<th></th>
						<th>10대</th>
						<th>20대</th>
						<th>30대</th>
						<th>40대</th>
						<th>50대</th>
						<th>60대</th>
						<th>그 외</th>
						<th>총</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
						double per1 = 0.0;
						double per2 = 0.0;
						double per3 = 0.0;
						double per4 = 0.0;
						double per5 = 0.0;
						double per6 = 0.0;
						double per0 = 0.0;
					
						per1=age11*100/bCount;
						per2=age22*100/bCount;
						per3=age33*100/bCount;
						per4=age44*100/bCount;
						per5=age55*100/bCount;
						per6=age66*100/bCount;
						per0=age00*100/bCount;
						%>
						<td>연령대</td>
						<td><%=per1 + "%" + " (" + age11 + "명)"%></td>
						<td><%=per2 + "%" + " (" + age22 + "명)"%></td>
						<td><%=per3 + "%" + " (" + age33 + "명)"%></td>
						<td><%=per4 + "%" + " (" + age44 + "명)"%></td>
						<td><%=per5 + "%" + " (" + age55 + "명)"%></td>
						<td><%=per6 + "%" + " (" + age66 + "명)"%></td>
						<td><%=per0 + "%" + " (" + age00 + "명)"%></td>
						<td><%="100%" + " (" + bCount + "명)"%></td>
					</tr>
				</tbody>
			</table>
		</div>

	</main>
	<footer>
	<%@ include file="riceThief_footer.jsp" %>
	</footer>
	<script>
	
	
	</script>


</body>
</html>