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
    <title>ใบเบิกน้ำเชื้อ</title>
</head>
<body>
<%@ include file="../menu.jsp"%>
<br><br>
<div id="wrapper">
    <div id="content">
        <div class="container">
            <div class="col-md-3">
                <div class="jumbotron" style="background-color: rgb(218, 68, 83)"
                     align="center">
                    <p style="font-size: 28px; font-weight: 700; color: white;">บันทึกใบเบิกน้ำเชื้อ</p>
                </div>
            </div>
            <div class="row">
                <hr>
            </div>
            <br> <br>
            <div class="row form-group">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <span class="fa fa-list-alt fa-lg"></span> บันทึกใบเบิกยา</a>
                        </h4>
                    </div>

                    <div class="panel-body">



                        <form action="disease" method="POST"  id="disease"
                              modelAttribute="disease"  commandName="sh" >
                            <div class="row form-group ">
                                <div class="col-md-6 ">
                                    <fieldset><br>

                                        <div class="row form-group">
                                            <label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> วันที่เบิก</label>
                                            <div class="col-md-6">
                                                <input name="date" id="date" type="date" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> หมายเลขน้ำเชื้อ/ชื่อพ่อพันธุ์</label>
                                            <div class="col-md-6">
                                                <div>
                                                    <select class="form-control" id="typeCattle.id" path="typeCattle.id">
                                                        <option value="">หมายเลขน้ำเชื้อ/ชื่อพ่อพันธุ์</option>
                                                        <c:forEach items="${type}" var="typecat">
                                                            <c:if test="${typeCattle.id == typecat.id }">
                                                                <option value="${typeCattle.id}" selected="selected">${typecat.value}</option></c:if>

                                                            <c:if test="${typeCattle.id != typecat.id }">
                                                                <option value="${typecat.id }">${typecat.value}</option>
                                                            </c:if>

                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> เบอร์ประจำตัวพ่อพันธุ์</label>
                                            <div class="col-md-6">
                                                <div>
                                                    <select class="form-control" id="typeCattle.id" path="typeCattle.id">
                                                        <option value="">เบอร์ประจำตัวพ่อพันธุ์</option>
                                                        <c:forEach items="${type}" var="typecat">
                                                            <c:if test="${typeCattle.id == typecat.id }">
                                                                <option value="${typeCattle.id}" selected="selected">${typecat.value}</option></c:if>

                                                            <c:if test="${typeCattle.id != typecat.id }">
                                                                <option value="${typecat.id }">${typecat.value}</option>
                                                            </c:if>

                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <label class="col-md-offset-s col-md-3 control-label"><font color="red">*</font> สายพันธุ์</label>
                                            <div class="col-md-6">
                                                <div>
                                                    <select class="form-control" id="statusBreed.id" path="Breed.id">
                                                        <option value="0">สายพันธุ์</option>
                                                        <c:forEach items="${stabreed}" var="stabreed">
                                                            <c:if test="${Breed.id == stabreed.id }">
                                                                <option value="${Breed.id}" selected="selected">${stabreed.value}</option></c:if>

                                                            <c:if test="${Breed.id != stabreed.id }">
                                                                <option value="${stabreed.id }">${stabreed.value}</option>
                                                            </c:if>

                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                    </fieldset>
                                </div>
                                <div class="col-md-4 ">
                                    <fieldset><br>
                                        <div class="row form-group">
                                            <label class="col-md-offset-s col-md-5 control-label"><font color="red">*</font> หน่วยที่ใช้ในคลัง</label>
                                            <div class="col-md-6">
                                                <div>
                                                    <select class="form-control" id="UnitMedicine.id"
                                                            path="UnitMedicine.id">
                                                        <option value="0">เลือกหน่วยสำหรับใช้ในคลัง</option>
                                                        <c:forEach items="${un}" var="un">
                                                            <c:if test="${UnitMedicine.id == un.id }">
                                                                <option value="${un.id}" selected="selected">${un.value}</option></c:if>

                                                            <c:if test="${UnitMedicine.id != un.id }">
                                                                <option value="${un.id }">${un.value}</option>
                                                            </c:if>

                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <label class="col-md-offset-s col-md-5 control-label"><font color="red">*</font> ชื่อผู้เบิก</label>
                                            <div class="col-md-6">
                                                <div>
                                                    <select class="form-control" id="member.id" path="member.id">
                                                        <option value="0">ผุ้เบิก</option>
                                                        <c:forEach items="${ulist}" var="user">
                                                            <c:if test="${member.id == user.id }">
                                                                <option value="${un.id}" selected="selected">${user.first}&nbsp;${user.last }</option></c:if>

                                                            <c:if test="${member.id != user.id }">
                                                                <option value="${user.id }">${user.first}&nbsp;${user.last }</option>
                                                            </c:if>

                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <%--<div class="row form-group">
                                            <label class="col-md-offset-s col-md-5 control-label"><font color="red"></font> หมายเหตุ</label>
                                            <div class="col-md-6">
                                                <textarea rows="3	" cols="45" type="text" class="form-control" id="note"></textarea>
                                            </div>
                                        </div>--%>

                                    </fieldset>
                                </div>
                            </div>
                            <%--</form:form>--%>
                    </div>

                    <div class="col-md-offset-8">
                        <button name="action" value="Add" id="add" onclick="addmm()"
                                class="btn btn-success btn-lg">
                            <i class="fa fa-save fa-lg"></i>&nbsp; บันทึกข้อมูล
                        </button>


                        <a><button name="action" value="cancel" onclick="cancel1()"
                                   class="btn btn-danger btn-lg">
                            <i class="fa fa-times fa-lg"></i>&nbsp; ยกเลิก
                        </button>	<br><br><br>	</a>
                    </div>
                </div>
            </div>
            <div>
            </div>

        </div>

    </div>

</div>
<%@ include file="../footer.jsp"%>

<script type="text/javascript">
    function cancel1() {
        location.reload();
    }

    // ยืนยันบันทึก
    function addmm(){
        swal({	title: "ยืนยันบันทึกข้อมูล?",
                text: "คุณต้องการยืนยันบันทึกข้อมูลยาหรือไม่!",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#55c7dd",
                confirmButtonText: "ต้องการ",
                cancelButtonText: "ไม่ต้องการ",
                closeOnConfirm: false,
                closeOnCancel: false },
            function(isConfirm){
                if (isConfirm) {
                    if($("#nameSemen").val() == ""){
                        swal("กรุณากรอกชื่อยา");
                    }else   if($("#symptomsOfSemen").val() == ""){
                        swal("กรุณากรอกอาการของโรค");
                    }else if($("#causeOfTheSemen").val() == ""){
                        swal("กรุณากรอกสาเหตุของโรค");
                    }else if($("#cableSemen\\.id").val() == "0"){
                        swal("กรุณาเลือกประเภทของโรค");
                    }else if($("#member\\.id").val() == "0"){
                        swal("กรุณากรอกผู้บันทึก");
                    }else{

                        $.post('adddisease',$("#form_semen").serialize(),
                            function (result) {
                                swal({	title: "สำเร็จ!",
                                    /* text: "หมายเลขยา "+result,  */
                                    timer: 2000,
                                    type: "success",
                                    showConfirmButton: false
                                });
                                setInterval(function(){location.reload()}, 2000);
                            })
                    }
                } else {
                    swal({	title: "Cancelled!",
                        text: "คุณได้ยกเลิกการบันทึกข้อมูล",
                        timer: 1000,
                        type: "error",
                        showConfirmButton: false
                    });
                }
            }
        );
    }

</script>


</body>
</html>