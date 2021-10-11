<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>아이디 중복 확인</title>
</head>
<body>
	<div id="checked-container">
		<c:if test="${result !=null }">
		[<span><%-- TODO : =id --%></span>]는 사용이 가능합니다.
		</c:if>
	</div>
</body>
</html>