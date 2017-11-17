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
<%	
int i= 1;
%>
<%@ include file="../menu.jsp"%>
	<div id="content">
<div class="container">
				<div class="row">
					<hr>
				</div><br><br>
<div class="panel panel-primary">
					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> ตั้งค่ารายการ</a>
						</h4>
					</div>
		<div class="panel-body">
		  	<table class="table table-striped table-hover  table-bordered" style="font-size: 15px">
				<thead>
					<tr>
							<th class="text-center">ลำดับ</th>
							<th class="text-center">ทำรายการ</th>
							<th class="text-center">วัน</th>
							<th class="text-center">เวลา</th>
							<th class="text-center">แก้ไข</th>
							<th class="text-center">ลบ</th>
							
						</tr>
					</thead>
					<tbody>
			<c:forEach items="${syncL }" var="sync">
					<tr>
							<td class="text-center"><%=i++%></td>
							<td class="text-center">${sync.namesync }</td>
		
							<td class="text-center">${sync.dayalert }</td>
							<td class="text-center">${sync.timealert }</td>
							
							<td class="text-center">
							<button type="button" class="btn btn-primary glyphicon glyphicon-edit" 
							data-toggle="modal" data-target="#edit" data-id1="${sync.id }" data-name1="${sync.namesync }"
							data-time1="${sync.timealert }"  data-dayalert1="${sync.dayalert }"></button>

							</td>
						<td class="text-center">
							<button class="btn btn-danger fui-cross" value="${sync.id}" onclick="chkdel(this.value)"><i class="glyphicon glyphicon glyphicon-remove"></i></button>
						</td>
					</tr>
			</c:forEach>
	       			<tr>
	       			<td><br></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
	       			</tr>
					</tbody>
					</table>
			</div>
								

			</div>
			
			
			
<div class="form-inline">
					<div class="col-md-3">
						<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
							align="center">
							<p style="font-size: 28px; font-weight: 700; color: white;">เพิ่มรายการ</p>
						</div>
					</div>	
				</div>
					<div class="panel-body">
					<form:form method="POST" action="" commandName="sync" id="sync">
				<table class="table table-striped table-hover  table-bordered" style="font-size: 15px">
				<thead>
				<tr>
					<th class="text-center">รายการ</th>
					<th class="text-center">วัน</th>
					<th class="text-center">เวลา</th>
					<th class="text-center">เพิ่ม</th>
					</tr>
					</thead>
					<tbody>
					<tr>
					<td class="text-center">
					<form:input id="namesync" path="namesync" class="form-control"/>
					</td>
					<td class="text-center">
					<form:input type="number" id="dayalert" path="dayalert" class="form-control"/>
					</td>
					<td class="text-center">
					<form:input type="time" id="timealert" path="timealert" class="form-control"/>
					</td>
					<td class="text-center">
					<form:hidden id="typeSync" path="typeSync.id" value="${typeId}"/>
						<button class="btn btn-success glyphicon glyphicon-floppy-save" type="submit" id="addSync"></button>
					</td>
				</tr>
				</tbody>			
				</table>
						</form:form>
					</div>
		
			
			
			
			
			<div class="text-center"><a href="set_sync">
			<button class="btn btn-embossed btn-primary">ย้อนกลับ</button></a></div><br>
			</div><!-- container -->
	</div>
	
			<div id="edit" class="modal fade">
			<div class="modal-dialog" style="width:70%">
				<div class="modal-content">
			
			<div class="modal-body">
                 <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
			<div class="panel-primary">
			<div class="panel-body">

		  	<table class="table table-striped table-hover  table-bordered">
				<thead>
					<tr>
							<th class="text-center">ทำรายการ</th>
							<th class="text-center">วัน</th>
							<th class="text-center">เวลา</th>
							<th class="text-center">แก้ไข</th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<form:form commandName="sync" id="editsync" method="POST">
							<td class="text-center">
							<form:hidden path="id" id="Eid" class="form-control"/>
							<form:hidden id="typeSync" path="typeSync.id" value="${typeId}"/>
							<form:input path="namesync" id="Editname" class="form-control text-center"/>
							</td>
							<td class="text-center">
							<form:input path="dayalert" id="EditdayAlert" class="form-control text-center"/>
							</td>
							<td class="text-center">
							<form:input type="time" path="timealert" id="Edittime" class="form-control text-center"/>
							</td>
							</form:form>
							<td class="text-center">
							<button type="submit" class="btn btn-success" id="saveEdit">บันทึก</button>						
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
	
<%@ include file="../footer.jsp"%>
</body>
<script type="text/javascript">
$(document).on('click','#addSync',function(e2){
	var namesync = $("#namesync").val();
	var dayslert = $("#dayalert").val();

	var MsgError="";
	if(namesync==""){
		MsgError+="ใส่ชื่อการบำรุงให้ถูกต้อง\n";
	}
	if(dayalert==""){
		MsgError+="ใส่วันให้ถูกต้อง\n";
	}
	if(MsgError!=""){
		swal("ผิดพลาด",MsgError, "error");
	}
	
	 else{
		/* $.post('checkSync',{name:$("#nameSync").val()},function(msg){
				
				if(msg=="yes"){*/
					$.ajax({
						url:"AddSync",
						method:"POST",
						data:$("#sync").serialize()
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
				/*}else{
					alert("ข้อมูลซ้ำ");
				}
				
			});*/
	 }
	e2.preventDefault();
}); 

$(document).on('click','#saveEdit',function(e2){
	var Editname = $("#Editname").val();
	var EditdayAlert = $("#EditdayAlert").val();

	var MsgError="";
	if(Editname==""){
		MsgError+="ใส่ชื่อการบำรุงให้ถูกต้อง\n";
	}
	if(EditdayAlert==""){
		MsgError+="ใส่วันให้ถูกต้อง\n";
	}
	if(MsgError!=""){
		swal("ผิดพลาด",MsgError, "error");
	}
	
	 else{
		/* $.post('checkSync',{name:$("#nameSync").val()},function(msg){
				
				if(msg=="yes"){*/
					$.ajax({
						url:"saveEditSync",
						method:"POST",
						data:$("#editsync").serialize()
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
				/*}else{
					alert("ข้อมูลซ้ำ");
				}
				
			});*/
	 }
	e2.preventDefault();
});


		
		
		function chkdel(str){
			var TypeId = ${typeId};
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
								url:'DelSync',
								type:'POST',
								data:{
									idSync:str,
									TypeId:TypeId,
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
var g_id2 = $(e.relatedTarget).data('gid2');
$(e.currentTarget).find('input[id="idSync"]').val(g_id);
$(e.currentTarget).find('input[id="TypeId"]').val(g_id2);
});

$('#del').on('hide.bs.modal', function(e) {
location.reload();
});

$('#edit').on('show.bs.modal', function(e) {
    var id1 = $(e.relatedTarget).data('id1');
    var name1 = $(e.relatedTarget).data('name1');
    var time1 = $(e.relatedTarget).data('time1');
    var dayAlert1 = $(e.relatedTarget).data('dayalert1');
    $(e.currentTarget).find('input[id="Eid"]').val(id1);
    $(e.currentTarget).find('input[id="Editname"]').val(name1);
    $(e.currentTarget).find('input[id="Edittime"]').val(time1);
    $(e.currentTarget).find('input[id="EditdayAlert"]').val(dayAlert1);
});


		$('#edit').on('hide.bs.modal', function(e) {
		    location.reload();
		});

</script>


</html>