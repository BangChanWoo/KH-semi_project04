<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<title>회원가입</title>
<style>
        body{
            text-align: center;
        }
        #id{
            margin-left: 55px;
        }
        .in{
            margin: 7px;
            
            width: 200px;
        }
        
        #agenum{
            width: 50px;
        }
    </style>
<script>
    window.addEventListener("load",ck);
        function ck(){
            document.getElementById("idckbtn").addEventListener("click",ckid);
            document.getElementById("joinbtn").addEventListener("click",joinsubmit);
        }

            function ckid(){
                var re=/^[a-zA-Z0-9]{6,16}$/
                var id=document.getElementById("id");
                if(re.test(id)){
                    alert("대문자/소문자/숫자만으로 6~16자로 입력해주세요")
                    return false;    
            }
        }

            function joinsubmit(){
            
            var pw1=document.getElementById("pw");
            var pw2=document.getElementById("repw");

            var pw1value=pw1.value;
            var pw2value=pw2.value;

            if(pw1value != pw2value){
                alert("비밀번호 동일하게 입력해주세요");
                return false;
            }
            if(document.getElementsByClassName("in").value.length==0){
                alert("입력창을 모두 입력해주세요.");
                 return false;
            }
            
        
    }
    </script>
</head>
<body>
	<header>
        <a href="main.jsp" target="_self"> <img src="./css/밥도둑 로고.png"></a>
        <hr>
    </header>
<section>
		<div>
		<br>
        <h1>회원가입</h1>
        </div>
        <br>
        <form action="#" method="POST">
            <div class="filedlable"><label class="io1">아이디</label></div>
            <div class="formlable"><input type="text" id="id" class="in" placeholder="아이디를 입력해주세요(6~16자).">
                <button id="idckbtn">중복확인</button>
            </div>
           
            <div class="filedlable"><label >비밀번호</label></div>
            <div class="formlable"><input type="password" id="pw" class="in" placeholder="비밀번호를 입력해주세요(6~16자)."></div>
            <div class="filedlable"><label >비밀번호 확인</label></div>
            <div class="formlable"><input type="password" id="repw" class="in" placeholder="비밀번호를 재입력해주세요."></div>
            <div class="filedlable"><label>이름</label></div>
            <div class="formlable"><input type="text" class="in" placeholder="이름을 입력해주세요."></div>
            <div class="filedlable"><label>닉네임</label></div>
            <div class="formlable"><input type="text" class="in" placeholder="닉네임을 입력해주세요."></div>
            <div class="filedlable"><label>이메일</label></div>
            <div class="formlable"><input type="text" class="in" placeholder="이메일을 입력해주세요."></div>
            <div class="filedlable"><label>핸드폰 번호</label></div>
            <div class="formlable"><input type="text" class="in" placeholder="-를 제외하고 입력해주세요."></div>
            <div class="filedlable"><label>주소</label></div>
            <div class="formlable"> <input type="text" class="in" placeholder="주소를 입력해주세요."></div>
            <div class="filedlable"><label>성별</label></div>
            <div class="formlable"><input type="radio" name="gender" value="M" checked>남자
            <input type="radio" name="gender" value="F">여자
        </div><br>
            <div class="filedlable"><label>나이</label></div>
            <div><input type="number" id="agenum" class="in" min="12" max="99" step="1" name="age"></div>
            <button type="submit" id="joinbtn">회원가입</button>
        </form>

    </section>

    <footer>
    <hr>
        <%@ include file="../WEB-INF/riceThief_footer.jsp" %>
    </footer>
	
</body>
</html>