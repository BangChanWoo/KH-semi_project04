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
			<input type="checkbox" onclick="allSelect()"> 전체 상품(<%=bkList.size()%>)
			<%for(CartDetailVo cVo: bkList){%>
				<li id="con_<%=cVo.getCart_no()%>">
					<input type="checkbox" id="check_<%=cVo.getCart_no()%>" class="checkPro" value="<%=cVo.getPro_price()%>" onclick="calc($(this), <%=cVo.getCart_no()%>, <%=cVo.getPro_no()%>)">
					<a href="selectproduct?rno=<%=cVo.getPro_no()%>"><img class="bkImg" src="<%=cVo.getPro_img()%>"></a>
					<div class="bkContent">
						<a class="bkTitle" href="selectproduct?rno=<%=cVo.getPro_no()%>"><%=cVo.getPro_title()%></a>
						<p><%=cVo.getPro_option()%></p>
						<hr>
						<p class="leftSide"><%=cVo.getPro_price()%> 원</p>
						<p class="rightSide" id="dFee_<%=cVo.getCart_no()%>"><i class="fas fa-truck"></i> <%=cVo.getPro_delivery_fee()%> 원</p>
						<hr class="clear noLine">
						<div class="btnGroup">
							<button id="minus_<%=cVo.getCart_no()%>" onclick="minusFunc(<%=cVo.getCart_no()%>, <%=cVo.getPro_price()%>)"><i class="fas fa-minus"></i></button>
							<button id="cnt_<%=cVo.getCart_no()%>"><%=cVo.getOption_cnt()%></button>
							<button id="plus_<%=cVo.getCart_no()%>" onclick="plusFunc(<%=cVo.getCart_no()%>, <%=cVo.getPro_price()%>)"><i class="fas fa-plus"></i></button>
						</div>
					</div>
					<a href="#" class="deletePro" onclick="deleteBk(<%=cVo.getCart_no()%>)"><i class="fas fa-times"></i></a>
				</li>
			<%} %>
			</ul>
			<div id="calContainer">
				<div id="calCard">
					<div id="calContent">
						<p class="leftSide">총 상품금액</p><div class="rightSide m-p">원</div><p class="rightSide" id="allPrice">0</p>
						<p class="leftSide clear">총 배송비</p><div class="rightSide m-p">원</div><p class="rightSide" id="allDeliver">0</p>
						<hr class="clear" style="border: solid 1px #CFB9AF">
						<p class="leftSide clear">총 결제예정금액</p><div class="rightSide m-p">원</div><p class="rightSide" id="allPurchase">0</p>
						<hr class="clear noLine">
					</div>
					<button onclick="goPurchase()" id="purchaseBtn">구매하기</button>
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
		function calc(cBox, cno, pno) {
			var sum = parseInt($("#allPrice").text());
			var dsum = parseInt($("#allDeliver").text());
			var allsum = 0;
			if(cBox.is(":checked") == true){
				sum += parseInt(cBox.val()) * parseInt($("#cnt_"+cno).text());
				dsum += parseInt($("#dFee_"+cno).text());
			}
			else{
				sum -= parseInt(cBox.val()) * parseInt($("#cnt_"+cno).text());
				dsum -= parseInt($("#dFee_"+cno).text());
			}
			allsum = sum + dsum;
			$("#allPrice").html(sum);
			$("#allDeliver").html(dsum);
			$("#allPurchase").html(allsum);
		}
		function minusFunc(cno, price){
			var cnt = parseInt($("#cnt_"+cno).text())-1;
			if(cnt > 0){
				$("#cnt_"+cno).html(cnt);
				$.ajax({
					type : "GET",
			        url:"minus.do",
			        data: {cno: cno},
			        dataType: "json",
			        success : function(data){
			        	if(data == "success"){
			        		var sum = parseInt($("#allPrice").text());
			    			var allSum = parseInt($("#allPurchase").text());
			    			if($("#check_"+cno).is(":checked") == true){
			    				sum -= parseInt(price);
			    				allSum -= parseInt(price);
			    			}
			    			$("#allPrice").html(sum);
			    			$("#allPurchase").html(allSum);
			        	}
			        },
			        error : function(e) {
			        	alert(e.responseText);
			        }
			    });
			}else{
				location.href="#";
			}
		}
		function plusFunc(cno, price){
			var cnt = parseInt($("#cnt_"+cno).text())+1;
			$("#cnt_"+cno).html(cnt);
			$.ajax({
				type : "GET",
		        url:"plus.do",
		        data: {cno: cno},
		        dataType: "json",
		        success : function(data){
		        	if(data == "success"){
		        		var sum = parseInt($("#allPrice").text());
		    			var allSum = parseInt($("#allPurchase").text());
		    			if($("#check_"+cno).is(":checked") == true){
		    				sum += parseInt(price);
		    				allSum += parseInt(price);
		    			}
		    			$("#allPrice").html(sum);
		    			$("#allPurchase").html(allSum);
		        	}
		        },
		        error : function(e) {
		        	alert(e.responseText);
		        }
		    });
		}
		function deleteBk(cno){
			$.ajax({
				type : "GET",
		        url:"removebasket.do",
		        data: {cno: cno},
		        dataType: "json",
		        success : function(data){
		        	if(data == "success"){
		        		//질문: 왜 삭제 안돼!!!!!!!!
		        		$("#cno_"+cno).remove();
		        		alert("삭제 완료");
		        	}
		        },
		        error : function(e) {
		        	alert("실패");
		        	alert(e.responseText);
		        }
		    });
		}
		function allSelect() {
			$("input[type=checkbox]").prop("checked",true);
		}
		function goPurchase(){
			var pcList = [];
			$('input[id^=check_]:checked').each(function() {
				var cno = $(this).attr("id").split("_")[1];
				pcList.push(cno);
			})
			location.href='payment?pcList='+pcList;
		}
	</script>
</body>
</html>