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
<title>คลอด</title>

<script type="text/javascript">


function show(str)
{
if (str=="")
  {
  document.getElementById("dadId").value="";
  return;
  } 
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("dadId").value=xmlhttp.responseText;
    }
  else
	  {
	  document.getElementById("dadId").value="-";
	  }
  }
xmlhttp.open("GET","getFatherId?q="+str,true);
xmlhttp.send();
}

function annconf() {
	 
	var vfullearly = document.getElementById('statusborn').value;
	
 
		document.getElementById('field1').disabled=true;
        document.getElementById('field2').disabled=true;
        document.getElementById('field3').disabled=true;
        document.getElementById('field4').disabled=true; 
 
    
	 
	if (vfullearly == "1")
	    {
	        document.getElementById('field1').disabled=false;
	        document.getElementById('field2').disabled=true;
	        document.getElementById('field3').disabled=true;
	        document.getElementById('field4').disabled=true;
	 
	    }
	else if (vfullearly == "2")
	    {
	        document.getElementById('field2').disabled=false;
	        document.getElementById('field1').disabled=false;
	        document.getElementById('field3').disabled=true;
	        document.getElementById('field4').disabled=true;
	    }
	else if(vfullearly == "3"){
		document.getElementById('field3').disabled=false;
	    document.getElementById('field1').disabled=false;
	    document.getElementById('field2').disabled=false;
	    document.getElementById('field4').disabled=true;	 	
		}
	else if (vfullearly == "4" ) {
		document.getElementById('field4').disabled=false;
	    document.getElementById('field1').disabled=false;
	    document.getElementById('field2').disabled=false;
	    document.getElementById('field3').disabled=false;	
		}
	    
	}
	

</script>

</head>
<body onload="annconf()">
<%@ include file="../menu.jsp"%><br><br>
<div id="content">
<div class="container">
			<div class="col-md-3">
				<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
						<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลการคลอด</p>
				</div>	
			</div>
			<div class="row">
				<hr>
			</div><br><br>
			<div class="row form-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลการคลอด</a>
						</h4>
					</div>
					
					<div class="panel-body">
						<form action="cattle" method="POST" id="cattle">
							<div class="row form-group">
								<div class="col-md-6">
									<fieldset><br>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> หมายเลขแม่พันธุ์</label>
												<div class="col-md-6">
							 						<div>
														<select class="form-control" id="momcatl" name="momcatl">
																	<option value="0">เลือกแม่โค</option>
															<c:forEach items="${memcat }" var="mom">
													
																<option value="${mom.id }" >&nbsp;${mom.num }</option>
															</c:forEach>
														</select>
							 						</div>																				
													<!-- <input path="" id="" type="text" class="form-control"/> -->
													<!-- <input path="id" id="id" type="hidden" class="form-control"/> -->
												</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> วัน/เดือน/ปี เกิด</label>
											<div class="col-md-6">
												<input name="calved" id="calved"  type="date" class="form-control"/>
											</div>
										</div>	
										
<%-- 										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> ผู้บันทึก</label>
												<div class="col-md-6">
							 						<div>
											<select class="form-control" id="memberid" name="memberid">
										<form:option value="0">ผู้บันทึก</form:option>
												<c:forEach items="${ulist}" var="user">

														<option value="${user.id }">${user.first}&nbsp;${user.last }</option>
															
											</c:forEach>
											</select>
							 					</div>											
											</div>
										</div> --%>
																			
									</fieldset>
								</div>
								
								<div class="col-md-6">
									<fieldset><br>
									<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> หมายเลขพ่อพันธุ์</label>
												<div class="col-md-6">
							 						<div>
							 							<!-- <input name="dadId" id="dadId" class="form-control" type="text" readonly="true"/> -->
													<select class="form-control" id="fatcatl" name="fatcatl">
														<option value="0">เลือกพ่อโค</option>
														
															<c:forEach items="${fatcat }" var="fat">
													
																<option value="${fat.num }" >&nbsp;${fat.num }</option>
															</c:forEach>
															
														</select>
							 						</div>																				
													<!-- <input path="" id="" type="text" class="form-control"/> -->
												<!-- 	<input path="id" id="id" type="hidden" class="form-control"/> -->
												</div>
										</div>
										
									<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> สถานะ</label>
												<div class="col-md-6">
							 						<div>
													<select  id="statusborn" name="statusborn" class="form-control select select-info" data-toggle="select" onchange="annconf(this.value);">
														<option value="">สถานะการเกิด</option>
														<option value="1">ลูกปกติ</option>
														<option value="2">ลูกแฝดสอง</option>
														<option value="3">ลูกแฝดสาม</option>
														<option value="4">ลูกแฝดสี่</option>															
														</select>
							 						</div>																				
												</div>
										</div>	
										
									</fieldset>
								</div>					
							</div>
				
					<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->		
					
						<div class="col-md-6">
							<div class="panel panel-primary" >
								<div class="panel-heading">
									<h3 class="panel-title" >
										<span class="fa fa-list-alt fa-lg"></span></i>&nbsp;ลูกโค
									</h3>
								</div>
								<div class="panel-body">
								<fieldset id="field1">
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> เบอร์แรกเกิด</label>
										<div class="col-md-6">
											<input name="numDate" id="numDate" type="text" class="form-control"/>
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> ชื่อโค</label>
										<div class="col-md-6">
											<input name="name" id="name" type="text" class="form-control"/>
										</div>
									</div>		
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> สายพันธุ์</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="statusbreed" name="statusbreed">
														<option value="0">เลือกสายพันธุ์</option>
														
															<c:forEach items="${statusbreed }" var="statusbreed">
													
																<option value="${statusbreed.id }" >&nbsp;${statusbreed.value }</option>
															</c:forEach>
															
														</select>
									 		</div>											
										</div>
									</div>		
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> สีโค</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="color" name="color">
														<option value="0">เลือกสีโค</option>
														
															<c:forEach items="${color }" var="color">
													
																<option value="${color.id }" >&nbsp;${color.nameColor }</option>
															</c:forEach>
															
														</select>
												</select>
									 		</div>											
										</div>
									</div>	
																			
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เพศ</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="sex" name="sex">
														<option value="0">เลือกเพศโค</option>
														
															<c:forEach items="${sex }" var="sex">
													
																<option value="${sex.id }" >&nbsp;${sex.value }</option>
															</c:forEach>
															
														</select>
												</select>
									 		</div>											
										</div>
									</div>																				
								
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>น้ำหนักแรกเกิด</label>
										<div class="col-md-6">
											<div class="input-group">
												<input name="weightBirth" id="weightBirth" type="text" class="form-control" />
												<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
											</div>
										</div>
									</div>
									
																	
								</fieldset>		
								</div>
							</div>
						</div>							
					
<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->		

						<div class="col-md-6">
							<div class="panel panel-primary" >
								<div class="panel-heading">
									<h3 class="panel-title" >
										<span class="fa fa-list-alt fa-lg"></span></i>&nbsp;ลูกโค
									</h3>
								</div>
								<div class="panel-body">
									<fieldset id="field2">
											<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> เบอร์แรกเกิด</label>
										<div class="col-md-6">
											<input name="numDate" id="numDate" type="text" class="form-control"/>
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> ชื่อโค</label>
										<div class="col-md-6">
											<input name="name" id="name" type="text" class="form-control"/>
										</div>
									</div>		
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> สายพันธุ์</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="statusbreed" name="statusbreed">
														<option value="0">เลือกสายพันธุ์</option>
														
															<c:forEach items="${statusbreed }" var="statusbreed">
													
																<option value="${statusbreed.id }" >&nbsp;${statusbreed.value }</option>
															</c:forEach>
															
														</select>
									 		</div>											
										</div>
									</div>		
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> สีโค</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="color" name="color">
														<option value="0">เลือกสีโค</option>
														
															<c:forEach items="${color }" var="color">
													
																<option value="${color.id }" >&nbsp;${color.nameColor }</option>
															</c:forEach>
															
														</select>
												</select>
									 		</div>											
										</div>
									</div>		
																														
<!-- 									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> วัน/เดือน/ปี เกิด</label>
										<div class="col-md-6">
											<input path="" id=""  type="date" class="form-control"/>
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>เวลาที่่คลอด</label>
										<div class="col-md-6">
											<input path="" id="" type="time" class="form-control" />
										</div>
									</div> -->	
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เพศ</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="sex" name="sex">
														<option value="0">เลือกเพศโค</option>
														
															<c:forEach items="${sex }" var="sex">
													
																<option value="${sex.id }" >&nbsp;${sex.value }</option>
															</c:forEach>
															
														</select>
												</select>
									 		</div>											
										</div>
									</div>																				
								
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>น้ำหนักแรกเกิด</label>
										<div class="col-md-6">
											<div class="input-group">
												<input name="weightBirth" id="weightBirth" type="text" class="form-control" />
												<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
											</div>
										</div>
									</div>
								</fieldset>	
								</div>
							</div>
						</div>							
					
<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->		

						<div class="col-md-6">
							<div class="panel panel-primary" >
								<div class="panel-heading">
									<h3 class="panel-title" >
										<span class="fa fa-list-alt fa-lg"></span></i>&nbsp;ลูกโค
									</h3>
								</div>
								<div class="panel-body">
									<fieldset id="field3">
														<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> เบอร์แรกเกิด</label>
										<div class="col-md-6">
											<input name="numDate" id="numDate" type="text" class="form-control"/>
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> ชื่อโค</label>
										<div class="col-md-6">
											<input name="name" id="name" type="text" class="form-control"/>
										</div>
									</div>		
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> สายพันธุ์</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="statusbreed" name="statusbreed">
														<option value="0">เลือกสายพันธุ์</option>
														
															<c:forEach items="${statusbreed }" var="statusbreed">
													
																<option value="${statusbreed.id }" >&nbsp;${statusbreed.value }</option>
															</c:forEach>
															
														</select>
									 		</div>											
										</div>
									</div>		
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> สีโค</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="color" name="color">
														<option value="0">เลือกสีโค</option>
														
															<c:forEach items="${color }" var="color">
													
																<option value="${color.id }" >&nbsp;${color.nameColor }</option>
															</c:forEach>
															
														</select>
												</select>
									 		</div>											
										</div>
									</div>		
																														
<!-- 									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> วัน/เดือน/ปี เกิด</label>
										<div class="col-md-6">
											<input path="" id=""  type="date" class="form-control"/>
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>เวลาที่่คลอด</label>
										<div class="col-md-6">
											<input path="" id="" type="time" class="form-control" />
										</div>
									</div> -->	
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เพศ</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="sex" name="sex">
														<option value="0">เลือกเพศโค</option>
														
															<c:forEach items="${sex }" var="sex">
													
																<option value="${sex.id }" >&nbsp;${sex.value }</option>
															</c:forEach>
															
														</select>
												</select>
									 		</div>											
										</div>
									</div>																				
								
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>น้ำหนักแรกเกิด</label>
										<div class="col-md-6">
											<div class="input-group">
												<input name="weightBirth" id="weightBirth" type="text" class="form-control" />
												<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
											</div>
										</div>
									</div>						
							</fieldset>	
								</div>
							</div>
						</div>																				
					
<!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->		

						<div class="col-md-6">
							<div class="panel panel-primary" >
								<div class="panel-heading">
									<h3 class="panel-title" >
										<span class="fa fa-list-alt fa-lg"></span></i>&nbsp;ลูกโค
									</h3>
								</div>
								<div class="panel-body">
									<fieldset id="field4">
														<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> เบอร์แรกเกิด</label>
										<div class="col-md-6">
											<input name="numDate" id="numDate" type="text" class="form-control"/>
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> ชื่อโค</label>
										<div class="col-md-6">
											<input name="name" id="name" type="text" class="form-control"/>
										</div>
									</div>		
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> สายพันธุ์</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="statusbreed" name="statusbreed">
														<option value="0">เลือกสายพันธุ์</option>
														
															<c:forEach items="${statusbreed }" var="statusbreed">
													
																<option value="${statusbreed.id }" >&nbsp;${statusbreed.value }</option>
															</c:forEach>
															
														</select>
									 		</div>											
										</div>
									</div>		
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> สีโค</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="color" name="color">
														<option value="0">เลือกสีโค</option>
														
															<c:forEach items="${color }" var="color">
													
																<option value="${color.id }" >&nbsp;${color.nameColor }</option>
															</c:forEach>
															
														</select>
												</select>
									 		</div>											
										</div>
									</div>		
																														
<!-- 									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> วัน/เดือน/ปี เกิด</label>
										<div class="col-md-6">
											<input path="" id=""  type="date" class="form-control"/>
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>เวลาที่่คลอด</label>
										<div class="col-md-6">
											<input path="" id="" type="time" class="form-control" />
										</div>
									</div> -->	
									
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เพศ</label>
										<div class="col-md-6">
									 		<div>
													<select class="form-control" id="sex" name="sex">
														<option value="0">เลือกเพศโค</option>
														
															<c:forEach items="${sex }" var="sex">
													
																<option value="${sex.id }" >&nbsp;${sex.value }</option>
															</c:forEach>
															
														</select>
												</select>
									 		</div>											
										</div>
									</div>																				
								
									<div class="row form-group">
										<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>น้ำหนักแรกเกิด</label>
										<div class="col-md-6">
											<div class="input-group">
												<input name="weightBirth" id="weightBirth" type="text" class="form-control" />
												<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
											</div>
										</div>
									</div>
									
								</fieldset>								
								
								</div>
							</div>
						</div>
						
						</form>	
						
								<div class="col-md-offset-6">
									<button name="action" value="Add" id="add"
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
	location.reload();
} 

// ยืนยันบันทึก
$(document).on('click','#add',function(e){
$.ajax({
	url:"saveCalve",
	method:"POST",
	data:$("#cattle").serialize()
}).done(function(s){
	swal({  title: "สำเร็จ",   
		text: "บันทึกเรียบร้อยแล้ว!", 
		type: "success",   
		showCancelButton: false,   
		confirmButtonText: "OK!",   
		closeOnConfirm: false }, 
		
		function(){   
			location.reload(); 
			});
}).fail(function() {
	swal("ผิดพลาด", "ไม่สามารถบันทึกได้!", "error");
}); 
e.preventDefault();
});

</script>

</body>
</html>