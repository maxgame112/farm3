<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
<c:forEach items="${memList }" var="m">
						<tr>
							<td><%=i++%></td>						
				    		<td>${m.first}</td>	   	
				        	<td>${m.last}</td>
				        	<td>${m.username}</td>
				        	<td>${m.address}</div></td>	
				        	<td>${m.tel}</td>	
				        	<td>${m.email}</td>
				        	<td>
				        	${m.privilege.value }
				   			</td>	
				   		<td>
				   		<form:form action="edit_member" method="POST" >
				   		<input id="id" name="id" type="hidden"  value="${m.id}">
				   			<button name="action"  class="btn btn-primary">
												<i class="glyphicon glyphicon-pencil"></i>
											</button>
											</form:form>
				   		</td>
				   		<td><button class="btn btn-danger"	value="${m.id }" onclick="chkdel(this.value)">
								<i class="glyphicon glyphicon glyphicon-remove"></i>
							</button>
						</td>
						</tr>
</c:forEach>

<input type="hidden" id="countPage" value="${count}"/>
<input type="hidden" id="Page" value="${page}"/>