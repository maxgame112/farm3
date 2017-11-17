<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ยา</title>
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

						<div class="row form-group ">
						<div class="col-md-6 ">
						<fieldset><br>
						
							<div class="row form-group">
								<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ชื่อทางการค้า</label>
									<div class="col-md-6">
										<input value="${medicine.tradeName }" id="tradeName" type="text" class="form-control" disabled="disabled"/>
										<input value="${medicine.id }" type="hidden" class="form-control" disabled="disabled"/>
									</div>
							</div>
					
						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ชื่อวิทยาศาสตร์</label>
						<div class="col-md-6">
							 	<input type="text" class="form-control" id="scientificName" value="${medicine.scientificName }" disabled="disabled"/>													
						</div>
						</div>
						
						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ชื่อสามัญ</label>
						<div class="col-md-6">
							 	<input type="text" class="form-control" id="commonName" value="${medicine.commonName }" disabled="disabled"/>													
						</div>
						</div>
						
						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> กลุ่มยา</label>
						<div class="col-md-6">
							 	<div>
									<input type="text" class="form-control" id="groupMedicine" value="${medicine.groupMedicine.value }" disabled="disabled"/>
							 	</div>											
						</div>
						</div>

						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> สรรพคุณ</label>
						<div class="col-md-6">
							<textarea rows="3" cols="45" class="form-control"  id="properties" type="text" disabled="disabled">${medicine.properties }</textarea>
						</div>
						</div> 
						
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> วิธีการใช้</label>
						<div class="col-md-6">
							<textarea rows="3" cols="45" class="form-control"  id="instruction" type="text" disabled="disabled">${medicine.instruction }</textarea>
						</div>
						</div> 
						
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ผลข้างเคียง</label>
						<div class="col-md-6">
							<textarea rows="3" cols="45" class="form-control"  id="sideEffect" type="text" disabled="disabled">${medicine.sideEffect }</textarea>
						</div>
						</div> 
						
						</fieldset>
						</div>
						<div class="col-md-4 ">
						<fieldset><br>
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ส่วนประกอบ</label>
						<div class="col-md-6">
							<textarea rows="3	" cols="45" class="form-control"  id="ingredient" type="text" disabled="disabled">${medicine.ingredient }</textarea>
						</div>
						</div> 
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ระยะหยุดยา</label>
							<div class="col-md-6">
							<div class="input-group">
								<input type="text" class="form-control" id="distanceDiscontinued" value="${medicine.distanceDiscontinued }" disabled="disabled"/>
							<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">วัน</span>
														
							</div>	
						</div>
						</div>
												
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red"></font> หมายเหตุ</label>
						<div class="col-md-6">
							<textarea rows="3" cols="45" class="form-control"  id="note" type="text" disabled="disabled">${medicine.note }</textarea>
						</div>
						</div> 
						
						</div> 
						</fieldset>
						</div>
									<div class="col-md-offset-8 col-md-6">
									<a href=medicinesh><button type="button" class="btn btn-embossed btn-primary">
									<i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp; ย้อนกลับ</button></a>
									
							<!-- 		<a href=EditMedicine><button type="button" class="btn btn-embossed btn-warning">
									<i class="fa fa-pencil fa-lg"></i></i>&nbsp; แก้ไขข้อมูล</button></a> -->
								</div>						
						
						</div>				

					</div>
					</div>
					</div>
					<div>
				</div>

			</div>

			</div>

		</div>
<%@ include file="../footer.jsp"%>
</body>
</html>