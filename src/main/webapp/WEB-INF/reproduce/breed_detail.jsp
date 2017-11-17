<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>รายละเอียดการผสมพันธุ์</title>
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
<body>
<%@ include file="../menu.jsp"%>
		<br><br>
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
							 						
													
																											
								 <input id="momcatl" type="text" class="form-control" value="${breed.cattleByCattlemaId.num }" readonly style="background-color:#e4ecf7"/> 
													 
													
												</div>
												</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>ครั้งที่ผสม</label>
											<div class="col-md-6">
												<input value="${breed.amount }" id="count" type="text" class="form-control"  readonly/>
												
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-label" ><font color="red">* </font> ผู้บันทึก</label>
												<div class="col-md-6">
							 						<div>
										<input  id ="memberid" type="text" class="form-control" value="${breed.member.first }&nbsp;${breed.member.last  }" readonly style="background-color:#e4ecf7" >
							 					</div>											
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>แจ้งเตือนตรวจท้อง</label>
											<div class="col-md-6">
												<div class="input-group">
												
							
														<input name	="day_input" id="day_input" value="${d.value}" type="text" class="form-control" />
													
														<span class="input-group-addon" style="border-radius: 0px 10px 10px 0px;">วัน</span>  
													 	
												
													
												</div>
													
												
											</div>
										</div>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="White">* </font>หมายเหตุ</label>
											<div>
											<textarea  rows="3" cols="45" class="form-control" name="note" id="note"  type="text" readonly style="background-color:#e4ecf7">${breed.note }</textarea>
											
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
														
							 						<input id="fatcatl" type="text" class="form-control" value="${breed.cattleByCattlefaId.num }" readonly style="background-color:#e4ecf7"/> 										
												
												</div>
										</div>
										</div>
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>วันที่ผสมพันธุ์</label>
											<div class="col-md-6">
												
												<input  id="fatcatl" type="text" class="form-control" value="${breed.date }" readonly style="background-color:#e4ecf7"/>
											</div>
										</div>
										
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>เวลาที่ผสมพันธุ์</label>
											<div class="col-md-6">
												<input value="${breed.time }" name="time" id="time" type="time" class="form-control" disabled="disabled"/>
											</div>
										</div>										
									</fieldset>
								</div>
							</div>
						</form>
								<div class="col-md-offset-8 col-md-6">
									<a href=breeding_list><button type="button" class="btn btn-embossed btn-primary">
									<i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp; ย้อนกลับ</button></a>
									
						
								</div>	
						
					</div>
				</div>
			</div>
</div>
</div>
		
		
		
		<%@ include file="../footer.jsp"%>
</body>
</html>