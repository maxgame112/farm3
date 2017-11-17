<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
							<thead>
								<tr>
									<th>ลำดับที่</th>
									<th>หมายเลขแม่พันธุ์</th>
									<th>ครั้งที่แท้ง</th>
									<th>วัน/เดือน/ปี ที่แท้ง</th>
									<th>ผู้บันทึก</th>


								</tr>
							</thead>
								<tbody style="text-align: center;">
%>
								<c:forEach items="${miss }" var="miss">
									<tr>
										<td><%=i++ %></td>
										<td>${miss.cattle.num }</td>
										<td>${miss.countMisscarry }</td>
										<td>${miss.day }</td>
										<td>${miss.member.first }&nbsp;${miss.member.last  }</td>
							
									</tr>
								</c:forEach>
<input type="hidden" id="count" value="${count}">
