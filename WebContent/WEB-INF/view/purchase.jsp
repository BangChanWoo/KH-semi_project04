<%@page import="cartDetail.vo.CartDetailVo"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/purchase.css" /><!-- 자체 css -->
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
<title>밥도둑_장바구니</title>
</head>
<body>
<% 
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	
 	ArrayList<CartDetailVo> pcVoList = (ArrayList<CartDetailVo>)request.getAttribute("pcVoList");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
	<main>
		<div>
			<h2>주문 상품 <a onclick="proToggle()"><i class="fas fa-chevron-down"></i></a></h2>
			<ul id="basketContainer">
			<%for(CartDetailVo cVo: pcVoList){%>
				<li id="con_<%=cVo.getCart_no()%>">
					<a href="selectproduct?rno=<%=cVo.getPro_no()%>"><img class="bkImg" src="<%=cVo.getPro_img()%>"></a>
					<div class="bkContent">
						<a class="bkTitle" href="selectproduct?rno=<%=cVo.getPro_no()%>"><%=cVo.getPro_title()%></a>
						<p class="optionContent"><%=cVo.getPro_option()%></p>
						<hr>
						<p class="leftSide"><%=cVo.getPro_price()%> 원</p>
						<p class="rightSide" id="dFee_<%=cVo.getCart_no()%>"><i class="fas fa-truck"></i> <%=cVo.getPro_delivery_fee()%> 원</p>
						<hr class="clear noLine">
						<p><%=cVo.getOption_cnt()%>개</p>
					</div>
					<a href="#" class="deletePro" onclick="deleteBk(<%=cVo.getCart_no()%>)"><i class="fas fa-times"></i></a>
				</li>
			<%} %>
			</ul>
		</div>
		<hr class="m-3">
		<div>
			<h2>배송지 정보</h2>
			<form action="#" method="post" id="sendFrm">
				<label>이름</label>
				<input>
				<label>주소</label>
				<input>
				<label>전화번호</label>
				<input>
				<label>배송<br>요청사항</label>
				<input>
			</form>
		</div>
		<hr class="m-3">
		<div>
			<h2>주문자 정보</h2>
			<form action="#" method="post" id="receiveFrm">
				<label>주문자</label>
				<input>
				<label>전화번호</label>
				<input>
				<label>이메일</label>
				<input>
			</form>
		</div>
		<hr class="m-3">
		<div>
			<h2>쿠폰</h2>
		</div>
		<hr class="m-3">
		<div>
		 	<h2>결제수단</h2>
		 	<table id="paymentTb">
		 		<tr>
		 			<td>카드 결제</td>
		 			<td>실시간 계좌이체</td>
		 			<td>휴대폰 결제</td>
		 			<td>가상계좌</td>
		 		</tr>
		 		<tr>
		 			<td>카카오페이</td>
		 			<td>페이코</td>
		 			<td>토스</td>
		 			<td>차이</td>
		 		</tr>
		 	</table>
		</div>
		<hr class="m-3">
		<div>
			<h2>최종 결제 정보</h2>
			<div id="finalInfo">
				<p class="leftSide">주문 금액</p><div class="rightSide m-p">원</div><p class="rightSide" id="allPrice">0</p>
				<p class="leftSide clear">총 배송비</p><div class="rightSide m-p">원</div><p class="rightSide" id="allDeliver">0</p>
				<p class="leftSide clear">할인금액</p><div class="rightSide m-p">원</div><p class="rightSide" id="discount">0</p>
				<hr class="clear" style="border: solid 1px #CFB9AF">
				<p class="leftSide clear">최종 결제 금액</p><div class="rightSide m-p">원</div><p class="rightSide" id="allPurchase">0</p>
				<hr class="clear noLine">
			</div>
		</div>
	</main>
	<hr class="clear">
	<%@ include file="riceThief_footer.jsp" %>
	<script type="text/javascript">
		function proToggle() {
			$("#basketContainer").slideToggle(1000);
		}
		<% int sum = 0;
		int dsum = 0;
		for(CartDetailVo cVo: pcVoList){
			sum += cVo.getPro_price();
			dsum += cVo.getPro_delivery_fee();
		}
		int allsum = sum + dsum;
		%>
		$("#allPrice").html(<%=sum%>);
		$("#allDeliver").html(<%=dsum%>);
		$("#allPurchase").html(<%=allsum%>);
	</script>
</body>
</html>