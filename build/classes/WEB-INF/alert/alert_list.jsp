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
<script src="<c:url value="/resources/js/baloon.js"/>"></script>
<script src="<c:url value="/resources/js/clicktable.js" />"></script>
<script src="<c:url value="/resources/js/fileinput.js" />"></script>
<title>การแจ้งเตือน</title>

</head>

<body onload="JavaScript:alert()">
<%@ include file="../menu.jsp"%><br><br>
<div id="content">
<div class="container">
			<div class="col-md-3">
				<div class="jumbotron" style="background-color: rgb(218, 68, 83)"
						align="center">
						<p style="font-size: 28px; font-weight: 700; color: white;">ข้อมูลการแจ้งเตือน</p>
				</div>	
			</div>
			<div class="row">
				<hr>
			</div><br><br>	
			
				<center>
					<hr>
				</center>
				<br>
				
					<div class="panel panel-primary">

					<div class="panel-heading">
						<h4 class="panel-title">
							<span class="fa fa-list-alt fa-lg"></span> ข้อมูลการตีเบอร์
						</h4>
					</div>
					<%
						int i = 0;
					%>
					<div class="panel-body">
					<form action="alertform" id="alertform">
						<table class="table table-striped table-hover  table-bordered"
							style="font-size: 16px;">
							<thead>
								<tr>
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 190px;">หมายเลขโค</th>
									<th style="width: 190px;">รายการแจ้งเตือน</th>									
									<th style="width: 190px;">วัน/เดือน/ปี</th>
									<c:if test="${sessionScope.privilege != null}">
										<th class="text-center" style="width:150px;">ปิดการแจ้งเตือน</th>
									</c:if>

								</tr>
							</thead>
							<tbody style="text-align: center;" id="list">
								
							</tbody>
						</table>
						</form>
						<c:if test="${sessionScope.privilege != null}">
							<div class="text-center">
							<input type="checkbox" name="checkAll" id="checkAll" data-toggle="checkbox" class="form-control hide"/>
							<button type="button" id="toggle" class="btn btn-embossed btn-primary" onclick="checkall()">เลือก/ไม่เลือก ทั้งหมด</button>
					   		<button type="button" class="btn btn-success" id="save">บันทึก</button>
					   		</div>
					   		<br>
				   		</c:if>
						
					<div class="row form-group" id="page" align="center"></div>
					</div>
					
				</div>		
				
		
</div>
</div>
<%@ include file="../footer.jsp"%><br><br>
</body>

<script type="text/javascript"> //สคริปแจ้งเตือน

  
  $("#list").load('search_alert',function(){
		$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast : $("#countPage").val()},function(m){
			for(i=0 ;i<=8;i++){
				if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
					$("[id=pageNum]").eq(i).addClass("active");
				}
			}
		});
	});


$(document).on('click','#pageNum',function(e){
		 var id =  $('[id=pageNum]').index(e.target);
		 $("#list").load('search_alert',{ id : $("#sel").val(), value : $("#search").val(),page:$("[id=pageNum]").eq(id).val()},function(){
				$("#page").load('page',{ pagePresent : $("#Page").val(), pageLast : $("#countPage").val()},function(m){
					for(i=0 ;i<=8;i++){
						if($("[id=pageNum]").eq(i).val()==$("#Page").val()){
							$("[id=pageNum]").eq(i).addClass("active");
						}
					}
				});
				
			}); 
	});
	
	
	//check
	function checkall() {
    var a = document.getElementById("checkAll");
    var x = document.getElementsByName("check");

    if(a.checked == true)
    {
          a.checked = false;
          for(i=0;i<=x.length;i++){
      		if(x[i].type=="checkbox"){
      			x[i].checked=false;
      		}
      		if(x[i].type=="hidden"){
  				x[i].disabled=false;
  	
  		}
      	}
    }
 else
    {
          a.checked = true;
          for(i=0;i<=x.length;i++){
      		if(x[i].type=="checkbox"){
      				x[i].checked=true;
      	
      		}
      		if(x[i].type=="hidden"){
  				x[i].disabled=true;
  	
  		}

      	}
    }
}
	
	//ปิดการแจ้งเตือน
	$(document).on('click','#save',function(e){

	$.ajax({
		url:"closeAlert",
		method:"GET",
		data:$("#alertform").serialize()
	}).done(function(s){
		swal({  title: "สำเร็จ",   
			text: "บันทึกเรียบร้อยแล้ว!", 
			type: "success",   
			showCancelButton: false,   
			timer: 2000,
			confirmButtonText: "OK!",
			closeOnConfirm: false }, 
			
			function(){   
				location.reload(); 
				});
	
	}).fail(function() {
		 swal("ผิดพลาด", "ไม่สามารถบันทึกได้!", "error");
	}); 
	/* }*/
	e.preventDefault();
});
	
	
	
	var events = document.getElementById("events");        
	 baloon.autocheck(); 
	 var ag1 = ${date1.size()};
	 //alert(ag1); เหลือจำนวนวันที่หมดอายุยา กับวัตถุดิบยังไม่ได้ใส่
	 var ag2 = ${date2.size()};
	 var ag3 = ${date3.size()};
	/*  var ag4 =	4;
	 var ag5 = 5; */
	 function alert(){
	 	if(ag1!=0){
	 		  baloon({
	 		        title: "แจ้งแตือน",
	 		        image: "<c:url value='/resources/img/alert2.JPG'/>",
	 		        message:["คุณมี "+ag1+" รายการแจ้งแตือน"].join(""),
	 		        timer: 5000,
	 		        closed: function baloonClosed () {
	 		            events.innerHTML = "Cancel\n" + events.innerHTML;
	 		        },
	 		        callback: function baloonCallback () {
	 		        	events.innerHTML = "Callback\n" + events.innerHTML;
	 		        	  /* window.location.href="index"; */ 
	 		        }
	 		
	 		    });
	 		  }
	 	if(ag2!=0){
			 baloon({
			        title: "แจ้งแตือน",
			        image: "<c:url value='/resources/img/alert.JPG'/>",
			        message:["คุณมี "+ag2+" รายการแจ้งแตือน"
			        ].join(""),
			        timer: 5000,
			        closed: function baloonClosed () {
			            events.innerHTML = "Cancel\n" + events.innerHTML;
			        },
			        callback: function baloonCallback () {
			        	events.innerHTML = "Callback\n" + events.innerHTML;
			        	/* window.location.href="index"; */
			        }
			
			    });
			}
	 	if(ag3!=0){
			 baloon({
			        title: "แจ้งแตือน",
			        image: "<c:url value='/resources/img/Red_Alert.jpg'/>",
			        message:["คุณมี "+ag3+" รายการแจ้งแตือน"
			        ].join(""),
			        timer: 5000,
			        closed: function baloonClosed () {
			            events.innerHTML = "Cancel\n" + events.innerHTML;
			        },
			        callback: function baloonCallback () {
			        	events.innerHTML = "Callback\n" + events.innerHTML;
			        	/* window.location.href="index"; */
			        }
			
			    });
			}
	   		
	  }/*end function*/

  
 </script>


</html>