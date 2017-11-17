<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<%
int a = (int)request.getAttribute("page1");
	a=(a-1)*10;
int i=1+a; 
%>
<c:forEach items="${medicine }" var="med">
						<tr>
							<td><%=i++%></td>						
				    		<td>${med.tradeName }</td>
				    		<td>${med.commonName }</td>	
				    		<td>${med.groupMedicine.value }</td>	   	
				        	<td>${med.properties }</td>	
						</tr>
						</c:forEach>
<input type="hidden" id="countPage1" value="${count1}"/>
<input type="hidden" id="Page1" value="${page1}"/>