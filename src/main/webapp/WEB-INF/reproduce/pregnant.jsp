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
<title>ตรวจท้อง</title>
<script type="text/javascript">
function EnableDisableTextBox(checkbox) {
    var textBox = document.getElementById ("day_input");
    textBox.readOnly = !checkbox.checked;

}
function EnableDisableTextBox2(checkbox) {
    var textBox2 = document.getElementById ("day_input2");
    textBox2.readOnly = !checkbox.checked;
}
function Init() {
    var checkBox1 = document.getElementById ("check1");
    var checkBox2 = document.getElementById ("check2");
    EnableDisableTextBox (checkBox1);
    EnableDisableTextBox2 (checkBox2);

    var vfullearly = document.getElementById('ststuspreg').value;

    document.getElementById('field1').disabled=true;
    document.getElementById('field2').disabled=true;


 }

/*ท้องไม่ท้อง*/
function annconf() {
 
var vfullearly = document.getElementById('ststuspreg').value;


 
if (vfullearly == "1")
    {
        document.getElementById('field1').disabled=false;
        document.getElementById('field2').disabled=true;
 
    }
else if (vfullearly == "2")
    {
        document.getElementById('field2').disabled=false;
        document.getElementById('field1').disabled=true;
    }
 
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
							<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลการตรวจท้อง</a>
						</h4>
					</div>
					
					<div class="panel-body">
						<form action="pregnant" method="POST" id="pregnant" >
							<div class="row form-group">
								<div class="col-md-6">
									<fieldset><br>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> หมายเลขแม่พันธุ์</label>
												<div class="col-md-6">
							 						<div>
														<select class="form-control momcatl" id="momcatl" name="momcatl" onchange="listvaluee();">
																	<option value="0">เลือกแม่โค</option>
															<c:forEach items="${memcat }" var="mom">
													
																<option value="${mom.id }" >&nbsp;${mom.num }</option>
															</c:forEach>
														</select>														
							 						</div>																				
													<!-- <input path="" id="" type="text" class="form-control"/> -->
												<!-- 	<input path="id" id="id" type="hidden" class="form-control"/> -->
												</div>											
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>วันที่ตรวจท้อง</label>
											<div class="col-md-6">
												<input name="datePreg" id="datePreg" type="date"  class="form-control" />
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>เวลาที่ตรวจท้อง</label>
											<div class="col-md-6">
												<input name="timePreg" id="timePreg" type="Time" class="form-control" />
											</div>
										</div>		
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> ผู้บันทึก</label>
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
											<label class="col-md-offset-s col-md-3 control-lable"><font color="White">* </font> หมายเหตุ</label>
											<div>
												<textarea rows="3" cols="45" class="form-control" name="note" id="note"  type="text"></textarea>
											</div>
										</div>			
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ถ้าผสมพันธุ์ติด วันกำหนดคลอด (คาดการณ์)</label>
											<div class="col-md-6">
												<div class="input-group">
													<input name="alert1" id="alert1" type="date"  class="form-control" disabled="disabled"/>
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">	</span>    	
												</div>
											</div>
										</div>	
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ถ้าผสมพันธุ์ติด ระยะเฝ้าระวังก่อนคลอด  7 วัน(คาดการณ์)</label>
											<div class="col-md-6">
												<div class="input-group">
													<input name="alert3" id="alert3" type="date" class="form-control"  disabled="disabled"/>
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;"></span>    	
												</div>
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ถ้าผสมพันธุ์ติด ระยะเฝ้าระวังหลังคลอด  7 วัน(คาดการณ์)</label>
											<div class="col-md-6">
												<div class="input-group">
													<input name="alert2" id="alert2" type="date" class="form-control" disabled="disabled"/>
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;"></span>    	
												</div>
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ถ้าไม่ท้อง ระยะการเหนี่ยวนำกลับสัด (คาดการณ์)</label>
											<div class="col-md-6">
												<div class="input-group">
													<input name="alert4" id="alert4" type="date" class="form-control" disabled="disabled"/>
													<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;"></span>    	
												</div>
											</div>
										</div>																
										
									</fieldset>
								</div>
								
								<div class="col-md-6">
									<fieldset><br>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> ผลการครวจท้อง</label>
												<div class="col-md-6">
							 						<div>
													<select id="ststuspreg" name="ststuspreg" class="form-control select select-info" data-toggle="select" onchange="annconf(this.value);">
														<option value="0">เลือกผลการตรวจ</option>
														<option value="1">ท้อง</option>
														<option value="2">ไม่ท้อง</option>
													</select>
							 						</div>																				

												</div>											
										</div>
									<fieldset id="field1">		
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ท้อง แจ้งเตือนคลอด</label>
											<div class="col-md-6">
												<div class="input-group">
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
										</div>	
									</fieldset>	
<!-- 									<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ระยะเฝ้าระวัง</label>
									<div class="col-md-6">
									<div class="input-group">
										<input name	="name" id="name" value="ก่อนกำหนดคลอด 7 " type="text" class="form-control" disabled="disabled"/>
										<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">วัน</span>  
									</div>	
									</div>
									</div>	
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ระยะเฝ้าระวัง</label>
									<div class="col-md-6">
									<div class="input-group">
										<input name	="name" id="name" value="หลังกำหนดคลอด  7 " type="text" class="form-control" disabled="disabled"/>
										<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">วัน</span>  
									</div>	
									</div>
									</div>	 -->
									
									<fieldset id="field2">	
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ไม่ท้อง  แจ้งเตือนผสมพันธุ์</label>
											<div class="col-md-6">
												<div class="input-group">
												<div class="input-group">
												<c:forEach items="${NdAlertList}" var="nd">
												
														<input name	="day_input" id="day_input2" value="${nd.value}" type="text" class="form-control" />
													
														<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">วัน</span>  
													</c:forEach>  	
												
													
												</div>
												<label class="checkbox">
													<input type="checkbox" id="check2" onclick="EnableDisableTextBox2(this)"/>กำหนดเอง
												</label>	
												</div>
											</div>
										</div>									
								</fieldset>	
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
<%@ include file="../footer.jsp"%>
<script type="text/javascript">

	function cancel() {
		location.reload();
	} 
	
	// ยืนยันบันทึก
	$(document).on('click','#add',function(e){
	$.ajax({
		url:"savePreg",
		method:"POST",
		data:$("#pregnant").serialize()
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
		var selectedValue = $(".momcatl").val();  //หลังclass form control
		//alert(selectedValue);
		if(selectedValue != 0){
		$.ajax({
			  url: "listValue5",
			  data : {id:selectedValue}
			}).done(function(element) {
				var json = JSON.parse(element);
			
				$( "#alert1" ).val( json.alert1 );
			  	$( "#alert2" ).val(json.alert2 );
				$( "#alert3" ).val( json.alert3 );
			  	$( "#alert4" ).val(json.alert4 );
			  
			  	//alert(json.unitMedicine.value);
			});
		}else{
			$( "#alert1" ).val("" );
			$( "#alert2" ).val( "" );
			$( "#alert3" ).val("" );
			$( "#alert4" ).val( "" );
			}
	}
	
</script>
</body>
</html>