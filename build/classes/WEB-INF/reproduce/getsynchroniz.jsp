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
<title>เหนี่ยวนำ</title>
</head>
<body>

 <%		int i=1;		
%>

<div class="panel panel-primary">

	       <div align="center"> <h4 class="panel-title">${Typesync }</h4> </div>

		<div class="panel-body">
		  	<table class="table table-striped table-hover  table-bordered" style="font-size: 15px">
				<thead>
					<tr>
		    <th class="text-center">ลำดับที่ </th>
		    <th class="text-center">ทำรายการ</th>
		    <th class="text-center">วัน</th>
		    <th class="text-center">เวลา</th>
		  </tr>	
		  	</thead>
					<tbody>
<c:forEach items="${syncList}" var="sync">
				  <tr>
				  	<td class="text-center"><%=i++%></td>
				    <td class="text-center">${sync.namesync }</td>
				    <input type="hidden" name="namesync" id="namesync" value="${sync.namesync }" />
				    <td class="text-center">${sync.dayalert }</td>
				    <input type="hidden" name="dayalert" id="dayalert" value="${sync.dayalert }" />
				    <td class="text-center">${sync.timealert }</td>
				    <input type="hidden" name="timealert" id="timealert" value="${sync.timealert }" />
				  </tr>
</c:forEach>
  <input type="hidden" name="num" id="num" value="${syncList.size() }" />
	  </tbody>
					</table>
				
			</div>
		</div>


</body>
</html>