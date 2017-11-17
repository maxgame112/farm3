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
<title>น้ำหนัก 1 ปี</title>
</head>
<body>
<%@ include file="../menu.jsp"%><br><br>
<div id="content">
<div class="container">
<div class="col-md-3">
				<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
						<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลน้ำหนักโค 1 ปี</p>
				</div>	
			</div>
			<div class="row">
				<hr>
			</div><br><br>
			<div class="row form-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลน้ำหนักโค 1 ปี</a>
						</h4>
					</div>
					
				<div class="panel-body">
					<form:form action="Weight" method="POST" id="Weight">
						<div class="row form-group">
							<div class="col-md-6">
								<fieldset><br>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> เบอร์แรกเกิด</label>
												<div class="col-md-6">
							 						<div>
														<select class="form-control calvesid" id="calvesid" name="calvesid" onchange="listvaluee();">
																	<option value="0">เลือกโค</option>
															<c:forEach items="${calves }" var="calves">
													
																<option value="${calves.id }" >&nbsp;${calves.numDate }</option>
															</c:forEach>
														</select>
							 						</div>																				
													<!-- <input path="" id="" type="text" class="form-control"/> -->
													<input path="id" id="id" type="hidden" class="form-control"/>
												</div>											
										</div>		
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>วันที่บันทึกน้ำหนัก </label>
											<div class="col-md-6">
												<input name="date" id="date" type="date" class="form-control" />
											</div>
										</div>	
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>น้ำหนัก 1 ปี</label>
											<div class="col-md-6">
												<div class="input-group">
													<input name="weightyear" id="weightyear" type="text" class="form-control" />
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
												</div>
											</div>
										</div>			
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>น้ำหนักแรกเกิด</label>
											<div class="col-md-6">
												<div class="input-group">
													<input name="weightBirth" id="weightBirth" type="text" class="form-control" disabled="disabled"/>
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
												</div>
											</div>
										</div>																				
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>น้ำหนักหย่านม</label>
											<div class="col-md-6">
												<div class="input-group">
													<input name="weightWean" id="weightWean" type="text" class="form-control" disabled="disabled"/>
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">กก.</span>    	
												</div>
											</div>
										</div>								
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> ผู้บันทึก</label>
												<div class="col-md-6">
							 						<div>
														<select class="form-control" id="memberid" name="memberid">
															<%-- <form:option value="0">ผู้บันทึก</form:option> --%>
																	<c:forEach items="${ulist}" var="user">
					
																			<option value="${user.id }">${user.first}&nbsp;${user.last }</option>
																				
																</c:forEach>
														</select>
							 						</div>																				
												</div>											
										</div>		
																						
																										
								</fieldset>
							</div>						
							
						</div>
					</form:form>
								<div class="col-md-offset-8">
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
		url:"saveWeight",
		method:"POST",
		data:$("#Weight").serialize()
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
	
	
	function listvaluee() { //เอาหน่วยที่ใช้ในคลังอออกมา
		var selectedValue = $(".calvesid").val();  //หลังclass form control
		//alert(selectedValue);
		if(selectedValue != 0){
		$.ajax({
			  url: "listValue",
			  data : {id:selectedValue}
			}).done(function(element) {
				var json = JSON.parse(element);
			
				$( "#weightBirth" ).val( json.weightBirth );
			  	$( "#weightWean" ).val(json.weightWean );
			  
			  	//alert(json.unitMedicine.value);
			});
		}else{
			$( "#weightBirth" ).val("" );
			$( "#weightWean" ).val( "" );
			}
	}
	
</script>

</body>
</html>