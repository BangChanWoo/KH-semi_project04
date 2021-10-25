<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/productDetail.css"/>
<%@page import="product_post.vo.ProductPost"%>
<%@page import="product_img.vo.ProductImg"%>
<%@page import="product_option.vo.ProductOption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/mypage.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jquery -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/httpRequest.js"></script> 
<title>밥도둑_스토어 상품 상세조회</title>
</head>
<body>
<%
	session.getAttribute("sessionID");
	session.getAttribute("sessionNickname");
	
	ProductPost vo = (ProductPost)request.getAttribute("vo");
	int rno = (int)request.getAttribute("rno"); 
	ArrayList<ProductOption> optionList = (ArrayList<ProductOption>)request.getAttribute("optionList");
	ArrayList<ProductImg> proImgList = (ArrayList<ProductImg>)request.getAttribute("proImgList");

%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
      <div id="contentContainer">
        <div id="detailImgContainer">
            <img src="<%=vo.getPro_img()%>" id="titleImg" alt="상품 대표 사진">
        </div>
        <div id="detailContainer">
        	<div id="detailTitleContainer">
	     	    <h2 id="detailTitle" class="categoryProductTitle"><%=vo.getPro_title()%></h2>
     		</div>
     		<div id="detailPriceContainer">
    	 	    <h3 id="detailPrice" class="categoryProductPrice"><%=vo.getPro_price()%>원</h3>
    	 	    
    	 	<!-- 좋아요, 공유하기 -->        	 	    
    	 	   <div id="likeContainer">
	        <c:if test="${not empty sessionID}">
	            <c:if test="${like == 'yes'}">
	            	<a href="likeornotpro?like=yes&rno=<%=rno%>" id="likeProduct"><i class="fas fa-heart"></i></a>
	            </c:if>
	            <c:if test="${like == null}">
	            	<a href="likeornotpro?rno=<%=rno%>" id="likeProduct"><i class="far fa-heart"></i></a>
	            </c:if>
            </c:if>
            
            <a href="#" onclick="productShare()" id="shareProduct"><i class="fas fa-share-square"></i></a>
    	 	   </div>
     	    </div>        	
        	<h3 id="deilveryFee">배송비 <%=vo.getPro_delivery_fee()%>원 </h3>
        	
        	<!-- 선택 옵션 -->
        	<form action="#">
					<!-- 사용안됨 <label for="productOption"></label> -->
					<select id="option">
						<% if(optionList != null){
						for(int i=0; i<optionList.size(); i++){ %>
						<option id="<%=optionList.get(i).getPro_option_no()%>">
							<%=optionList.get(i).getPro_option_content()%>
						</option>
						<%} } %>
					</select>
				</form>
				<div id="selectedContainer">
					<div class="option_column">
					    <div class="option_info_label">옵션정보</div>
	                    <div class="quantity">수량</div>
	                    <!-- <div class="price">상품금액</div> -->
	                   </div>
	                   <ul class="option_list">
	                   	<!-- <li class="item">
						    <div class="option_info">옵션정보</div>
		                    <div class="quantity"><button type="button" id="minus" class="btn minus">-</button><input type="number" min="1" id="optAmountNum" name="optAmount" class="optAmount" value="${vo.pro_price}" readonly><button type="button" class="btn plus" id="plus">+</button></div>
		                    <div class="price">상품금액</div>
	                   	</li> -->
	                   </ul>
				</div>
			</div>
	    </div>
     	<hr class="clear">
     	<div id="acount">	
        	<p id="allPro">총 상품 금액 : <span class="allselling" id="allSellingPrice"><c:out value="${sum}"/></span><span class="won">원</span><p>
        	<p id="totalPro">총 합계 금액 : <span class="allsum" id="realAllSellingPrice">${sum+2500}</span><span class="won">원</span></p>
  		</div>	
  		<div id="proBtn">
       		<button onclick="goBasket()">장바구니 담기</button>
       		<button onclick="goPurchase()">바로 구매</button>
       	</div>
       	<hr>
       	<div id="productExplain">
       		<h2 id="expTxt">상품 상세정보</h2>
       		<div id="proExplainImg">
       		<%if(proImgList != null){
	            for(int i=0; i<proImgList.size(); i++){%>
       		<img src="<%=proImgList.get(i).getPro_content_img()%>" id="explainImg" alt="상품 상세설명">
       		<%} } %>
       		</div>
       	</div>
       	<hr class="clear">
       	<div id="review">
       		<h2>리뷰</h2>
       		<p>아직 리뷰가 작성되지 않았습니다.</p>
		</div>       	      	
     </main>
     <hr class="clear">
    <%@ include file="riceThief_footer.jsp" %>
	<script type="text/javascript">
	let cnt = 0;
	
	// 선택된 것이 없다면 옵션정보 보이지 않음.
	$("#selectedContainer").hide(); 
	
	$("#option").change(function(){
		// 선택된 데이터의 텍스트값 가져오기
		var value = $(this).val();
		var select_id = $("#option option:selected").attr('id');
		
		var isExistItem = false;
		$(".option_info").each(function(){
			if($(this).text()== value) {  // 기존에 선택된 데이터와 같은 item이 있다면 
				// stat 1 증가
				var $l = $(this).parents('li');
				var stat = $l.find('input.optAmount').val();
				stat = parseInt(stat) + 1;
				// 클릭된 item의 정보 업데이트
				var val = stat * $l.find('input.aprice').val();
				$l.find('#price').val(val);
				$l.find('input.optAmount').val(stat);
				
				// item이 추가되지 않도록 true
				isExistItem = true;
				return;
			}
		});
		
		if(!isExistItem){  // 기존에 선택된 데이터와 같은 것이 없다면 item 추가
			html='';
			html+='<li class="item">';
			html+='<div class="selectId" hidden="hidden">'+ select_id +'</div>'
			html+='<div class="option_info">'+value+'</div>';
			html+='<div class="quantity">';
			// 추가된 버튼 + - 에 click event 등록 clickBtnMinusPlus(this)
			html+='<button type="button" id="minus" class="btn minus" onclick="clickBtnMinusPlus(this);">-</button>';
			html+='<input type="number" min="1" id="optAmountNum" name="optAmount" class="optAmount" value="1" readonly>';
			html+='<button type="button" class="btn plus" id="plus" onclick="clickBtnMinusPlus(this);">+</button>';
			html+='</div>';
			//html+='<div class="price"><input type="hidden" id="price" class="bbprice" value="0"></div>';
			//${vo.pro_price}
			html+='<input type="hidden" id="aprice" class="aprice" value="${vo.pro_price}">';
			html+='<input type="hidden" id="price" class="bbprice" value="${vo.pro_price}">';
			html+='</li>';
			// 선택한 옵션 텍스트 출력
			$(".option_list").append(html);
		}
		
		// 총 가격 계산
		calPrice();
		
		//select태그의 selected를 처음으로 돌리기
		$("#option option:eq(0)").prop("selected", true);
		$("#selectedContainer").show(); 
	});
	// 총 가격 계산
	function calPrice(){
		var sum =0;		
		$('.bbprice').each(function(){
			sum += parseInt($(this).val());
		})
		$('#allSellingPrice').html(sum);
		$('#realAllSellingPrice').html(sum+"${vo.pro_delivery_fee}"*1);
	}
	
	//상품 갯수+가격 조절
	function clickBtnMinusPlus(target){
		var $l = $(target).parents('li');
		var symPlusMinus = $(target).text();
		var plus_value = 0;
		if(symPlusMinus == "+") plus_value= 1 
		else if(symPlusMinus == "-") plus_value = -1;

		var stat = $l.find('input.optAmount').val();
		stat = parseInt(stat) + plus_value;
		if(stat<1){  // 0 개가 되면 상품 삭제
			alert('상품을 삭제합니다.');
			$l.remove();
			return;
		}
		// 클릭된 item의 정보 업데이트
		var val = stat * $l.find('input.aprice').val();
		$l.find('#price').val(val);
		$l.find('input.optAmount').val(stat);
		$l.find('input.optAmount').text(stat);
		
		// 총 가격 계산
		calPrice();
	}
    
    //공유하기
    function productShare(){
		var url = '';
		var textarea = document.createElement("textarea");
		document.body.appendChild(textarea);
		url = window.document.location.href;
		textarea.value = url;
		textarea.select();
		document.execCommand("copy");
		document.body.removeChild(textarea);
		alert("URL이 복사되었습니다.")
	}
    
    function goBasket(){
    	if("${sessionID}" == ""){
    		alert("로그인하셔야 장바구니에 넣을 수 있습니다.");
    	}else{
    		var option = [];
        	var cnt = [];
        	$(".selectId").each(function(){
        		option.push($(this).text());
        	});
        	$(".optAmount").each(function(){
        		cnt.push($(this).val());
        	});
        	
        	var bkList = [];
        	var obj = null;
        	for(var i=0; i<option.length; i++){
        		obj = new Object;
        		obj.option = option[i];
        		obj.cnt = cnt[i];
        		obj.proNo = "${rno}";
        		obj.id = "${sessionID}";
        		bkList.push(obj);
        	}
        	$.ajax({
    			type : "POST",
    	        url:"putbasket.do",
    	        data: JSON.stringify(bkList),
    	        contentType: "application/json; charset=utf-8",
    	        //dataType: "json",
    	        success : function(data){
    	        	if (confirm("장바구니에 상품이 담겼습니다.\n장바구니로 이동하시겠습니까?") == true){
            			location.href = "selectbasket";
            			return true;
            		}else{   
            			return false;
            		}
    	        },
    	        error : function(e) {
    	        	alert("실패");
    	        	//alert(e.responseText);
    	        }
    	    });
    	}
    }
    function goPurchase(){
    	if("${sessionID}" == ""){
    		alert("로그인하셔야 구매할 수 있습니다.");
    	}else{
    		var option = [];
        	var cnt = [];
        	$(".selectId").each(function(){
        		option.push($(this).text());
        	});
        	$(".optAmount").each(function(){
        		cnt.push($(this).val());
        	});
        	
        	var bkList = [];
        	var obj = null;
        	for(var i=0; i<option.length; i++){
        		obj = new Object;
        		obj.option = option[i];
        		obj.cnt = cnt[i];
        		obj.proNo = "${rno}";
        		obj.id = "${sessionID}";
        		bkList.push(obj);
        	}
        	$.ajax({
    			type : "POST",
    	        url:"directpurchase.do",
    	        data: JSON.stringify(bkList),
    	        contentType: "application/json; charset=utf-8",
    	        //dataType: "json",
    	        success : function(data){
    	        	location.href='payment';
    	        },
    	        error : function(e) {
    	        	alert("실패");
    	        	//alert(e.responseText);
    	        }
    	    });
    	}
	}
    </script>
</body>
</html>
