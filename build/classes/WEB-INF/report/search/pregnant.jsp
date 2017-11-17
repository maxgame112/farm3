<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
				<thead >
								<tr>
									<th>ลำดับที่</th>
									<th>หมายเลขแม่พันธุ์</th>
									<th>วันที่ตรวจท้อง</th>
									<th>สถานะการตรวจท้อง</th>
								</tr>
							</thead> 
								<tbody style="text-align: center;">
									<c:forEach items="${preg }" var="preg" >

									<tr>
									<td><%=i++%></td>
									<td>${preg.breeding.cattleByCattlemaId.num }</td>
									<td>${preg.datePreg }</td>
									<td>${preg.statusPregnant.value }</td>
									
									</tr>
</c:forEach>
								</tbody>				
<input type="hidden" id="count" value="${count}">