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


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/css/easy-autocomplete.min.css" />" rel='stylesheet' type='text/css' />
<link href="<c:url value="/resources/css/easy-autocomplete.themes.min.css" />" rel='stylesheet' type='text/css' />
<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script src="<c:url value="/resources/js/jquery.easy-autocomplete.min.js" />"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<title>การสั่งซื้อยา</title>
<%@ include file="../menu.jsp"%>
</head>
<body>
<%int i=1; %>
<div class="container">
<br><br>
	<div class=" row form-group"> <!-- //บนสุด -->
		<div class="col-md-3">
			<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
				align="center">
				<p style="font-size: 28px; font-weight: 700; color: white;">การสั่งซื้อยา</p>
			</div>
		</div>
	</div>
		<div class=" row form-group"> <!-- //กลาง -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title" style="font-size: 24px; color: white;"> <i class="fa fa-cart-arrow-down"></i>&nbsp;เพิ่มรายการสั่งซื้อ</h3>
			</div>
			<div class="panel-body">
				<!-- <h1>กลาง</h1> -->
				<div class="row form-group">
				<%--<form:form action="ordered_medicine" method="POST"  commandName=" " >--%>

								<%--<c:forEach items="${ulist }" var="m">--%>
									<%--<form:input path="member.id" type="hidden" value="${m.id}"/>--%>
								<%--</c:forEach>--%>

					<div class="col-md-6"> <!-- คอลัมแรก -->
						<div class="row form-group">
							<label class="col-md-offset-0 col-md-3 control-label"><font color="red">*</font> วันที่สั่งซื้อ</label>
							<div class="col-md-6">
								<input  value="${day }" id="day" name="day" type="date" class="form-control" />
							 	<%--<form:input path="day" value="${day }" id="day" name="day" type="date" class="form-control" />											--%>
							</div>
						</div>
						<div class="row form-group">

								<label class="col-md-offset-0 col-md-3 control-label"><font color="red">*</font> ชื่อยา</label>
								<div class="col-md-6">
									<input  type="text" class="form-control"/>
									<%--<select class="form-control Medicineid" id="Medicineid"  onchange="Listunit();"/>--%>
									 	<%--<form:option value="null">เลือกชื่อยา (ทางการค้า)</form:option>--%>
										<%--<c:forEach items="${medicine }" var="med">--%>
										<%--<c:if test="${Medicine.id == med.id }">--%>
												<%--<form:option value="${med.id }" selected="selected">${med.tradeName }</form:option>--%>
										<%--</c:if>--%>
										<%--<c:if test="${Medicine.id != med.id }">--%>
											<%--<form:option value="${med.id }">${med.tradeName }</form:option>--%>
										<%--</c:if>--%>
										<%--</c:forEach>--%>
									<%--</form:select>--%>

								</div>
						</div>
						<div class="row form-group">

								<label class="col-md-offset-0 col-md-3 control-label">จำนวนคงคลัง</label>
								<div class="col-md-6">
									<input name="beforeQuantity" id="oquantity" type="text" class="form-control" readonly="true">
								</div>
						</div>


					</div><!--  //จบคอลัมแรก -->
					<div class="col-md-4 "> <!-- คอลัม2 -->
						<div class="row form-group">
							<label  class="col-md-offset-1 col-md-3 control-label"><font color="red">*</font> จำนวนที่สั่ง</label>
							<div class="col-md-6">
								<input  type="number" class="form-control"/>
							</div>
						</div>
						<div class="row form-group">
							<label  class="col-md-offset-1 col-md-3 control-label"><font color="red">*</font> หน่วย</label>
							<div class="col-md-6">
								<input id="unitmed" type="text" class="form-control" readonly="true">
							</div>
						</div>
					</div> <!-- คอลัม2 -->
				<%--</form:form>--%>
				</div>
				<div class="row form-group">
						<center>
							<button type="button" class="btn btn-success btn-lg"
								id="btn_select" onclick="ordermed()">
								<li class="glyphicon glyphicon-download"></li>&nbsp;เพิ่มการสั่งซื้อ
							</button>
						</center>
					</div>
			</div>
		</div>

		</div><!-- //กลาง -->
</div>


<div class="container">
		<div class=" row form-group">
				<div class="form-inline">
					<div class="col-md-3">
						<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
							align="center">
							<p style="font-size: 28px; font-weight: 700; color: white;">ประวัติการสั่งซื้อยา</p>
						</div>
					</div>
					<div class="col-md-9" align="right">
						<div class="input-group form-search">

						<span class="input-group-btn search-query"> <select class="form-control  search-query btn-info" id="selectValue" style="width: 150px;color: white;">
								<option value="1">ชื่อยา</option>
								<option value="2">ผู้สั่งซื้อ</option>
								<option value="3">วันที่สั่งซื้อ</option>
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
		<table class="table table-striped table-hover" class="form-control" class="font-nav" style="font-size: 18px;" border="1" bordercolor="#BDBDBD">
							<thead >
								<tr>
									<th>ลำดับที่</th>
									<th>วันที่สั่งซื้อ</th>
									<th>รายการ</th>
									<th>จำนวน</th>
									<th>หน่วย</th>
									<th>ชื่อผู้สั่งซื้อ</th>
									<%--<c:if test="${sessionScope.privilege == 1}"><th>ยกเลิกการสั่งซื้อ</th></c:if>--%>
								</tr>
							</thead>
								<tbody style="text-align: center;" id="list" >

								</tbody>
					</table>
			<div class="row form-group" id="page" align="center"></div>
		</div>
	</div>
</div> <!-- end container -->

	<%-- <div class=" row form-group"> <!-- //ล่างสุด -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title" style="font-size: 24px; color: white;"> <i class="fa fa-cart-plus"></i>&nbsp;ประวัติการสั่งซื้อ</h3>
			</div>
		<div class="panel-body">
		<center>
				<div class="row form-group">
					<table class="table table-striped table-hover" class="form-control" class="font-nav" style="font-size: 18px;" border="1" bordercolor="#BDBDBD">
							<thead >
								<tr>
									<th>ลำดับที่</th>
									<th>วันที่สั่งซื้อ</th>
									<th>รายการ</th>
									<th>จำนวน</th>
									<th>หน่วย</th>
									<th>ชื่อผู้สั่งซื้อ</th>
									<!-- <th>ยกเลิก</th> -->
								</tr>
							</thead>
								<tbody style="text-align: center;" >
									<c:forEach items="${listrder }" var="list">
										<tr>
											<td><%=i++ %></td>
											<td>${list.day }</td>
											<td>${list.medicine.tradeName }</td>
											<td>${list.quantity }</td>
											<td>${list.medicine.unitMedicine.value }</td>
											<td>${list.member.first } ${list.member.last }</td>
										</tr>
									</c:forEach>
								</tbody>
					</table>
				</div></center>
		</div>
		</div>
	</div> <!-- //closeล่างสุด --> --%>


<jsp:include page="../footer.jsp"/>
</body>
<script type="text/javascript">
//search
$("#list").load('search_order_medicine',{ id : 0 ,value : 0},function(){
	$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast  : $("#countPage").val()},function(m){
		for(i=0 ;i<=10;i++){
			if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
				$("[id=pageNum]").eq(i).addClass("active");
			}
		}
	});
});
$(document).on('keyup','#search',function(e){
	$("#list").load('search_order_medicine',{ id : $("#selectValue").val(), value : $("#search").val()},function(){
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
	 $("#list").load('search_order_medicine',{ id : $("#selectValue").val(), value : $("#search").val(),page:$("[id=pageNum]").eq(id).val()},function(){
			$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast : $("#countPage").val()},function(m){
				for(i=0 ;i<=10;i++){
					if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
						$("[id=pageNum]").eq(i).addClass("active");
					}
				}
			});

		});
});
//order
function ordermed(){
	swal({	title: "ยืนยันบันทึกข้อมูล?",
		text: "คุณต้องการยืนยันบันทึกข้อมูลการสั่งซื้อใช่หรือไม่!",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: "#55c7dd",
		cancelButtonText: "ไม่ต้องการ",
		confirmButtonText: "ต้องการ",
		closeOnConfirm: false,
		closeOnCancel: false },
		function(isConfirm){
			if (isConfirm) {
				if($("#Medicineid").val() == 0)
				{
					swal("กรุณากรอกชื่อยาให้ถูกต้อง");
				}else if($("#quantity").val() == "" || $("#quantity").val() <= 0){
					swal("กรุณากรอกจำนวนให้ถูกต้อง");
				}else if($("#day").val() == ""){
					swal("กรุณากรอกวันที่สั่งซื้อ");
				}else{
				$.post('ordered_medicine',$("#ordermed").serialize(),
				      function (result) {
				     	swal({	title: "สำเร็จ!",
			     			text: "บันทึกการสั่งซื้อเรียบร้อยแล้ว!",
							timer: 1000,
							type: "success",
							showConfirmButton: false
						});
						setInterval(function(){location.reload()}, 1000);
					})
				}
				} else {
				swal({	title: "ยกเลิก!",
						text: "คุณได้ยกเลิกการบันทึกข้อมูล",
						timer: 1000,
						type: "error",
						showConfirmButton: false
				});
			}
		}
	);
}

function Listunit() { //เอาหน่วยที่ใช้ในคลังอออกมา
	var selectedValue = $(".Medicineid").val();  //หลังclass form control
	//alert(selectedValue);
	if(selectedValue != 0){
	$.ajax({
		  url: "listMedUnit",
		  data : {id:selectedValue}
		}).done(function(element) {
			var json = JSON.parse(element);

			$( "#oquantity" ).val( json.quantity );
		  	$( "#unitmed" ).val(json.unitMedicine.value );

		  	//alert(json.unitMedicine.value);
		});
	}else{
		$( "#oquantity" ).val("" );
		$( "#unitmed" ).val( "" );
		}
}

function chkdel(str){ //alert(str);
	swal({  title: "ยกเลิกการสั่งซื้อ!",
			text: "คุณต้องการยกเลิกการสั่งซื้อใช่หรือไม่?",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "ต้องการ",
			cancelButtonText: "ไม่ต้องการ",
			closeOnConfirm: false,   closeOnCancel: false
			}, function(isConfirm){
				if (isConfirm) {
					$.ajax({
						url:'cancle_order_medicine',
						type:'POST',
						data:{
							id:str,
						},success : function (result){
					swal({title:"สำเร็จ",
							text:"ยกเลิกการสั่งซื้อเรียบร้อยแล้ว!",
							type:"success",
							timer: 2000,
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
						text:"ยกเลิกรายการที่เลือกเรียบร้อยแล้ว!",
						type:"error",
						timer: 2000,
						showConfirmButton: false
				});}
			});

	}
</script>
</html>
