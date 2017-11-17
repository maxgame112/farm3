<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ระบบการรักษาโรค เฟส3</title>
<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
<script src="<c:url value="/resources/js/baloon.js"/>"></script>
<!-- Bootstrap -->

</head>
<body>
 
<jsp:include page="menu.jsp"/>
	<div class="section-bg">
		<div class="container">
		<img class="icon"
				src="<c:url value=  "/resources/img/Logo-V9.png"/> "
				height="100%"> <br> 
			<div> 
			<h3 class="homepage-title">ระบบการจัดการฟาร์ม :
					ระบบการรักษาโรค เฟส3</h3>
			</div>
			<div>
				<h3 class="homepage-subtitle">Farm Management System : Healthcare System Phase 3</h3>
			</div>
		</div>
		<br> <br> <br> <br>
	</div>



<div id="footer_container">
	<footer class="footer" style="width: 100%; padding : 10px;height: auto">
	<div class="container">
		<div class="col-md-6" align="left">
				<div class="row form-inline">
						<span style="color: white;font-size: 16px;">Copyright ©2017</span>
						<span style="color: white;font-size: 18px;"> | </span>
						<a href="development" target="_blank" style="font-size: 16px;">Development Team</a>	
						<span style="color: white;font-size: 18px;"> | </span>
						<a href="contact" target="_blank" style="font-size: 16px;">Contact</a>
				</div>
				<div class="row form-inline">
					<span style="color: white;font-size: 16px;">By Computer Engineering 
					<a href="http://www.up.ac.th" target="_blank" class="textright">University Of Phayao &nbsp;</a></span>
					<a href="https://www.facebook.com/ComputerEngineeringUP?fref=ts" target="_blank" class="textright"><i class="fa fa-facebook-official"></i></a>
				</div>
		</div>
		<div class="col-md-6">
			<div align="right">
				<a>
					<a class="textright" href="index">Farm Management System : HealthCare System Phase 3</a>
					<img id="imgfooter" src="<c:url value="/resources/img/Logo_V2_4.png" /> " height="45" " title="กลับสู่หน้าหลัก">
				</a> 
			</div>
		</div>
	</div>
	</footer>

</body>
</html>