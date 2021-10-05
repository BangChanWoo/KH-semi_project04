<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
        body{
            text-align: center;
        }
        #loginbtn{
            width: 192px;
        }
</head>
<body>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
        <header>
            <a href="#" target="_self"> <img src="./images/밥도둑 로고.png"></a>
            <hr>
    </header>

    <section>
        <form>
            <i class="far fa-user" style="font-size:1px 1px;"></i> 
            <input type="text" class="id"  placeholder="UserId"><br>
            <i class="fas fa-key" class="pw" style="font-size:1px 1px;"></i>
            <input type="text"  placeholder="Password"><br>
            <br>

            <button id="loginbtn">로그인</button><br>
            <button id="ckid">아이디 찾기<a href="./findId.html" target="_self"></a></button>
            <button id="ckpw">비밀번호 찾기<a href="#"></a></button>

        </form>



    </section>

    <footer>

    </footer>
</body>
</html>