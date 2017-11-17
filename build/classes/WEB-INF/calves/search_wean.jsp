<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
<c:forEach items="${Listwean }" var="wea">
									<tr>
										<td><%=i++ %></td>
										<td>${wea.cattle.numDate }</td>
										<td>${wea.date }</td>
										<td>${wea.weigthwean }</td>					
										<td>${wea.member.first }&nbsp;${wea.member.last }</td>
									</tr>
								</c:forEach>
<input type="hidden" id="countPage" value="${count}"/>
<input type="hidden" id="Page" value="${page}"/>