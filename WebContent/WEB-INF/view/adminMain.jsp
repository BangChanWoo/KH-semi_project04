<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/basic.css" />  <!-- 공통 css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_header.css" /> <!-- header css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/riceThief_footer.css" /><!-- footer css -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/main.css"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://kit.fontawesome.com/616f27e0c4.js" crossorigin="anonymous"></script>

<title>밥도둑_관리자 메인</title>
<%
	String msg = (String)request.getAttribute("msg");
%>
<script type="text/javascript">
    <%if(msg != null){%>
    	alert("<%=msg%>");
    <%}%>
</script>
</head>
<body>
<%@ include file="riceThief_adminHeader.jsp" %>
	<hr>
	<main>
        <div class="slideContainer">
        	
			<div class="mySlides fade">
			  <img src="./css/001.png" class="slideImg" alt="slide show">
			</div>
			<div class="mySlides fade">
			  <img src="./css/002.png" class="slideImg" alt="slide show">
			</div>
			<div class="mySlides fade">
			  <img src="./css/003.png" class="slideImg" alt="slide show">
			</div>
			<div class="mySlides fade">
			  <img src="./css/004.png" class="slideImg" alt="slide show">
			</div>
			<input type='button' id='btnAdMan' value='메인 광고 관리' style="float: right;">
			<a class="prev" onclick="plusSlides(-1)"><i class="fas fa-chevron-left"></i></a>
			<a class="next" onclick="plusSlides(1)"><i class="fas fa-chevron-right"></i></a>
		</div>
		<br>
		<div style="text-align:center">
		  <span class="dot" onclick="currentSlide(1)"></span> 
		  <span class="dot" onclick="currentSlide(2)"></span> 
		  <span class="dot" onclick="currentSlide(3)"></span> 
		  <span class="dot" onclick="currentSlide(4)"></span> 
		</div>
		
        
    </main>
    <hr>

	<%@ include file="riceThief_footer.jsp" %>
	
	<script>
	var slideIndex = 1;
	showSlides(slideIndex);
	
	function plusSlides(n) {
	  showSlides(slideIndex += n);
	}
	
	function currentSlide(n) {
	  showSlides(slideIndex = n);
	}
	
	function showSlides(n) {
	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("dot");
	  if (n > slides.length) {slideIndex = 1}    
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	      slides[i].style.display = "none";  
	  }
	  for (i = 0; i < dots.length; i++) {
	      dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";  
	  dots[slideIndex-1].className += " active";
	}
	</script>
</body>
</html>