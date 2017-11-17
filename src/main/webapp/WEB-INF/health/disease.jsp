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
<title>เพิ่มข้อมูลโรค</title>
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
						<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลโรค</p>
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
						<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลโรค</a>
						</h4>
				</div>
							
				<div class="panel-body">
							<form:form action="disease" method="POST"  id="disease"
							modelAttribute="disease"  commandName="sh" >
						<div class="row form-group ">
						<div class="col-md-6 ">
						<fieldset><br>
						
							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> ชื่อโรค</label>
								<div class="col-md-6">
									<form:input path="nameDisease" id="nameDisease" type="text" class="form-control" />
									<form:input path="id" type="hidden" class="form-control" />
								</div>
							</div>
							
							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> อาการของโรค</label>
								<div class="col-md-6">
									<form:textarea rows="3	" cols="45" path="symptomsOfDisease" type="text" class="form-control" id="symptomsOfDisease"></form:textarea>
								</div>
							</div>
							
							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> สาเหตุการเกิดโรค</label>
								<div class="col-md-6">
									<form:textarea rows="3	" cols="45" path="causeOfTheDisease" type="text" class="form-control" id="causeOfTheDisease"></form:textarea>
								</div>
							</div>							
					
						<div class="row form-group">
							<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> ประเภทของโรค</label>
						<div class="col-md-6">
							 	<div>
									<form:select class="form-control" id="cableDisease.id" path="cableDisease.id">
										<form:option value="0">ประเภทของโรค</form:option>
												<c:forEach items="${cabledisease}" var="calbledis">
													<c:if test="${cableDisease.id == calbledis.id }">
														<form:option value="${cableDisease.id}" selected="selected">${calbledis.value}</form:option></c:if>
															
													<c:if test="${cableDisease.id != calbledis.id }">
													<form:option value="${calbledis.id }">${calbledis.value}</form:option>
													</c:if>
															
											</c:forEach>
									</form:select>
							 	</div>											
						</div>
						</div>
					
						</fieldset>
						</div>
						<div class="col-md-4 ">
						<fieldset><br>
							<div class="row form-group">
								<label class="col-md-offset-s col-md-5 control-label"><font color="red"></font> อาการแทรกซ้อน</label>
								<div class="col-md-6">
									<form:textarea rows="3	" cols="45" path="complications" type="text" class="form-control" id="complications"></form:textarea>
								</div>
							</div>	
						
							<div class="row form-group">
							<label class="col-md-offset-s col-md-5 control-label"><font color="red">*</font> ผู้บันทึก</label>
						<div class="col-md-6">
							 	<div>
									<form:select class="form-control" id="member.id" path="member.id">
										<%-- <form:option value="0">ผู้บันทึก</form:option> --%>
												<c:forEach items="${ulist}" var="user">
													<c:if test="${member.id == user.id }">
														<form:option value="${un.id}" selected="selected">${user.first}&nbsp;${user.last }</form:option></c:if>
															
													<c:if test="${member.id != user.id }">
														<form:option value="${user.id }">${user.first}&nbsp;${user.last }</form:option>
													</c:if>
															
											</c:forEach>
									</form:select>
							 	</div>											
						</div>
						</div>
						
							<div class="row form-group">
								<label class="col-md-offset-s col-md-5 control-label"><font color="red"></font> หมายเหตุ</label>
								<div class="col-md-6">
									<form:textarea rows="3	" cols="45" path="note" type="text" class="form-control" id="note"></form:textarea>
								</div>
							</div>	
						
						</fieldset>
						</div> 
						</div>
						</form:form>
				</div>				
							
								<div class="col-md-offset-8">
									<button name="action" value="Add" id="add" onclick="addmm()"
										class="btn btn-success btn-lg">
										<i class="fa fa-save fa-lg"></i>&nbsp; บันทึกข้อมูล
									</button>
									

									<a><button name="action" value="cancel" onclick="cancel()"
										class="btn btn-danger btn-lg">
										<i class="fa fa-times fa-lg"></i>&nbsp; ยกเลิก
									</button>	<br><br><br>	</a>	
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
	 function addmm(){
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
					if($("#nameDisease").val() == ""){
						swal("กรุณากรอกชื่อโรค");
					}else   if($("#symptomsOfDisease").val() == ""){
						swal("กรุณากรอกอาการของโรค");
					}else if($("#causeOfTheDisease").val() == ""){
						swal("กรุณากรอกสาเหตุของโรค");
					}else if($("#cableDisease\\.id").val() == "0"){
						swal("กรุณาเลือกประเภทของโรค");
					}else if($("#member\\.id").val() == "0"){
						swal("กรุณากรอกผู้บันทึก");
					}else{

					$.post('adddisease',$("#disease").serialize(),
					      function (result) {
					     	swal({	title: "สำเร็จ!",   
								/* text: "หมายเลขยา "+result,  */   
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


</body>
</html>