<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
<c:forEach items="${ListStam }" var="number">
									<tr>
										<td><%=++i %></td>
										<td>${number.cattle.num }</td>
										<td>${number.cattle.numDate }</td>
										<td>${number.date }</td>									
										<td>${number.member.first }&nbsp;${number.member.last }</td>
									</tr>
								</c:forEach>
<input type="hidden" id="countPage" value="${count}"/>
<input type="hidden" id="Page" value="${page}"/>