<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>ลงทะเบียนน้ำเชื้อ</title>
</head>
<body>
<jsp:include page="../menu.jsp"><br><br>
<br><br>
	<div class="container">
		<div class="col-md-3">
				<div class="jumbotron" style="background-color: rgb(218, 68, 83)" align="center">
				<p style="font-size: 28px; font-weight: 700; color: white;">การลงทะเบียนน้ำเชื้อ</p>
			</div>
		</div>
		<br><br><br>
		<div class="row form-group"> <!-- //ตาราง -->
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4 class="panel-title"><span class="fa fa-list-alt fa-lg"></span>&nbsp;ข้อมูลน้ำเชื้อ</a></h4>
				</div>
				<div class="panel-body"><br>
				
				
				<form:form action="semen" method="POST"  id="semen" modelAttribute="semen"  commandName="semen" >
				
					<div class="row form-group">
						<div class="col-md-6 "> <!-- //คอลัม1 -->
							<div class="row form-group ">
								<label class="col-md-offset-0 col-md-4 control-label"><font color="red">*</font> หมายเลขน้ำเชื้อ/ชื่อพ่อพันธุ์</label>
								<div class="col-md-6">
							 		<form:input type="text" class="form-control" id="nameCattle" path="nameCattle"/>													
								</div>
							</div>
							<div class="row form-group ">
								<label class="col-md-offset-0 col-md-4 control-label"><font color="red">*</font> สายพันธุ์</label>
								<div class="col-md-6">
							 		<form:select path="Breed.id" id="Breed.id" class="form-control" >
							 			<form:option value="0">เลือกสายพันธุ์</form:option>
							 			<c:forEach items="${breed }" var="breedtype">
							 				<c:if test="${Breed.id == breedtype.id }">
							 					<form:option value="${breedtype.id }" selected="selected">${breedtype.value }</form:option>
							 				</c:if>
							 				<c:if test="${Breed.id != breedtype.id}">
							 					<form:option value="${breedtype.id }">${breedtype.value }</form:option>
							 				</c:if>
							 			</c:forEach>
							 		</form:select>												
								</div>
							</div>
							
							<div class="row form-group ">
								<label class="col-md-offset-0 col-md-4 control-label"><font color="red">*</font> เบอร์ประจำตัวพ่อพันธุ์</label>
								<div class="col-md-6">
							 		<form:input type="text" class="form-control" id="HNumber" path="HNumber"/>													
								</div>
							</div>
							<div class="row form-group ">
								<label class="col-md-offset-0 col-md-4 control-label"><font color="red">*</font> สีพ่อพันธุ์</label>
								<div class="col-md-6">
							 		<form:input type="text" class="form-control" id="colorCattle" path="colorCattle"/>												
								</div>
							</div>
							<div class="row form-group ">
								<label class="col-md-offset-0 col-md-4 control-label"><font color="red">*</font> สีหลอด</label>
								<div class="col-md-6">
							 		<form:input type="text" class="form-control" id="tubeColor" path="tubeColor"/>												
								</div>
							</div>
						</div> <!-- //closeคอลัม1 -->
						<div class="col-md-4 "> <!-- //คอลัม2 -->			
							<div class="row form-group ">
								<label class="col-md-offset-1 col-md-4 control-label"><font color="red">*</font> สีจุกปิด</label>
								<div class="col-md-6">
							 		<form:input type="text" class="form-control" id="lidColor" path="lidColor"/>												
								</div>
							</div>
							<div class="row form-group ">
								<label class="col-md-offset-1 col-md-4 control-label" data-toggle="select"><font color="red">*</font> ขนาดหลอด</label>
								<div class="col-md-6">
							 		<form:select class="form-control" path="tubeSize" id="tubeSize">
							 			<option value="0">เลือกขนาดหลอด</option>
										<option value="0.25">0.25 ml</option>
										<option value="0.50">0.50 ml</option>
							 		</form:select>													
								</div>
							</div>
							<div class="row form-group ">
								<label class="col-md-offset-1 col-md-4 control-label"><font color="red">*</font> เจ้าของฟาร์ม</label>
								<div class="col-md-6">
							 		<form:input type="text" class="form-control" id="farm" path="farm"/>													
								</div>
							</div>
							<div class="row form-group ">
								<label class="col-md-offset-1 col-md-4 control-label"> ตัวแทนจำหน่าย</label>
								<div class="col-md-6">
							 		<form:input type="text" class="form-control" id="dealer" path="dealer"/>													
								</div>
							</div>
						</div> <!-- //closeคอลัม2 -->
					</div>
			</form:form>
					
					
					<div class="col-md-offset-9">
									<button name="action" value="Add" id="add" onclick="addsemen()"
										class="btn btn-success btn-lg">
										<i class="fa fa-save fa-lg"></i>&nbsp; บันทึกข้อมูล
									</button>
									<a href="view_semen"><button name="action" value="cancel" onclick="cancel()"
										class="btn btn-danger btn-lg">
										<i class="fa fa-times fa-lg"></i>&nbsp; ยกเลิก
									</button></a>
					</div>
				</div> <!-- //จบ body -->
				
			</div>
		</div> <!-- ปิดตาราง -->
	</div> <!-- ปิดcontainer -->
<%@ include file="../footer.jsp"%>	
</body>
<!-- <script type="text/javascript">
function cancel() {
	location.reload();
}
//ยืนยันบันทึก
function addsemen(){
	swal({	title: "ยืนยันบันทึกข้อมูล?",   
		text: "คุณต้องการยืนยันบันทึกข้อมูลวัสดุอุปกรณ์หรือไม่!",   
		type: "warning",   
		showCancelButton: true,   
		confirmButtonColor: "#55c7dd",   
		cancelButtonText: "ไม่ต้องการ",
		confirmButtonText: "ต้องการ", 
		closeOnConfirm: false,   
		closeOnCancel: false }, 
		function(isConfirm){   
			if (isConfirm) {
				if($("#nameCattle").val() == ""){
					swal("ชื่อพ่อ");
				}else if($("#Breed\\.id").val() == "0"){
					swal("กรุณาเลือกสายพัน");
				}else{
				$.post('addsemen',$("#semen").serialize(),
				      function (result) {
				     	swal({	title: "เสร็จเรียบร้อย!",   
							/* text: "หมายเลขยา "+result, */   
							timer: 2000,   
							type: "success",
							showConfirmButton: false 
						});
						setInterval(function(){location.reload()}, 2000);
					})
				}
				} else { 
				swal({	title: "Cancelled!",   
						text: "คุณได้ยกเลิกการบันทึกข้อมูล",   
						timer: 1000,   
						type: "error",
						showConfirmButton: false 
				});
			} 
		}
	);
}
</script> -->

<script type="text/javascript">
function cancel() {
	location.reload();
}
//ยืนยันบันทึก
function addsemen(){
	
	var Breed = $("#Breed\\.id").val();
	
	
	
	swal({	title: "ยืนยันบันทึกข้อมูล?",   
		text: "คุณต้องการยืนยันบันทึกข้อมูลน้ำเชื้อหรือไม่!",   
		type: "warning",   
		showCancelButton: true,   
		confirmButtonColor: "#55c7dd",   
		cancelButtonText: "ไม่ต้องการ",
		confirmButtonText: "ต้องการ", 
		closeOnConfirm: false,   
		closeOnCancel: false }, 
		function(isConfirm){   
			if (isConfirm) {
				if($("#nameCattle").val()  == ""){
					swal("กรุณากรอกหมายเลขน้ำเชื้อ/ชื่อพ่อพันธุ์");
				}else if($("#Breed\\.id").val() == "0"){
					swal("กรุณาเลือกสายพันธุ์");
				}else if($("#HNumber").val() == ""){
					swal("กรุณากรอกเบอร์ประจำตัวตัวพ่อพันธุ์");
				}else if($("#colorCattle").val() == ""){
					swal("กรุณากรอกสีพันธุ์พ่อ");
				}else if($("#tubeColor").val() == ""){
					swal("กรุณากรอกสีหลอด");
				}else if($("#lidColor").val() == ""){
					swal("กรุณากรอกสีจุกปิด");
				}else if($("#tubeSize").val() == "0"){
					swal("กรุณาเลือกขนาดหลอด");
				}else if($("#farm").val() == ""){
					swal("กรุณากรอกเจ้าของฟาร์ม");
				}else{
				$.post('addsemen',$("#semen").serialize(),
				      function (result) {
				     	swal({	title: "เสร็จเรียบร้อย!",   
							/* text: "หมายเลขยา "+result, */   
							timer: 2000,   
							type: "success",
							showConfirmButton: false 
						});
						setInterval(function(){location.reload()}, 2000);
					})
				}
				} else { 
				swal({	title: "Cancelled!",   
						text: "คุณได้ยกเลิกการบันทึกข้อมูล",   
						timer: 1000,   
						type: "error",
						showConfirmButton: false 
				});
			} 
		}
	);
}
</script>
</html>