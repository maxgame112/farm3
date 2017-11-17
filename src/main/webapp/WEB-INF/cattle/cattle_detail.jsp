<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/fileinput.css" />" media="all"
	rel='stylesheet' type='text/css' />
<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
<script src="<c:url value="/resources/js/clicktable.js" />"></script>
<script src="<c:url value="/resources/js/fileinput.js" />"></script>
<title>บันทึกข้อมูลโค</title>
</head>
<body>
<%@ include file="../menu.jsp"%><br><br>
<div id="content">
<div class="container">
				<div class="col-md-3">
					<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
						<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลโค</p>
					</div>
				</div>
				<div class="row">
					<hr>
				</div><br><br>
				<div class="row form-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
						<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลโค</a>
						</h4>
					</div>
				
				<div class="panel-body">
						<%-- <c:forEach items="${cattle }" var="cattle"> --%>
						<div class="row form-group">
							<div class="col-md-6">
								<fieldset><br>

								
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> หมายเลขโค</label>
										<div class="col-md-6">
											<input value="${cattle.num }" id="num" type="text" class="form-control" disabled="true"/>
											<input value="${cattle.id }" id="id" type="hidden" class="form-control" disabled="true"/>
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red"> *</font> เบอร์แรกเกิด</label>
										<div class="col-md-6">
											<input value="${cattle.numDate }" id="numDate" type="" class="form-control" disabled="disabled"/>
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red"> *</font> ชื่อโค</label>
										<div class="col-md-6">
											<input value="${cattle.name }" id="name" type="name" class="form-control" disabled="disabled"/>
										</div>
									</div>	
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> ประเภทของโค</label>
									<div class="col-md-6">
										<input value="${cattle.typeCattle.value }" id="typeCattle" type="name" class="form-control" disabled="disabled"/>
									</div>
									</div>																										
								
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> วัน/เดือน/ปี เกิด</label>
									<div class="col-md-6">
										<input value="${cattle.calved }" id="calved"  type="date" class="form-control" disabled="disabled"/>
									</div>
								</div>
								
							<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> เพศ</label>
									<div class="col-md-6">
										<input value="${cattle.sex.value }" id="statusCattle" type="name" class="form-control" disabled="disabled"/>	
									</div>
									</div>									
								
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> สายพันธุ์</label>
									<div class="col-md-6">
										<input value="${cattle.statusBreed.value }" id="statusCattle" type="name" class="form-control" disabled="disabled"/>	
									</div>
									</div>				
									
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red"> </font>น้ำหนักแรกเกิด</label>
											<div class="col-md-6">
												<div class="input-group">
													<input value="${cattle.weightBirth }" id="weightBirth" type="text" class="form-control" disabled="disabled" />
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
												</div>
											</div>
										</div>																
								
									<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red"> </font>น้ำหนัก 1 ปี</label>
											<div class="col-md-6">
												<div class="input-group">
													<input value="${cattle.weight }" id="weight" type="text" class="form-control" disabled="disabled"/>
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
												</div>
											</div>
										</div>			
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red"> </font>น้ำหนักหย่านม</label>
											<div class="col-md-6">
												<div class="input-group">
													<input value="${cattle.weightWean }" id="weight" type="text" class="form-control" disabled="disabled" />
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
												</div>
											</div>
										</div>									
								
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> รหัสพ่อ</label>
										<div class="col-md-6">
											<input value="${cattle.faId }" id="faId" type="text" class="form-control" disabled="disabled"/>
										</div>
									</div>		
								
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> รหัสแม่</label>
										<div class="col-md-6">
											<input value="${cattle.maId }"  id="maId" type="text" class="form-control" disabled="disabled"/>
										</div>
									</div>										
						
								</fieldset>
							</div>
							<br>
							<div class="row form-group">
							<fieldset>

							<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> สีโค</label>
								<div class="col-md-6">
									<input value="${cattle.color.nameColor }" id="color" type="text" class="form-control" disabled="disabled"/>				
								</div>
							</div>		
							
							<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> ฝูงโค</label>
								<div class="col-md-6">
									<input value="${cattle.groupCattle.groupNameCattle }" id="groupCattle" type="text" class="form-control" disabled="disabled"/>									
								</div>
							</div>		
							
							<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> คอก</label>
								<div class="col-md-6">
									<input value="${cattle.stall.value }" id="stall" type="text" class="form-control" disabled="disabled"/>								
								</div>
							</div>					
																												
							<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> ชื่อฟาร์ม</label>
										<div class="col-md-6">
											<input value="${cattle.farm }"  id="farm" type="text" class="form-control" disabled="disabled"/>
										</div>
							</div>								
							</fieldset>
							</div>
						</div>	
						
				<%-- 	</c:forEach> --%>
					<div class="col-md-offset-8 col-md-6">
						<a href=cattlelist><button type="button" class="btn btn-embossed btn-primary">
						<i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp; ย้อนกลับ</button></a>
						
<!-- 						<a href=EditDisease><button type="button" class="btn btn-embossed btn-warning">
						<i class="fa fa-pencil fa-lg"></i></i>&nbsp; แก้ไขข้อมูล</button></a> -->
					</div>
						

				</div>
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
				$.post('addcattle',$("#cattle").serialize(),
				      function (result) {
				     	swal({	title: "Success!",   
							/* text: "หมายเลขยา "+result,  */   
							timer: 2000,   
							type: "success",
							showConfirmButton: false 
						});
						setInterval(function(){location.reload()}, 2000);
					})
				}

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