<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
							<thead>
								<tr>
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 190px;">หมายเลขโค</th>
									<th style="width: 190px;">โปรแกรมที่ใช้</th>
									<th style="width: 190px;">วัน/เดือน/ปี ที่ตรวจ</th>
									<th>ผู้บันทึก</th>

								</tr>
							</thead>
								<tbody style="text-align: center;">
								<c:forEach items="${sync }" var="synchroniz">
									<tr>
										<td><%=i++ %></td>
										<td>${synchroniz.cattle.num }</td>
										<td>${synchroniz.typeSync.value }</td>
										<td>${synchroniz.dateSync }</td>
										<td>${synchroniz.member.first }&nbsp;${synchroniz.member.last }</td>
									
							
									</tr>
								</c:forEach>
								</tbody>				
<input type="hidden" id="count" value="${count}">