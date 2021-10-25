<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	if("${func}" == "recipeInsert"){
		alert("${msg}");
		location.href = "recipeboard";
	}else if("${func}" == "recipeDelete"){
		alert("${msg}");
		location.href = "recipeboard";
	}else if("${func}" == "commentInsert"){
		alert("${msg}");
		location.href = "selectrecipe?rno=${rno}";
	}else if("${func}" == "commentUpdate"){
		alert("${msg}");
		location.href = "selectrecipe?rno=${rno}";
	}else if("${func}" == "commentDelete"){
		alert("${msg}");
		location.href = "selectrecipe?rno=${rno}";
	}
</script>
</body>
</html>