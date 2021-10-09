<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/productInsert.css"/>
<!--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/userlist.css" />-->

<title>관리자_상품등록</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>            
        $(document).ready (function () {                
            $('.btn_txtAdd').click (function () {                                        
                $('.t_space').append (                        
                		"<label>상품 이름</label> <input type='text' name='productOptionName' id='productOptionName' required='required' placeholder=' 예) 등심 140g '> <label>상품 가격</label> <input type='text' name='productOptionPrice' id='productOptionPrice' required='required' placeholder=' 예) 8900 '> <input type='button' value='삭제' class='btn_txtRemove'><br>"                   
                		); // end append                            
                $('.btn_txtRemove').on('click', function () { 
                	//$(this).prev().prev().prev().prev().prev().remove ();
                	$(this).prev().prev().prev().prev().remove ();
                	$(this).prev().prev().prev().remove ();
                	$(this).prev().prev().remove ();
                    $(this).prev().remove (); // remove the textbox
                    $(this).next ().remove (); // remove the <br>
                    $(this).next ().next ().remove ();
                    $(this).remove (); // remove the button
                    // document.getElementById(btn).remove();
                    // document.getElementById(btn).prev().remove ();
                    // document.getElementById(btn).next ().remove ();
                    // document.getElementById(btn).remove ();
                });
            }); // end click                                            
        }); // end ready        
    </script> 
</head>
<body>
<%@ include file="./riceThief_adminHeader.jsp"%>
	<hr>
	<main>
	<h2 align = center>상품 등록</h2>
	<form method="post" action="#" enctype="multipart/form-data" >
			<div id="header">
				<div id="titleImgContainer">
					<p align="center">상품 대표 사진</p>
					<img id="titleImg" src="./css/alt.JPG"> <input type="file"
						name="uploadTitleImg" id="uploadTitleImg" class="hidden_input"
						accept="image/jpeg, image/jpg, image/png" required="required">
					<br>
					<br>
				</div>
				<div id="txtContainer">
					<br> <label>상품 제목</label> <input type="text"
						name="productTitle" id="productTitle" required="required"
						placeholder=" 예) 수제 치즈 폭탄 돈까스 "> <br>
					<br> <label>상품 소개</label>
					<textarea name="productIntro" id="productIntro" required="required"
						placeholder=" 예) 국내산 한돈을 사용한 치즈 폭탄 돈까스!"></textarea>
					<br>
					<br> <label><h3>상품 옵션</h3></label>
					<div class="t_space">
						<label>상품 이름</label> 
						<input type="text" name="productOptionName" id="productOptionName" required="required"placeholder=" 예) 등심 140g "> 
						<label>상품 가격</label> 
						<input type="text" name="productOptionPrice" id="productOptionPrice" required="required" placeholder=" 예) 8900 "> 
						<input name="addButton" type="button" style="cursor: hand" value="추가" class="btn_txtAdd">
						<br>
					</div>
					<br>
					<label>카테고리</label> 
					<select id="cateList" name="cateList">
						<option value="6001">국/찌개/탕</option>
						<option value="6002">김치/젓갈/반찬</option>
						<option value="6003">밀키트</option>
						<option value="6004">만두/돈까스</option>
						<option value="6005">치킨/피자/튀김</option>
						<option value="6006">냉동면류/냉동밥</option>
						<option value="6007">양념육/해물요리</option>
						<option value="6008">샐러드/도시락</option>
					</select> <br>
					<br> <label><input type="radio" name="fee" value="pay"
						class="fee_value"> 유료 배송</label> <label><input
						type="radio" name="fee" value="free" class="fee_value"> 무료
						배송</label> <br>
					<label>배송비</label><input type="text" name="feeText" class="feeText">

				</div>
			</div>
			<h2 align = center>상품 상세 설명</h2>
			<div id="body">
			<div id="explane">
				<ul id="step">
				
						<li>
						<input name="addButton" type="button" style="cursor: hand" onClick="add_exTextbox()" value="추가">
							<div class="stepContent">
								<div id="stepTxt">
									<label>상품설명</label>
									<textarea name="productContent_1" type="text"
										id="productContent_1" required="required"></textarea>
								</div>
								<div id="stepImgContainer">
									<img src="./css/alt.JPG" name="stepImg_1" id="stepImg_1"
										alt="레시피 순서"> <input type="file" name="uploadStepImg_1"
										required="required">
								</div>
							</div>
						</li>
				</ul>
				
			</div>
			</div>

			<div class="btnContainer">
                <button type="submit" id="saveBtn" class="productBtn">저장</button>
                <button type="button" id="cancleBtn" class="productBtn" onclick="location.href='main?msg=게시글 작성을 취소하였습니다.'">취소</button>
            </div>     
        </form>
		
		
		
		</main>
		<script>
		$('.fee_value').on('click', function() {
		    var valueCheck = $('.fee_value:checked').val(); 
		    // 체크된 Radio 버튼의 값을 가져옵니다.
		    if(valueCheck == 'pay'){
		    	 $('.feeText').val('');
		    	 $('.feeText').attr('disabled', false);
		    	 $('.feeText').focus();
		    }else{
		    	 $('.feeText').val(0);
		    	 $('.feeText').attr('disabled', true);
		    }
		});
		
		
			
		</script>
		

</body>
</html>