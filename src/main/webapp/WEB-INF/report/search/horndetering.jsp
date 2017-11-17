<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
							<thead>
								<tr>
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 190px;">เบอร์แรกเกิด</th>
									<th style="width: 190px;">วัน/เดือน/ปี ที่สูญเขา</th>
									<th>วิธีที่ใช้การสูญเขา</th>
									<th>ผู้บันทึก</th>

								</tr>
							</thead>
								<tbody style="text-align: center;">
							<c:forEach items="${horn }" var="horn">
									<tr>
										<td><%=i++ %></td>
										<td>${horn.cattle.numDate }</td>
										<td>${horn.date }</td>
										<td>${horn.typeHorn.value }</td>									
										<td>${horn.member.first }&nbsp;${horn.member.last }</td>
									</tr>
								</c:forEach>
								</tbody>				
<input type="hidden" id="count" value="${count}">