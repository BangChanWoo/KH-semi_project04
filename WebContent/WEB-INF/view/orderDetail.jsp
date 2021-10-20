<%@page import="java.util.ArrayList"%>
<%@page import="product_order.vo.ProductOrder"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/orderdetail.css" /><!-- footer css -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/httpRequest.js"></script> 
<!-- title -->
<title>밥도둑_결제내역</title>
	<script type="text/javascript">
		$(function(){
			$('#orderSelect').change(function(){
				if($('#orderSelect').val() == 0){
					$.ajax({
						type : "GET",
				        url:"orderdetail",
				        data: {state: "0"},
				        dataType : "json",
				        success : function(data){
				        	alert(data.orderList);
				        },
				        error : function(e) {
				        	alert(e.responseText);
				        }
				    });
				}else if($('#orderSelect').val() == 1){
					$.ajax({
						type : "GET",
				        url:"orderdetail",
				        data: {state: "1"},
				        dataType : "json",
				        success : function(data){
				        	alert(data.orderList);
				        },
				        error : function(e) {
				        	alert("실패~");
				        }
				    });
				}else if($('#orderSelect').val() == 2){
					$.ajax({
						type : "GET",
				        url:"orderdetail",
				        data: {state: "2"},
				        dataType : "json",
				        success : function(data){
				        	alert(data.orderList);
				        },
				        error : function(e) {
				        	alert(e.responseText);
				        }
				    });
				}
			});
		});
	</script>
</head>
<body>
<% 
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	
	ArrayList<ProductOrder> orderList = (ArrayList<ProductOrder>)request.getAttribute("orderList");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	int state = (int)request.getAttribute("state");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
	<main>
		<h2>결제내역 조회</h2>
		<select id="orderSelect" name="orderSelect">
			<option id="all" value="0" <c:if test="${empty state}">selected="selected"</c:if>>전체 상태</option>
			<option id="ready" value="1" <c:if test="${state == 1}">selected="selected"</c:if>>상품 준비중</option>
			<option id="complete" value="2" <c:if test="${state == 2}">selected="selected"</c:if>>배송 완료</option>
		</select>
		<table id="orderTable">
			 <colgroup>
			 	<col width="20%">
			 	<col width="20%">
			 	<col width="20%">
			 	<col width="20%">
			 	<col width="20%">
			 </colgroup>
			<tr>
				<th>상품정보</th>
				<th>주문일자</th>
				<th>주문금액(수량)</th>
				<th>주문상태</th>
				<th>리뷰작성</th>
			</tr>
			<%for(ProductOrder vo: orderList) {%>
			<tr>
				<td class="proContent"><img src="./css/alt.JPG"><a href="#">제목제목제목제목제목제목제목제목</a></td>
				<td>주문일자</td>
				<td>주문금액(<%=vo.getOrder_count()%>)</td>
				<td><%=vo.getOrder_status()%></td>
				<td><button onclick="writeReview()">리뷰 작성</button><button onclick="location.href='#'">주문 취소</button></td>
			</tr>
			<%} %>
		</table>
		<h2 id="result">아</h2>
		<div id="pageBtnAll">
        <%if(startPage > 1){%>
            <a class="pageBtn" href="orderdetail?pagenum=<%=startPage-1%>"><i class="fas fa-chevron-left"></i></a>
            <%} %>
            <%for (int i = startPage; i <= endPage; i++) {%>
            <a id="pageBtn_<%=i%>" class="pageBtn" href="orderdetail?pagenum=<%=i%>"><%=i%></a>
            <%} %>
            <%if(endPage < pageCount){%>
            <a class="pageBtn" href="orderdetail?pagenum=<%=endPage+1%>"><i class="fas fa-chevron-right"></i></a>
        <%} %>
        </div>
	</main>
	<hr>
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>