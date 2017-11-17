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
<title>Member</title>
</head>
<body>
<%@ include file="../menu.jsp"%><br><br>
<br><br>
<div id="content">
<div class="container">
	<div class="row form-group">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">
					<span class="fa fa-list-alt fa-lg"></span> ข้อมูลสมาชิก</a>
				</h4>				
			</div>
			
			<div class="panel-body">
				<div class="row form-group">
					<div class="col-md-6">
						<%-- <fieldset>
							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> ชื่อ-นามสกุล</label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm"
									disabled="disabled" value="${uuser.first }  ${uuser.last }" style="text-align: center;">

								</div>
							</div>	
							
							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> เพศ</label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm"
									disabled="disabled" value="${uuser.sex }" style="text-align: center;">

								</div>
							</div>							
							
						</fieldset>
					</div>
					
					<div class="col-md-6">
						<fieldset>
							<div class="row form-group">
								<label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font>รหัสเข้าใช้งาน</label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm"
									disabled="disabled" value="${uuser.username }" style="text-align: center;">

								</div>
							</div>								
						</fieldset> --%>
					</div>					
					
				</div>
			</div>
		</div>
	</div>
</div>  
</div>
<%@ include file="../footer.jsp"%>
</body>
</html>