<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
							<thead>
								<tr>
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 190px;">หมายเลขโค</th>
									<th style="width: 190px;">วัน/เดือน/ปี</th>
									<th>น้ำหนัก  1 ปี</th>
									<th>ผู้บันทึก</th>

								</tr>
							</thead>
								<tbody style="text-align: center;">
					<c:forEach items="${weight }" var="horn">
									<tr>
										<td><%=i++ %></td>
										<td>${horn.cattle.num }</td>
										<td>${horn.date }</td>
										<td>${horn.weightyear }</td>									
										<td>${horn.member.first }&nbsp;${horn.member.last }</td>
									</tr>
								</c:forEach>	
<input type="hidden" id="count" value="${count}">
