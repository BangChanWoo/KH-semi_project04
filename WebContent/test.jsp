<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test Calculate Page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./WebContent/js/httpRequest.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#btnSend").on('click', function() {
				var num1 = $("#num1").val();
				var num2 = $("#num2").val();
				var oper = $("#oper").val();
				var url = "calc.do";
				var query = "n1=" + num1 + "&n2=" + num2;
				query += "&oper=" + oper;
				$.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
					type : "GET",
					url : url,
					data : query,
					dataType : "json", // 전달받을 객체는 JSON 이다.
					success : function(data) {
						$("#result").html(data.result); // 전달받은 JSON 객체의 Key인 result로 value값 접근
						$("#num1").val("");
						$("#num2").val("");
						$("#oper").val("add");
					},
					error : function(e) {
						alert(e.responseText);
					}
				});
			});
		});
	</script>
</head>
<body>
	<input type="text" id="num1">
	<select id="oper">
		<option value="add">더하기</option>
		<option value="sub">빼기</option>
		<option value="mul">곱하기</option>
		<option value="div">나누기</option>
	</select>
	<input type="text" id="num2">
	<input type="button" value=" = " id="btnSend">
	<br>
	<hr>
	<div id="result"></div>
</body>
</html>