<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/basic.css" />
<!-- 공통 css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/riceThief_header.css" />
<!-- header css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/riceThief_footer.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<title>비밀번호 찾기</title>
<style>
        body{ text-align: center; }
        div{ margin:2rem; }
        .vv{ width:200px; }
    </style>
</head>
<body>
	<header>
		<%@ include file="riceThief_header.jsp" %>
	<hr>
    </header>

    <section>
  		<form method="post" action="checkpwafter">
        <div>
            <i class="fas fa-user-lock">비밀번호 찾고자 하는 아이디를 입력해주세요.</i><br>
            <input type="text" class="vv" name="uid" placeholder="밥도둑 아이디 입력"><br>
                <p>아이디가 기억나지 않는다면?<a href="/WEB-INF/view/findId.jsp" target="_self">아이디 찾기 바로가기</a></p>
            </div>  
               <div>
                <i class="fas fa-user-lock">회원정보로 입력된 이름을 입력해주세요.</i><br>
                <input type="text" class="vv" name="uname" placeholder="회원이름 입력"><br>
                </div>
                <div>
                    <i class="fas fa-user-lock">회원정보로 입력된 핸드폰 번호를 입력해주세요.</i><br>
                	<input type="text" class="vv" name="phone" placeholder="핸드폰 번호 입력"><br>
                </div>
               
                <button id="findpwbtn" onclick="searchPw()">찾기</button>
            </form>
    </section>

    <footer>
	<hr>
       <%@ include file="riceThief_footer.jsp" %>
    </footer>
    <script>
		function searchPw(){
			var name=document.getElementById("uname").value;
			var phone=document.getElementById("phone").value;
			if(name=="" && phone==""){
				alert("모든 정보를 입력해주세요.");
				return false;
			}
			
		}
	</script>
</body>
</html>