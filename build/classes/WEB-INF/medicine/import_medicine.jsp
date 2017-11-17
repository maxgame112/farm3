<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>การนำเข้ายา</title>
<jsp:include page="../menu.jsp"/>

</head>
<body>
<div class="container">
<br><br>
	<div class=" row form-group"> <!-- //บนสุด -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"style="font-size: 24px; color: white;"><i class="fa fa-list-ul"></i>&nbsp;การนำเข้ายา</h3>
			</div>
		<div class="panel-body" >
			<!-- <h1>บนสุด</h1> -->
			<div class="row form-group"> <!-- ใบบิล -->
				<center>
				<div class="col-md-6">
					<div class="form-inline">
							<label class="control-label" style="font-size: 20px">เลขที่ใบนำเข้า :</label>
							<input  type="text"
								class="form-control " size="30" />
					</div>
				</div>

				<div class="col-md-4">
					<div class="form-inline">
							<label class="control-label" style="font-size: 20px">วันที่ :</label>
							<input  type="date"
								class="form-control "  />
					</div>
				</div>
				</center>
			</div><!-- close ใบบิล -->
		</div>
		<div class=" row form-group"> <!-- //กลาง -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title" style="font-size: 24px; color: white;"> <i class="fa fa-cart-arrow-down"></i>&nbsp;เพิ่มรายการนำเข้า</h3>
			</div>
			<div class="panel-body">
				<!-- <h1>กลาง</h1> -->
				<div class="row form-group">
				
					
					<div class="col-md-6"> <!-- คอลัมแรก -->
						<div class="row form-group">
							<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ล็อตที่นำเข้า</label>
							<div class="col-md-6">
							 	<input type="text" class="form-control" id="" path="">													
							</div>
						</div>	
						<div class="row form-group">
		
								<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> ชื่อยา</label>
								<div class="col-md-6">
									<!-- <input type="text" class="form-control id="" path=""> -->
									<select class="form-control">
									 <option value="0">เลือกชื่อยา (ทางการค้า)</option>
									</select>
								</div>
						</div>
						<div class="row form-group">
		
								<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> จำนวน</label>
								<div class="col-md-6">
									<input type="text" class="form-control id="" path="">
								</div>
						</div>
						<div class="row form-group">
		
								<label class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> หน่วย</label>
								<div class="col-md-6">
									<input type="text" class="form-control id="" path="">
								</div>
						</div>
						
					</div><!--  //จบคอลัมแรก -->
					<div class="col-md-4 "> <!-- คอลัม2 -->
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> วันที่ผลิต</label>
							<div class="col-md-6">
								<input type="date" class="form-control" path="" id="" type="text">
							</div>
						</div>
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"><font color="red">*</font> วันที่หมดอายุ</label>
							<div class="col-md-6">
								<input type="date" class="form-control" path="" id="" type="text">
							</div>
						</div>
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"> นำเข้าจาก</label>
							<div class="col-md-6">
								<input class="form-control" path="" id="" type="text">
							</div>
						</div>
						<div class="row form-group">
							<label  class="col-md-offset-2 col-md-3 control-label"> สถานที่จัดเก็บ</label>
							<div class="col-md-6">
								<!-- <input class="form-control" path="" id="" type="text"> -->
								<textarea rows="2" cols="45" class="form-control" path="" id="" type="text"></textarea>
							</div>
						</div>
						
					</div> <!-- คอลัม2 -->
				</div>
				
			</div>
		</div>
		<div class="row form-group">
			<center><button type="button" class="btn btn-success btn-lg" id="btn_select"><li class="glyphicon glyphicon-download"></li>&nbsp;เลือกยา</button></center>
		</div>
		</div><!-- //กลาง -->
		</div>
	</div> <!-- //closeบนสุด -->

	<div class=" row form-group"> <!-- //ล่างสุด -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title" style="font-size: 24px; color: white;"> <i class="fa fa-cart-plus"></i>&nbsp;รายการที่นำเข้า</h3>
			</div>
		<div class="panel-body">
		<center>
				<div class="row form-group"> 
					<table class="table table-striped table-hover" class="form-control" class="font-nav" style="font-size: 18px;" border="1" bordercolor="#BDBDBD">
							<thead >
								<tr>
									<th>ลำดับที่</th>
									<th>ล็อตที่</th>
									<th>รายการ</th>
									<th>จำนวน</th>
									<th>หน่วย</th>
									<th>วันที่ผลิต</th>
									<th>วันที่หมดอายุ</th>
									<th>นำเข้าจาก</th>
									<th>สถานที่เก็บ</th>
									<th>ยกเลิก</th>
								</tr>
							</thead> 
							<tbody style="text-align: center;" id="lists">
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td>
										<button type="button" class="btn btn-danger btn-lg"  id="remove">
											<i class="fa fa-remove"></i>
										</button>
									</td>
								</tr>		
							</tbody>					
					</table>
				</div>
				<div class="row form-group">
					<button type="button" class="btn btn-success btn-lg"  id="addAll">
						<i class="fa fa-save fa-lg"></i>&nbsp;บันทึกรายการ
					</button>
					<button type="button" class="btn btn-danger btn-lg" id="cen" onclick="cen()">
							<i class="fa fa-times fa-lg"></i>&nbsp;ยกเลิกรายการ
					</button>
				</div>
		</center>		
		</div>
		</div>
	</div> <!-- //closeล่างสุด -->
</div>
	<%@ include file="../footer.jsp"%>

</body>
<!-- <script language="JavaScript" type="text/javascript">
$(document).on('click','#save',function(e){
	if($("#id").val() ==""
		&& $("#people\\.firstname").val() !=""
		&& $("#people\\.lastname").val() !=""
		&& $("#people\\.idCardNo").val() !=""
		&& $("#people\\.birthdate").val() !=""
		&& $("#people\\.nationality").val() !=""
		&& $("#people\\.username").val() !=""
		&& $("#people\\.password").val() !=""
		&& $("#repassword").val() !=""
		&& $("#people\\.addresses0\\.province0").val() !="0"
		&& $("#people\\.addresses0\\.amphure0").val() !="0"
		&& $("#people\\.addresses0\\.tambon0").val() !="0"
		&& $("#privilege").val()!="0"
	){
		$.post('checkIdCardNo',{idCardNo : $("#people\\.idCardNo").val()},function(e){
			if(e=="true"){
				$.post('checkusername',{username : $("#people\\.username").val()},function(e){
					if(e=="true"){
						if($("#people\\.password").val()== $("#repassword").val()){
							swal({   title: "ต้องการบันทึกบุคลากรใหม่ใช่หรือไม่",  
								text: "กรุณากรอกรหัสยืนยันตัวตน",    
								type: "input",   
								showCancelButton: true,   
								closeOnConfirm: false,   
								animation: "slide-from-top",   
								inputType:"password",
								inputPlaceholder: "password" }, 
								function(password){  
									if (password === false) return false;      
									if (password === "") {     
										swal.showInputError("กรุณากรอกรหัส");    
									return false   
								}     
									
									$.post('checkingpassword',{password : password},function(msg){
										 if(msg == "true"){

												$.ajax({
													url:"addOfficer",
													method:"POST",
													data:$("#officer").serialize()+"&button=ok"+"&role="+$("#privilege").val()
												}).success(function(msg){
													 swal({   title: "สำเร็จ",   
															text: "บันทึกบุคลากรใหม่เรียบร้อย",   
															type: "success",   
															showCancelButton: true,   
															confirmButtonText: "OK",   
															closeOnConfirm: false,   
															showCancelButton: false,},
															function(isConfirm){  
																if (isConfirm) {    
																	window.location.href="search_officer"; 
																	} 
																});
													
												});
										 }else{
											 swal.showInputError("รหัสไม่ถูกต้องไม่สามารถบันทึกใบสมัครได้");
											} 
										});
										 
								});
							
							
						}else{
							swal("ผิดพลาด", "password ไม่ตรงกัน", "error"); 
						}
					}else{
						swal("ผิดพลาด", "username ซ้ำ  ไม่สามารถบันทึกได้", "error"); 
					}
				});
				
			}else{
				swal("ผิดพลาด", "เลขบัตรประจำตัวประชาชนไม่ถูกต้อง", "error"); 
			}
		});
		
		
		
	}else{
		swal("ผิดพลาด", "กรุณากรอกข้อมูลให้ครบ", "error"); 
		
	}
	
	e.preventDefault();
});


    $("#dataTable").on('click', '#remCF', function(){
        $(this).parent().parent().remove();
    });  
  function provinces(id,val){
    	$("#amphure"+id).load('amphure', {
			id : val.value
		});
   	 $("#tambon"+id).load('tambon', {id : 0});
   	 $("#people\\.addresses"+id+"\\.mooban\\.id").load('mooban', {id : 0});
    } 
  
  function amphures(id,val){
  	$("#tambon"+id).load('tambon', {
			id : val.value
		});
	 $("#people\\.addresses"+id+"\\.mooban\\.id").load('mooban', {id : 0});
  } 
  
  function tambons(id,val){
	  	$("#people\\.addresses"+id+"\\.mooban\\.id").load('mooban', {
				id : val.value
			});
	  } 
  

  
    </script> -->
</html>
