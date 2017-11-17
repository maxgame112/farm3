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
<title>เหนี่ยวนำ</title>

<script type="text/javascript">

function show(str)
{
if (str=="")
  {
  document.getElementById("txtHint").innerHTML="";
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
    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","getSynchroniz?q="+str,true);
xmlhttp.send();
}

</script>

</head>
<body>
<%@ include file="../menu.jsp"%><br><br>
<%@ include file="../footer.jsp"%>
<div id="content">
<div class="container">
			<div class="col-md-3">
				<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
						<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลการเหนี่ยมนำ</p>
				</div>	
			</div>
			<div class="row">
				<hr>
			</div><br><br>	
			<div class="row form-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลการเหนี่ยวนำ</a>
						</h4>
					</div>				
				
					<div class="panel-body">
						<form:form  method="POST" id="synchronize" commandName="synchronize">
							<div class="row form-group">
								<div class="col-md-6">
									<fieldset><br>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> หมายเลขแม่พันธุ์</label>
												<div class="col-md-6">
							 						<div>
														<form:select class="form-control select select-info" id="momcatl" data-toggle="select" path="cattle.id">
																	<form:option value="">เลือกแม่โค</form:option>
															<c:forEach items="${momcat }" var="mom">
													
																<form:option value="${mom.id }" >&nbsp;${mom.num }</form:option>
															</c:forEach>
														</form:select>
							 						</div>																				
													<!-- <input path="" id="" type="text" class="form-control"/> -->
													<!-- <input name="id" id="id" type="hidden" class="form-control"/> -->
												</div>											
										</div>		
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> ผู้บันทึก</label>
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
																												
									</fieldset>
								</div>
								
								<div class="col-md-6">
									<fieldset><br>
									
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> โปรแกรมที่ใช้</label>
												<div class="col-md-6">
							 						<div>
														<form:select class="form-control select select-info" data-toggle="select" id="Typesync.id" path="typeSync.id" onchange="show(this.value)">
															<form:option value="">เลือกรายการ</form:option>
																<c:forEach items="${typesync}" var="typesync">
									
																	<form:option value="${typesync.id }">${typesync.value}</form:option>
																								
																</c:forEach>
														</form:select>
							 						</div>																				
												</div>											
										</div>	
									
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>วันทีี่เริ่มทำโปรแกรม</label>
											<div class="col-md-6">
												<form:input path="dateSync" id="dateSync" type="date" class="form-control" />
											</div>
										</div>											
									</fieldset>
								</div>
								
			
								<div id="txtHint"></div>
															
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
</body>

<script type="text/javascript">

	function cancel() {
		location.reload();
	} 
	
	// ยืนยันบันทึก
	$(document).on('click','#add',function(e){
	$.ajax({
		url:"saveSynchroniz",
		method:"POST",
		data:$("#synchronize").serialize()
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

</html>