<%@page import="java.util.ArrayList"%>
<%@page import="user.vo.*"%>
<%@page import="admin.user.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	ArrayList<User> volist = (ArrayList<User>) request.getAttribute("adminUserList");
	ArrayList<User> volist1 = (ArrayList<User>) request.getAttribute("adminUserList1");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount");
	int bCount = (int) request.getAttribute("bCount");
	int genderCount = (int) request.getAttribute("genderCount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<!-- footer css -->
<!--<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/recipeCategory.css" />-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/userlist.css" />

<title>관리자_회원관리</title>
</head>
<body>
	<%@ include file="../WEB-INF/riceThief_adminHeader.jsp"%>
	<hr>
	<main>
		<h2>회원관리</h2>
		<div class='right-box'>
			<input type="text" placeholder="사용자 아이디 입력">
			<button id="btnSearch">검색</button>
		</div>


		<div class="board_list_wrap">
			<table class="board_list">
				<caption>회원 목록</caption>
				<thead>
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>상세정보</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
                    		int bCount1=bCount;
                    		if(volist != null){
                    			for(User vo : volist){	
                    	%>
						<%
							//for(int i=1;i<=bCount;i++){
							if(bCount!=0){
								//bCount=1;
								bCount1+=1;
						%>
						<td><%=bCount1-bCount %></td>
						<td><%=vo.getUid()%></td>
						<td><%=vo.getUname()%></td>
						<td><button type="button" class="info_btn">
								<img src="./css/user.png">
							</button></td>
						<%} %>
					</tr>
					<%
                    			}
                    		}
                    	%>
				</tbody>
			</table>

			<div class="paging">
				<a href="#" class="bt">첫 페이지</a> <a href="#" class="bt">이전 페이지</a>
				<%if(startPage > 1){ %>
				<a href="./SelectUserServlet?pagenum=<%=startPage-1 %>"
					class="num on"></a>
				<%} %>
				<%for(int i = startPage; i<=endPage; i++){ %>
				<a href="./SelectUserServlet?pagenum=<%=i %>" class="num"><%=i %></a>
				<%} %>
				<%if(endPage < pageCount){ %>
				<a href="./SelectUserServlet?pagenum=<%=endPage+1%>" class="num"></a>
				<%} %>
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
					   double checkPerc=0.0;
                       checkPerc=100*genderCount/bCount;
                       int female=bCount-genderCount;
                    	%>
						<td>남녀 성비</td>

						<td><%=checkPerc+"%"+" ("+genderCount+"명)" %></td>
						<td><%=100-checkPerc+"%"+" ("+ female +"명)" %></td>
						<td><%="100%"+" (" + bCount + "명)" %></td>

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
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
                    		if(volist1 != null){
                    			for(User vo : volist1){	
                    %>
						<%
						
						int age=vo.getAge();
						int age1=0;
						int age2=0;
						int age3=0;
						int age4=0;
						int age5=0;
						int age6=0;
						int age0=0;
                    	for(int i=0; i<=bCount;i++){
                    		ArrayList<Integer> list = new ArrayList<Integer>();
                    		list.add(age);
                    		for(int a : list){
                    			if(a>=10 && a<=19){
                        			age1++;
                        		}
                        		else if(a>=20 && a<=29){
                        			
                        			age2++;
                        		}
                        		else if(a>=30 && a<=39){
                        		
                        			age3++;
                        		}
                        		else if(a>=40 && a<=49){
                        	
                        			age4++;
                        		}
                        		else if(a>=50 && a<=59){
                        			
                        			age5++;
                        		}
                        		else if(a>=60 && a<=69){
                        	
                        			age6++;
                        		}
                        		else {
                        		
                        			age0++;
                        		}
                    		}
                    		
                    	}
                    %>
						<td>연령대</td>
						<td>10%<%=age %></td>
						<td>20%<%=age2 %></td>
						<td>30%<%=age3 %></td>
						<td>40%<%=age4 %></td>
						<td>50%<%=age5 %></td>
						<td>60%<%=age6 %></td>
						<td>2% <%=age0 %></td>
					</tr>
					<%}} %>
				</tbody>
			</table>
		</div>

	</main>
	</hr>
	<%@ include file="../WEB-INF/riceThief_footer.jsp"%>
</body>
</html>