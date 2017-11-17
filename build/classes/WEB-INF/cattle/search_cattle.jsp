<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
								<c:forEach items="${cattle }" var="cattle">
									<tr>
										<td><%=i++ %></td>
										<td>${cattle.num }</td>
										<td>${cattle.numDate }</td>										
										<td>${cattle.name }</td>
										<td>${cattle.calved }</td>
										<td>${cattle.statusBreed.value }</td>
										<td>${cattle.color.nameColor }</td>
										<td>
											<form:form action="cattleDetail?id=${cattle.id }" method="POST" >
												<button type="submit" class="btn btn-success">
												<i class="fa fa-search-plus"></i>
												</button>
											</form:form>
										</td>
								<c:if test="${sessionScope.privilege == 1 || sessionScope.privilege == 2 || sessionScope.privilege == 3}">		
										<td>
										<form:form action="edit_cattle?id=${cattle.id }" method="POST" >
												<button type="submit" class="btn btn-primary">
												<i class="glyphicon glyphicon-pencil"></i>
												</button>
										</form:form>
										</td>	
			 							
										<%-- <td>
										<form:form action="groupcattle?id=${cattle.id }" method="POST" >
												<button type="submit" class="btn btn-danger">
												<i class="glyphicon glyphicon-remove"></i>
												</button>
										</form:form>
										</td> --%>
										
									
								</c:if>		
								<c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">				
										

										<td>
										<button class="btn btn-danger"	value="${cattle.id }" onclick="catdel(this.value)">
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