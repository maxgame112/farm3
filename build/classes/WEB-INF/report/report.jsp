<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
<title>ออกรายงาน</title>
</head>
<body>
<%@ include file="../menu.jsp"%>
<%int i=1,n=1,m=1; %>
		<hr> 
       		<div class="container">
        		<div class="col-md-3">
					<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
						<p style="font-size: 28px; font-weight: 700; color: white;">ออกรายงาน</p>
					</div>
				</div>
			 </div>
<div class="container">
			<br>
	<div class="panel-body" style="font-size: 18px;">
				<div class="row form-group">
					<div class="col-md-offset-3  col-md-3">
						<div class="col-md-5">
							<p style="font-size: 20px; font-weight: bold;">เลือกการออกรายงาน :</p>
						</div>
						<div class="col-md-4">
							<select class="form-control" style="font-size: 18px;" id="selectValue">
								<option value="">กรุณาเลือกประเภทการออกรายงาน</option>
								<option value = "1">การรักษา</option>
								<option value = "2">ผสมพันธุ์</option>
								<option value = "3">ตรวจท้อง</option>
								<option value = "4">การคลอด</option>
								<option value = "5">เหนี่ยวนำการกลับสัด</option>
								<option value = "6">สูญเขา</option>
								<option value = "7">หย่านม</option>
								<option value = "8">ตีเบอร์</option>
								<option value = "9">น้ำหนัก 1 ปี</option>
								<option value = "10">โคแท้ง</option>
							</select>
						</div>
					</div>
				</div>
<%-- 				<div class="row form-group">
					<div class="col-md-offset-3  col-md-3">
						<div class="col-md-5">
							<p style="font-size: 20px; font-weight: bold;">ชื่อผู้เบิก :</p>
						</div>
						<div class="col-md-4">
							<select class="form-control" style="font-size: 18px;" id="memberid" onchange="selectsR(this);">
								<option value="0">ทั้งหมด</option>
								<c:forEach items="${members }" var="member">
									<option value="${member.id }" >${member.first } ${member.last }</option>
								</c:forEach>
											
							</select>
						</div>
					</div>
						<br><br>
				</div> --%>
					
				<div class="row" id="DS">
						<div class="col-md-offset-1 col-md-9" id="date">
							<p class="col-md-offset-1 col-md-1 control-label"
								style="font-size: 20px; font-weight: bold;">ตั้งแต่วันที่:</p>
							<div class='col-md-4'>
								<div class="form-group">
								
									<div class="input-group">
										<input id ="dateStart" value="${day1 }" type="date" class="form-control"
											style="font-size: 18px;" /> <span class="input-group-addon"
											style="border-radius: 0px 10px 10px 0px; padding: 5px 7px 5px 7px; margin-top: 0px;"><span
											class="fa fa-calendar"></span></span>
									</div>
								</div>
							</div>
							<p class="col-md-offset-1 col-md-1 control-label"
								style="font-size: 20px; font-weight: bold;"> ถึงวันที่:</p>
							<div class='col-md-4'>
								<div class="form-group">
									<div class="input-group">
									
										<input id="dateEnd" value="${day1 }" type="date" class="form-control"
											style="font-size: 18px;" /> <span class="input-group-addon"
											style="border-radius: 0px 10px 10px 0px; padding: 5px 7px 5px 7px; margin-top: 0px;"><span
											class="fa fa-calendar"></span></span>
									</div>
								</div>
							</div>
						</div>
					</div> 
			
			<div class="col-md-offset-6">
				<span><button type="button" class="btn btn-info btn-lg" id="btnSeach">
						<i class="fa fa-search"></i> ค้นหา
				</button></span>
			</div>
<br>
	<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<i class="fa fa-list-alt fa-lg"></i> ข้อมูลที่ต้องการ
						</h4>
					</div>
					<div class="panel-body" style="font-size: 18px;">
						<table class="table table-striped table-hover table-bordered" id="dataBody" >
							
						</table>
						<center>
							<h4 style="font-size: 38px; color: gray;" id="not_found">ไม่พบข้อมูล!!</h4>
						</center>
				
						<div class="row form-group" align="right" id="btnReport">
							<button type="button" class="btn btn-success btn-lg" id="btnreport">
								<i class="fa fa-print fa-lg"></i> พิมพ์รายงาน
							</button>
						</div> 
					</div>
	</div>
    </div>
</div>	
<jsp:include page="../footer.jsp"/>
	

</body>

<script type="text/javascript">
$("#not_found").addClass("hide");

$(document).on('click','#btnSeach',function(e){
	var idReport = $("#selectValue").val();
	var dateStart = $("#dateStart").val();
	var dateEnd = $("#dateEnd").val();
	
	if(idReport ==0){
		swal("ผิดพลาด!", "กรุณาเลือกประเภทรายงาน", "error");
	}else if(dateStart==""){
		swal("ผิดพลาด!", "กรุณาเลือกวันที่ให้ถูกต้อง", "error");
	}else if(dateEnd==""){
		swal("ผิดพลาด!", "กรุณาเลือกวันที่ให้ถูกต้อง", "error");
	}else{
		$("#dataBody").load('search_report_pdf',{
			idReport : idReport,
			dateStart :dateStart,
			dateEnd : dateEnd
			}
		,function(e){
			if($("#count").val()!=0){
				$("#not_found").addClass("hide");
				$("#btnReport").removeClass("hide");
				$("#dataBody").removeClass("hide");
			}else{
				$("#not_found").removeClass("hide");
				$("#dataBody").addClass("hide");
				$("#btnReport").addClass("hide");
			} 
		});
		
	}// end else
});



$(document).on('click','#btnReport',function(e){
	var idReport = $("#selectValue").val();
	var dateStart = $("#dateStart").val();
	var dateEnd = $("#dateEnd").val();
	
	if(idReport ==0){
		swal("ผิดพลาด!", "กรุณาเลือกประเภทรายงาน", "error");
	}else if(dateStart==""){
		swal("ผิดพลาด!", "กรุณาเลือกวันที่ให้ถูกต้อง", "error");
	}else if(dateEnd==""){
		swal("ผิดพลาด!", "กรุณาเลือกวันที่ให้ถูกต้อง", "error");
	}else{
		
	window.open("ReportImport?idReport="+idReport+"&dateStart="+dateStart+"&dateEnd="+dateEnd);
	
	}
});

</script>

</html>