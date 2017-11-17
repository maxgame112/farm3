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
<%-- <script src="<c:url value="/resources/js/jquery.select-to-autocomplete.js" />"></script> --%>
<script src="<c:url value="/resources/js/clicktable.js" />"></script>
<script src="<c:url value="/resources/js/fileinput.js" />"></script>
<title>บันทึกข้อมูลโรค</title>

<script type="text/javascript">

function annconf() {
	 
	var vfullearly = document.getElementById('statusmedicine').value;
	
		document.getElementById('medicine').disabled=true;
        document.getElementById('doseUsesage').disabled=true;

        
		document.getElementById('medicine1').disabled=true;
        document.getElementById('doseUsesage1').disabled=true;
        
		document.getElementById('medicine2').disabled=true;
        document.getElementById('doseUsesage2').disabled=true;
        
		document.getElementById('medicine3').disabled=true;
        document.getElementById('doseUsesage3').disabled=true;
        
		document.getElementById('medicine4').disabled=true;
        document.getElementById('doseUsesage4').disabled=true;
        
		document.getElementById('medicine5').disabled=true;
        document.getElementById('doseUsesage5').disabled=true;


    
	 
	if (vfullearly == "1")
	    {
	        document.getElementById('medicine').disabled=false;
	        document.getElementById('doseUsesage').disabled=false;
	        
	        document.getElementById('medicine1').disabled=true;
	        document.getElementById('doseUsesage1').disabled=true;

			document.getElementById('medicine2').disabled=true;
	        document.getElementById('doseUsesage2').disabled=true;
	        
			document.getElementById('medicine3').disabled=true;
	        document.getElementById('doseUsesage3').disabled=true;
	        
			document.getElementById('medicine4').disabled=true;
	        document.getElementById('doseUsesage4').disabled=true;
	        
			document.getElementById('medicine5').disabled=true;
	        document.getElementById('doseUsesage5').disabled=true;
	 
	    }
	else if (vfullearly == "2")
	    {
        document.getElementById('medicine1').disabled=false;
        document.getElementById('doseUsesage1').disabled=false;
        
        document.getElementById('medicine').disabled=false;
        document.getElementById('doseUsesage').disabled=false;

		document.getElementById('medicine2').disabled=true;
        document.getElementById('doseUsesage2').disabled=true;
        
		document.getElementById('medicine3').disabled=true;
        document.getElementById('doseUsesage3').disabled=true;
        
		document.getElementById('medicine4').disabled=true;
        document.getElementById('doseUsesage4').disabled=true;
        
		document.getElementById('medicine5').disabled=true;
        document.getElementById('doseUsesage5').disabled=true;
	        
	    }
	else if(vfullearly == "3"){
        document.getElementById('medicine2').disabled=false;
        document.getElementById('doseUsesage2').disabled=false;
        
        document.getElementById('medicine').disabled=false;
        document.getElementById('doseUsesage').disabled=false;

		document.getElementById('medicine1').disabled=false;
        document.getElementById('doseUsesage1').disabled=false;
        
		document.getElementById('medicine3').disabled=true;
        document.getElementById('doseUsesage3').disabled=true;
        
		document.getElementById('medicine4').disabled=true;
        document.getElementById('doseUsesage4').disabled=true;
        
		document.getElementById('medicine5').disabled=true;
        document.getElementById('doseUsesage5').disabled=true;
		}
	else if (vfullearly == "4" ) {
			 document.getElementById('medicine3').disabled=false;
	        document.getElementById('doseUsesage3').disabled=false;
	        
	        document.getElementById('medicine').disabled=false;
	        document.getElementById('doseUsesage').disabled=false;

			document.getElementById('medicine1').disabled=false;
	        document.getElementById('doseUsesage1').disabled=false;
	        
			document.getElementById('medicine2').disabled=false;
	        document.getElementById('doseUsesage2').disabled=false;
	        
			document.getElementById('medicine4').disabled=true;
	        document.getElementById('doseUsesage4').disabled=true;
	        
			document.getElementById('medicine5').disabled=true;
	        document.getElementById('doseUsesage5').disabled=true;
		}
	
	else if (vfullearly == "5" ) {
			 document.getElementById('medicine4').disabled=false;
	        document.getElementById('doseUsesage4').disabled=false;
	        
	        document.getElementById('medicine').disabled=false;
	        document.getElementById('doseUsesage').disabled=false;

			document.getElementById('medicine1').disabled=false;
	        document.getElementById('doseUsesage1').disabled=false;
	        
			document.getElementById('medicine2').disabled=false;
	        document.getElementById('doseUsesage2').disabled=false;
	        
			document.getElementById('medicine3').disabled=false;
	        document.getElementById('doseUsesage3').disabled=false;
	        
			document.getElementById('medicine5').disabled=true;
	        document.getElementById('doseUsesage5').disabled=true;
		}
		
	else if (vfullearly == "6" ) {
		 document.getElementById('medicine5').disabled=false;
	        document.getElementById('doseUsesage5').disabled=false;
	        
	        document.getElementById('medicine').disabled=false;
	        document.getElementById('doseUsesage').disabled=false;

			document.getElementById('medicine1').disabled=false;
	        document.getElementById('doseUsesage1').disabled=false;
	        
			document.getElementById('medicine2').disabled=false;
	        document.getElementById('doseUsesage2').disabled=false;
	        
			document.getElementById('medicine3').disabled=false;
	        document.getElementById('doseUsesage3').disabled=false;
	        
			document.getElementById('medicine4').disabled=false;
	        document.getElementById('doseUsesage4').disabled=false;
		} 
	    
	}
	
function Init() {
    var checkBox1 = document.getElementById ("check1");
    EnableDisableTextBox (checkBox1);

 }
 
function EnableDisableTextBox(checkbox) {
    var textBox = document.getElementById ("day_input");
    textBox.readOnly = !checkbox.checked;

}

</script>
</head>
<body onload="annconf();Init()">


<%@ include file="../menu.jsp"%>
<br><br>
	<div id="content">
	<div class="container">
		<div class="col-md-3">
			<div class="jumbotron" style="background-color: rgb(218, 68, 83)" align="center">
				<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลการรักษา</p>						
			</div>		
		</div>
	<div class="row">
		<hr>
	</div>
	<br> <br>
		<div class="row form-group">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">
					<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลการรักษา</a>
				</h4>
			</div>
			
			<div class="panel-body">
				<form action="TreatmentHistory" method="POST" id="treat">
					<div class="row form-group">
						<div class="col-md-6"> 
							<fieldset><br>
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> ชื่อโค</label>
									<div class="col-md-6">
								 		<div>
											<select class="form-control cattle" id="cattle" name="cattle" onchange="listcattle();">
												<option value="0">เลือกโค</option>
													<c:forEach items="${cattle }" var="cattle">
													
														<option value="${cattle.id }" >&nbsp;${cattle.name }</option>
													</c:forEach>
											</select>
							 			</div>
									</div>
								</div>
								
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> หมายเลขโค</label>
									<div class="col-md-6"> 
										<input name="num" id="num" type="text" class="form-control" disabled="disabled"/>
									</div>
								</div>
								
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> วันที่ทำการวินิจฉัย</label>
									<div class="col-md-6">
										<input name="date" id="date" type="date" class="form-control" />
									</div>
								</div>
								
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>เวลาที่ทำการวินิจฉัย</label>
											<div class="col-md-6">
												<input name="dateEndTreat" id="dateEndTreat" type="time" class="form-control" />
											</div>
										</div>	

							<div class="row form-group"> 
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font>อาการเจ็บป่วย</label>
									<div class="col-md-6">
										<textarea rows="3" cols="45" name="causeOfIllness" id="causeOfIllness" type="text" class="form-control"></textarea> 
									</div>
							</div>
								
							<div class="row form-group" align="center">
								  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">ช่วยเหลือในการค้นหาโรคและยา</button>
							</div> 	
												
								<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เลือกจำนวนยา</label>
								<div class="col-md-6">
							 		<div>
								<select  id="statusmedicine" name="statusmedicine" class="form-control select select-info" data-toggle="select" onchange="annconf(this.value);">
														<option value="">จำนวนยาที่ใช้</option>
														<option value="1">ยาตัวที่ 1</option>
														<option value="2">ยาตัวที่ 2</option>
														<option value="3">ยาตัวที่ 3</option>
														<option value="4">ยาตัวที่ 4</option>		
														<option value="5">ยาตัวที่ 5</option>	
														<option value="6">ยาตัวที่ 6</option>												
									</select>
							 		</div>											
								</div>
							</div>
								
								
							</fieldset>
						</div>
							
						<div class="col-md-4">
							<fieldset><br>
															
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> ชื่อโรค</label>
									<div class="col-md-6">
										<div>
											<select class="form-control disease" id="disease" name="disease" onchange="listDisease();">
												<option value="">เลือกโรค</option>
												<c:forEach items="${disease }" var="disease">
													<option value="${disease.id}">&nbsp;${disease.nameDisease }
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
							
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> อาการป่วย</label>
									<div class="col-md-6">
										<textarea rows="3" cols="45" name="symptomsOfDisease" id="symptomsOfDisease" type="text" class="form-control" disabled="true"></textarea>
									</div>
								</div>
								
								
								<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> ผู้บันทึก</label>
								<div class="col-md-6">
							 		<div>
									<select class="form-control" id="memberid" name="memberid">
												<c:forEach items="${ulist}" var="user">
													<c:if test="${member.id == user.id }">
														<option value="${un.id}" selected="selected">${user.first}&nbsp;${user.last }</option></c:if>
															
													<c:if test="${member.id != user.id }">
														<option value="${user.id }">${user.first}&nbsp;${user.last }</option>
													</c:if>
															
											</c:forEach>
									</select>
							 		</div>											
								</div>
								</div>
								
										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font>แจ้งเตือนการรักษา</label>
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
						</div>
					</div>
					
					<div id="content">
							<div class="panel panel-primary" >
								<div class="panel-heading">
									<h3 class="panel-title" >
										<span class="fa fa-list-alt fa-lg"></span></i>&nbsp;ยา
									</h3>
								</div>
								<div class="panel-body">
										<div class="panel-body">
											<table class="table table-striped table-hover  table-bordered"
												style="font-size: 16px;">
												<thead>
													<tr>
														<th style="width: 150px;">ชื่อทางการค้า</th>
														<th style="width: 190px;">ชื่อสามัญ</th>
														<th style="width: 190px;">ระยะหยุดยา (วัน)</th>
														<th style="width: 190px;">จำนวนที่ใช้</th>
					
													</tr>	
												</thead>
												<tbody style="text-align: center;">
													<td>
														<div class="row form-group">
															<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เลือกยา</label>
																<div class="col-md-6">
			
																	<select class="form-control medicine" id="medicine" name="medicine" onchange="Listmed();" style="width: 150px;">
																		<option value="">เลือกยาที่ใช้</option>
																			<c:forEach items="${medicine }" var="medicine">
																				<option value="${medicine.id }">&nbsp;${medicine.tradeName }
																		</c:forEach>
																	</select>						
									

																</div>
														</div>
													</td>
													<td>
													<fieldset id="2">
														<input name="commonName" id="commonName" class="form-control" style="width: 150px;" disabled="true"/>
													</fieldset>
													</td>
													<td>
														<input name="distanceDiscontinued" id="distanceDiscontinued" class="form-control" style="width: 50px;" disabled="true"/>
														<input value="วัน" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
													<td>
														<input name="doseUsesage" id="doseUsesage" class="form-control" style="width: 50px;"/>
														<input value="CC" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
												</tbody>

												
												<tbody style="text-align: center;">
													<td>
														<div class="row form-group">
															<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เลือกยา</label>
																<div class="col-md-6">
			
																	<select class="form-control medicine1" id="medicine1" name="medicine" onchange="Listmed1();" style="width: 150px;">
																		<option value="">เลือกยาที่ใช้</option>
																			<c:forEach items="${medicine }" var="medicine">
																				<option value="${medicine.id }">&nbsp;${medicine.tradeName }
																		</c:forEach>
																	</select>						
									

																</div>
														</div>
													</td>
													<td>
														<input name="commonName" id="commonName1" class="form-control" style="width: 150px;" disabled="true"/>
													</td>
													<td>
														<input name="distanceDiscontinued" id="distanceDiscontinued1" class="form-control" style="width: 50px;" disabled="true"/>
														<input value="วัน" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
													<td>
														<input name="doseUsesage" id="doseUsesage1" class="form-control" style="width: 50px;"/>
														<input value="CC" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
												</tbody>
												
												<tbody style="text-align: center;">
													<td>
														<div class="row form-group">
															<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เลือกยา</label>
																<div class="col-md-6">
			
																	<select class="form-control medicine2" id="medicine2" name="medicine" onchange="Listmed2();" style="width: 150px;">
																		<option value="">เลือกยาที่ใช้</option>
																			<c:forEach items="${medicine }" var="medicine">
																				<option value="${medicine.id }">&nbsp;${medicine.tradeName }
																		</c:forEach>
																	</select>						
									

																</div>
														</div>
													</td>
													<td>
														<input name="commonName" id="commonName2" class="form-control" style="width: 150px;" disabled="true"/>
													</td>
													<td>
														<input name="distanceDiscontinued" id="distanceDiscontinued2" class="form-control" style="width: 50px;" disabled="true"/>
														<input value="วัน" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
													<td>
														<input name="doseUsesage" id="doseUsesage2" class="form-control" style="width: 50px;"/>
														<input value="CC" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
												</tbody>
												
												<tbody style="text-align: center;">
													<td>
														<div class="row form-group">
															<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เลือกยา</label>
																<div class="col-md-6">
			
																	<select class="form-control medicine3" id="medicine3" name="medicine" onchange="Listmed3();" style="width: 150px;">
																		<option value="">เลือกยาที่ใช้</option>
																			<c:forEach items="${medicine }" var="medicine">
																				<option value="${medicine.id }">&nbsp;${medicine.tradeName }
																		</c:forEach>
																	</select>						
									

																</div>
														</div>
													</td>
													<td>
														<input name="commonName" id="commonName3" class="form-control" style="width: 150px;" disabled="true"/>
													</td>
													<td>
														<input name="distanceDiscontinued" id="distanceDiscontinued3" class="form-control" style="width: 50px;" disabled="true"/>
														<input value="วัน" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
													<td>
														<input name="doseUsesage" id="doseUsesage3" class="form-control" style="width: 50px;"/>
														<input value="CC" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
												</tbody>
												
												<tbody style="text-align: center;">
													<td>
														<div class="row form-group">
															<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เลือกยา</label>
																<div class="col-md-6">
			
																	<select class="form-control medicine4" id="medicine4" name="medicine" onchange="Listmed4();" style="width: 150px;">
																		<option value="">เลือกยาที่ใช้</option>
																			<c:forEach items="${medicine }" var="medicine">
																				<option value="${medicine.id }">&nbsp;${medicine.tradeName }
																		</c:forEach>
																	</select>						
									

																</div>
														</div>
													</td>
													<td>
														<input name="commonName" id="commonName4" class="form-control" style="width: 150px;" disabled="true"/>
													</td>
													<td>
														<input name="distanceDiscontinued" id="distanceDiscontinued4" class="form-control" style="width: 50px;" disabled="true"/>
														<input value="วัน" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
													<td>
														<input name="doseUsesage" id="doseUsesage4" class="form-control" style="width: 50px;"/>
														<input value="CC" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
												</tbody>
												
												<tbody style="text-align: center;">
													<td>
														<div class="row form-group">
															<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เลือกยา</label>
																<div class="col-md-6">
			
																	<select class="form-control medicine5" id="medicine5" name="medicine" onchange="Listmed5();" style="width: 150px;">
																		<option value="">เลือกยาที่ใช้</option>
																			<c:forEach items="${medicine }" var="medicine">
																				<option value="${medicine.id }">&nbsp;${medicine.tradeName }
																		</c:forEach>
																	</select>						
									

																</div>
														</div>
													</td>
													<td>
														<input name="commonName" id="commonName5" class="form-control" style="width: 150px;" disabled="true"/>
													</td>
													<td>
														<input name="distanceDiscontinued" id="distanceDiscontinued5" class="form-control" style="width: 50px;" disabled="true"/>
														<input value="วัน" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
													<td>
														<input name="doseUsesage" id="doseUsesage5" class="form-control" style="width: 50px;"/>
														<input value="CC" class="form-control" style="width: 50px;" disabled="true"/>
													</td>
												</tbody>
											</table>
										</div>
								</div>
							</div>
					
					</div>
						
				</form>
					<div class="row form-group">
							<div class="form-inline">

									
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
		
	<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title"><font color="blue">ช่วยเหลือในการค้นหาโรคและยา</font></h3>
        </div>

			<div align="right" class=" row form-group" style="margin-right: 30px">
				<div class="form-inline">
					<label for="select">ค้นหาโดย</label>
						<div class="input-group form-search">
							<select class="form-control  search-query" style="width: 150px; border-radius: 10px 0px 0px 10px; margin-right: -1px;"
									id="selectValue">
								<option value="1">อาการ</option>
							</select> 
							
								<span class="input-group-btn"> <input type="text" class="form-control search-query" id="search">
									<button class="btn btn-info " type="button" onclick="search();search2()"
												id="btnSeach"
												style="border-radius: 0px 10px 10px 0px; padding: 5px 7px 5px 7px; margin-top: 0px;">
												<i class="fa fa-search fa-lg"></i> ค้นหา
										</button>
								</span>
						</div>
				</div>
			</div>		
			
				<center>
					<hr>
				</center>
				<br>
        
        
  				&nbsp;&nbsp;&nbsp;&nbsp; <a href="disease"><button type="button" class="btn btn-success">
  					<i class="fa fa-plus" aria-hidden="true"></i>
  					เพิ่มข้อมูลโรค</button></a>	
  					 
					<div class="panel-body">
						<table class="table table-striped table-hover  table-bordered"
							style="font-size: 16px;">
							<thead>
								<tr>
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 150px;">ชื่อโรค</th>
									<th>อาการของโรค</th>									
									<th  style="width: 190px;">ชนิดของโรค</th>
									<th >สาเหตุของโรค</th>

								</tr>
							</thead>
							
							<tbody style="text-align: center;" id="list">
								
							</tbody>
						</table>
						<div class="row form-group" id="page" align="center"></div>
					</div>
					
			
					<div class="panel-body">
						<table class="table table-striped table-hover  table-bordered"
							style="font-size: 16px;">
							<thead>
								<tr>
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 150px;">ชื่อทางการค้า</th>
									<th style="width: 150px;">ชื่อสามัญ</th>
									<th style="width: 190px;">กลุ่มยา</th>			
									<th style="width: 190px;">สรรพคุณ</th>									

								</tr>
							</thead>
							<tbody style="text-align: center;" id="listM">
								
							</tbody>
						</table>
						<div class="row form-group" id="p" align="center"></div>
					</div>
			
			
        <div class="modal-footer">
          <button type="button" class="btn btn-info" data-dismiss="modal">ปิด</button>
        </div>
      </div>
    </div>
    
    <script type="text/javascript">
    
 // DISEASE
  $("#list").load('search_t',{ id : 0 ,value : 0},function(){ //load list_view_medicine
	    	$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast  : $("#countPage").val()},function(m){
    		for(i=0 ;i<=10;i++){
    			if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
    				$("[id=pageNum]").eq(i).addClass("active");
    			}
  		}
    	});
    });
    function search(){ //click button search
    	$("#list").load('search_t',{ id : $("#selectValue").val(), value : $("#search").val()},function(){
    		$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast : $("#countPage").val()},function(m){
    			for(i=0 ;i<=10;i++){
    				if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
    					$("[id=pageNum]").eq(i).addClass("active");
    				}
    			}
    		});
    	});
    }


    $(document).on('click','#pageNum',function(e){ // page number
    	 var id =  $('[id=pageNum]').index(e.target);
    	 $("#list").load('search_t',{ id : $("#selectValue").val(), value : $("#search").val(),page:$("[id=pageNum]").eq(id).val()},function(){
    			$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast : $("#countPage").val()},function(m){
    				for(i=0 ;i<=10;i++){
    					if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
    						$("[id=pageNum]").eq(i).addClass("active");
    					}
    				}
    			});
    			
    		}); 
    });


    //MEDICINE
    $("#listM").load('search_t1',{ id : 0 ,value : null},function(){ 
    	$("#p").load('page1',{ pagePresent1 : $("#Page1").val(), pageLast1  : $("#countPage1").val() },function(m){
    		for(i=0 ;i<=10;i++){
    			if($("[id=pageNum1]").eq(i).val()==$("#Page1").val()){
    				$("[id=pageNum1]").eq(i).addClass("active");
   			}
    		}
   	});
    }); 

     function search2(){ //click button search
    	$("#listM").load('search_t1',{ id : $("#selectValue").val(), value : $("#search").val()},function(){
    		$("#p").load('page1',{ pagePresent1 : $("#Page1").val(), pageLast1 : $("#countPage1").val()},function(m){
    			for(i=0 ;i<=10;i++){
    				if($("[id=pageNum1]").eq(i).val()==$("#Page1").val()){
    					$("[id=pageNum1]").eq(i).addClass("active");
    				}
    			}
    		});
    	});
    }

    $(document).on('click','#pageNum1',function(e){ 
    	 var id =  $('[id=pageNum1]').index(e.target);
    	 $("#listM").load('search_t1',{ id : $("#selectValue").val(), value : $("#search").val(),page:$("[id=pageNum1]").eq(id).val()},function(){
    			$("#p").load('page1',{ pagePresent1 : $("#Page1").val(), pageLast1 : $("#countPage1").val()},function(m){
    				for(i=0 ;i<=10;i++){
    					if($("[id=pageNum1]").eq(i).val()==$("#Page1").val()){
    						$("[id=pageNum1]").eq(i).addClass("active");
    					}
    				}
    			});
    			
    		}); 
    });
    
    </script>
    
<!-- <script type="text/javascript">

	$(function() {		
		$("#search").autocomplete({
			source: function (request, response) {
	            $.getJSON("auto", {
	            	term: request.term
	            }, response);
	        }
		});
	});
	
</script> -->
    
  </div>
  
  
		
		
	</div>
	</div>
	

			
	<%@ include file="../footer.jsp"%>



<script>

function listcattle() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".cattle").val();  //หลังclass form control
	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "cowlist",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);
		
			$( "#num" ).val( json.num );
		  	/* $( "#weightWean" ).val(json.weightWean ); */
		  
		  	//alert(json.unitMedicine.value);
		});
	}else{
		$( "#num" ).val("" );
	/* 	$( "#weightWean" ).val( "" ); */
		}
}

function listDisease() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".disease").val();  //หลังclass form control
	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "diseaselist",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);
		
			$( "#symptomsOfDisease" ).val( json.symptomsOfDisease );
		  	/* $( "#weightWean" ).val(json.weightWean ); */
		  
		  	//alert(json.unitMedicine.value);
		});
	}else{
		$( "#symptomsOfDisease" ).val("" );
	/* 	$( "#weightWean" ).val( "" ); */
		}
}

function Listmed() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".medicine").val();  //หลังclass form control
	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "listmed",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);
		
			$( "#distanceDiscontinued" ).val( json.distanceDiscontinued );
		    $( "#commonName" ).val(json.commonName );
		  
		  	//alert(json.unitMedicine.value);
		});
	}else{
		$( "#distanceDiscontinued" ).val("" );
		$( "#commonName" ).val( "" );  
		}
}

function Listmed1() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".medicine1").val();  //หลังclass form control
	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "listmed",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);
		
			$( "#distanceDiscontinued1" ).val( json.distanceDiscontinued );
		    $( "#commonName1" ).val(json.commonName );
		  
		  	//alert(json.unitMedicine.value);
		});
	}else{
		$( "#distanceDiscontinued1" ).val("" );
		$( "#commonName1" ).val( "" );  
		}
}

function Listmed2() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".medicine2").val();  //หลังclass form control
	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "listmed",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);
		
			$( "#distanceDiscontinued2" ).val( json.distanceDiscontinued );
		    $( "#commonName2" ).val(json.commonName );
		  
		  	//alert(json.unitMedicine.value);
		});
	}else{
		$( "#distanceDiscontinued2" ).val("" );
		$( "#commonName2" ).val( "" );  
		}
}

function Listmed3() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".medicine3").val();  //หลังclass form control
	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "listmed",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);
		
			$( "#distanceDiscontinued3" ).val( json.distanceDiscontinued );
		    $( "#commonName3" ).val(json.commonName );
		  
		  	//alert(json.unitMedicine.value);
		});
	}else{
		$( "#distanceDiscontinued3" ).val("" );
		$( "#commonName3" ).val( "" );  
		}
}

function Listmed4() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".medicine4").val();  //หลังclass form control
	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "listmed",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);
		
			$( "#distanceDiscontinued4" ).val( json.distanceDiscontinued );
		    $( "#commonName4" ).val(json.commonName );
		  
		  	//alert(json.unitMedicine.value);
		});
	}else{
		$( "#distanceDiscontinued4" ).val("" );
		$( "#commonName4" ).val( "" );  
		}
}

function Listmed5() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".medicine5").val();  //หลังclass form control
	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "listmed",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);
		
			$( "#distanceDiscontinued5" ).val( json.distanceDiscontinued );
		    $( "#commonName5" ).val(json.commonName );
		  
		  	//alert(json.unitMedicine.value);
		});
	}else{
		$( "#distanceDiscontinued5" ).val("" );
		$( "#commonName5" ).val( "" );  
		}
}

function cancel() {
	location.reload();
} 

// ยืนยันบันทึก
$(document).on('click','#add',function(e){
$.ajax({
	url:"saveTreat",
	method:"POST",
	data:$("#treat").serialize()
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