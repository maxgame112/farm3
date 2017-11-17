<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
								<c:forEach items="${sync }" var="synchroniz">
									<tr>
										<td><%=i++ %></td>
										<td>${synchroniz.cattle.num }</td>
										<td>${synchroniz.typeSync.value }</td>
										<td>${synchroniz.dateSync }</td>
										<td>${synchroniz.member.first }&nbsp;${synchroniz.member.last }</td>
									
							
									</tr>
								</c:forEach>
<!-- <tr>
<td colspan="7"><br></td>
</tr> -->
<input type="hidden" id="countPage" value="${count}"/>
<input type="hidden" id="Page" value="${page}"/>