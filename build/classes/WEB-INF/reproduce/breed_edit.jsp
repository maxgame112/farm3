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
						<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลการผสมพันธุ์</p>
				</div>	
			</div>
			<div class="row">
				<hr>
			</div><br><br>
			<div class="row form-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลการผสมพันธุ์</a>
						</h4>
					</div>
					
					<div class="panel-body">
						<form action="breeding" method="POST" id="breeding">
							<div class="row form-group">
								<div class="col-md-6">
									<fieldset><br>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> หมายเลขแม่พันธุ์</label>
												<div class="col-md-6">
							 						<div>
							 						
														<select class="form-control" id="momcatl" name="momcatl" onchange="show(this.value)">
																	<option value="0">เลือกแม่โค</option>
															<c:forEach items="${memcat }" var="mom">
													
																<option value="${mom.id }" >&nbsp;${mom.num }</option>
															</c:forEach>
														</select>
							 						</div>																				
													<!-- <input path="" id="" type="text" class="form-control"/> -->
						
												</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ครั้งที่ผสม</label>
											<div class="col-md-6">
												<input name="count" id="count" type="text" class="form-control"  readonly/>
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-label" ><font color="red">* </font> ผู้บันทึก</label>
												<div class="col-md-6">
							 						<div>
									<select class="form-control" id="memberid" name="memberid">
										<%-- <form:option value="0">ผู้บันทึก</form:option> --%>
												<c:forEach items="${ulist}" var="user">

														<option value="${breed.member.id }">${breed.member.first }&nbsp;${breed.member.last  }</option>
														
											</c:forEach>
									</select>
							 					</div>											
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>แจ้งเตือนตรวจท้อง</label>
											<div class="col-md-6">
												<div class="input-group">
												<c:forEach items="${dAlertList}" var="d">
												
														<input name	="day_input" id="day_input" value="${d.value}" type="text" class="form-control" />
													
														<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">วัน</span>  
													</c:forEach>  	
												
													
												</div>
												<label class="checkbox">
													<input type="checkbox" id="check1" onclick="EnableDisableTextBox(this)"/>กำหนดเอง
												</label>	
												
											</div>
										</div>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="White">* </font>หมายเหตุ</label>
											<div>
												<textarea rows="3" cols="45" class="form-control" name="note" id="note" type="text" ></textarea>
											</div>
										</div>

																				
									</fieldset>
								</div>
								
								<div class="row form-group">
									<fieldset><br>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> หมายเลขพ่อพันธุ์</label>
												<div class="col-md-6">
							 						<div>
														<select class="form-control" id="fatcatl" name="fatcatl">
														<option value="0">เลือกพ่อโค</option>
														
															<c:forEach items="${fatcat }" var="fat">
													
																<option value="${fat.id }" >&nbsp;${fat.num }</option>
															</c:forEach>
															
														</select>
							 						</div>													
													<!-- <input path="" id="" type="text" class="form-control"/> 
													<input path="id" id="id" type="hidden" class="form-control"/>-->
												</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>วันที่ผสมพันธุ์</label>
											<div class="col-md-6">
												<input value="${breed.date }"  name="date" id="date" type="date" class="form-control" />
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>เวลาที่ผสมพันธุ์</label>
											<div class="col-md-6">
												<input value="${breed.time }" name="time" id="time" type="time" class="form-control" />
											</div>
										</div>										
									</fieldset>
								</div>
							</div>
						</form>
								<div class="col-md-offset-8">
									<button name="action" value="Add" id="add" onclick="editbre()"
										class="btn btn-success btn-lg">
										<i class="fa fa-save fa-lg"></i>&nbsp; บันทึกข้อมูล
									</button>
									


									<button name="action" value="cancel" onclick="cancel()"
										class="btn btn-danger btn-lg">
										<i class="fa fa-times fa-lg"></i>&nbsp; ยกเลิก
									</button>	<br><br><br>		
								</div>
						
					</div>
				</div>
			</div>
</div>
</div>
<%@ include file="../footer.jsp"%>

<script type="text/javascript">

	function cancel() {
		swal({	title: "Cancelled!",   
			text: "คุณได้ยกเลิกการบันทึกข้อมูล",
			/* text: "หมายเลขยา "+result,  */   
			timer: 1200,   
			type: "error",
			showConfirmButton: false },
			function(){   
				window.location.href='breeding_list'; 
		});
		
		/* setInterval(function(){location.reload()}, 2000); */
	
}
	
	// ยืนยันบันทึก
	 function editbre(){
		swal({	title: "ยืนยันบันทึกข้อมูล?",   
			text: "คุณต้องการยืนยันบันทึกข้อมูลโคหรือไม่!",   
			type: "warning",   
			showCancelButton: true,   
			confirmButtonColor: "#55c7dd",   
			confirmButtonText: "ต้องการ",
			cancelButtonText: "ไม่ต้องการ",   
			closeOnConfirm: false,   
			closeOnCancel: false }, 
			function(isConfirm){   
				if (isConfirm) {
					if($("#breed.cattleByCattlemaId.num").val() == ""){
						swal("กรุณากรอกหมายเลขแม่โค");
					}else if($("#breed.cattleByCattlefaId.num").val() == ""){
						swal("กรุณากรอกเบอร์แรกเกิด");
					
					}else{

					$.post('breed_edit',$("#breed").serialize(),
					      function (result) {
					     	swal({	title: "Success!",   
								/* text: "หมายเลขยา "+result,  */   
								timer: 200,   
								type: "success",
								showConfirmButton: false },
								function(){   
									window.location.href='breeding_list'; 
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