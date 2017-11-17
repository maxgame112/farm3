<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
							<thead>
								<tr>
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 190px;">หมายเลขโค</th>
									<th style="width: 190px;">เบอร์แรกเกิด</th>									
									<th style="width: 190px;">วัน/เดือน/ปี ที่ตีเบอร์</th>
									<th>ผู้บันทึก</th>

								</tr>
							</thead>
								<tbody style="text-align: center;">
							<c:forEach items="${numcat }" var="number">
									<tr>
										<td><%=++i %></td>
										<td>${number.cattle.num }</td>
										<td>${number.cattle.numDate }</td>
										<td>${number.date }</td>									
										<td>${number.member.first }&nbsp;${number.member.last }</td>
									</tr>
								</c:forEach>		
<input type="hidden" id="count" value="${count}">
