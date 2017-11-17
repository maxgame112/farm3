<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<jsp:include page="menu.jsp"/>
<script>
swal({  title: 'ผิดพลาด!',text: 'กรุณาเข้าสู่ระบบ', type: 'error',showCancelButton: false,confirmButtonText: 'OK!',closeOnConfirm: false }, 
		function(){window.location.href="index" });

</script>
</body>
</html>