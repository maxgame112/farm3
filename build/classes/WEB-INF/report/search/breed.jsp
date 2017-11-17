<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
							<thead>
								<tr>
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 190px;">หมายเลขแม่พันธุ์</th>
									<th style="width: 190px;">หมายเลขพ่อพันธุ์</th>
									<th style="width: 190px;">วัน/เดือน/ปี ที่ผสม</th>
									<th>ผู้บันทึก</th>


								</tr>
							</thead> 
								<tbody style="text-align: center;">
									<c:forEach items="${breed }" var="breeding" >

									<tr>
									<td><%=i++ %></td>
										<td>${breeding.cattleByCattlemaId.num }</td>
										<td>${breeding.cattleByCattlefaId.num }</td>
										<td>${breeding.date }</td>
										<td>${breeding.member.first }&nbsp;${breeding.member.last  }</td>
									</tr>
</c:forEach>
								</tbody>				
<input type="hidden" id="count" value="${count}">