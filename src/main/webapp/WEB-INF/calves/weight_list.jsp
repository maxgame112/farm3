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
<title>น้ำหนัก 1 ปี</title>
</head>
<body>
<%@ include file="../menu.jsp"%><br><br>
<div id="content">
<div class="container">
	<div class="col-md-3">
			<div class="jumbotron" style="background-color: rgb(218, 68, 83)" align="center">
				<p style="font-size: 28px; font-weight: 700; color: white;">ข้อมูลน้ำหนัก 1 ปี</p>						
			</div>		
		</div>
	<div class="row">
		<hr>
	</div><br><br>
		<div align="right" class=" row form-group" style="margin-right: 30px">
			<div class="form-inline">
				<label for="select">ค้นหาโดย</label>
					<div class="input-group form-search">
						<select class="form-control  search-query" style="width: 150px; border-radius: 10px 0px 0px 10px; margin-right: -1px;"
								id="selectValue">
								<option value="1">หมายเลขโค</option>
						</select> 
							<span class="input-group-btn"> <input type="text" class="form-control search-query" id="search">
								<button class="btn btn-info " type="button" onclick="search()"
											id="btnSeach"
											style="border-radius: 0px 10px 10px 0px; padding: 5px 7px 5px 7px; margin-top: 0px;">
											<i class="fa fa-search fa-lg"></i> ค้นหา
									</button>
							</span>
					</div>
				</div>
			</div>
				<center>
					<hr>
				</center>
				<br>
				
				<div class="panel panel-primary">

					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> ข้อมูลน้ำหนัก 1 ปี
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
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 190px;">หมายเลขโค</th>
									<th style="width: 190px;">วัน/เดือน/ปี</th>
									<th>น้ำหนัก  1 ปี</th>
									<th>ผู้บันทึก</th>
									<c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">
										<th style="width: 190px;">แก้ไข</th>
									</c:if>
									<c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">
										<th style="width: 190px;">ลบ</th>
									</c:if>
								</tr>
							</thead>
							<tbody style="text-align: center;" id="list">
								<c:forEach items="${weight }" var="horn">
									<tr>
										<td><%=++i %></td>
										<td>${horn.cattle.num }</td>
										<td>${horn.date }</td>
										<td>${horn.weightyear }</td>									
										<td>${horn.member.first }&nbsp;${horn.member.last }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- <div class="row form-group" id="page" align="center"></div> -->
					</div>
					
				</div>					
</div>
</div>
<%@ include file="../footer.jsp"%>
</body>
<script type="text/javascript">
$("#list").load('search_weight',{ id : 0 ,value : 0},function(){ //load list_view_medicine
	$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast  : $("#countPage").val()},function(m){
		for(i=0 ;i<=10;i++){
			if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
				$("[id=pageNum]").eq(i).addClass("active");
			}
		}
	});
});
function search(){ //click button search
	$("#list").load('search_weight',{ id : $("#selectValue").val(), value : $("#search").val()},function(){
		$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast : $("#countPage").val()},function(m){
			for(i=0 ;i<=10;i++){
				if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
					$("[id=pageNum]").eq(i).addClass("active");
				}
			}
		});
	});
}


$(document).on('click','#pageNum',function(e){ // page number
	 var id =  $('[id=pageNum]').index(e.target);
	 $("#list").load('search_weight',{ id : $("#selectValue").val(), value : $("#search").val(),page:$("[id=pageNum]").eq(id).val()},function(){
			$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast : $("#countPage").val()},function(m){
				for(i=0 ;i<=10;i++){
					if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
						$("[id=pageNum]").eq(i).addClass("active");
					}
				}
			});
			
		}); 
});
</script>
</html>