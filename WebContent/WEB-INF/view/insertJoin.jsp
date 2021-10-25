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
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/mypage.js"></script>
<title>회원가입</title>
<style>
        body{
            text-align: center;
        }
        #id{
            margin-left: 10px;
        }
        .in{
            margin: 7px;
            
            width: 200px;
        }
        
        #agenum{
            width: 50px;
        }
        .invalid{border-color:red;}
        #id_check,#email_check,#phone_check,#pw_check{color:red;}
    </style>

</head>
<body>
	<header>
        <%@ include file="riceThief_header.jsp"%>
        <hr>
    </header>
<section>
		<div>
		<br>
        <h1>회원가입</h1>
        </div>
        <br>
        <form action="joinuser" method="POST">
            <div class="filedlable"><label class="io1">아이디</label></div>
            <div class="formlable"><input type="text" id="id" name="id" class="in" placeholder="아이디를 입력해주세요(6~16자).">
            </div>
            <div id="id_check"></div> <!-- ajax 경고문 들어갈 공간 -->
           
            <div class="filedlable"><label >비밀번호</label></div>
            <div class="formlable"><input type="password" id="pw" name="pw" class="in" placeholder="비밀번호를 입력해주세요(6~16자)."></div>
            <div class="filedlable"><label >비밀번호 확인</label></div>
            <div id="pw_check"></div>
            <div class="formlable"><input type="password" id="repw" class="in" placeholder="비밀번호를 재입력해주세요."></div>
            <div class="filedlable"><label>이름</label></div>
            <div class="formlable"><input type="text" name="uname" class="in" placeholder="이름을 입력해주세요."></div>
            <div class="filedlable"><label>닉네임</label></div>
            <div class="formlable"><input type="text" id="nickname" name="nickname" class="in" placeholder="닉네임을 입력해주세요."></div>
            <div class="filedlable"><label>이메일</label></div>
            <div class="formlable"><input type="text" id="email" name="email" class="in" placeholder="이메일을 입력해주세요."></div>
            <div id="email_check"></div>
            <div class="filedlable"><label>핸드폰 번호</label></div>
            <div class="formlable"><input type="text" id="phone" name="phone" class="in" placeholder="-를 제외하고 입력해주세요."></div>
            <div id="phone_check"></div>
            <div class="filedlable"><label>주소</label></div>
            <div class="formlable"> <input type="text" name="address" class="in" placeholder="주소를 입력해주세요."></div>
            <div class="filedlable"><label>성별</label></div>
            <div class="formlable"><input type="radio" name="gender" value="M" checked>남자
            <input type="radio" name="gender" value="F">여자
        </div><br>
            <div class="filedlable"><label>나이</label></div>
            <div><input type="number" id="agenum" name="id" class="in" min="12" max="99" step="1" name="age"></div>
            <button type="submit" id="joinbtn" onclick="joincheck()">회원가입</button>
        </form>

    </section>

    <footer>
    <hr>
        <%@ include file="riceThief_footer.jsp" %>
    </footer>
    <script>
    	function joincheck(){
    	    var id=document.getElementById("id");
    		var pw=document.getElementById("pw");
    		var nickname=document.getElementById("nickname");
    		var email=document.getElementById("email");
    		var phone=document.getElementById("phone");
    		var address=document.getElementById("address");
    		
    		var id1=id.value;
    		var pw1=pw.value;
    		var nickname1=nickname.value;
    		var email1=email.value;
    		var phone1=phone.value;
    		var address1=address.value;
    		
    		if(id1=="" && pw1=="" && nickname1=="" && email1=="" && phone1=="" && address==""){
				alert("모든 정보를 입력해주세요.");
				return false;
			}
    		
    	};
    	id.onblur=function(){
    		var re=/^[a-zA-Z0-9]{6,16}$/; //id,pw
    		if(re.test($("#id").val())==false){
    			$("#id_check").html("사용할 수 없는 아이디입니다.");
				$("#id_check").css({"color":"red"});
    			alert("아이디 조건에 맞게 입력해주세요.");
    		}
    		else{
    			var id=$("#id").val();
        		console.log(id+"id체크")
        		$.ajax({
        			type:"post",
        			url:"<%=request.getContextPath()%>/dupidcheck?uid="+id,
        			data:{uid:id},
        			success:function(result){
        				if(result=="false"){
        					$("#id_check").html("사용할 수 있는 아이디입니다.");
        					$("#id_check").css({"color":"green"});
        				}else{
        					$("#id_check").html("사용할 수 없는 아이디입니다.");
        					$("#id_check").css({"color":"red"});
        				}
        				}
        			});
    		}
    		
    		};
    	
    	
    	repw.onblur=function(){
    		var re=/^[a-zA-Z0-9]{6,16}$/; //id,pw
    		if(re.test($("#pw").val())==false){
    			pw_check.innerHTML="비밀번호가 조건에 맞지 않습니다.";
    			alert("비밀번호를 조건에 맞게 입력해주세요.");
    		}
    		else{
    			var pw=document.getElementById("pw").value;
        		var repw=document.getElementById("repw").value;
        		console.log(pw);
        		console.log(repw);
        		if(pw!=repw){
        			pw_check.innerHTML="비밀번호가 일치하지 않습니다.";
        		}else{
        			pw_check.innerHTML="";
        		}
    		}
    		
    	};
    	
    	
    	email.onblur=function(){
    		var re1=/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/; //email
    		if(re1.test($("#email").val())==false){
    			email.classList.add('invalid');
    			email_check.innerHTML="이메일이 조건에 맞지 않습니다.";
    			alert("이메일 주소를 조건에 맞게 입력해주세요.");
    		}
    		else{
    			if(!email.value.includes('@')){
        			email.classList.add('invalid');
        			email_check.innerHTML="올바른 이메일 주소를 입력하세요.";
        		}else{
        			email.classList.remove('invalid');
        			email_check.innerHTML="";
        		}
    		}
    		
    	};
    	
        phone.onblur=function(){
        	var re2=/^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/; //phone
        	if(re2.test($("#phone").val())==false){
        		phone.classList.add('invalid');
    			phone_check.innerHTML="전화번호가 조건에 맞지 않습니다.";
    			alert("전화번호를 조건에 맞게 입력해주세요.");
    		}
    		else{
    			if(!phone.value.includes('010')){
        			phone.classList.add('invalid');
        			phone_check.innerHTML="올바른 전화번호를 입력하세요.";
        		}else{
        			phone.classList.remove('invalid');
        			phone_check.innerHTML="";
        		}
    		}
    		
    	} ;
    	
    </script>
	
</body>
</html>