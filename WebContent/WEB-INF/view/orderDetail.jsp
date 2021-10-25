<%@page import="product_order_detail.vo.ProductOrderDetailVo"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/orderdetail.css" /><!-- 자체 css -->
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
<script type="text/javascript" src="./js/mypage.js"></script> 
<!-- title -->
<title>밥도둑_결제내역</title>
	<script type="text/javascript">
		$(function(){
			$('#orderSelect').change(function(){
				var pagenum = 1;
				$('.pageBtn').click(function () {
					pagenum = $('.pageBtn').val();
				})
				if($('#orderSelect').val() == 0){
					$.ajax({
						type : "GET",
				        url:"orderdetail.do",
				        data: {state: "0", pagenum : pagenum},
				        dataType: "json",
				        success : function(data){
				        	$(".removePart").remove();
				        	var html = "";
				        	for(var i=0; i<data.length; i++){
				        		html += "<tr class='removePart'>"
								html += "<td class='proContent'><img src='"+data[i].pro_img+"'><a href='selectproduct?rno="+data[i].pro_no+"'>"+data[i].pro_title+"</a></td>"
								html += "<td>"+data[i].order_date+"</td>"
								html += "<td>"+data[i].pro_price+"("+data[i].order_count+")</td>"
								if(data[i].order_state == 'N'){
									html += "<td>상품준비중</td>"
								}else if(data[i].order_state == 'Y'){
									html += "<td>배송완료</td>"
								}
								html += "<td><button onclick='writeReview()'>리뷰 작성</button><button onclick=''>주문 취소</button></td>"
								html += "</tr>";
				        	}
				        	$("#orderTable").append(html);
				        },
				        error : function(e) {
				        	alert(e.responseText);
				        }
				    });
				}else if($('#orderSelect').val() == 1){
					$.ajax({
						type : "GET",
				        url:"orderdetail.do",
				        data: {state: "1", pagenum : pagenum},
				        dataType: "json",
				        success : function(data){
				        	$(".removePart").remove()
				        	var html = "";
				        	for(var i=0; i<data.length; i++){
				        		html += "<tr class='removePart'>"
								html += "<td class='proContent'><img src='"+data[i].pro_img+"'><a href='selectproduct?rno="+data[i].pro_no+"'>"+data[i].pro_title+"</a></td>"
								html += "<td>"+data[i].order_date+"</td>"
								html += "<td>"+data[i].pro_price+"("+data[i].order_count+")</td>"
								if(data[i].order_state == 'N'){
									html += "<td>상품준비중</td>"
								}else if(data[i].order_state == 'Y'){
									html += "<td>배송완료</td>"
								}
								html += "<td><button onclick='writeReview()'>리뷰 작성</button><button onclick=''>주문 취소</button></td>"
								html += "</tr>";
				        	}
				        	$("#orderTable").append(html);
				        },
				        error : function(e) {
				        	alert(e.responseText);
				        }
				    });
				}else if($('#orderSelect').val() == 2){
					$.ajax({
						type : "GET",
				        url:"orderdetail.do",
				        data: {state: "2", pagenum : pagenum},
				        dataType: "json",
				        success : function(data){
				        	$(".removePart").remove()
				        	var html = "";
				        	for(var i=0; i<data.length; i++){
				        		html += "<tr class='removePart'>"
								html += "<td class='proContent'><img src='"+data[i].pro_img+"'><a href='selectproduct?rno="+data[i].pro_no+"'>"+data[i].pro_title+"</a></td>"
								html += "<td>"+data[i].order_date+"</td>"
								html += "<td>"+data[i].pro_price+"("+data[i].order_count+")</td>"
								if(data[i].order_state == 'N'){
									html += "<td>상품준비중</td>"
								}else if(data[i].order_state == 'Y'){
									html += "<td>배송완료</td>"
								}
								html += "<td><button onclick='writeReview()'>리뷰 작성</button><button onclick=''>주문 취소</button></td>"
								html += "</tr>";
				        	}
				        	$("#orderTable").append(html);
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
	
	ArrayList<ProductOrderDetailVo> orderList = (ArrayList<ProductOrderDetailVo>)request.getAttribute("orderList");
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
			<% if(orderList != null){
			for(ProductOrderDetailVo vo: orderList) {%>
			<tr class="removePart">
				<td class="proContent"><img src="<%=vo.getPro_img()%>"><a href="selectproduct?rno=<%=vo.getPro_no()%>"><%=vo.getPro_title()%></a></td>
				<td><%=vo.getOrder_date()%></td>
				<td><%=vo.getPro_price()%>(<%=vo.getOrder_count()%>)</td>
				<%if(vo.getOrder_state() == 'N'){%>
				<td>상품준비중</td>
				<%} else if(vo.getOrder_state() == 'Y'){%>
				<td>배송완료</td>
				<%} %>
				<td><button onclick="writeReview()">리뷰 작성</button><button onclick="location.href='#'">주문 취소</button></td>
			</tr>
			<%} }else if(orderList.isEmpty()){%>
			<h2>결제 내역이 없습니다.</h2>
			<h2><%=orderList %></h2>
			<%} %>
		</table>
		<div id="pageBtnAll">
        <%if(startPage > 1){%>
            <a class="pageBtn" href="orderdetailview?pagenum=<%=startPage-1%>"><i class="fas fa-chevron-left"></i></a>
            <%} %>
            <%for (int i = startPage; i <= endPage; i++) {%>
            <a id="pageBtn_<%=i%>" class="pageBtn" href="orderdetailview?pagenum=<%=i%>"><%=i%></a>
            <%} %>
            <%if(endPage < pageCount){%>
            <a class="pageBtn" href="orderdetailview?pagenum=<%=endPage+1%>"><i class="fas fa-chevron-right"></i></a>
        <%} %>
        </div>
	</main>
	<hr>
	<%@ include file="riceThief_footer.jsp" %>
</body>
</html>