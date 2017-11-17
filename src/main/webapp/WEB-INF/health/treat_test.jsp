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
</head>
<body>


<%@ include file="../menu.jsp"%>
<br><br>
	<div id="content">
	<div class="container">
		<div class="col-md-3">
			<div class="jumbotron" style="background-color: rgb(218, 68, 83)" align="center">
				<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลโรค</p>						
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
				<form action="TreatmentHistory" method="POST" id="TreatmentHistory">
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
									
					<%-- 				<div class="col-md-6">
										<input name="cattle" id="cattle" type="hidden" class="form-control "/>
										<form:input path="" id=id type="hidden" class="form-control"/>
									</div> --%>
								</div>
								
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> หมายเลขโค</label>
									<div class="col-md-6"> 
										<input name="num" id="num" type="text" class="form-control" disabled="disabled"/>
									</div>
								</div>							
								
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> สาเหตุการป่วย</label>
									<div class="col-md-6">
										<textarea rows="3" cols="45" name="causeOfIllness" id="causeOfIllness" type="text" class="form-control "></textarea>
									</div>
								</div>

								<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เลือกยาที่ใช้</label>
									<div class="col-md-6">
			
									<select class="form-control medicine" id="medicine" name="medicine" onchange="Listmed();">
												<option value="">เลือกยาที่ใช้</option>
												<c:forEach items="${medicine }" var="medicine">
													<option value="${medicine.id }">&nbsp;${medicine.tradeName }
												</c:forEach>
										</select>						
									

									</div>
								</div>
								
	<!-- 							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> เลือกกลุ่มยาที่ใช้</label>
									<div class="col-md-6">
										<input id="groupMedicine.value" name="groupMedicine.value" type="text" class="form-control "/>						
									</div>
								</div> -->
	
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> ชื่อสามัญ</label>
									<div class="col-md-6"> 
										<input name="commonName" id="commonName" type="text" class="form-control" disabled="disabled"/>
									</div>
								</div>
								
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> วันเดือนปีที่เริ่มรักษา</label>
									<div class="col-md-6">
										<input name="dateTreat" id="dateTreat"  type="date" class="form-control"/>
									</div>
								</div>
								
	<!-- 					<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">* </font> วันเดือนปีที่ให้ยา</label>
									<div class="col-md-6">
										<input path="dateTreat" id="dateTreat"  type="date" class="form-control"/>
									</div>
								</div>    -->		
	
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
										<%-- <form:option value="0">ผู้บันทึก</form:option> --%>
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
								

								
							</fieldset>
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
		
			/* $( "#groupMedicine.value" ).val( json.groupMedicine.value ); */
		    $( "#commonName" ).val(json.commonName );
		  
		  	//alert(json.unitMedicine.value);
		});
	}else{
		/* $( "#groupMedicine.value" ).val("" ); */
		$( "#commonName" ).val( "" ); 
		}
}


/*function Listmed() {
	var selectedValue = $(".groupMedi").val();  
	alert(selectedValue); 
	if(selectedValue != 0){
	$.ajax({
		  url: "listmed",
		  data : {id:selectedValue}
		})
	}
}


function Listmed() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".medicineid").val();

	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "listmed",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);

			$( "#groupmed" ).val( json.groupMedicine.value );
		 // $( "#unittool" ).val(json.unitTool.value );
		 // alert(json.unitTool.value);
		});
	}else{
		//$( "#oquantity" ).val("" );
		//$( "#unittool" ).val( "" );
		}
}


var options1 = {

		  url: function(phrase) {
		    return "diseaselist";
		  },

		  getValue: function(element) {
		    return  element.nameDisease;
		  },

		  ajaxSettings: {
		    dataType: "json",
		    method: "GET",
		    data: {
		      dataType: "json"
		    }
		  },

		  preparePostData: function(data) {
		    data.term1 = $("#nameDisease").val();
		    return data;
		  },
		  
		  list: {
			  
			   onSelectItemEvent: function() {
					var sysptom = $("#nameDisease").getSelectedItemData().symptomsOfDisease;

					$("#symptomsOfDisease").val(sysptom);
				}, 

				/*onClickEvent: function() {
					  data.term1 = $("#symptomsOfDisease").val();
					    return data; 
					    alert(data);
					//$('#symptomsOfDisease').val(data.symptomsOfDisease);
				 	var json = JSON.parse(data);
					$('#symptomsOfDisease').val(json.symptomsOfDisease); 
				}	
			},
		  
		  theme: "plate-dark",

		  requestDelay: 400
		};

var options = {

		  url: function(phrase) {
		    return "cowlist";
		  },

		  getValue: function(element) {
		    return  element.num;
		  },

		  ajaxSettings: {
		    dataType: "json",
		    method: "GET",
		    data: {
		      dataType: "json"
		    }
		  },

		  preparePostData: function(data) {
		    data.term = $("#cowid").val();
		    return data;
		  },
		  
		  list: {
				onClickEvent: function() {
					$('#causeFlu').val($("#cowid").val());
				}	
			},
		  
		  theme: "plate-dark",

		  requestDelay: 400
		};

	$("#cowid").easyAutocomplete(options);
	$("#nameDisease").easyAutocomplete(options1);

  
	*/	
	
	
	
  
/*  function addrow(tableID){
	 if($("#cattleW").val() != ""){
	 var table = document.getElementById(tableID);
	 var rowCount = table.rows.length-1;
	$("#dataTable").append('<tr>'+
	'<td><input type="text" class="form-control input-sm " disabled="disabled"  size="2" style="text-align: center;"  value='+(rowCount+1)+'></td>'+
	'<td><select class="form-control  input-sm" id="group'+rowCount+'"  onchange="groups('+rowCount+',this);"  style="width: 170px;" ></select></td>'+
	'<td><select class="form-control  input-sm" id="medicine'+rowCount+'" name="selectMedicines['+rowCount+'].MedicineId.id"  onchange="medicines('+rowCount+',this);"  style="width: 170px;" ></select></td>'+
	'<td  style="text-align: center;"><input type="text" class="form-control input-sm " size="15" style="text-align: left;" disabled="disabled" id="commonName'+rowCount+'" name="commonName['+rowCount+'].road" /></td>'+
	'<td><div class="form-inline"><input type="text" class="form-control input-sm" size="3" style="text-align: center;"  id="Amount" name="selectMedicines['+rowCount+'].amount" /><input type="text" class="form-control input-sm " size="5" style="text-align: center;" disabled="disabled" id="unit'+rowCount+'" name="unit['+rowCount+'].road" /></div></td>'+
	'<td><input type="date" class="form-control input-sm " size="12"  id="date" name="selectMedicines['+rowCount+'].dateStartMedi" /></td>'+
	'<td><input type="text" class="form-control input-sm " size="10" style="text-align: center;" disabled="disabled" id="longMedi'+rowCount+'" name="longMedi['+rowCount+'].road" /></td>'+
	'<td><a href="javascript:void(0);" id="remCF"><button  class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></button></a></td>'+
	'</tr>');
	 $("#dataTable").on('click', '#remCF', function(){
	        $(this).parent().parent().remove();
	    });
	 $("#group"+rowCount).load('../group');
	 $("#medicine"+rowCount).load('../medicine', {id : 0});
	 }
}  */

function cancel() {
	location.reload();
} 

// ยืนยันบันทึก
$(document).on('click','#add',function(e){
$.ajax({
	url:"saveTreat",
	method:"POST",
	data:$("#TreatmentHistory").serialize()
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