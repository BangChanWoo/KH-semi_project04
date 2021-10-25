<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/productInsert.css"/>
<!--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/userlist.css" />-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>



<title>관리자_상품등록</title>
<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<%@ include file="./riceThief_adminHeader.jsp"%>
	<hr>
	<main>
	<h2 align = center>상품 등록</h2>
		<form method="post" action="insertproduct" enctype="multipart/form-data" id="header">
			<div id="header">
				<div id="titleImgContainer">
					<p align="center">상품 대표 사진</p>
					<img id="titleImg" src="./css/alt.JPG"> <input type="file"name="uploadTitleImg" id="uploadTitleImg" class="hidden_input" accept="image/jpeg, image/jpg, image/png" required="required">
					
				</div>
				<div id="txtContainer">
					<br> <label>상품 제목</label> 
					<input type="text" name="productTitle" id="productTitle" required="required" placeholder=" 예) 수제 치즈 폭탄 돈까스 "> <br> <br> 
					<label>상품 수량</label>
					<input type="text" name="productStock" id="productStock" required="required" placeholder=" 예) 100 "> 
					<br> <br>
					<div id="productContainer">
						<h3>상품 옵션</h3>
						<div id="productOption">
							<label>상품 이름</label> 
							<input type="text" name="productOptionName_1" id="productOptionName_1" required="required" placeholder=" 예) 등심 140g "> 
							<label>상품 가격</label> 
							<input type="text" name="productOptionPrice" id="productOptionPrice_1" required="required" placeholder=" 예) 8900 ">
							<!--<input name="addButton" type="button" style="cursor: hand" value="추가" id="btn_txtAdd"> <br>-->
						</div>
						<a href='#' id='btn_txtAdd'><i class='fas fa-plus-circle'></i></a><br>
					</div>
					<br> <label>카테고리</label> <select id="cateList" name="cateList">
						<option value="6001">국/찌개/탕</option>
						<option value="6002">김치/젓갈/반찬</option>
						<option value="6003">밀키트</option>
						<option value="6004">만두/돈까스</option>
						<option value="6005">치킨/피자/튀김</option>
						<option value="6006">냉동면류/냉동밥</option>
						<option value="6007">양념육/해물요리</option>
						<option value="6008">샐러드/도시락</option>
					</select> <br> <br> 
					<label>유료 배송</label> 
					<input type="radio" name="fee"value="pay" class="fee_value"> 
					<label>무료배송</label>
					<input type="radio" name="fee" value="free" class="fee_value">  <br> 
					<label>배송비</label><input type="text" name="feeText" class="feeText">

				</div>
			</div>
			
			
			
				<div id="productDetailExplane" >
				<h2 align=center>상품 상세 설명</h2>
				<div  id="explane" align="center">
					<div id="stepImgContainer">
					<img src="./css/alt.JPG" name="stepImg_1" id="stepImg_1"alt="상품 상세 정보 순서"> 
					<input type="file"name="uploadStepImg_1" required="required">
					<input name="addButton" type="button" style="cursor: hand"id="img_btn" value="추가">
					</div>
					</div>
					
				</div>
			
			
			<input type="hidden" name="optionCount" id="optionCount" readonly value="1">
            <input type="hidden" name="stepCount" id="stepCount" readonly value="1">
			
			<div class="btnContainer">
				<button type="submit" id="saveBtn" class="productBtn">저장</button>
				<button type="button" id="cancleBtn" class="productBtn"
					onclick="location.href='main?msg=게시글 작성을 취소하였습니다.'">취소</button>
			</div>
		</form>
	</main>
	<hr>
	<%@ include file="riceThief_footer.jsp"%>
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
		    var proOptNameId = 1;
		    var proOptPriceId = 1;
		    
			$('#btn_txtAdd').on('click', function() {
				proOptNameId++;
		    	proOptPriceId++;
		    	$("#productContainer").append("<label>상품 이름</label> <input type='text' name='productOptionName_"+proOptNameId+"' id='productOptionName_"+proOptNameId+"'required='required' placeholder=' 예) 등심 140g'><br>");
				//$("#productContainer").append("<label> 상품 가격</label> <input type='text' name='productOptionPrice_"+proOptPriceId+"' id='productOptionPrice_'"+proOptPriceId+"required='required' placeholder=' 예) 8900'><br>");
				$("#optionCount").val(proOptNameId);
				console.log(proOptNameId);
			});
			
			//상품 상세 설명 
		    var stepId = 1;
        	var stepImgId = 1;
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

