<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/includes.jsp"%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%@ include file="../menu.jsp"%><br><br>
<script>
swal({  title: 'ผิดพลาด',text: 'ไม่สามารถบันทึกได้!', type: 'error',showCancelButton: false,confirmButtonText: 'OK!',closeOnConfirm: false }, 
		function(){window.history.back() });

</script>

</body>
</html>