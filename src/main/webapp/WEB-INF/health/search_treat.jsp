<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
								<c:forEach items="${treat }" var="treatment">
									<tr>
										<td><%=i++ %></td>
										<td >${treatment.cattle.num }</td>
										<td>${treatment.dateTreat}</td>	
										
										<td>${treatment.causeOfIllness }</td>
										<td>${treatment.disease.nameDisease }</td>
										<td>${treatment.medicine.tradeName}</td>										
														</tr>
								</c:forEach>

<!-- <tr>
<td colspan="7"><br></td>
</tr> -->
<input type="hidden" id="countPage" value="${count}"/>
<input type="hidden" id="Page" value="${page}"/>