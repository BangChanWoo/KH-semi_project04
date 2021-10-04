<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>회원가입</title>
<style>
	body{
	 text-align: center;
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
        <a href="" target="_self"> <img src="./images/밥도둑 로고.png"></a>
        <hr>
    </header>

    <section>
        <h1>회원가입</h1>
        <form action="joinuser" method="Post">
            <label>아이디</label>
            <input type="text" id="id" name="id" placeholder="아이디를 입력해주세요(6~16자).">
            <button id="idckbtn">중복확인</button><br>
            <label>비밀번호</label>
            <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요(6~16자)."><br>
            <label>비밀번호 확인</label>
            <input type="password" id="repw" placeholder="비밀번호를 재입력해주세요."><br>
            <label>이름</label>
            <input type="text" name="uname" placeholder="이름을 입력해주세요."><br>
            <label>닉네임</label>
            <input type="text" placeholder="닉네임을 입력해주세요."><br>
            <label>이메일</label>
            <input type="text" name="email" placeholder="이메일을 입력해주세요."><br>
            <label>핸드폰 번호</label>
            <input type="text"  name="phone" placeholder="-를 제외하고 입력해주세요."><br>
            <label>주소</label>
            <input type="text" name="address" placeholder="주소를 입력해주세요."><br>
            <label>성별</label>
            <input type="radio" name="gender" value="M" checked>남자
            <input type="radio" name="gender" value="F">여자<br>
            <label>나이</label>
            <input type="number" name="age"  min="12" max="99" step="1" name="age"><br>
            <button type="submit" id="joinbtn">회원가입</button>
        </form>

    </section>

    <footer>
        <hr>
        <p>4조 팀명</p>
    </footer>
	
</body>
</html>