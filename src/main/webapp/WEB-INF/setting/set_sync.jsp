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
			<div class=" row form-group">
				<div class="form-inline">
					<div class="col-md-3">
						<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
							align="center">
							<p style="font-size: 28px; font-weight: 700; color: white;">ตั้งค่าการเหนี่ยวนำ</p>
						</div>
					</div>	
				</div>
				<br><br><br>
				<br>
				<div class="row form-group">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> ตั้งค่าการเหนี่ยวนำ</a>
						</h4>
					</div>	
					<div class="panel-body">
						<table class="table table-striped table-hover  table-bordered"
							style="font-size: 16px;">
							<thead>
								<tr>
									<th class="text-center" style="width: 550px">ชื่อโปรแกรม</th>
									<th class="text-center" style="width: 250px">ตั้งค่า</th>
									<th class="text-center" style="width: 250px">ลบ</th>
								</tr>
							</thead>
							<tbody style="text-align: center;" id="listM">
								<c:forEach items="${type }" var="type">
									<tr>
										<td class="text-center">${type.value }</td>
										<td class="text-center">
											<a href="EditSyncSetting?TypeId=${type.id}" class="btn btn-primary glyphicon glyphicon-wrench">
											</a>
										</td>
										<td class="text-center">
											<button class="btn btn-danger fui-cross" value="${type.id}" onclick="chkdel(this.value)"><i class="glyphicon glyphicon glyphicon-remove"></i></button>
										</td>										
									</tr>
								</c:forEach>
								
								
								
							</tbody>
						</table>
					</div>
					
					<div class="panel-heading">
	    		    <h4 class="panel-title">เพิ่มโปรแกรมเหนี่ยวนำ</h4>
	   				</div>
					<div class="panel-body">
					
					<table class="table table-striped table-hover  table-bordered" style="font-size: 15px">
					<thead>
					<tr>
					<th class="text-center">
					ชื่อโปรแกรม
					</th>
					<th class="text-center">
					บันทึก
					</th>
					</tr>
					</thead>
					<tbody>
					<tr>
					<td class="text-center">
					<form:form method="POST" action="" commandName="typesync" id="typesync">
					<form:input id="value" path="value" class="form-control" />
						</form:form>	
					</td>
					<td class="text-center">
					<button type="submit" class="btn btn-success glyphicon glyphicon-floppy-save" id="add"></button>
					</td>
					</tr>
					</tbody>
					</table>
					</div>
					
					</div>	
				</div>
				

	</div>
</div>
</div>		

	<div class="container">
		<!-- modal -->
		<div id="del" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
				<form action="DelTypeSync" method="get">
				<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h3 class="modal-title">ลบข้อมูล</h3>						
					</div>
					<div class="modal-body">
						<h4 class="control">คุณต้องการที่จะลบข้อมูลนี้ใช่หรือไม่</h4>						
						<input type="hidden" name="id" id="id" />
					</div>
					<div class="modal-footer">						
						<button type="button" class="btn btn-default"  data-dismiss="modal">ปิด</button>	
						<button type="submit" class="btn btn-danger" id="btn_delete">ลบ</button>					
					</div>
				</form>
					</div>
			</div>
		</div>
		<!-- modal -->
	</div>

<%@ include file="../footer.jsp"%>
</body>

<script type="text/javascript">

function chkdel(str){
	swal({  title: "แจ้งเตือน!",   
			text: "หากคุณลบ ยาบำรุงที่อยู่ในโปรแกรมนี้จะถูกลบทั้งหมด \nคุณต้องการลบใช่หรือไม่?",   
			type: "warning",   
			showCancelButton: true,   
			confirmButtonColor: "#DD6B55",   
			confirmButtonText: "ใช่, ต้องการลบ!",   
			cancelButtonText: "ไม่, ยกเลิกการลบ!",   
			closeOnConfirm: false,   closeOnCancel: false 
			}, function(isConfirm){   
				if (isConfirm) {     
					$.ajax({
						url:'DelTypeSync',
						type:'POST',
						data:{
							id:str,
						},success : function (result){
					swal({title:"สำเร็จ", 
							text:"ลบเรียบร้อยแล้ว!", 
							type:"success",
							timer: 1500,   
							showConfirmButton: false
						},function(isClose){ 
							window.location.reload();
						}
						);   
						}
					,error: function(result){
						swal("ผิดพลาด", "ไม่สามารถลบได้!", "error");
					}
					
				});
					} 
				else {     swal({
						title:"ยกเลิก", 
						text:"ยกเลิกการลบเรียบร้อยแล้ว!", 
						type:"error",
						timer: 1500,   
						showConfirmButton: false
				});} 
			});

	}


$('#del').on('show.bs.modal', function(e) {
	 var g_id = $(e.relatedTarget).data('gid');
	  $(e.currentTarget).find('input[id="id"]').val(g_id);
});

$('#del').on('hide.bs.modal', function(e) {
	location.reload();
});

$(document).on('click', '#add', function(e){
	var value = $('#value').val();
	if(value==""){
		swal("ผิดพลาด", "กรอกชื่อโปรแกรมให้ถูกต้อง!", "error");
	}
	else{
		$.post('checkTypeSync',{value:$("#value").val()},function(msg){
			
			if(msg=="yes"){
				$.ajax({
					url:"AddTypeSync",
					method:"POST",
					data:$("#typesync").serialize()
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
				});
			}else{
				swal("ผิดพลาด", "มีโปรแกรมนี้อยู่ในระบบแล้ว!", "error");
			}
			
		});
	}	
	e.preventDefault();
});

</script>


</html>