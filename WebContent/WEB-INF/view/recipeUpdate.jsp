<%@page import="recipe_steps.vo.RecipeSteps"%>
<%@page import="ingredient.vo.Ingredient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="recipe.model.vo.Recipe"%>
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
<%
	User memberLoginInfo = (User)request.getSession().getAttribute("loginInfo");
	String id = null;
	if(memberLoginInfo != null){
		id = memberLoginInfo.getUid();
	}
	Recipe vo = (Recipe)request.getAttribute("vo");
	int rno = (int)request.getAttribute("rno");
	
	ArrayList<Ingredient> ingreList = (ArrayList<Ingredient>)request.getAttribute("ingreList");
	ArrayList<RecipeSteps> stepList = (ArrayList<RecipeSteps>)request.getAttribute("stepList");
	
%>
	<%@ include file="riceThief_header.jsp" %>
	<hr>
    <main>
        <form method="post" action="updaterecipe" enctype="multipart/form-data" id="contentFrm">
        <input type="hidden" name="rno" id="rno" readonly="readonly" value="<%=rno%>">
        <input type="hidden" name="writer" id="writer" readonly="readonly" value="<%=vo.getUid()%>">
            <div id="contentContainer">
                <div id="titleImgContainer">
                    <img id="titleImg" src="<%=vo.getRec_img()%>">
                    <input data-buttontext="<%=vo.getRec_img()%>" value="<%=vo.getRec_img()%>" type="file" name="uploadTitleImg" id="uploadTitleImg" class="hidden_input" accept="image/jpeg, image/jpg, image/png">
                    <p>레시피 대표 사진</p>
                </div>
                <div id="txtContainer">
                    <label>레시피 제목</label>
                    <input type="text" name="recipeTitle" id="recipeTitle" required="required" placeholder=" 예) 노오븐 케이크 만들기 " value="<%=vo.getRec_title()%>">

                    <label>레시피 소개</label>
                    <textarea  name="recipeIntro" id="recipeIntro" required="required" placeholder=" 예) 오븐 없이 간단하게 만드는 케이크 레시피"><%=vo.getRec_summary()%></textarea>

                    <label>동영상</label>
                    <textarea name="recipeVideo" id="recipeVideo" placeholder=" 예) https://www.youtube.com/watch?v=oJPmqm6QgUA"><%=vo.getRec_video()%></textarea>

                    <label>카테고리</label>
                    <select id="cateList" name="cateList" required="required">
                        <option value="default">종류별</option>
                        <option value="63" <c:if test='${vo.getRec_cate_no() == 63}'>selected="selected"</c:if>>밑반찬</option>
                        <option value="56" <c:if test='${vo.getRec_cate_no() == 56}'>selected="selected"</c:if>>메인반찬</option>
                        <option value="54" <c:if test='${vo.getRec_cate_no() == 54}'>selected="selected"</c:if>>국/탕</option>
                        <option value="55" <c:if test='${vo.getRec_cate_no() == 55}'>selected="selected"</c:if>>찌개</option>
                        <option value="60" <c:if test='${vo.getRec_cate_no() == 60}'>selected="selected"</c:if>>디저트</option>
                        <option value="53" <c:if test='${vo.getRec_cate_no() == 53}'>selected="selected"</c:if>>면/만두</option>
                        <option value="52" <c:if test='${vo.getRec_cate_no() == 52}'>selected="selected"</c:if>>밥/죽/떡</option>
                        <option value="61" <c:if test='${vo.getRec_cate_no() == 61}'>selected="selected"</c:if>>퓨전</option>
                        <option value="57" <c:if test='${vo.getRec_cate_no() == 57}'>selected="selected"</c:if>>김치/젓갈/장류</option>
                        <option value="58" <c:if test='${vo.getRec_cate_no() == 58}'>selected="selected"</c:if>>양념/소스/잼</option>
                        <option value="65" <c:if test='${vo.getRec_cate_no() == 65}'>selected="selected"</c:if>>양식</option>
                        <option value="64" <c:if test='${vo.getRec_cate_no() == 64}'>selected="selected"</c:if>>샐러드</option>
                        <option value="68" <c:if test='${vo.getRec_cate_no() == 68}'>selected="selected"</c:if>>스프</option>
                        <option value="66" <c:if test='${vo.getRec_cate_no() == 66}'>selected="selected"</c:if>>빵</option>
                        <option value="69" <c:if test='${vo.getRec_cate_no() == 69}'>selected="selected"</c:if>>과자</option>
                        <option value="59" <c:if test='${vo.getRec_cate_no() == 59}'>selected="selected"</c:if>>차/음료/술</option>
                        <option value="62" <c:if test='${vo.getRec_cate_no() == 62}'>selected="selected"</c:if>>기타</option>
                    </select>
                    <label>레시피 정보</label>
                    
                    <div id="listContainer">
                        <label>양</label><label>시간</label><label>난이도</label>
                        <select id="servingList" name="servingList" required="required">
                            <option value="~인분" <c:if test='${vo.getInfo_serving() == "~인분"}'>selected="selected"</c:if>>~ 인분</option>
                            <option value="1인분" <c:if test='${vo.getInfo_serving() == "1인분"}'>selected="selected"</c:if>>1인분</option>
                            <option value="2인분" <c:if test='${vo.getInfo_serving() == "2인분"}'>selected="selected"</c:if>>2인분</option>
                            <option value="3인분" <c:if test='${vo.getInfo_serving() == "3인분"}'>selected="selected"</c:if>>3인분</option>
                            <option value="4인분" <c:if test='${vo.getInfo_serving() == "4인분"}'>selected="selected"</c:if>>4인분</option>
                            <option value="5인분" <c:if test='${vo.getInfo_serving() == "5인분"}'>selected="selected"</c:if>>5인분</option>
                            <option value="6인분" <c:if test='${vo.getInfo_serving() == "6인분"}'>selected="selected"</c:if>>대량</option>
                        </select>
                        
                        <select id="timeList" name="timeList" required="required">
                            <option value="시간" <c:if test='${vo.getInfo_time() == "시간"}'>selected="selected"</c:if>>시간</option>
                            <option value="30분 미만" <c:if test='${vo.getInfo_time() == "30분 미만"}'>selected="selected"</c:if>>30분 미만</option>
                            <option value="1시간 미만" <c:if test='${vo.getInfo_time() == "1시간 미만"}'>selected="selected"</c:if>>1시간 미만</option>
                            <option value="1시간 30분 미만" <c:if test='${vo.getInfo_time() == "1시간 30분 미만"}'>selected="selected"</c:if>>1시간 30분 미만</option>
                            <option value="2시간 미만" <c:if test='${vo.getInfo_time() == "2시간 미만"}'>selected="selected"</c:if>>2시간 미만</option>
                            <option value="2시간 30분 미만" <c:if test='${vo.getInfo_time() == "2시간 30분 미만"}'>selected="selected"</c:if>>2시간 30분 미만</option>
                            <option value="3시간 미만" <c:if test='${vo.getInfo_time() == "3시간 미만"}'>selected="selected"</c:if>>3시간 미만</option>
                            <option value="3시간 30분 미만" <c:if test='${vo.getInfo_time() == "3시간 30분 미만"}'>selected="selected"</c:if>>3시간 30분 미만</option>
                            <option value="4시간 미만" <c:if test='${vo.getInfo_time() == "4시간 미만"}'>selected="selected"</c:if>>4시간 미만</option>
                            <option value="4시간 이상" <c:if test='${vo.getInfo_time() == "4시간 이상"}'>selected="selected"</c:if>>4시간 이상</option>
                        </select>
                        
                        <select id="levelList" name="levelList" required="required">
                            <option value="난이도" <c:if test='${vo.getInfo_level() == "난이도"}'>selected="selected"</c:if>>난이도</option>
                            <option value="초급" <c:if test='${vo.getInfo_level() == "초급"}'>selected="selected"</c:if>>초급</option>
                            <option value="중급" <c:if test='${vo.getInfo_level() == "중급"}'>selected="selected"</c:if>>중급</option>
                            <option value="고급" <c:if test='${vo.getInfo_level() == "고급"}'>selected="selected"</c:if>>고급</option>
                        </select>
                    </div>

                    <label>레시피 tip</label>
                    <textarea name="recipeTip" id="recipeTip" required="required"  placeholder=" 예) 판 젤라틴은 찬물에 10분간 불린 후, 손으로 짜서 물기를 제거해주세요"><%=vo.getRec_tip()%></textarea>
                </div>
            </div>
            <div id="ingreContainer">
                <h2>레시피 재료</h2>
                <div id="ingreAddContainer">
                <%int iCnt = 0;
                for(; iCnt<ingreList.size(); iCnt++) { %>
                	<input type="hidden" name="ingreId_<%=iCnt+1%>" id="ingreId_<%=iCnt+1%>" readonly="readonly" value="<%=ingreList.get(iCnt).getIngre_no()%>">
                    <input value="<%=ingreList.get(iCnt).getIngre_name()%>" name="recipeIngre_<%=iCnt+1%>" type="text" id="recipeIngre_<%=iCnt+1%>" required="required"  placeholder=" 예) 버터">
                    <input value="<%=ingreList.get(iCnt).getIngre_unit()%>" name="recipeIngreUnit_<%=iCnt+1%>" type="text" id="recipeIngreUnit_<%=iCnt+1%>" required="required"  placeholder=" 예) 30g"><br>
                <%} %>
                </div>
                <a href='#' id='ingreAdd'><i class='fas fa-plus-circle'></i></a><br>
            </div>
            <div id="stepContainer">
                <h2>레시피 순서</h2>
                <div>
                	<ul id="step">
                	<%int sCnt = 0;
                	for(;sCnt<stepList.size(); sCnt++) { %>
	                    <li>
	                    	<input type="hidden" name="stepId_<%=sCnt+1%>" id="stepId_<%=sCnt+1%>" readonly="readonly" value="<%=stepList.get(sCnt).getStep_no()%>">
	                        <h2>Step 1</h2>
	                        <div class="stepContent">
	                            <div id="stepTxt">
	                                <label>레시피 내용</label>
	                                <textarea name="recipeContent_<%=sCnt+1%>" type="text" id="recipeContent_<%=sCnt+1%>" required="required"><%=stepList.get(sCnt).getStep_content()%></textarea>
	                            </div>
	                            <div id="stepImgContainer">
	                            	<img src="<%=stepList.get(sCnt).getStep_img()%>" name="stepImg_<%=sCnt+1%>" id="stepImg_<%=sCnt+1%>" alt="레시피 순서">
	                            	<input value="<%=stepList.get(sCnt).getStep_img()%>" type="file" name="uploadStepImg_<%=sCnt+1%>">
	                            </div>
	                        </div>
	                    </li>
	                <%} %>
	                </ul>
                </div>
                <a href='#' id='stepAdd'><i class='fas fa-plus-circle'></i></a><br>
            </div>
            <input type="hidden" name="ingreCount" id="ingreCount" readonly="readonly" value="1">
            <input type="hidden" name="stepCount" id="stepCount" readonly="readonly" value="1">
            <div class="btnContainer">
                <button type="submit" id="saveBtn" class="recipeBtn">저장</button>
                <button type="button" id="cancleBtn" class="recipeBtn" onclick="location.href='selectrecipe?rno=<%=rno%>&msg=cancle'">취소</button>
            </div>
        </form>
    </main>
    <hr class="clear">
    <%@ include file="riceThief_footer.jsp" %>
    
    <script>
	    $('#ingreAdd').click(function(e){ e.preventDefault(); });
	    $('#stepAdd').click(function(e){ e.preventDefault(); });
    	//재료
        var ingreId = <%=iCnt%>;
        var ingreUnitId = <%=iCnt%>;
        $("#ingreCount").val(ingreId);
        //재료 추가 버튼 클릭
        $("#ingreAdd").click(ingreAddFunc);
        
        function ingreAddFunc(){
            ingreId++;
            ingreUnitId++;
            $("#ingreAddContainer").append("<input type='text' name='recipeIngre_"+ ingreId +"' id='recipeIngre_"+ ingreId +"' required='required' placeholder=' 예) 버터' style='margin: 1rem'>");
            $("#ingreAddContainer").append("<input type='text' name='recipeIngreUnit_"+ ingreUnitId +"' id='recipeIngreUnit_"+ ingreUnitId +"' required='required' placeholder=' 예) 30g'style='margin: 1rem'><br>");
            $("#ingreCount").val(ingreId);
        }
        
        //순서
        var stepId = <%=sCnt%>;
        var stepImgId = <%=sCnt%>;
        $("#stepCount").val(stepId);
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
        $("#uploadTitleImg").change(function(){
        	readURL(this);
        });
        function readURL(input) {
        	if (input.files && input.files[0]) {
        		var reader = new FileReader();
        		
        		reader.onload = function (e) {
        			$('#titleImg').attr('src', e.target.result);  
        		}
        		reader.readAsDataURL(input.files[0]);
        	}
        }
        //순서 이미지 넣어야함
    </script>
</body>
</html>