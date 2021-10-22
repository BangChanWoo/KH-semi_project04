<%@page import="cartDetail.vo.CartDetailVo"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basket.css" /><!-- 자체 css -->
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
	
 	ArrayList<CartDetailVo> bkList = (ArrayList<CartDetailVo>)request.getAttribute("bkList");
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
	<main>
		<h2><i class="fas fa-shopping-cart"></i> ${sessionNickname}님의 장바구니</h2>
		<div id="flexContainer">
			<ul id="basketContainer">
			<%for(CartDetailVo cVo: bkList){%>
				<li>
					<input type="checkbox" class="checkPro" value="<%=cVo.getPro_price()%>" onclick="calc($(this), <%=cVo.getCart_no()%>, <%=cVo.getPro_no()%>)">
					<a href="selectproduct?rno=<%=cVo.getPro_no()%>"><img class="bkImg" src="<%=cVo.getPro_img()%>"></a>
					<div class="bkContent">
						<a class="bkTitle" href="selectproduct?rno=<%=cVo.getPro_no()%>"><%=cVo.getPro_title()%></a>
						<p><%=cVo.getPro_option()%></p>
						<hr>
						<p class="leftSide"><%=cVo.getPro_price()%> 원</p>
						<p class="rightSide" id="dFee_<%=cVo.getCart_no()%>"><i class="fas fa-truck"></i> <%=cVo.getPro_delivery_fee()%> 원</p>
						<hr class="clear noLine">
						<div class="btnGroup">
							<button id="minus_<%=cVo.getCart_no()%>" onclick="minusFunc(<%=cVo.getCart_no()%>)"><i class="fas fa-minus"></i></button>
							<button id="cnt_<%=cVo.getCart_no()%>"><%=cVo.getOption_cnt()%></button>
							<button id="plus_<%=cVo.getCart_no()%>" onclick="plusFunc(<%=cVo.getCart_no()%>)"><i class="fas fa-plus"></i></button>
						</div>
					</div>
					<a href="#" class="deletePro"><i class="fas fa-times"></i></a>
				</li>
			<%} %>
			</ul>
			<div id="calContainer">
				<div id="calCard">
					<div id="calContent">
						<p class="leftSide">총 상품금액</p><p class="rightSide" id="allPrice">0 원</p>
						<p class="leftSide clear">총 배송비</p><p class="rightSide" id="allDeliver">0 원</p>
						<hr class="clear" style="border: solid 1px #CFB9AF">
						<p class="leftSide clear">총 결제예정금액</p><p class="rightSide" id="allPurchase">0 원</p>
					</div>
					<button onclick="location.href='#'" id="purchaseBtn">구매하기</button>
				</div>
			</div>
		</div>
		<hr class="clear noLine">
	</main>
	<hr class="clear noLine">
	<a href="productboard" id="ingBtn"><i class="fas fa-reply"></i> 쇼핑 계속하기</a>
	<hr class="clear">
	<%@ include file="riceThief_footer.jsp" %>
	<script type="text/javascript">
		var sum = 0;
		var dsum = 0;
		var allsum = 0;
		function calc(cBox, cno, pno) {
			if(cBox.is(":checked") == true){
				sum += parseInt(cBox.val()) * parseInt($("#cnt_"+cno).text());
				dsum += parseInt($("#dFee_"+cno).text());
			}
			else{
				sum -= parseInt(cBox.val()) * parseInt($("#cnt_"+cno).text());
				dsum -= parseInt($("#dFee_"+cno).text());
			}
			allsum = sum + dsum;
			$("#allPrice").html(sum+" 원");
			$("#allDeliver").html(dsum+" 원");
			$("#allPurchase").html(allsum+" 원");
		}
		function minusFunc(cno){
			var cnt = parseInt($("#cnt_"+cno).text())-1;
			if(cnt > 0){
				$("#cnt_"+cno).html(cnt);
			}else{
				location.href="#";
			}
		}
		function plusFunc(cno){
			var cnt = parseInt($("#cnt_"+cno).text())+1;
			if(cnt < 11){
				$("#cnt_"+cno).html(cnt);
			}else{
				alert("대량 구매하시려면 관리자에게 문의 부탁드립니다.")
			}
		}
	</script>
</body>
</html>