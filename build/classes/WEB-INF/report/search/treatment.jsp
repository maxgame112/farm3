<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
				<thead >
								<tr>
									<th>ลำดับที่</th>
									<th>หมายเลขโค</th>
									<th>วันที่</th>
									<th>อาการของโรค</th>
									<th>โรคที่ป่วย</th>
									<th>ยาที่ใช้รักษา</th>
								</tr>
							</thead> 
								<tbody style="text-align: center;">
									<c:forEach items="${treat }" var="treat" >

									<tr>
									<td><%=i++%></td>
									<td>${treat.cattle.num }</td>
									<td>${treat.dateTreat }</td>
									<td>${treat.causeOfIllness }</td>
									<td>${treat.disease.nameDisease }</td>
									<td>${treat.medicine.tradeName}</td>
									</tr>
</c:forEach>
								</tbody>				
<input type="hidden" id="count" value="${count}">
