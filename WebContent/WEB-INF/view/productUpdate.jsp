<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/productInsert.css"/>
<!--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/userlist.css" />-->
<%@page import="user.vo.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="product_post.vo.ProductPost"%>
<%@page import="product_option.vo.ProductOption"%>
<%@page import="product_img.vo.ProductImg"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>



<title>관리자_상품 수정</title>
<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<%
	User LoginInfo = (User)request.getSession().getAttribute("loginInfo");
	String id = null;
	if(LoginInfo != null){
		id = LoginInfo.getUid();
	}
	// 나중ㅇ[ 삭제]
	else{
		id="admin";
	}
	ProductPost vo = (ProductPost)request.getAttribute("vo");
	int pro_no = (int)request.getAttribute("pro_no");
	int optCount=(int)request.getAttribute("optCount");
	int imgCount=(int)request.getAttribute("imgCount");
	ArrayList<ProductOption> ProductOption = (ArrayList<ProductOption>) request.getAttribute("ProductOption");
	ArrayList<ProductImg> ProductImg = (ArrayList<ProductImg>)request.getAttribute("ProductImg");
%>
<%@ include file="./riceThief_adminHeader.jsp"%>
	<hr>
	<main>
	<h2 align = center>상품 수정</h2>
		<form method="post" action="updateproduct" enctype="multipart/form-data" id="header">
		<input type="hidden" name="pro_no" id="pro_no" readonly="readonly" value="<%=pro_no%>">
		
			<div id="header">
				<div id="titleImgContainer">
					<p align="center">상품 대표 사진</p>
					<input type="hidden" name="defaultTitleImg" id="defaultTitleImg" value="<%=vo.getPro_img()%>">
					<img id="titleImg" src="<%=vo.getPro_img()%>"> 
					<input type="file"name="uploadTitleImg" id="uploadTitleImg" class="hidden_input" accept="image/jpeg, image/jpg, image/png" required="required">
				</div>
				<div id="txtContainer">
					<br> <label>상품 제목</label> 
					<input type="text" name="productTitle" id="productTitle" required="required" placeholder=" 예) 수제 치즈 폭탄 돈까스 " value="<%=vo.getPro_title() %>"> <br> <br> 
					<label>상품 수량</label>
					<input type="text" name="productStock" id="productStock" required="required" placeholder=" 예) 100 " value="<%=vo.getPro_stock() %>"> 
					<br> <br>
					<div id="productContainer">
						<h3>상품 옵션</h3>
						<div id="productOption">
						<%int iCnt = 0;
						if( ProductOption != null){
							for(ProductOption vo1 : ProductOption){
								iCnt++;
							%>
							<label>상품 이름</label> 
							<input value="<%=vo1.getPro_option_no() %>" type="hidden" name="proOptNameId_<%=iCnt%>" readonly="readonly" >
							<input value="<%=vo1.getPro_option_content() %>" type="text" name="productOptionName_<%=iCnt%>" id="productOptionName_<%=iCnt%>" required="required" placeholder=" 예) 등심 140g" ><br>
							<%} } %>

							<label>상품 가격</label> 
							<input type="text" name="productOptionPrice" id="productOptionPrice_1" required="required" placeholder=" 예) 8900 " value="<%=vo.getPro_price()%>">
							<!--<input name="addButton" type="button" style="cursor: hand" value="추가" id="btn_txtAdd"> <br>-->
						</div>
						<a href='#' id='btn_txtAdd'><i class='fas fa-plus-circle'></i></a><br>
					</div>
					<br> <label>카테고리</label> <select id="cateList" name="cateList" required="required" >
						<option value="6001"<c:if test='${vo.getPro_cate_no() == 6001}'>selected="selected"</c:if>>국/찌개/탕</option>
						<option value="6002"<c:if test='${vo.getPro_cate_no() == 6002}'>selected="selected"</c:if>>김치/젓갈/반찬</option>
						<option value="6003"<c:if test='${vo.getPro_cate_no() == 6003}'>selected="selected"</c:if>>밀키트</option>
						<option value="6004"<c:if test='${vo.getPro_cate_no() == 6004}'>selected="selected"</c:if>>만두/돈까스</option>
						<option value="6005"<c:if test='${vo.getPro_cate_no() == 6005}'>selected="selected"</c:if>>치킨/피자/튀김</option>
						<option value="6006"<c:if test='${vo.getPro_cate_no() == 6006}'>selected="selected"</c:if>>냉동면류/냉동밥</option>
						<option value="6007"<c:if test='${vo.getPro_cate_no() == 6007}'>selected="selected"</c:if>>양념육/해물요리</option>
						<option value="6008"<c:if test='${vo.getPro_cate_no() == 6008}'>selected="selected"</c:if>>샐러드/도시락</option>
					</select> <br> <br> 
					<label>유료 배송</label> 
					<input type="radio" name="fee"value="pay" class="fee_value"> 
					<label>무료배송</label>
					<input type="radio" name="fee" value="free" class="fee_value">  <br> 
					<label>배송비</label><input type="text" name="feeText" class="feeText" value="<%=vo.getPro_delivery_fee()%>">

				</div>
			</div>
			
			<h2 align=center>상품 상세 설명</h2>
			
				<div id="productDetailExplane" >
				<div  id="explane" align="center">
				<%
				int sCnt = 0;
				if( ProductImg != null){
					for(ProductImg vo2 : ProductImg){
						sCnt++;
					%>				
					<input type="hidden" name="stepId_<%=sCnt%>" id="stepId_<%=sCnt%>" readonly="readonly" value="<%=vo2.getPro_content_no()%>">
					<div id="stepImgContainer">
					<input type="hidden" name="defaultStepImg_<%=sCnt%>" id="defaultStepImg_<%=sCnt%>" value="<%=vo2.getPro_content_img()%>">
					<img src="<%=vo2.getPro_content_img()%>" name="stepImg_<%=sCnt+1%>" id="stepImg_<%=sCnt%>"alt="상품 상세 정보 순서"> 
					<input value="<%=vo2.getPro_content_img()%>" type="file"name="uploadStepImg_<%=sCnt%>" >
					
					</div>
					<%} } %>
					<input name="addButton" type="button" style="cursor: hand"id="img_btn" value="추가">
					</div>
					
				</div>
			
			
			<input type="hidden" name="optionCount" id="optionCount" readonly value="1">
            <input type="hidden" name="stepCount" id="stepCount" readonly value="1">
			
			<div class="btnContainer">
				<button type="submit" id="saveBtn" class="productBtn">수정</button>
				
				<button type="button" id="cancleBtn" class="productBtn" onclick="location.href='main?msg=게시글 작성을 취소하였습니다.'">취소</button>
			
		</form>
		<form method="get" action="deleteproduct" >
			<input type="hidden" name="pro_no" value="<%=pro_no%>">
			<button type="submit" id="saveBtn" class="productBtn">수정</button>
		</form>
		</div>
	</main>
    <!-- <%@ include file="riceThief_footer.jsp" %> -->
		<script>
		//배송비 
			$('.fee_value').on('click', function() {
				var valueCheck = $('.fee_value:checked').val();
				// 체크된 Radio 버튼의 값을 가져옵니다.
				if (valueCheck == 'pay') {
					$('.feeText').val('');
					$('.feeText').attr('disabled', false);
					$('.feeText').focus();
				} else {
					$('.feeText').val(0);
					$('.feeText').attr('disabled', true);
				}
			});
		
			$('#btn_txtAdd').click(function(e){ e.preventDefault(); });
		    $('#img_btn').click(function(e){ e.preventDefault(); });
		    
		    //상품 옵션 
		    var proOptNameId = <%=iCnt%>;
			var proOptPriceId = <%=iCnt%>;
			$("#optionCount").val(proOptNameId);
			
			
			$('#btn_txtAdd').on('click', function() {
				proOptNameId++;
		    	proOptPriceId++;
		    	$("#productContainer").append("<label>상품 이름</label> <input type='text' name='productOptionName_"+proOptNameId+"' id='productOptionName_"+proOptNameId+"'required='required' placeholder=' 예) 등심 140g'><br>");
				//$("#productContainer").append("<label> 상품 가격</label> <input type='text' name='productOptionPrice_"+proOptPriceId+"' id='productOptionPrice_'"+proOptPriceId+"required='required' placeholder=' 예) 8900'><br>");
				$("#optionCount").val(proOptNameId);
				console.log(proOptNameId);
			});
			
			//상품 상세 설명 
		    var stepId =<%=sCnt%>;
			var stepImgId = <%=sCnt%>;
			$("#stepCount").val(stepId);
        	//순서 추가 버튼 클릭
        	//$("#img_btn").click(stepAddFunc);
        	
        	$('#img_btn').on('click', function() {
        		stepId++;
        		stepImgId++;
        		$('#productDetailExplane').append('<div id="stepImgContainer"><img src="./css/alt.JPG" name="stepImg_'+stepId+'" id="stepImg_'+stepId+'" alt="상품 상세 정보 순서"> <input type="file" name="uploadStepImg_'+stepId+'" required="required"></div>');
        		$("#stepCount").val(stepId);
        		console.log(stepId);
        	});
			
		    $('#uploadTitleImg').change(function(){
	        	readTitle(this);
	        });
		    
	        function readTitle(input) {
	        	if (input.files && input.files[0]) {
	        		var reader = new FileReader();
	        		
	        		reader.onload = function (e) {
	        			$('#titleImg').attr('src', e.target.result);  
	        		}
	        		reader.readAsDataURL(input.files[0]);
	        	}
	        }
	        
	        $("input[id^='uploadStepImg_']").change(function(){
	        	console.log($(this).attr('id').charAt(14));
	        	var num = $(this).attr('id').charAt(14);
	    		readStep(this, num);
	        });
	        function readStep(input, num) {
	        	console.log(num);
	        	if (input.files && input.files[0]) {
	        		var reader = new FileReader();
	        		
	        		reader.onload = function (e) {
	        			$("#stepImg_"+num).prev().attr('src', e.target.result);
	        		}
	        		reader.readAsDataURL(input.files[0]);
	        	}
	        }
		</script>
		</body>
</html>

