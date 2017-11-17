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
<title>แก้ไขข้อมูลโรค</title>
</head>
<body>
<%@ include file="../menu.jsp"%>
<br><br>
	<div id="wrapper">
		<div id="content">
			<div class="container">
				<div class="col-md-3">
					<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
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
						<span class="fa fa-list-alt fa-lg"></span> บันทึกข้อมูลโรค</a>
						</h4>
				</div>
							
				<div class="panel-body">
						<div class="row form-group ">
						<div class="col-md-6 ">
						<fieldset><br>
						
							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> ชื่อโรค</label>
								<div class="col-md-6">
									<input  id="nameDisease" type="text" class="form-control" value="${dis.nameDisease }" disabled="disabled" />
									<input value="dis.id" type="hidden" class="form-control" />
								</div>
							</div>
				
							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> อาการของโรค</label>
								<div class="col-md-6">
									<textarea rows="3	" cols="45"  type="text" class="form-control" id="symptomsOfDisease" disabled="disabled">${dis.symptomsOfDisease}</textarea>
								</div>
							</div>
							
							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> สาเหตุการเกิดโรค</label>
								<div class="col-md-6">
									<textarea rows="3	" cols="45"  type="text" class="form-control" id="causeOfTheDisease" disabled="disabled">${dis.causeOfTheDisease }</textarea>
								</div>
							</div>							

						<div class="row form-group">
							<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> ประเภทของโรค</label>
						<div class="col-md-6">
							 <div>
							 	<input  id="calbledis" type="text" class="form-control" value="${dis.cableDisease.value }" disabled="disabled" />
							 </div>											
						</div>
						</div>
					
						</fieldset>
						</div>
						<div class="col-md-4 ">
						<fieldset><br>
							<div class="row form-group">
								<label class="col-md-offset-s col-md-5 control-label"><font color="red"></font> อาการแทรกซ้อน</label>
								<div class="col-md-6">
									<textarea rows="3	" cols="45" type="text" class="form-control" id="complications" disabled="disabled">${dis.complications }</textarea>
								</div>
							</div>	
						
							<div class="row form-group">
							<label class="col-md-offset-s col-md-5 control-label"><font color="red">*</font> ผู้บันทึก</label>
						<div class="col-md-6">
							 	<div>
							 	<input  id="member" type="text" class="form-control" value="${dis.member.first }&nbsp;${dis.member.last }" disabled="disabled" />
							 	</div>											
						</div>
						</div>
						
							<div class="row form-group">
								<label class="col-md-offset-s col-md-5 control-label"><font color="red"></font> หมายเหตุ</label>
								<div class="col-md-6">
									<textarea rows="3	" cols="45"  type="text" class="form-control" id="note" disabled="disabled">${dis.note }</textarea>
								</div>
							</div>	
						
						</fieldset>
						</div> 
						</div>
						
					<div class="col-md-offset-8 col-md-6">
						<a href=diseasesh><button type="button" class="btn btn-embossed btn-primary">
						<i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp; ย้อนกลับ</button></a>
						
<!-- 						<a href=EditDisease><button type="button" class="btn btn-embossed btn-warning">
						<i class="fa fa-pencil fa-lg"></i></i>&nbsp; แก้ไขข้อมูล</button></a> -->
					</div>
				</div>				
							

					</div>
					</div>
					<div>
				</div>

			</div>

			</div>

		</div>


<%@ include file="../footer.jsp"%>
</body>
</html>