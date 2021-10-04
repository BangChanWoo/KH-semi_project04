<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/riceThief_footer.css" />
<!-- footer css -->
<!--<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/recipeCategory.css" />-->
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/userlist.css" />

<style>
.right-box {
	float: right;
	margin: 10px;
}
main h2 {
	margin: 1rem 0;
	text-align: center;
}
</style>
<title>관리자_회원관리</title>
</head>
<body>
	<%@ include file="../WEB-INF/riceThief_adminHeader.jsp"%>
	<hr>
	<main>
		<h2>회원관리</h2>

		<div class='right-box'>
			<input type="text" placeholder="사용자 아이디 입력">
			<button id="btnSearch">검색</button>
		</div>


		<div class="board_list_wrap">
            <table class="board_list">
                <caption>회원 목록</caption>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>이름</th>
                        <th>상세정보</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>관리자</td>
                        <td>2019-11-20</td>
                        <td class="tit">
                            <a href="#">asd</a>
                        </td>
                        
                   
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>관리자</td>
                        <td>2019-11-12</td>
                        <td class="tit">
                            <a href="#">asd</a>
                        </td>
                        
                        
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>관리자</td>
                        <td>2019-11-02</td>
                        <td class="tit">
                            <a href="#">asd</a>
                        </td>
                        
                      
                    </tr>
                    <tr>
                        <td>4</td>
                         <td>관리자</td>
                        <td>2019-10-28</td>
                        <td class="tit">
                            <a href="#">asd</a>
                        </td>
                       
                
                    </tr>
                    <tr>
                        <td>5</td>
                         <td>관리자</td>
                        <td>2019-10-24</td>
                        <td class="tit">
                            <a href="#">asd</a>
                        </td>
                    </tr>
                    <tr>
                        <td>6</td>
                         <td>관리자</td>
                        <td>2019-10-24</td>
                        <td class="tit">
                            <a href="#">asd</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div class="paging">
                <a href="#" class="bt">첫 페이지</a>
                <a href="#" class="bt">이전 페이지</a>
                <a href="#" class="num on">1</a>
                <a href="#" class="num">2</a>
                <a href="#" class="num">3</a>
                <a href="#" class="bt">다음 페이지</a>
                <a href="#" class="bt">마지막 페이지</a>
            </div>
        </div>
        <div class="gender">
        	<table class="gender_table">
        		<thead>
                    <tr>
                        <th></th>
                        <th>남자</th>
                        <th>여자</th>
                        <th>총</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>남녀 성비</td>
                        <td>50%</td>
                        <td>50%</td>
                        <td>100%</td>
                    </tr>
                 </tbody>
        	</table>
        </div>
        
        <div class="age_group">
        	<table class="age_group_table">
        		<thead>
                    <tr>
                        <th></th>
                        <th>10대</th>
                        <th>20대</th>
                        <th>30대</th>
                        <th>40대</th>
                        <th>50대</th>
                        <th>60대</th>
                        <th>그 외</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>연령대</td>
                        <td>10%</td>
                        <td>20%</td>
                        <td>30%</td>
                        <td>40%</td>
                        <td>50%</td>
                        <td>60%</td>
                        <td>2%</td>
                    </tr>
                 </tbody>
        	</table>
        </div>
		
	</main>
	</hr>
	<%@ include file="../WEB-INF/riceThief_footer.jsp" %>
</body>
</html>