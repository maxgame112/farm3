<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/includes.jsp"%>
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
<title>แก้ไขข้อมูลยา</title>
</head>
<body>
<%@ include file="../menu.jsp"%>
	<br><br>
<div id="wrapper">
		<div id="content">
			<div class="container">
				<div class="col-md-3">
					<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
						<p style="font-size: 28px; font-weight: 700; color: white;">จดทะเบียนยา</p>
					</div>
				</div>
				<div class="row">
					<hr>
				</div>
				<br> <br>
				<div class="row form-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
						<span class="fa fa-list-alt fa-lg"></span> จดทะเบียนยา</a>
						</h4>
				</div>
							
				<div class="panel-body">
							<form:form action="medicine_edited" method="POST"  id="medicine"
							modelAttribute="medicine"  commandName="sh" >
						<div class="row form-group ">
						<div class="col-md-6 ">
						<fieldset><br>
						
							<div class="row form-group">
												<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ชื่อทางการค้า</label>
												<div class="col-md-6">

													<form:input path="tradeName" id="tradeName" type="text" class="form-control" />
													<form:input path="id" type="hidden" class="form-control" />
										</div>
											</div>
					
						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ชื่อวิทยาศาสตร์</label>
						<div class="col-md-6">
							 	<form:input type="text" class="form-control" id="scientificName" path="scientificName"/>													
						</div>
						</div>
						
						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ชื่อสามัญ</label>
						<div class="col-md-6">
							 	<form:input type="text" class="form-control" id="
" path="commonName"/>													
						</div>
						</div>
						
						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> กลุ่มยา</label>
						<div class="col-md-6">
							 	<div>
			
									<form:select class="form-control" id="groupMedicine.id"
															path="groupMedicine.id">
											<form:option value="">เลือกกลุ่มยา</form:option>
												<c:forEach items="${groupmed}" var="group">
													<c:if test="${groupMedicine.id == group.id }">
														<form:option value="${group.id}" selected="selected">${group.value}</form:option></c:if>
															
													<c:if test="${groupMedicine.id != group.id }">
													<form:option value="${group.id }">${group.value}</form:option>
													</c:if>
															
											</c:forEach>
										</form:select>
							 	</div>											
						</div>
						</div>

						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> สรรพคุณ</label>
						<div class="col-md-6">
							<form:textarea rows="3" cols="45" class="form-control" path="properties" id="properties" type="text"></form:textarea>
						</div>
						</div> 
						
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> วิธีการใช้</label>
						<div class="col-md-6">
							<form:textarea rows="3" cols="45" class="form-control" path="instruction" id="instruction" type="text"></form:textarea>
						</div>
						</div> 
						
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ผลข้างเคียง</label>
						<div class="col-md-6">
							<form:textarea rows="3" cols="45" class="form-control" path="sideEffect" id="sideEffect" type="text"></form:textarea>
						</div>
						</div> 
						
						</fieldset>
						</div>
						<div class="col-md-4 ">
						<fieldset><br>
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ส่วนประกอบ</label>
						<div class="col-md-6">
							<form:textarea rows="3	" cols="45" class="form-control" path="ingredient" id="ingredient" type="text"></form:textarea>
						</div>
						</div> 
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ระยะหยุดยา</label>
							<div class="col-md-6">
							<div class="input-group">
								<form:input type="text" class="form-control" id="distanceDiscontinued" path="distanceDiscontinued" />
							<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">วัน</span>
														
							</div>	
						</div>
						</div>
						
<%-- 						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> วันที่ผลิต</label>
								<div class="col-md-6">
								<form:input type="date" class="form-control" id="mfgDate" path="mfgDate" />

						</div>
						</div>
						
						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> วันหมดอายุ</label>
								<div class="col-md-6">
								<form:input type="date" class="form-control" id="expDate" path="expDate" />
						</div>
						</div>
						
						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> หน่วยบรรจุ</label>
						<div class="col-md-6">
							 	<div>
									<form:select class="form-control" id="UnitMedicine.id"
															path="UnitMedicine.id">
											<form:option value="0">เลือกหน่วยยา</form:option>
												<c:forEach items="${un}" var="un">
													<c:if test="${UnitMedicine.id == un.id }">
														<form:option value="${un.id}" selected="selected">${un.value}</form:option></c:if>
															
													<c:if test="${UnitMedicine.id != un.id }">
														<form:option value="${un.id }">${un.value}</form:option>
													</c:if>
															
											</c:forEach>
										</form:select>
							 	</div>											
						</div>
						</div> --%>
						
						
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red"></font> หมายเหตุ</label>
						<div class="col-md-6">
							<form:textarea rows="3" cols="45" class="form-control" path="note" id="note" type="text"></form:textarea>
						</div>
						</div> 
						
						</div> 
						</fieldset>
						</div>
						</div>				
							</form:form>
								<div class="col-md-offset-8">
									<button name="action" value="Add" id="add" onclick="addm()"
										class="btn btn-success btn-lg">
										<i class="fa fa-save fa-lg"></i>&nbsp; บันทึกข้อมูล
									</button> 

								<a href="medicinesh">	<button name="action" value="cancel" onclick="cancel()"
										class="btn btn-danger btn-lg">
										<i class="fa fa-times fa-lg"></i>&nbsp; ยกเลิก
									</button></a>	<br><br><br>		
					</div>
					</div>
					</div>
					<div>
				</div>

			</div>

			</div>

		</div>
<%@ include file="../footer.jsp"%>

		
<script type="text/javascript">
			
	function cancel() {
		location.reload();
	} 
	
	// ยืนยันบันทึก
	 function addm(){
		swal({	title: "ยืนยันบันทึกข้อมูล?",   
			text: "คุณต้องการยืนยันบันทึกข้อมูลยาหรือไม่!",   
			type: "warning",   
			showCancelButton: true,   
			confirmButtonColor: "#55c7dd",   
			confirmButtonText: "ต้องการ",
			cancelButtonText: "ไม่ต้องการ",   
			closeOnConfirm: false,   
			closeOnCancel: false }, 
			function(isConfirm){   
				if (isConfirm) {
					if($("#commonName").val() == ""){
						swal("กรุณากรอกชื่อยาสามัญ");
					}else   if($("#tradeName").val() == ""){
						swal("กรุณากรอกชื่อทางการค้า");
					}else if($("#scientificName").val() == ""){
						swal("กรุณากรอกชื่อวิทยาศาสตร์");
					}else if($("#groupMedicine\\.id").val() == "0"){
						swal("กรุณาเลือกประเภทยา");
					}else if($("#properties").val() == ""){
						swal("กรุณากรอกสรรพคุณ");
					}else if($("#instruction").val() == ""){
						swal("กรุณากรอกขนาดที่ใช้");
					}else  if($("#sideEffec").val() == ""){
						swal("กรุณากรอกระยะหยุดยา");
					}else if($("#mfgDate").val() == ""){
						swal("กรุณากรอก วัน/เดือน/ปี ที่ผลิต");
					}else if($("#expDate").val() == ""){
						swal("กรุณากรอก วัน/เดือน/ปี ที่หมดอายุ");
					}else if($("#UnitMedicine\\.id").val() == "0"){
						swal("กรุณาเลือกหน่วยบรรจุ");
					}else{

					$.post('medicine_edited',$("#medicine").serialize(),
					      function (result) {
					     	swal({	title: "Success!",   
/* 								text: "หมายเลขยา "+result,    */
								timer: 2000,   
								type: "success",
								showConfirmButton: false },
								
								function(){   
									window.location.href='medicinesh'; 
									
							});
							/* setInterval(function(){location.reload()}, 2000); */
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




</body>
</html>