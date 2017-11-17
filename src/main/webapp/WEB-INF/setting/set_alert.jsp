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
<title>ตั้งค่า</title>
</head>
<body>
<%@ include file="../menu.jsp"%>
<div id="content">
	<div class="container">
			<div class="row">
				<hr>
			</div><br><br>
		<div class="row form-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> ตั้งค่าการแจ้งเตือน</a>
						</h4>
					</div>
					<%
						int i = 0;
					%>
					<div class="panel-body">
						<table class="table table-striped table-hover  table-bordered"
							style="font-size: 16px;">
							<thead>
								<tr>
									<th>ลำดับที่</th>
									<th>รายการแจ้งเตือน</th>
									<th>จำนวนวันแจ้งเตือน</th>
									<th>หมายเหตุ</th>
									<th>แก้ไข</th>

								</tr>
							</thead>
							<tbody style="text-align: center;" id="listM">
								<c:forEach items="${tyalert }" var="typeal">
									<tr>
										<td><%= ++i %></td>
										<td>${typeal.name }</td>
										<td>${typeal.value }</td>
										<td>${typeal.note }</td>
										<td>
											   <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal"
											   data-name="${typeal.name }" data-value="${typeal.value }" data-note="${typeal.note }" data-id="${typeal.id }">
											  	<i class="glyphicon glyphicon-pencil"></i>
											  </button>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					</div>	
				</div>
		</div>
	</div>

  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title">ตั้งค่ารายการแจ้งเตือน</h3>
        </div>
        <div class="modal-body" align="center">
        	<form id="typealert" >
          				<div class="row form-group">
							<label class="col-md-offset-s col-md-3 control-label"><font color="red"></font> รายการแจ้งเตือน</label>
							<div class="col-md-6">
							 	<div>
							 	<input name="name" id="name" type="text" class="form-control"/>
							 	<input name="id" id="id" type="hidden" class="form-control"/>
								 </div>											
							</div>
						</div>
						
          				<div class="row form-group">
							<label class="col-md-offset-s col-md-3 control-label"><font color="red"></font> จำนวนวันแจ้งเตือน</label>
							<div class="col-md-6">
							 	<div>
							 	<input name="value"  id="value" type="text" class="form-control" />
								 </div>											
							</div>
						</div>	
						
          				<div class="row form-group">
							<label class="col-md-offset-s col-md-3 control-label"><font color="red"></font> หมายเหตุ</label>
							<div class="col-md-6">
							 	<div>
							 	<input name="note" id="note" type="text" class="form-control"/>
								 </div>											
							</div>
						</div>
				</form>												
     		   </div>
				        <div class="modal-footer">
				      	<button name="action" value="Add" id="add"
							class="btn btn-success btn-lg">
							<i class="fa fa-save fa-lg"></i>&nbsp; บันทึกข้อมูล
						</button>
				          <button type="button" class="btn btn-danger" data-dismiss="modal">
				          <i class="fa fa-times fa-lg"></i>&nbsp; ยกเลิก</button>
				        </div>
      </div>
      
    </div>
  </div>


<%-- 		<c:forEach items="${tyalert }" var="type">
			${type.name }
		</c:forEach> --%>
<%@ include file="../footer.jsp"%>
</body>

<script type="text/javascript">
$('#myModal').on('show.bs.modal', function(e) {
	var id = $(e.relatedTarget).data('id');
    var name = $(e.relatedTarget).data('name');
    var value = $(e.relatedTarget).data('value');
    var note = $(e.relatedTarget).data('note');
    
    $(e.currentTarget).find('input[id="id"]').val(id);
    $(e.currentTarget).find('input[id="name"]').val(name);
    $(e.currentTarget).find('input[id="value"]').val(value);
    $(e.currentTarget).find('input[id="note"]').val(note);
    
});

 $(document).on('click','#add',function(e){

	$.ajax({
		url:"edit_alert",
		method:"POST",
		data:$("#typealert").serialize()
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