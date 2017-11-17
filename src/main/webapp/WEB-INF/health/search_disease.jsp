<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
								<c:forEach items="${dis }" var="dis">
									<tr>
										<td><%=i++ %></td>
										<td>${dis.nameDisease }</td>
										<td>${dis.symptomsOfDisease }</td>
										<td>${dis.cableDisease.value }</td>
										<td>${dis.member.first }&nbsp;${dis.member.last }</td>
										<td>
										<form:form action="diseasedetail?id=${dis.id }" method="POST" commandName="sh">
												<button type="submit" class="btn btn-success">
												<i class="fa fa-search-plus"></i>
												</button>
											</form:form>
										</td>
										
							<c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">			
										<td>
										<form:form action="edit_disase?id=${dis.id }" method="POST" commandName="sh">
												<button type="submit" class="btn btn-primary">
												<i class="glyphicon glyphicon-pencil"></i>
												</button>
											</form:form>
										</td>										
										<td>
										<button class="btn btn-danger"	value="${dis.id }" onclick="chkdel(this.value)">
												<i class="glyphicon glyphicon glyphicon-remove"></i>
										</button>
										</td>
							</c:if>			
									</tr>
								</c:forEach>
<!-- <tr>
<td colspan="7"><br></td>
</tr> -->
<input type="hidden" id="countPage" value="${count}"/>
<input type="hidden" id="Page" value="${page}"/>

