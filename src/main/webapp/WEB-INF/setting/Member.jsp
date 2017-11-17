<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="Shortcut Icon" href="<c:url value="/resources/img/cow.ico"/>" type="image/x-icon">
<link href="<c:url value="/resources/css/fileinput.css" />" media="all"
	rel='stylesheet' type='text/css' />

<link href="<c:url value="/resources/css/easy-autocomplete.min.css" />" rel='stylesheet' type='text/css' />
<link href="<c:url value="/resources/css/easy-autocomplete.themes.min.css" />" rel='stylesheet' type='text/css' />
<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script src="<c:url value="/resources/js/jquery.easy-autocomplete.min.js" />"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">

<script src="<c:url value="/resources/js/clicktable.js" />"></script>
<script src="<c:url value="/resources/js/fileinput.js" />"></script>
<title>สมัครสมาชิก</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<br><br>
	<div class="container">
<div class="panel panel-primary">
		<div class="panel-heading">
	        
	        <h4 class="panel-title">ข้อมูลส่วนตัว</h4>
	        
	   	</div>
		<div class="panel-body">
		<c:forEach items="${ulist }" var="m">
		  	<table class="table table-striped table-hover  table-bordered">
					<tbody>
	<%-- <tr>
		<th class="text-center">Username</th>
		<td class="text-center" width="700px"><input id="user" value =" ${ m.username}" class="form-control"/></td>
	</tr> --%>
	<tr>
		<th class="text-center">ชื่อ</th>
		<td class="text-center"><input id="first" value =" ${ m.first}" class="form-control" disabled="true"/></td>
	</tr>
	<tr>
		<th class="text-center">นามสกุล</th>
		<td class="text-center"><input id="last" value =" ${ m.last}" class="form-control" disabled="true"/></td>
	</tr>
	<tr>
		<th class="text-center">เพศ</th>
		<td class="text-center">
			<input id="last" value =" ${ m.sex}" class="form-control" disabled="true"/>
		<%-- <form:select class="form-control select select-info" data-toggle="select" path="sex" >
			<option value="ชาย">ชาย</option>
			<option value="หญิง">หญิง</option>
		</form:select> --%>
		</td>
	</tr>
	<tr>
		<th class="text-center">วัน/เดือน/ปี เกิด</th>
		<td class="text-center"><input  id="birthday" value =" ${ m.birthday}" class="form-control" disabled="true"/></td>
	</tr>
	<tr>
		<th class="text-center">เบอร์โทร</th>
		<td class="text-center"><input id="phone" value =" ${ m.tel}" class="form-control" disabled="true"/></td>
	</tr>
	<tr>
		<th class="text-center">รหัสบัตรประชาชน</th>
		<td class="text-center"><input id="idCard" value =" ${ m.idCard}" class="form-control" disabled="true"/></td>
	</tr>
	<tr id=color2>
		<th class="text-center">ที่อยู่</th>
		<td class="text-center"><textarea id="address" class="form-control" disabled="true">${ m.address}</textarea></td>
	</tr>
	<tr>
		<th class="text-center">Email</th>
		<td class="text-center"><input id="email" type="text" value =" ${ m.email}" class="form-control" disabled="true"/></td>
	</tr>
	<tr>
		<th class="text-center">Fax.</th>
		<td class="text-center"><input id="fax" type="text" value =" ${ m.fax}"  class="form-control" disabled="true"/></td>
	</tr>
</tbody>
					</table>
					
					<form:form action="edit_memberBylogin" method="POST" >
					<input id="id" name="id" type="hidden"  value="${m.id}">
					<div class="col-md-12" align="right">
				   			<button name="action"  class="btn btn-primary" >
												แก้ไขข้อมูล
											</button>
					</div>
					</form:form>					
					
					</c:forEach>

					
			</div>
		</div>
</div>  
<jsp:include page="../footer.jsp"/>

</body>
</html>