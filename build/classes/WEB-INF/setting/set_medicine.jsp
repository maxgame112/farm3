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
<%@ include file="../menu.jsp"%><br><br>
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
											<p style="font-size: 28px; font-weight: 700; color: white;">การตั้งค่ากลุ่มยา</p>
										</div>
									</div>	
								</div>
						</div>



						<div class="row ">
        					<div class="col-md-6">
        						<div class="panel panel-primary">
        							<div class="panel-heading">
        								<h3 class="panel-title">เพิ่มกลุ่มยา</h3>
        							</div>
        							<div class="panel-body">
        								<table >
        									<tbody align="center">
        									
        									<tr>
        										<td><h4>กลุ่มยา : </h4></td>
        										<td>
        										<form:form commandName="groupm" id="groupm" >
        											<form:input  id="value" path = "value" class="form-control col-md-offset-1"  />
        										</form:form>
												</td>
        										<td>
        											
        											<button type="button" class="btn btn-success col-md-offset-12" id="add">
				        								<span class="glyphicon glyphicon-floppy-saved"></span></button>
				        							
				        						</td>
        									</tr>
											</tbody>
        								</table>
        							</div>
        						</div>
        					</div>
        				
          				
          				<div class="col-md-6">
           				 <div class="panel panel-primary">
             				 <div class="panel-heading">
                				<h3 class="panel-title">กลุ่มยาที่มี</h3>
             				 </div>
             				 <table class="table table-striped table-hover  table-bordered">
									<thead>
										<tr>
				    						<th align="center">กลุ่มยา</th>
				       				 		<th align="center">ลบ</th>
				   		   				</tr>
				 		   		</thead>
						    		<tbody style="text-align: center;">
						   	 		<c:forEach items="${grpm }" var="grpm">
						     			<tr>	
						      				<td>${grpm.value }</td>
						        			<td>
		        								<button class="btn btn-danger"
												value="${grpm.id}" onclick="chkdel(this.value)">
												<span class="glyphicon glyphicon-floppy-remove"></span>
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

<%@ include file="../footer.jsp"%>	
</body>
<script type="text/javascript">
function chkdel(str){ //alert(str);
	swal({  title: "ยืนยันการลบข้อมูล!",   
			text: "คุณต้องการลบใช่หรือไม่?",   
			type: "warning",   
			showCancelButton: true,   
			confirmButtonColor: "#DD6B55",   
			confirmButtonText: "ต้องการ",   
			cancelButtonText: "ไม่ต้องการ",   
			closeOnConfirm: false,   closeOnCancel: false 
			}, function(isConfirm){   
				if (isConfirm) {     
					$.ajax({
						url:'del_group',
						type:'POST',
						data:{
							id:str,
						},success : function (result){
					swal({title:"สำเร็จ", 
							text:"ลบเรียบร้อยแล้ว!", 
							type:"success",
							timer: 200,   
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
						timer: 2000,   
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

$(document).on('click','#add',function(e){
	var value = $("#value").val();
	if(value=="")
	{
		swal("ผิดพลาด", "กรอกชื่อสีให้ถูกต้อง!", "error");
		
	}
	else
	{
		$.post('Checkgroup',{value:$("#value").val()},function(msg){
			if(msg=="yes"){
				$.ajax({
					url:"addGroup",
					method:"POST",
					data:$("#groupm").serialize()
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
			}
			else
			{
				swal("ผิดพลาด", "กลุ่มยานี้อยู่ในระบบแล้ว!", "error");
			}
			
		});
	}
		e.preventDefault();
	}); 
	
</script>
</html>