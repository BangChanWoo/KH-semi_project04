<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	boolean result=(Boolean)request.getAttribute("result");
	String checkId=(String)request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>아이디 중복 확인</title>
</head>
<body>
	<div id="checked-container">
		<%if(result){ %>
			[<span><%=checkId %></span>]는 사용이 가능합니다.
			<br><br>
			<button type="button" onclick="setUserId('<%=checkId %>')">닫기</button>
		<%}else{ %>
		[<span><%=checkId %></span>]는 이미 사용 중 입니다.
		<br>
		<button type="button" onclick="location='/WEB-INF/view/insertJoin.jsp'">닫기</button>
		<%} %>
	</div>
	<script>
		function setUserId(uid){
			var id=opener.document.getElementById("id");
			var pw=opener.document.getElementById("pw");
			id.value=checkId;
			pw.focus();
			self.close();
		}
	</script>
</body>
</html>