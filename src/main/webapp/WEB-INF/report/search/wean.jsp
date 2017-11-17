<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes.jsp"%>    
<%int i=1; %>		
							<thead>
								<tr>
									<th style="width: 55px;">ลำดับที่</th>
									<th style="width: 190px;">เบอร์แรกเกิด</th>
									<th style="width: 190px;">วัน/เดือน/ปี ที่หย่านม</th>
									<th>น้ำหนักหย่านม</th>
									<th>ผู้บันทึก</th>

								</tr>
							</thead>
								<tbody style="text-align: center;">
						<c:forEach items="${wean }" var="wea">
									<tr>
										<td><%=i++ %></td>
										<td>${wea.cattle.numDate }</td>
										<td>${wea.date }</td>
										<td>${wea.weigthwean }</td>					
										<td>${wea.member.first }&nbsp;${wea.member.last }</td>
									</tr>
								</c:forEach>			
<input type="hidden" id="count" value="${count}">
