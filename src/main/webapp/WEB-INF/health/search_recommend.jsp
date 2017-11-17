<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
								<c:forEach items="${disease }" var="dis">
									<tr>
										<td><%=i++ %></td>
										<td>${dis.nameDisease }</td>
										<td>${dis.symptomsOfDisease }</td>
										<td>${dis.cableDisease.value }</td>
										<td>${dis.causeOfTheDisease}</td>										
		
									</tr>
								</c:forEach>
								
								
<%-- 								<c:forEach items="${medicine }" var="med">
						<tr>
							<td><%=i++%></td>						
				    		<td>${med.tradeName }</td>
				    		<td>${med.properties }</td>	
				    		<td>${med.properties }</td>	   	
				        	<td>${med.properties }</td>	
						</tr>
				</c:forEach> --%>
							
				
<!-- <tr>
<td colspan="7"><br></td>
</tr> -->
<input type="hidden" id="countPage" value="${count}"/>
<input type="hidden" id="Page" value="${page}"/>




