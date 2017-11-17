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
<title>แก้ไขข้อมูล</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<br><br>
	<div class="container">
	<div class=" row form-group">
				<div class="form-inline">
					<div class="col-md-3">
						<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
							align="center">
							<p style="font-size: 28px; font-weight: 700; color: white;">แก้ไขข้อมูลสมาชิก</p>
						</div>
					</div>	
				</div>
		</div>
	
<div class="panel panel-primary">
		<div class="panel-heading">
	        <h4 class="panel-title">ข้อมูลสมาชิก</h4>
	   	</div>
		<div class="panel-body">
	<form:form action="edited_memberBylogin" method="post" commandName="member" id="member">
		<form:input path="id" type="hidden"/>
		<form:input path="username" id="user" type="hidden"/>
		<form:input path="password" id="pass1" type="hidden"/>
		  	<table class="table table-striped table-hover  table-bordered">
					<tbody>
	<tr>
		<th class="text-center">ชื่อ</th>
		<td class="text-center"><form:input id="first" path="first" placeholder="ชื่อ" class="form-control"/></td>
	</tr>
	<tr>
		<th class="text-center">นามสกุล</th>
		<td class="text-center"><form:input id="last" path="last" placeholder="นามสกุล" class="form-control"/></td>
	</tr>
	<tr>
		<th class="text-center">เพศ</th>
		<td class="text-center">
		<form:select class="form-control select select-info" data-toggle="select" path="sex" >
			<option value="ชาย">ชาย</option>
			<option value="หญิง">หญิง</option>
		</form:select>
		</td>
	</tr>
	<tr>
		<th class="text-center">ว/ด/ป เกิด</th>
		<td class="text-center"><form:input  id="birthday" path="birthday" class="form-control date"  placeholder="ว/ด/ป"/></td>
	</tr>
	<tr>
		<th class="text-center">เบอร์โทร</th>
		<td class="text-center"><form:input id="phone" path="tel" placeholder="เบอร์โทร" class="form-control" /></td>
	</tr>
	<tr>
		<th class="text-center">รหัสบัตรประชาชน</th>
		<td class="text-center"><form:input id="idCard" path="idCard" placeholder="รหัสบัตรประชาชน" class="form-control" min="12"/></td>
	</tr>
	<tr id=color2>
		<th class="text-center">ที่อยู่</th>
		<td class="text-center"><form:textarea id="address" path="address" placeholder="ที่อยู่" class="form-control" /></td>
	</tr>
	<tr>
		<th class="text-center">Email</th>
		<td class="text-center"><form:input id="email" type="email" path="email" placeholder="Email" class="form-control" /></td>
	</tr>
	<tr>
		<th class="text-center">Fax.</th>
		<td class="text-center"><form:input id="fax" type="text" path="fax" placeholder="fax" class="form-control" /></td>
	</tr>
	
	<c:if test="${sessionScope.privilege == 1}">
	<tr>
		<th class="text-center">สิทธิ์การใช้งานโดยadmin</th>
		<td class="text-center">
			<form:select class="form-control" path="privilege.id" id="privilegeid">
										
											<c:forEach items="${pri }" var="privi">
												<c:if test="${Privilege.id == privi.id }">
													<form:option value="${privi.id }" selected="selected">${privi.value }</form:option>
												</c:if>
												<c:if test="${Privilege.id != privi.id}">
													<form:option value="${privi.id }">${privi.value }</form:option>
												</c:if>
											</c:forEach>
											
			</form:select>
		<%-- <form:input id="fax" type="text" path="privilege.id" class="form-control" readonly="true"/> --%>
		
		</td>
	</tr>
	</c:if>
	
	<c:if test="${sessionScope.privilege != 1}">
	<tr>
		<th class="text-center">สิทธิ์การใช้งาน</th>
		<td class="text-center">
		
		<form:input type="text" path="privilege.value" class="form-control" readonly="true"/>
		<form:input type="hidden" path="privilege.id" class="form-control"/>
		</td>
	</tr>
	</c:if>
	
	
</tbody>
					</table>
					</form:form>
					
					<div class="text-center">
					<button id="edit" class="btn btn-embossed btn-success btn-wide" style="text-align: center;">บันทึก</button>
					<a href="index"><button type="submit" id="cancle" name="action" class="btn btn-embossed btn-danger btn-wide" style="text-align: center;">ยกเลิก</button></a>
					</div>
					
			</div>
		</div>
</div>  
<jsp:include page="../footer.jsp"/>


<script type="text/javascript">
$(document).on('click','#edit',function(e){
	var user = $("#user").val(); 
	var first = $("#first").val();
	var last = $("#last").val();
	var birthday = $("#birthday").val();
	var phone = $("#phone").val();
	var idCard = $("#idCard").val();
	var address = $("#address").val();
	var email = $("#email").val();
	var MsgError=""; 
	if(user==""){
		MsgError+="ตรวจสอบUsernameให้ถูกต้อง\n";
	}
	if(first==""){
		 MsgError+="ตรวจสอบชื่อให้ถูกต้อง\n";
		  }
	if(last==""){
		 MsgError+="ตรวจสอบนามสกุลให้ถูกต้อง\n";
		  }
	 if(birthday==""){
		 MsgError+="ตรวจสอบ ว/ด/ป เกิด ให้ถูกต้อง\n";
		  }
	 if(idCard==""|| idCard.length < 13||idCard.length > 13){
		 MsgError+="ตรวจสอบรหัสบัตรประชาชนให้ถูกต้อง\n";
		  }
	 if(address=="" || address.length < 15){
		  MsgError+="ตรวจสอบที่อยู่ให้ถูกต้อง\n";
		  }
	 if(phone==""){ 
		  MsgError+="ตรวจสอบเบอร์โทรให้ถูกต้อง\n";
		  }
	 if(email=="" || email.indexOf("@")==-1 || email.indexOf(".com")==-1){ 
		  MsgError+="ตรวจสอบอีเมลให้ถูกต้อง\n";
		  }
	 if(MsgError!=""){
		 swal("ผิดพลาด", MsgError, "error");

	 }
	 else{
			$.ajax({
				url:"edited_member",
				method:"POST",
				data:$("#member").serialize()
			}).done(function(s){
				swal({  title: "สำเร็จ",   
					text: "บันทึกเรียบร้อยแล้ว!", 
						type: "success",   
						showCancelButton: false,   
						confirmButtonText: "OK!",   
						closeOnConfirm: false }, 
						
						function(){   
							window.location.href='index'; 
							});
				
			});

	e.preventDefault();
	}
}); 
</script>


</body>
</html>