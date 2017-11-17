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
<script src="<c:url value="/resources/js/fileinput.js" />"></script>">
<title>โคแท้ง</title>
</head>

<script type="text/javascript">

function EnableDisableTextBox(checkbox) {
    var textBox = document.getElementById ("day_input");
    textBox.readOnly = !checkbox.checked;
}

function Init () {
    var checkBox1 = document.getElementById ("check1");

    EnableDisableTextBox (checkBox1);
}

</script>

<body onload="Init(); ">
<%@ include file="../menu.jsp"%><br><br>
<div id="content">
<div class="container">
			<div class="col-md-3">
				<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
						<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลโคแท้ง</p>
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
						<form:form action="misscarry" method="POST" id="misscarry" commandName="misscarry">
							<div class="row form-group">
								<div class="col-md-6">
									<fieldset><br>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> หมายเลขแม่พันธุ์</label>
												<div class="col-md-6">
							 						<div>
							 						
														<form:select class="form-control" id="cattleid" path="cattle.id" >
																	<form:option value="0">เลือกแม่โค</form:option>
															<c:forEach items="${memcat }" var="mom">
													
																<form:option value="${mom.id }" >&nbsp;${mom.num }</form:option>
															</c:forEach>
														</form:select>
							 						</div>																				
													<!-- <input path="" id="" type="text" class="form-control"/> -->
						
												</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>วันที่ผสมพันธุ์</label>
											<div class="col-md-6">
												<form:input  path="day" id="day" type="date" class="form-control" value="${miss.day }"/>
											</div>
										</div>										
										
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-label" ><font color="red">* </font> ผู้บันทึก</label>
												<div class="col-md-6">
							 						<div>
										<form:select class="form-control" id="memberid" path="member.id">
										<%-- <form:option value="0">ผู้บันทึก</form:option> --%>
												<c:forEach items="${ulist}" var="user">

														<form:option value="${user.id }">${user.first}&nbsp;${user.last }</form:option>
															
											</c:forEach>
									</form:select>
							 					</div>											
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>แจ้งเตือนเหนี่ยวนำการกลับสัด</label>
											<div class="col-md-6">
												<div class="input-group">
												<c:forEach items="${dAlertList}" var="d">
												
														<input name="day_input" id="day_input" value="${d.value}" type="text" class="form-control" />
													
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
												<form:textarea rows="3" cols="45" class="form-control" path="note" id="note" type="text" ></form:textarea>
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
<%@ include file="../footer.jsp"%><br><br>
<script type="text/javascript">

	function cancel() {
		location.reload();
	} 
	
	// ยืนยันบันทึก
	$(document).on('click','#add',function(e){
	$.ajax({
		url:"Savemisscarry",
		method:"POST",
		data:$("#misscarry").serialize()
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