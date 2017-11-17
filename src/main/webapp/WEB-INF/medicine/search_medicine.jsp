<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
							<c:forEach items="${medi}" var="medicine">
									<tr>
										<td><%=i++%></td>
																			
										<td>${medicine.commonName}</td>
										<td>${medicine.tradeName}</td>	
										
										<td>${medicine.groupMedicine.value}</td>
										<td>${medicine.properties}</td>
										<td>
										<form:form action="medicinedetail?id=${medicine.id }" method="POST" commandName="sh">
												<button type="submit" class="btn btn-success">
												<i class="fa fa-search-plus"></i>
												</button>
											</form:form>
										</td>
						<c:if test="${sessionScope.privilege == 1 || sessionScope.privilege ==2 || sessionScope.privilege ==3}">				
										<td>
										<form:form action="edit_medicine?id=${medicine.id }" method="POST" commandName="sh">
												<button type="submit" class="btn btn-primary">
												<i class="glyphicon glyphicon-pencil"></i>
												</button>
											</form:form>
										</td>	

										<td>
										<button class="btn btn-danger"	value="${medicine.id }" onclick="chkdel(this.value)">
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