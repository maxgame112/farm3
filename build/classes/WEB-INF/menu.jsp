<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
 <link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel='stylesheet' type='text/css' />
 <link href="<c:url value="/resources/css/bootflat.css"/>"
 rel='stylesheet' type='text/css' />
 <link href="<c:url value="/resources/css/homestyle.css"/>"
 rel='stylesheet' type='text/css' />
 <link href="<c:url value="/resources/css/settable.css"/>"
 rel='stylesheet' type='text/css' />
 <link href="<c:url value="/resources/css/desktop.css" />"
 rel='stylesheet' type='text/css' />
<%-- 	<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script> --%>
 <link href="<c:url value="/resources/font-awesome-4.3.0/css/font-awesome.min.css"/>"
 rel='stylesheet' type='text/css' />


 <!-- Sweet alert -->
 <link href="<c:url value="/resources/css/sweetalert.css"/>" rel="stylesheet">
 <script src="<c:url value="/resources/js/sweetalert-dev.js"/>"></script>
 	<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
    <script src="<c:url value="/resources/js/jquery-2.1.3.min.js"/>"></script> 
 <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
 <link href="<c:url value="/resources/css/fileinput.min.css"/>" rel="stylesheet">
 <script src="<c:url value="/resources/js/fileinput.min.js"/>"></script>
 <link href="<c:url value="/resources/css/fileinput.css"/>" rel="stylesheet">
 <script src="<c:url value="/resources/js/fileinput.js"/>"></script>
<script>
$(document).on('ready', function() {
   $("#input-4").fileinput({showCaption: false});
});
</script>

   <link href="<c:url value="/resources/picker/bootstrap-datepicker.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/picker/jquery.timepicker.css"/>" rel="stylesheet">
</head>
<body>
<header class="header"> <nav
 class="navbar navbar-default navbar-fixed-top">
<div class="container-fluid">
 <div class="navbar-header">
   <a class="navbar-brand" href="index"><img
     src="<c:url value=  "resources/img/Logo-V9.png"/> "
     <%-- src="<c:url value=  "resources/img/44.png"/> " --%>
     height="40"></a>
   <button type="button" class="navbar-toggle" data-toggle="collapse"
     data-target="#myNavbar">
     <span class="icon-bar"></span> <span class="icon-bar"></span> <span
       class="icon-bar"></span>
   </button>
 </div>

   <c:if test="${sessionScope.privilege == null}">
   <div class="collapse navbar-collapse" id="myNavbar">
   <ul class="nav navbar-nav navbar-right">
     <li style="font-size: 18px;"><a href="register"
       ><i class="glyphicon glyphicon-user "></i>
         สมัครสมาชิก</a></li>
     <li style="font-size: 18px;"><a href="#" data-toggle="modal"
       data-target="#login"><i class="glyphicon glyphicon-log-in"></i>
         เข้าสู่ระบบ</a></li>
   </ul>
   </div>
 </c:if>

 <c:if test="${sessionScope.privilege != null }"> <!-- //เรียก privilege ที่ ประกาศ จาก maincontroller /login -->
 <c:forEach items="${ulist }" var="m">
 <ul class="nav navbar-nav">
 <li class="dropdown" role="menu">
             <a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-ambulance"></i>&nbsp; การรักษา <b class="caret"></b></a>
             <ul class="dropdown-menu">
        <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege == 2}">
               <li><a tabindex="-1" href="treat"><i class="fa fa-pencil-square-o fa-fw"></i>วินัจฉัยโรคและให้ยา</a></li>
        </c:if>
        <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">
          <li ><a tabindex="-1" href="treat_health"><i class="fa fa-pencil-square-o fa-fw"></i>ติดตามการรักษา</a></li> 
               <li ><a tabindex="-1" href="disease"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลโรค</a></li>
               <li ><a tabindex="-1" href="treat_horn"><i class="fa fa-pencil-square-o fa-fw"></i>การรักษาหลังสูญเขา</a></li>
							<li ><a tabindex="-1" href="treat_num"><i class="fa fa-pencil-square-o fa-fw"></i>การรักษาหลังตีเบอร์</a></li>
							<li ><a tabindex="-1" href="treat_birth"><i class="fa fa-pencil-square-o fa-fw"></i>การรักษาหลังคลอด</a></li>
						
        </c:if>
<%--          <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege == 2}">
               <li><a tabindex="-1" href="treat_test"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกการรักษา</a></li>
        </c:if>  --%>
           <li ><a tabindex="-1" href="list_recommend"><i class="fa fa-search" aria-hidden="true"></i> แนะนำการใช้ยา</a></li>
                <li class="divider"></li>
             <li class="dropdown-submenu" role="menu">
                     <a tabindex="-1" href="#"><i class="fa fa-table fa-fw"></i>ข้อมูลการรักษา</a>
                     <ul class="dropdown-menu">
                        <li><a tabindex="-1" href="treathis"><i class="fa fa-table fa-fw"></i>ข้อมูลการรักษา</a></li>
                    <li><a tabindex="-1" href="diseasesh"><i class="fa fa-table fa-fw"></i>ข้อมูลโรค</a></li>
                     </ul>
                 </li>
             </ul>
     </li>

       <li class="dropdown" role="menu">
             <a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-flask"></i>&nbsp; ยา<b class="caret"></b></a>
             <ul class="dropdown-menu">
          <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">
               <li><a tabindex="-1" href="medicine"><i class="fa fa-pencil-square-o fa-fw"></i>ลงทะเบียนยาใหม่</a></li>
               <!-- <li><a tabindex="-1" href="import_medicine"><i class="fa fa-pencil-square-o fa-fw"></i>นำเข้ายา</a></li> -->
               <li><a tabindex="-1" href="release_medicine"><i class="fa fa-pencil-square-o fa-fw"></i>เบิกยา</a></li>
               <li><a tabindex="-1" href="order_medicine"><i class="fa fa-pencil-square-o fa-fw"></i>สั่งซื้อยา</a></li>
               <li class="divider"></li>
           </c:if>
                 <li ><a tabindex="-1" href="medicinesh"><i class="fa fa-table fa-fw"></i>ข้อมูลยา</a></li>
           </ul>
     </li>

   <!--  น้ำเชื้อ -->
     <!--  <li class="dropdown" role="menu">
             <a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-flask"></i>&nbsp; น้ำเชื้อ/ถังเก็บน้ำเชื้อ<b class="caret"></b></a>
             <ul class="dropdown-menu">
       <li class="dropdown-submenu"><a tabindex="-1"><i class="fa fa-table fa-fw"></i>ลงทะเบียน</a>
         <ul class="dropdown-menu">
                    <li><a tabindex="-1" href="view_semen"><i class="fa fa-pencil-square-o fa-fw"></i>น้ำเชื้อ</a></li>
                        <li><a tabindex="-1" href="view_bucket"><i class="fa fa-pencil-square-o fa-fw"></i>ถังเก็บน้ำเชื้อ</a></li>
                  </ul>
       </li>
               <li><a tabindex="-1" href="stock_semen"><i class="fa fa-pencil-square-o fa-fw"></i>น้ำเชื้อคงคลัง</a></li>
       <li class="dropdown-submenu"><a tabindex="-1"><i class="fa fa-table fa-fw"></i>นำเข้า</a>
         <ul class="dropdown-menu">
                    <li><a tabindex="-1" href="view_semen"><i class="fa fa-pencil-square-o fa-fw"></i>น้ำเชื้อ</a></li>
                        <li><a tabindex="-1" href="view_bucket"><i class="fa fa-pencil-square-o fa-fw"></i>ถังเก็บน้ำเชื้อ</a></li>
                  </ul>
       </li>
               <li><a tabindex="-1" href="release_semen"><i class="fa fa-pencil-square-o fa-fw"></i>เบิกน้ำเชื้อ</a></li>
       <li><a tabindex="-1" href="order_semen"><i class="fa fa-pencil-square-o fa-fw"></i>สั่งซื้อน้ำเชื้อ/ถังเก็บน้ำเชื้อ</a></li>
       <li><a tabindex="-1" href="addnitrogen_bucket"><i class="fa fa-pencil-square-o fa-fw"></i>เติมไนโตรเจนเหลว</a></li>
           </ul>
     </li> -->
<li class="dropdown" role="menu">
						<a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown"><img
								src="<c:url value=  "/resources/img/sperm-m.png"/>"
								style="height: 28px;weight: 27px">&nbsp; น้ำเชื้อ<b class="caret"></b></a>
						<ul class="dropdown-menu">
								<%--&lt;%&ndash;<li class="dropdown-submenu"><a tabindex="-1"><i class="fa fa-table fa-fw"></i>ลงทะเบียน</a>--%>
							<ul class="dropdown-menu">&ndash;%&gt;
									<%--&lt;%&ndash;<li><a tabindex="-1" view_semen="" href="view_semen"><i class="fa fa-pencil-square-o fa-fw"></i>น้ำเชื้อ</a></li>--%>
									<%-- <li><a tabindex="-1" view_bucket="" href="view_bucket"><i class="fa fa-pencil-square-o fa-fw"></i>ถังเก็บน้ำเชื้อ</a></li>--%>
							</ul>
							</li>
								<%--<li><a tabindex="-1" stock_semen="" href="stock_semen"><i class="fa fa-pencil-square-o fa-fw"></i>น้ำเชื้อคงคลัง</a></li>--%>
								<%--<li class="dropdown-submenu"><a tabindex="-1"><i class="fa fa-table fa-fw"></i>นำเข้า</a>
                                    <ul class="dropdown-menu">
                                            <li><a tabindex="-1" view_semen="" href="view_semen"><i class="fa fa-pencil-square-o fa-fw"></i>น้ำเชื้อ</a></li>
                                         <li><a tabindex="-1" view_bucket="" href="view_bucket"><i class="fa fa-pencil-square-o fa-fw"></i>ถังเก็บน้ำเชื้อ</a></li>&ndash;%&gt;
                                       </ul>
                                </li>--%>
							<li><a tabindex="-1" href="view_semen"><i class="fa fa-pencil-square-o fa-fw"></i>ข้อมูลน้ำเชื้อ</a></li>
								<%--<li><a tabindex="-1" order_semen="" href="order_semen"><i class="fa fa-pencil-square-o fa-fw"></i>สั่งซื้อน้ำเชื้อ/ถังเก็บน้ำเชื้อ</a></li>
                                 <li><a tabindex="-1" addnitrogen_bucket="" href="addnitrogen_bucket"><i class="fa fa-pencil-square-o fa-fw"></i>เติมไนโตรเจนเหลว</a></li>--%>
						</ul>
					</li>


 <li class="dropdown" role="menu">
             <a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-paw"></i>&nbsp; โค <b class="caret"></b></a>
             <ul class="dropdown-menu">
             <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">
                <li><a tabindex="-1" href="cattle"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลโค</a></li>
                <li><a tabindex="-1" href="search_pedigree"><i class="fa fa-table fa-fw"></i>ข้อมูลพันธุ์ประวัติโค</a>
               <!--  <li><a tabindex="-1" href="groupcattle"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลฝูงโค</a></li> -->
              </c:if>
               <li class="divider"></li>
               <li ><a tabindex="-1" href="cattlelist"><i class="fa fa-table fa-fw"></i>ข้อมูลโค</a></li>
             </ul>
     </li>

      <li class="dropdown" role="menu">
             <a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-heart"></i>&nbsp; ระบบขยายพันธุ์โค <b class="caret"></b></a>
             <ul class="dropdown-menu">
             <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege == 2 || sessionScope.privilege == 3}">
               <li><a tabindex="-1" href=breeding><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกการผสมพันธุ์</a></li>
               <li ><a tabindex="-1" href="pregnant"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลตรวจท้อง</a></li>
               <li ><a tabindex="-1" href="calve"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลการคลอด</a></li>
               <li ><a tabindex="-1" href="synchroniz"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลการเหนี่ยวนำ</a></li>
             <!--   <li ><a tabindex="-1" href="misscarry"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลโคแท้ง</a></li> -->
              </c:if>
                <li class="divider"></li>
             <li class="dropdown-submenu" role="menu">
                     <a tabindex="-1" href="#"><i class="fa fa-table fa-fw"></i>ระบบขยายพันธุ์โค</a>
                     <ul class="dropdown-menu">
                        <li><a tabindex="-1" href="breeding_list"><i class="fa fa-table fa-fw"></i>ข้อมูลการผสมพันธุ์</a></li>
                    <li><a tabindex="-1" href="pregnant_list"><i class="fa fa-table fa-fw"></i>ข้อมูลการตรวจท้อง</a></li>
                    <li><a tabindex="-1" href="calve_list"><i class="fa fa-table fa-fw"></i>ข้อมูลการคลอด</a></li>
                    <li><a tabindex="-1" href="synchroniz_list"><i class="fa fa-table fa-fw"></i>ข้อมูลการเหนี่ยวนำ</a></li>
                  <!--   <li><a tabindex="-1" href="misscarry_list"><i class="fa fa-table fa-fw"></i>ข้อมูลโคแท้ง</a></li> -->
                     </ul>
                 </li>
             </ul>
     </li>
<li class="dropdown" role="menu">
						<a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown"><img
								src="<c:url value=  "/resources/img/missac-m.png"/>"
								style="height: 28px;weight: 27px">&nbsp; โคแท้ง <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li ><a tabindex="-1" href="misscarry"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลโคแท้ง</a></li>
							<li><a tabindex="-1" href="misscarry_list"><i class="fa fa-table fa-fw"></i>ข้อมูลโคแท้ง</a></li>
						</ul>
					</li>
     <li class="dropdown" role="menu">
             <a tabindex="-1" href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-stethoscope"></i>&nbsp; ลูกโค<b class="caret"></b></a>
             <ul class="dropdown-menu">
             <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">
               <li><a tabindex="-1" href="horndeter"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลสูญเขา</a></li>
               <li ><a tabindex="-1" href="wean"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลหย่านม</a></li>
               <li ><a tabindex="-1" href="numbercat"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกข้อมูลตีเบอร์</a></li>
               <li ><a tabindex="-1" href="weight"><i class="fa fa-pencil-square-o fa-fw"></i>บันทึกน้ำหนักโค 1 ปี</a></li>
              </c:if>
                <li class="divider"></li>
             <li class="dropdown-submenu" role="menu">
                     <a tabindex="-1" href="#"><i class="fa fa-table fa-fw"></i>ข้อมูลการรักษา</a>
                     <ul class="dropdown-menu">
                        <li><a tabindex="-1" href="horndeter_list"><i class="fa fa-table fa-fw"></i>ข้อมูลการสูญเขา</a></li>
                    <li><a tabindex="-1" href="wean_list"><i class="fa fa-table fa-fw"></i>ข้อมูลการหย่านม</a></li>
                    <li><a tabindex="-1" href="numbercat_list"><i class="fa fa-table fa-fw"></i>ข้อมูลการตีเบอร์</a></li>
                    <li><a tabindex="-1" href="weight_list"><i class="fa fa-table fa-fw"></i>ข้อมูลน้ำหนัก 1 ปี</a></li>
                     </ul>
                 </li>
             </ul>
     </li>
     <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">
         <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-exclamation-triangle"></i> การแจ้งเตือน<b class="caret"></b></a>
               <ul class="dropdown-menu">
               <li><a href="alert_list">ตั้งค่าการแจ้งเตือน</a></li>
               </ul>
         </li>
       </c:if>

       <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">
         <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-file-text"></i> ออกรายงาน<b class="caret"></b></a>
               <ul class="dropdown-menu">
<!-- 					<li><a href="report">ออกรายงานTest</a></li> -->
         <li><a href="report_1">ออกรายงาน</a></li>
         </ul>
     </li>
   </c:if>

      <c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">
       <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cogs"></i> ตั้งค่า <b class="caret"></b></a>
                 <ul class="dropdown-menu">
                   <li	><a href="set_alert">ตั้งค่าการแจ้งเตือน</a></li>
                   <li	><a href="set_sync">ตั้งค่าการเหนี่ยวนำ</a></li>
                   <li	><a href="set_brand">ตั้งค่าแบรนด์</a></li>
                   <c:if test="${sessionScope.privilege == 1}">
                 <li><a href="set_member">จัดการข้อมูลสมาชิก</a></li>
               </c:if>
                <!--    <li class="divider"></li> -->
                   <li class="dropdown-submenu" role="menu">
                             <a tabindex="-1" href="#"></i>ตั้งค่าอื่นๆ</a>
                         <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="set_medicine"></i>ตั้งค่ากลุ่มยา</a></li>
                        <li><a tabindex="-1" href="set_statusbreed">ตั้งค่าสายพันธุ์</a></li>
                        <li><a tabindex="-1" href="set_color">ตั้งค่าสีโค</a></li>
                     <!-- <li><a tabindex="-1" href="set_synchroniz">ตั้งค่าการเหนี่ยวนำ</a></li>  -->


                         </ul>
                     </li>
                   </ul>
           </li>
       </c:if>



   <%-- c:if test="${m.privilege.id == 1}">
   <li><a href="#">+ADMIN+</a></li>
   </c:if> --%>
 </ul>

<%--  	<ul class="nav navbar-nav">
   <c:if test="${m.privilege.id == 2}">
   <li><a href="#">+คนนอก+</a></li>
   </c:if>
 </ul>

 <ul class="nav navbar-nav">
   <c:if test="${m.privilege.id == 1 || 2}">
   <li><a href="#">+คนนอก+</a></li>
   </c:if>
 </ul>    --%>

   <ul class="nav navbar-nav navbar-right">
   <div class="navbar-header">
   <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-5">
           <span class="sr-only">Toggle navigation</span>
         </button>
       </div>
         <li><a href="member">${m.first}&nbsp; ${m.last }</a></li>
            <li ><a href="logout"><i class="fa fa-sign-out"></i> ออกจากระบบ</a></li>
      </ul>
    </c:forEach>
 </c:if>

</div>
</nav> </header>
 <div class="container">
     <form action="login" method="POST" id="loginForm">
   <!-- modal -->
   <div id="login" class="modal fade">
     <div class="modal-dialog">
       <div class="modal-content">
         <div class="modal-header">
           <button type="button" class="close" data-dismiss="modal"
             aria-hidden="true"></button>
           <h3 class="modal-title">เข้าสู่ระบบ</h3>
         </div>
         <div class="modal-body">

           <div class="row form-group">
             <div class="col-md-offset-2 col-md-2">
               <h4>ชื่อผู้ใช้:</h4>
             </div>
             <div class="col-md-6">
               <input type="text" name="username" class="form-control" id="username" placeholder="username...">
             </div>
           </div>
           <div class="row form-group">
             <div class="col-md-offset-2 col-md-2">
               <h4>รหัสผ่าน:</h4>
             </div>
             <div class="col-md-6">
               <input type="password" name="password" class="form-control" id="password" placeholder="password...">

             </div>
           </div>
             <div class="text-center"><p id="demo" style="color:red;"></p></div>
         </div>
         <div class="modal-footer">
           <button type="submit" class="btn btn-primary" id="login">ล็อคอิน</button>
           <button type="button" class="btn btn-default" data-dismiss="modal">ปิด</button>

         </div>
       </div>
     </div>
   </div>
   <!-- modal -->
 </form>
 </div>


<script type="text/javascript"> //ปรับให้เป็นค่าว่างตอนกรอก login ไม่สำเร็จ
$('#login').on('hide.bs.modal', function(e) {
   document.getElementById("loginForm").reset();
});
</script>

<!-- <script type="text/javascript">

$(document).on('click','#btn_login',function(e){

 $.post('checkLogin',{username:$("#username").val(),password:$('#password').val()},function(msg){
   if(msg=="yes"){
     $.ajax({
       url:'login',
       type:'POST',
       data:{
         username:$("#username").val(),
         password:$('#password').val(),

       },success : function (result) {
         window.location.href="index";
       },error: function(result){
         swal("Oops...", "Something went wrong!", "error");
       }

     });
   }
   else
   {
     document.getElementById("demo").innerHTML = "Username Or Password Incorrect";

   }
 });
 e.preventDefault();
});



 $('#login').on('hide.bs.modal',function (e){
   document.getElementById("loginForm").reset();
   document.getElementById("demo").innerHTML = null;
 });
</script> -->


</body>
</html>
