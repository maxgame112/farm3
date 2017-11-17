<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/fileinput.css" />" media="all" rel='stylesheet' type='text/css' />
<script src="<c:url value="/resources/js/clicktable.js" />"></script>
<script src="<c:url value="/resources/js/fileinput.js" />"></script>
<title>การเบิกยา</title>
</head>
<%@ include file="../menu.jsp"%>
<% int  i=1,j=1;%>
<body>
	<br><br>
<div class="container">
		<div class=" row form-group">
				<div class="form-inline">
					<div class="col-md-3">
						<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
							align="center">
							<p style="font-size: 28px; font-weight: 700; color: white;">การเบิกยา</p>
						</div>
					</div>
					<div class="col-md-9" align="right">
						<div class="input-group form-search">

						<span class="input-group-btn search-query"> 
						<select class="form-control  search-query btn-info" id="selectValue1" style="width: 150px;color: white;">								
								<option value="1">ชื่อยา (ทางการค้า)</option>							
								<option value="2">กลุ่มยา</option>
						</select> 
						<input id="search1" class="form-control search-query " oninput="search1()"
							style="margin-left: -2px; margin-right: -1px;">

							<button onclick="search1()"
								class="btn btn-info search-query glyphicon glyphicon-search"
								style="padding: 5px 10px 5px 10px;"></button>
						</span>
					</div>
					</div>
				</div>
			</div>
		<hr>
<div class="panel panel-primary">
		<div class="panel-heading">
	        <h4 class="panel-title" style="font-size: 25px;">ยาคงคลัง</h4>
	   	</div>
		<div class="panel-body">
		  <table class="table table-striped table-hover  table-bordered">
				<thead>
					<tr>
						<th>ลำดับที่</th>					
				    	<th>ชื่อยา (ทางการค้า)</th>
				    	<th>ชื่อยา (สามัญ)</th>				      
				        <th>กลุ่มยา</th>
				        <th>จำนวนคงคลัง</th>
				        <th>หน่วย</th>
				        <th>เบิก</th>
				       <!--  <th>รายละเอียดเพิ่มเติม</th>		 -->	        
				      </tr>
				</thead> 
				
				 	<tbody style="text-align: center;" id="listRelease"> 
						
					</tbody>
				
			</table>
			<div class="row form-group" id="p" align="center"></div>
		</div>
	</div>
</div>
<br>




<div class="container">
		<div class=" row form-group">
				<div class="form-inline">
					<div class="col-md-3">
						<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
							align="center">
							<p style="font-size: 28px; font-weight: 700; color: white;">ประวัติการเบิกยา</p>
						</div>
					</div>
					<div class="col-md-9" align="right">
						<div class="input-group form-search">

						<span class="input-group-btn search-query"> <select class="form-control  search-query btn-info" id="selectValue" style="width: 150px;color: white;">								
								<option value="1">ชื่อยา</option>							
								<option value="2">ผู้เบิก</option>
								<option value="3">วันที่เบิก</option>
						</select> <input id="search" class="form-control search-query "
							style="margin-left: -2px; margin-right: -1px;">

							<button onclick="search()"
								class="btn btn-info search-query glyphicon glyphicon-search"
								style="padding: 5px 10px 5px 10px;"></button>
						</span>
					</div>
					</div>
				</div>
			</div>
		<hr>
<div class="panel panel-primary">
		<div class="panel-heading">
	        <h4 class="panel-title" style="font-size: 25px;">รายละเอียด</h4>
	   	</div>
		<div class="panel-body">
		<table class="table table-striped table-hover  table-bordered">
				<thead>
					<tr>
						<th>ลำดับที่</th>
						<th>วันที่เบิก</th>						
				    	<th>รายการ</th>	
				    	<th>จำนวน</th>			      
				        <th>หน่วย</th>
				        <th>ชื่อผู้เบิก</th>
				       	<c:if test="${sessionScope.privilege == 1}"><th>ยกเลิกการเบิก</th></c:if>	        
				      </tr>
				</thead> 
				
				 	<tbody style="text-align: center;" id="list"> 
						
					</tbody>
				
			</table>
			<div class="row form-group" id="page" align="center"></div>
		</div>
	</div>
</div> <!-- end container -->

<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
   
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
         <h3 class="modal-title">ระบุจำนวนเบิก</h3> 
      </div>
      <div class="modal-body">
      <form id="q">
      <input id="beforequantity"  type="hidden" class="form-control input-sm " size="35" />
       	<!-- <div class="row form-group">
       	<label class="col-md-offset-3 col-md-2 control-label">จำนวนคงคลัง</label>
       		<div class="form-inline">
      		<input id="beforequantity"  type="number" class="form-control input-sm " size="35" readonly="true"/>
      		</div>
      	</div> -->
             	 <div class="row form-group">
				<label class="col-md-offset-3 col-md-2 control-label"><font style="color: red;">* </font>วันที่เบิก</label>
				<div class="form-inline">
				
					<input name="id" id="id" type="hidden" class="form-control input-sm " size="35" />
					<input name="day" id="day" value="${day }" type="date" class="form-control input-sm " size="35" />
				</div>
			</div>
			<div class="row form-group">
				<label class="col-md-offset-3 col-md-2 control-label"><font style="color: red;">* </font>จำนวน</label>
				<div class="form-inline">
					<input name="quantity" id="quantity" type="number" class="form-control input-sm " size="35" />
				</div>
			</div>
		</form>	
      </div>
      <div class="modal-footer">
      	<button name="action" type="submit" class="btn btn-success" id="save_relaese">บันทึกการเบิก</button>	
        <button type="button" class="btn btn-danger"  data-dismiss="modal">ปิด</button>	
      </div>
 
    </div>

  </div>
</div>

	


<jsp:include page="../footer.jsp"/>

</body>
<script type="text/javascript">
//search for release ####################################################
$("#listRelease").load('search_release_med',{ id : 1 ,value : null},function(){ 
	$("#p").load('page1',{ pagePresent1 : $("#Page1").val(), pageLast1  : $("#countPage1").val() },function(m){
		for(i=0 ;i<=10;i++){
			if($("[id=pageNum1]").eq(i).val()==$("#Page1").val()){
				$("[id=pageNum1]").eq(i).addClass("active");
			}
		}
	});
}); 

function search1(){
	$("#listRelease").load('search_release_med',{ id : $("#selectValue1").val(), value : $("#search1").val()},function(){
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
	 $("#listRelease").load('search_release_med',{ id : $("#selectValue1").val(), value : $("#search1").val(),page:$("[id=pageNum1]").eq(id).val()},function(){
			$("#p").load('page1',{ pagePresent1 : $("#Page1").val(), pageLast1 : $("#countPage1").val()},function(m){
				for(i=0 ;i<=10;i++){
					if($("[id=pageNum1]").eq(i).val()==$("#Page1").val()){
						$("[id=pageNum1]").eq(i).addClass("active");
					}
				}
			});
			
		}); 
});












//search release##########################################################
$("#list").load('search_release_medicine',{ id : 0 ,value : 0},function(){ 
	$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast  : $("#countPage").val()},function(m){
		for(i=0 ;i<=10;i++){
			if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
				$("[id=pageNum]").eq(i).addClass("active");
			}
		}
	});
});
$(document).on('keyup','#search',function(e){
	$("#list").load('search_release_medicine',{ id : $("#selectValue").val(), value : $("#search").val()},function(){
		$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast : $("#countPage").val()},function(m){
			for(i=0 ;i<=10;i++){
				if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
					$("[id=pageNum]").eq(i).addClass("active");
				}
			}
		});
	});
});


$(document).on('click','#pageNum',function(e){ 
	 var id =  $('[id=pageNum]').index(e.target);
	 $("#list").load('search_release_medicine',{ id : $("#selectValue").val(), value : $("#search").val(),page:$("[id=pageNum]").eq(id).val()},function(){
			$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast : $("#countPage").val()},function(m){
				for(i=0 ;i<=10;i++){
					if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
						$("[id=pageNum]").eq(i).addClass("active");
					}
				}
			});
			
		}); 
}); 

//add release
$(document).on('click','#save_relaese',function(e){
	var before = $("#beforequantity").val();
	var quantity = $("#quantity").val();
	var b = parseInt(before);
	var q = parseInt(quantity);
	var day = $("#day").val();
	if(day==""){	
		swal("ผิดพลาด", "กรุณาระบุวันที่เบิก!", "error");
	}else if( q > b || quantity <=0 ){
		swal("ผิดพลาด", "กรุณาระบุจำนวนเบิกให้ถูกต้อง!", "error");
}else{
	$.ajax({
		url:"Saverelease_medicine",
		method:"POST",
		data:$("#q").serialize()
	}).done(function(s){
		swal({  title: "สำเร็จ",   
			text: "บันทึกการเบิกเรียบร้อยแล้ว!", 
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
} 
}); 





$('#myModal').on('show.bs.modal', function(e) {
    var id1 = $(e.relatedTarget).data('id1');
    var id2 = $(e.relatedTarget).data('beforequantity');

    
    $(e.currentTarget).find('input[id="beforequantity"]').val(id2);
    $(e.currentTarget).find('input[id="id"]').val(id1);
    
});



//$('#myModal').on('hide.bs.modal', function(e) {
  //  location.reload();
//});



function chkdel(str){ //alert(str);
	swal({  title: "ยกเลิกการเบิก!",   
			text: "คุณต้องการยกเลิกการเบิกใช่หรือไม่?",   
			type: "warning",   
			showCancelButton: true,   
			confirmButtonColor: "#DD6B55",   
			confirmButtonText: "ต้องการ",   
			cancelButtonText: "ไม่ต้องการ",   
			closeOnConfirm: false,   closeOnCancel: false 
			}, function(isConfirm){   
				if (isConfirm) {     
					$.ajax({
						url:'cancle_release_medicine',
						type:'POST',
						data:{
							id:str,
						},success : function (result){
					swal({title:"เสร็จเรียบร้อย", 
							text:"ยกเลิกการเบิกเรียบร้อยแล้ว!",
							type:"success",
							timer: 2000,   
							showConfirmButton: false
						},function(isClose){ 
							window.location.reload();
						}
						);   
						}
					,error: function(result){
						swal("ผิดพลาด", "ไม่สามารถยกเลิกการเบิกได้!", "error");
					}
					
				});
					} 
				else {  swal({
						title:"ยกเลิก", 
						text:"ยกเลิกการรายการที่เลือกเรียบร้อยแล้ว!", 
						type:"error",
						timer: 2000,   
						showConfirmButton: false
				});} 
			});

	}
</script>

</html>