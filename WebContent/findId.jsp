<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

    <style>
        body{
            text-align: center;
        }
        .lo1,.lo2{
            margin-top: 2rem;
            margin-bottom: 2rem;
        }

    </style>
</head>
<body>
<header>
        <a href="main.jsp" target="_self"> <img src="./images/밥도둑 로고.png"></a>
        <hr>
    </header>

    <section>
        <form>
            <div class="lo1">
                <i class="fas fa-exclamation-circle" style="font: 1px 1px;"></i>
                회원정보에 등록한 이름과 핸드폰 번호를 입력해주세요.<br>
                <label>이름<input type="text"  placeholder="이름을 입력하세요."></label><br>
                <label>핸드폰번호<input type="text" placeholder="번호를 입력하세요."></label><br>
            </div>
            <div class="lo2">
                <i class="fas fa-exclamation-circle" style="font: 1px 1px;"></i>
                회원정보에 등록한 이름과 이메일를 입력해주세요.<br>
                <label>이름<input type="text" placeholder="이름을 입력하세요."></label><br>
                <label>핸드폰번호<input type="text" placeholder="이메일을 입력하세요."></label><br>
            </div>

            <button id="findbtn">찾기</button>




        </form>

    </section>
</body>
</html>