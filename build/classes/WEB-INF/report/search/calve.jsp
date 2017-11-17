<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
				<thead >
								<tr>
									<th>ลำดับที่</th>
									<th>หมายเลขแม่พันธุ์</th>
									<th>หมายเลขพ่อพันธุ์</th>
									<th>หมายเลขแรกเกิดลูกโค</th>
									<th>วัน/เดือน/ปี  เกิด</th>
								</tr>
							</thead> 
								<tbody style="text-align: center;">
									<c:forEach items="${calve }" var="calve" >

									<tr>
									<td><%=i++%></td>
									<td>${calve.maId }</td>
									<td>${calve.faId }</td>
									<td>${calve.numDate }</td>
									<td>${calve.calved }</td>
									</tr>
</c:forEach>
								</tbody>				
<input type="hidden" id="count" value="${count}">