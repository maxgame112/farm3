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
<title>ผสมพันธุ์</title>

<script type="text/javascript">

function EnableDisableTextBox(checkbox) {
    var textBox = document.getElementById ("day_input");
    textBox.readOnly = !checkbox.checked;
}

function Init () {
    var checkBox1 = document.getElementById ("check1");

    EnableDisableTextBox (checkBox1);
}


function show(str)
{
	var dt = new Date();
	var y = dt.getFullYear();
if (str=="")
  {
  document.getElementById("count").value="";
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
    document.getElementById("count").value=xmlhttp.responseText;
    }
/*   else
	  {
	  document.getElementById("count").value="1/"+y;
	  } */
  }
xmlhttp.open("GET","getCountBreed?q="+str,true);
xmlhttp.send();
}
</script>
</head>
<body onload="Init()">
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

														<option value="${user.id }">${user.first}&nbsp;${user.last }</option>
															
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
												<input  name="date" id="date" type="date" class="form-control" />
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>เวลาที่ผสมพันธุ์</label>
											<div class="col-md-6">
												<input name="time" id="time" type="time" class="form-control" />
											</div>
										</div>										
									</fieldset>
								</div>
							</div>
						</form>
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
<%@ include file="../footer.jsp"%><br><br>
<script type="text/javascript">

	function cancel() {
		location.reload();
	} 
	
	// ยืนยันบันทึก
	$(document).on('click','#add',function(e){
	$.ajax({
		url:"saveBreed",
		method:"POST",
		data:$("#breeding").serialize()
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