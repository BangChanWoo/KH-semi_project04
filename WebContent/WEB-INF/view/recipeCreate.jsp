<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/recipeCreate.css"/>

<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>밥도둑_게시글 작성</title>
</head>
<body>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <form method="post" action="insertrecipe.kh" enctype="multipart/form-data" id="contentFrm">
            <div id="contentContainer">
                <div id="titleImgContainer">
                    <img id="titleImg" src="./css/alt.JPG">
                    <input type="file" name="uploadTitleImg" id="uploadTitleImg" class="hidden_input" accept="image/jpeg, image/jpg, image/png" required="required">
                    <p>레시피 대표 사진</p>
                </div>
                <div id="txtContainer">
                    <label>레시피 제목</label>
                    <input type="text" name="recipeTitle" id="recipeTitle" required="required" placeholder=" 예) 노오븐 케이크 만들기 ">

                    <label>레시피 소개</label>
                    <textarea  name="recipeIntro" id="recipeIntro" required="required" placeholder=" 예) 오븐 없이 간단하게 만드는 케이크 레시피"></textarea>

                    <label>동영상</label>
                    <textarea name="recipeVideo" id="recipeVideo" placeholder=" 예) https://www.youtube.com/watch?v=oJPmqm6QgUA"></textarea>

                    <label>카테고리</label>
                    <select id="cateList" name="cateList" required="required">
                        <option value="62">종류별</option>
                        <option value="63">밑반찬</option>
                        <option value="56">메인반찬</option>
                        <option value="54">국/탕</option>
                        <option value="55">찌개</option>
                        <option value="60">디저트</option>
                        <option value="53">면/만두</option>
                        <option value="52">밥/죽/떡</option>
                        <option value="61">퓨전</option>
                        <option value="57">김치/젓갈/장류</option>
                        <option value="58">양념/소스/잼</option>
                        <option value="65">양식</option>
                        <option value="64">샐러드</option>
                        <option value="68">스프</option>
                        <option value="66">빵</option>
                        <option value="69">과자</option>
                        <option value="59">차/음료/술</option>
                        <option value="62">기타</option>
                    </select>

                    <label>레시피 정보</label>
                    
                    <div id="listContainer">
                        <label>양</label><label>시간</label><label>난이도</label>
                        <select id="servingList" name="servingList" required="required">
                            <option value="~인분">~ 인분</option>
                            <option value="1인분">1인분</option>
                            <option value="2인분">2인분</option>
                            <option value="3인분">3인분</option>
                            <option value="4인분">4인분</option>
                            <option value="5인분">5인분</option>
                            <option value="6인분">대량</option>
                        </select>
                        
                        <select id="timeList" name="timeList" required="required">
                            <option value="시간">시간</option>
                            <option value="30분 미만">30분 미만</option>
                            <option value="1시간 미만">1시간 미만</option>
                            <option value="1시간 30분 미만">1시간 30분 미만</option>
                            <option value="2시간 미만">2시간 미만</option>
                            <option value="2시간 30분 미만">2시간 30분 미만</option>
                            <option value="3시간 미만">3시간 미만</option>
                            <option value="3시간 30분 미만">3시간 30분 미만</option>
                            <option value="4시간 미만">4시간 미만</option>
                            <option value="4시간 이상">4시간 이상</option>
                        </select>
                        
                        <select id="levelList" name="levelList" required="required">
                            <option value="난이도">난이도</option>
                            <option value="초급">초급</option>
                            <option value="중급">중급</option>
                            <option value="고급">고급</option>
                        </select>
                    </div>

                    <label>레시피 tip</label>
                    <textarea name="recipeTip" id="recipeTip"  placeholder=" 예) 판 젤라틴은 찬물에 10분간 불린 후, 손으로 짜서 물기를 제거해주세요"></textarea>
                </div>
            </div>
            <div id="ingreContainer">
                <h2>레시피 재료</h2>
                <div id="ingreAddContainer">
                    <input name="recipeIngre_1" type="text" id="recipeIngre_1" required="required"  placeholder=" 예) 버터">
                    <input name="recipeIngreUnit_1" type="text" id="recipeIngreUnit_1" required="required"  placeholder=" 예) 30g"><br>
                </div>
                <a href='#' id='ingreAdd'><i class='fas fa-plus-circle'></i></a><br>
            </div>
            <div id="stepContainer">
                <h2>레시피 순서</h2>
                <div>
                	<ul id="step">
	                    <li>
	                        <h2>Step 1</h2>
	                        <div class="stepContent">
	                            <div id="stepTxt">
	                                <label>레시피 내용</label>
	                                <textarea name="recipeContent_1" type="text" id="recipeContent_1" required="required"></textarea>
	                            </div>
	                            <div id="stepImgContainer">
	                            	<img src="./css/alt.JPG" name="stepImg_1" id="stepImg_1" alt="레시피 순서">
	                            	<input type="file" name="uploadStepImg_1" id="uploadStepImg_1" required="required">
	                            </div>
	                        </div>
	                    </li>
	                </ul>
                </div>
                <a href='#' id='stepAdd'><i class='fas fa-plus-circle'></i></a><br>
            </div>
            <input type="hidden" name="ingreCount" id="ingreCount" readonly value="1">
            <input type="hidden" name="stepCount" id="stepCount" readonly value="1">
            <div class="btnContainer">
                <button type="submit" id="saveBtn" class="recipeBtn">저장</button>
                <button type="button" id="cancleBtn" class="recipeBtn" onclick="location.href='main?msg=cancle">취소</button>
            </div>
        </form>
    </main>
    <hr class="clear">
    <%@ include file="riceThief_footer.jsp" %>
    
    <script>
	    $('#ingreAdd').click(function(e){ e.preventDefault(); });
	    $('#stepAdd').click(function(e){ e.preventDefault(); });
    	//재료
        var ingreId = 1;
        var ingreUnitId = 1;
        //재료 추가 버튼 클릭
        $("#ingreAdd").click(ingreAddFunc);
        
        function ingreAddFunc(){
            ingreId++;
            ingreUnitId++;
            $("#ingreAddContainer").append("<input type='text' name='recipeIngre_"+ ingreId +"' id='recipeIngre_"+ ingreId +" required='required' placeholder=' 예) 버터' style='margin: 1rem'>");
            $("#ingreAddContainer").append("<input type='text' name='recipeIngreUnit_"+ ingreUnitId +"' id='recipeIngreUnit_"+ ingreUnitId +" required='required' placeholder=' 예) 30g'style='margin: 1rem'><br>");
            $("#ingreCount").val(ingreId);
        }
        
        //순서
        var stepId = 1;
        var stepImgId = 1;
        //순서 추가 버튼 클릭
        $("#stepAdd").click(stepAddFunc);
        
        function stepAddFunc(){
        	stepId++;
            stepImgId++;
            $("#step").append('<li><h2>Step '+stepId+'</h2><div class="stepContent"><div id="stepTxt"><label>레시피 내용</label><textarea name="recipeContent_'+stepId+'" type="text" id="recipeContent_'+stepId+'" required="required"></textarea></div><div id="stepImgContainer"><img src="./css/alt.JPG" name="stepImg_'+stepId+'" id="stepImg_'+stepId+'" alt="레시피 순서"><input type="file" name="uploadStepImg_'+stepId+'" required="required"></div></div></li>');
            $("#recipeIngre_"+ingreId).css("margin", "1rem");
            $("#stepCount").val(stepId);
        }
        //미리보기
        // 이벤트를 바인딩해서 input에 파일이 올라올때 위의 함수를 this context로 실행합니다.
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
        //순서 이미지 넣어야함
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