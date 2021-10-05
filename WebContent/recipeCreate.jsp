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

<!-- javascript -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/recipeCreate.js"></script>
<!-- jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>밥도둑_게시글 작성</title>
</head>
<body>
	<%@ include file="../WEB-INF/riceThief_header.jsp" %>
	<hr>
    <main>
        <form method="get" action="insertrecipe.kh" id="contentFrm">
            <div id="contentContainer">
                <div id="titleImgContainer">
                    <img id="titleImg" src="./css/alt.JPG">
                    <div id="dropTitleImg">
                        <input type="text" name="dropTitleLabel" id="dropTitleLabel" value="이곳에 사진 파일 드랍" required="required">
                    </div>
                    <p>레시피 대표 사진</p>
                </div>
                <div id="txtContainer">
                    <label>레시피 제목</label>
                    <input type="text" name="recipeTitle" id="recipeTitle" required="required" placeholder=" 예) 노오븐 케이크 만들기 ">

                    <label>레시피 소개</label>
                    <textarea  name="recipeIntro" id="recipeIntro" required="required" placeholder=" 예) 오븐 없이 간단하게 만드는 케이크 레시피"></textarea>

                    <label>동영상</label>
                    <textarea name="recipeVideo" id="recipeVideo" required="required" placeholder=" 예) https://www.youtube.com/watch?v=oJPmqm6QgUA"></textarea>

                    <label>카테고리</label>
                    <select id="cateList" name="cateList">
                        <option value="cateAll">종류별</option>
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
                        <select id="servingList" name="servingList">
                            <option value="servingAll">~ 인분</option>
                            <option value="1">1인분</option>
                            <option value="2">2인분</option>
                            <option value="3">3인분</option>
                            <option value="4">4인분</option>
                            <option value="5">5인분</option>
                            <option value="6">대량</option>
                        </select>
                        
                        <select id="timeList" name="timeList">
                            <option value="timeAll">시간</option>
                            <option value="1">30분 미만</option>
                            <option value="2">1시간 미만</option>
                            <option value="3">1시간 30분 미만</option>
                            <option value="4">2시간 미만</option>
                            <option value="5">2시간 30분 미만</option>
                            <option value="6">3시간 미만</option>
                            <option value="7">3시간 30분 미만</option>
                            <option value="8">4시간 미만</option>
                            <option value="9">4시간 이상</option>
                        </select>
                        
                        <select id="levelList" name="levelList">
                            <option value="levelAll">난이도</option>
                            <option value="1">초급</option>
                            <option value="2">중급</option>
                            <option value="3">고급</option>
                        </select>
                    </div>

                    <label>레시피 tip</label>
                    <textarea name="recipeTip" id="recipeTip" required="required"  placeholder=" 예) 판 젤라틴은 찬물에 10분간 불린 후, 손으로 짜서 물기를 제거해주세요"></textarea>
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
	                            <img src="./css/alt.JPG" name="stepImg_1" id="stepImg_1" alt="레시피 순서">
	                        </div>
	                    </li>
	                </ul>
                </div>
                <a href='#' id='stepAdd'><i class='fas fa-plus-circle'></i></a><br>
            </div>
            <div class="btnContainer">
                <button type="submit" id="saveBtn" class="recipeBtn">저장</button>
                <button type="button" id="cancleBtn" class="recipeBtn" onclick="location.href='main?msg=게시글 작성을 취소하였습니다.'">취소</button>
            </div>
        </form>
    </main>
    <hr class="clear">
    <%@ include file="../WEB-INF/riceThief_footer.jsp" %>
    
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
            $("#ingreAddContainer").append("<input type='text' name='recipeIngre_"+ ingreId +" id='recipeIngre_"+ ingreId +" required='required' placeholder=' 예) 버터'>");
            $("#ingreAddContainer").append("<input type='text' name='recipeIngreUnit_"+ ingreUnitId +" id='recipeIngreUnit_"+ ingreUnitId +" required='required' placeholder=' 예) 30g'><br>");
        }
        
        //순서
        var stepId = 1;
        var stepImgId = 1;
        //재료 추가 버튼 클릭
        $("#stepAdd").click(stepAddFunc);
        
        function stepAddFunc(){
            stepId++;
            stepImgId++;
            $("#step").append("<li><h2>Step " + stepId + "</h2><div class='stepContent'><div id='stepTxt'><label>레시피 내용</label><textarea type='text' name='recipeContent_"+stepId+"' id='recipeContent_"+stepId+"' required='required'></textarea></div><img src='./css/alt.JPG' name='stepImg_"+stepImgId+"' id='stepImg_"+stepImgId+"' alt='레시피 순서'></div></li>");
            $("#recipeIngre_"+ingreId).css("margin", "1rem");
        }




        //드랍 영역 이벤트 등록하기
        var dropTitleImg = document.getElementById("dropTitleImg");
        //var dropImg = document.getElementById("dropImg");

        // 이벤트 핸들러 할당
        dropTitleImg.addEventListener("dragenter", dragEnter, false);
        dropTitleImg.addEventListener("dragexit", dragExit, false);
        dropTitleImg.addEventListener("dragover", dragOver, false);
        dropTitleImg.addEventListener("drop", drop, false);
        //event.stopPropagation();
        //event.preventDefault();
    
        var labelName = "#dropTitleLabel"
        //console.log(labelName);

        //drop 이벤트 헨들러 작성하기
        function dragEnter(event) {
            event.stopPropagation();
            event.preventDefault();
        }
        function dragExit(event) {
            event.stopPropagation();
            event.preventDefault();
        }
        function dragOver(event) {
            event.stopPropagation();
            event.preventDefault();
        }
        function drop(event) {
            event.stopPropagation();
            event.preventDefault();

            var files = event.dataTransfer.files;
            var count = files.length;
            
            // 오직 한개 이상의 파일이 드랍된 경우에만 처리기를 호출한다.
            if (count > 0)
                handleFiles(files, labelName);
        }


        // 오직 한개 이상의 파일이 드랍된 경우에만 처리기를 호출한다.
        function handleFiles(files, labelName) {
            var file = files[0];
            $(labelName).val("Processing " + file.name);
            var reader = new FileReader();

            // 파일 리더의 이베트 핸들러 정의
            reader.onloadend = handleReaderLoadEnd;
            
            // 파일을 읽는 작업 시작
            reader.readAsDataURL(file);
        }

        function handleReaderLoadEnd(event) {
            var img = document.getElementById("titleImg");
            img.src = event.target.result;
        }        
    </script>
</body>
</html>