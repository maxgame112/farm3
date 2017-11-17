<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
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
<title>ข้อมูลน้ำเชื้อ</title>
</head>
<body>
<c:if test="${sessionScope.username == null}">
	<c:redirect url="index"/>
</c:if>
	<jsp:include page="../menu.jsp"/>
<%int i=1; %>	
		 <div class="container">
		 <hr>
		<div class=" row form-group">
				<div class="form-inline">
					<div class="col-md-3">
						<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
							align="center">
							<p style="font-size: 28px; font-weight: 700; color: white;">ข้อมูลน้ำเชื้อ</p>
						</div>
					</div>
					<div class="col-md-9" align="right">
						<div class="input-group form-search">

						<span class="input-group-btn search-query"> <select class="form-control  search-query btn-info" id="selectValue" style="width: 150px;color: white;">								
								<option value="1">ชื่อพ่อพันธุ์</option>							
								<option value="2">เบอร์ประจำตัว</option>
								<option value="3">สีหลอด</option>
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
		<div>
		<a href="form_semen"><button type="button" class="btn btn-success">ลงทะเบียนน้ำเชื้อ</button></a>
		</div><br>
		  	<table class="table table-striped table-hover  table-bordered">
				<thead>
					<tr>
						<th>ลำดับที่</th>						
				    	<th>หมายเลขน้ำเชื้อ/ชื่อพ่อพันธุ์</th>
				    	<th>สายพันธุ์</th>
				    	<th>เบอร์ประจำตัวพ่อพันธุ์</th>					    	
				        <th>สีพ่อพันธุ์</th>			
				        <th>สีหลอด</th>
				        <th>ขนาดหลอด (ml)</th>
				        <th>แก้ไข</th>
				        <th>ลบ</th>
				      </tr>
				</thead>   
				  
				  
				<tbody style="text-align: center;" > 
					<c:forEach items="${semen}" var="semen">
						<tr>
										<td><%=i++%></td>
										<td>${semen.nameCattle }</td>
										<td>${semen.breed.value }</td>
										<td>${semen.HNumber }</td>										
										<td>${semen.colorCattle }</td>
										<td>${semen.tubeColor }</td>
										<td>${semen.tubeSize }</td>
										
										<td>
										<form:form action="edit_semen?id=${semen.id }" method="POST" commandName="show">
											
											<button name="action" class="btn btn-primary">
												<i class="glyphicon glyphicon-pencil"></i>
											</button>
										</form:form>									
										</td>
										<td>
											<!-- <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">
												<i class="glyphicon glyphicon glyphicon-remove"></i>
											</button> -->	
											<form:form action="del_semen?id=${semen.id }" method="POST" commandName="show">
											
												<button name="action" type="submit" id="del_semen" class="btn btn-danger"
													onclick="return confirm('Do you want to delete?')"
												>
													<i class="glyphicon glyphicon glyphicon-remove"></i>
												</button>
											
											</form:form>								
										</td>
						</tr>
					</c:forEach>
				</tbody>
	    
			</table>
			<div class="row form-group" id="page" align="center"></div>
		</div>
	</div>
</div> <!-- end container -->			  
				  
				      
	<c:forEach items="${semen}" var="semen">
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
    <form action="del_semen?id=${semen.id }" method="POST" commandName="show">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h3 class="modal-title">ลบข้อมูล</h3>
      </div>
      <div class="modal-body">
        <h4 class="control">คุณต้องการที่จะลบข้อมูลนี้ใช่หรือไม่</h4>	
      </div>
      <div class="modal-footer">
      	<button name="action" type="submit" class="btn btn-danger" id="del_tool">ลบ</button>	
        <button type="button" class="btn btn-default"  data-dismiss="modal">ปิด</button>	
      </div>
      </form>
    </div>

  </div>
</div>
</c:forEach>
	<jsp:include page="../footer.jsp"/>
	

	
</body>
</html>