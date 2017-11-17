<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/WEB-INF/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/fileinput.css" />" media="all"
	rel='stylesheet' type='text/css' />
<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
<script src="<c:url value="/resources/js/clicktable.js" />"></script>
<script src="<c:url value="/resources/js/fileinput.js" />"></script>
<title>แบ่งฝูงโค</title>
</head>
<body>
<%@ include file="../menu.jsp"%><br><br>
<div id="content">
<div class="container">
				<div class="col-md-3">
					<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
						<p style="font-size: 28px; font-weight: 700; color: white;">บันทึกข้อมูลโค</p>
					</div>
				</div>
				<div class="row">
					<hr>
				</div><br><br>
				<div class="row form-group">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลโค</a>
							</h4>
						</div>
						<div class="panel-body">
							<form:form action="edited_cattle" modelAttribute="cattle" method="POST" id="cattle" commandName="shc">
								<div class="row form-group">
									<div class="col-md-6">
									
<%-- 										<div class="row form-group">
											<label class="col-md-offset-s col-md-3 control-lable"><font color="red">* </font> หมายเลขแม่พันธุ์</label>
												<div class="col-md-6">
							 						<div>
							 						
														<select class="form-control" id="catl" name="catl">
																	<option value="0">เลือกแม่โค</option>
															<c:forEach items="${gcattle }" var="mom">
													
																<option value="${mom.id }" >&nbsp;${mom.num }</option>
															</c:forEach>
														</select>
							 						</div>																				
													<input name="id" id="id" type="hidden" class="form-control"/>
						
												</div>
										</div> --%>
									
								<div class="row form-group">
									<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> ฝูงโค</label>
								<div class="col-md-6">
										 <div>
											<form:select class="form-control" id="groupCattle.id" path="groupCattle.id">
												<form:option value="0">ฝูงโค</form:option>
														<c:forEach items="${groupcattle}" var="groupcattle">
															<c:if test="${groupCattle.id == groupcattle.id }">
																<form:option value="${groupcattle.id}" selected="selected">${groupcattle.groupNameCattle}</form:option></c:if>
																		
															<c:if test="${groupCattle.id != groupcattle.id }">
															<form:option value="${groupcattle.id }">${groupcattle.groupNameCattle}</form:option>
															</c:if>
																		
													</c:forEach>
											</form:select>
										 </div>											
								</div>
							</div>	
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
<%@ include file="../footer.jsp"%>

<script type="text/javascript">

	function cancel() {
		location.reload();
	} 
	
	// ยืนยันบันทึก
	$(document).on('click','#add',function(e){
	$.ajax({
		url:"editgroup",
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