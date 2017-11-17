<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>
<%
int a = (int)request.getAttribute("page");
	a=(a-1)*10;
int i=1+a; 
%>
								<c:forEach items="${alertlist }" var="alertlist">
									<tr>
										<td><%=i++ %></td>
										<td>${alertlist.cattle_1 }</td>
										<td>${alertlist.typeAlert.name }</td>
										<td>${alertlist.datealert }</td>
									<c:if test="${sessionScope.privilege != null}">
										<td>
										  <input type="hidden" name="check" id="check[${alertlist.id }]" value="1"/>
							  				<input type="hidden" name="id" id="id" value="${alertlist.id}"/>
										    <label class="checkbox">
							  				<input type="checkbox" name="check" id="chk"  data-toggle="checkbox" onclick="Javascript: if(this.checked){document.getElementById('check[${alertlist.id }]').disabled = true;}else{document.getElementById('check[${alertlist.id }]').disabled = false;}" 
							 				 value="2" />
							 				 </label>
										</td>
									</c:if>
									</tr>
								</c:forEach>
<!-- <tr>
<td colspan="7"><br></td>
</tr> -->
 <input type="hidden" name="num" id="num" value="${num}"/>
<input type="hidden" id="countPage" value="${count}"/>
<input type="hidden" id="Page" value="${page}"/>