<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
<link rel="Shortcut Icon" href="<c:url value="/resources/img/cow.ico"/>" type="image/x-icon">
<title>ตั้งค่าแบรนด์</title>
</head>
<body>
<%@ include file="../menu.jsp"%><br><
<br>
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
	        <h4 class="panel-title">ตั้งค่าแบรนด์</h4>
	   	</div>
		<div class="panel-body">
			<form action="saveBrand" id="brand" enctype="multipart/form-data" method="post">
				<table class="table table-striped table-hover  table-bordered">
					<tbody>
					<tr>
						<th class="text-center" colspan="4" style="height: 250px;">
							<div align="center">
								โลโก้
			<img id='output' class="thumbnail" data-src="holder.js/..."  src="<c:url value="img/img_brand/logo.jpg"/>" style="width:auto; height:200px;">
		<script>
 	 		var openFile = function(event) {
   	 		var input = event.target;
   	 		var reader = new FileReader();
  		
   	 		reader.onload = function(){
    		var dataURL = reader.result;
     		var output = document.getElementById('output');
      		output.src = dataURL;
  	  		};
  	  		reader.readAsDataURL(input.files[0]);
 	  	};
       </script>
       <input type="file" id="file" name="file" size="50" 
       onchange='openFile(event)' data-show-upload="false" 
       data-show-caption=true data-show-preview="false" data-show-remove="false"/>
       	<!-- <input id="file" type="file"  name="file" class="file" onchange='openFile(event)' data-show-upload="false" data-show-caption=true data-show-preview="false" data-show-remove="false"> -->
			
							</div>
						</th>
					</tr>
					<tr>
					<th class="text-center">
					ชื่อฟาร์มภาษาไทย
					</th>
					<td class="text-center">
					<input type="text" name="nameThai" id="nameThai" class="form-control text-center" value="${farm.nameThai }"/>
					</td>
			
					<th class="text-center">
					ชื่อฟาร์มภาษาอังกฤษ
					</th>
					<td class="text-center">
					<input type="text" name="nameEng" id="nameEng" class="form-control text-center" value="${farm.nameEng }"/>
					</td>
					</tr>
					<tr>
					<th class="text-center text-center">
					ชื่อย่อฟาร์ม
					</th>
					<td class="text-center">
					<input type="text" name="shotName" id="shotName" class="form-control text-center" value="${farm.shotName }"/>
					</td>
					
					<th class="text-center">
					ที่อยู่ฟาร์ม
					</th>
					<td class="text-center">
						<textarea name="address" id="address" class="form-control text-center">${farm.address }</textarea>
					</td>
					</tr>
					<tr>
						<th class="text-center text-center">
					เบอร์โทรศัพท์
					</th>
					<td class="text-center">
					<input type="text" name="phone" id="phone" class="form-control text-center" value="${farm.phone }"/>
					 
					</td>
					</tr>
					
					</tbody>
				</table>
				<div class="text-center">
					<button type="submit" class="btn btn-success">
				        	<span class="glyphicon glyphicon-floppy-saved"></span></button>
				</div>
			</form>
		</div>
	</div>
	<br>
</div><!-- container -->
<%@ include file="../footer.jsp"%>
<!-- <script type="text/javascript">
$(document).on('click','#save',function(e){
	$.ajax({
		url:"saveBrand",
		method:"POST",
		data:$("#brand").serialize()
	}).done(function(s){
		swal({  title: "Good job!",   
			text: "Successful!", 
			type: "success",   
			showCancelButton: false,   
			confirmButtonText: "OK!",   
			closeOnConfirm: false }, 
			
			function(){   
				location.reload(); 
				});
	
	}).fail(function() {
		 swal("Oops...", "Failed!", "error");
	}); 

	e.preventDefault();
});
</script> -->
</body>
</html>