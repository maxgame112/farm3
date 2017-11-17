<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/includes.jsp"%>

<c:if test="${page1.page!= 0 && page1.pageFinal!=0}">
<button class="btn btn-primary" style="border-radius: 0px; -webkit-user-select: none;">หน้าที่ ${page1.page} จาก  ${page1.pageFinal}</button>
</c:if>
<c:if test="${page1.pageFirst!= 0}">
<button class="btn btn-primary" id="pageNum1" style="border-radius: 0px;" value="${page1.pageFirst}">หน้าแรก</button>
</c:if>
<c:if test="${page1.pageFirst1!= 0}">
<button class="btn btn-primary" id="pageNum1" style="border-radius: 0px;" value="${page1.pageFirst1}"><<  กลับ</button>
</c:if>
<c:if test="${page1.pagePrevious!= 0}">
<button class="btn btn-default" id="pageNum1" style="border-radius: 0px;" value="${page1.pagePrevious}">${page1.pagePrevious}</button>
</c:if>
<c:if test="${page1.pagePrevious1!= 0}">
<button class="btn btn-default" id="pageNum1" style="border-radius: 0px;" value="${page1.pagePrevious1}">${page1.pagePrevious1}</button>
</c:if>
<c:if test="${page1.pagePresent!= 0}">
<button class="btn btn-default " id="pageNum1" style="border-radius: 0px;" value="${page1.pagePresent}">${page1.pagePresent}</button>
</c:if>
<c:if test="${page1.pageNext!= 0}">	
<button class="btn btn-default" id="pageNum1" style="border-radius: 0px;" value="${page1.pageNext}">${page1.pageNext}</button>
</c:if>
<c:if test="${page1.pageNext1!= 0}">	
<button class="btn btn-default" id="pageNum1" style="border-radius: 0px;" value="${page1.pageNext1}">${page1.pageNext1}</button>
</c:if>
<c:if test="${page1.pageLast!= 0}">
<button class="btn btn-primary"  id="pageNum1" style="border-radius: 0px;" value="${page1.pageLast}">ต่อไป  >></button>  
</c:if>
<c:if test="${page1.pageLast1!= 0}">
<button class="btn btn-primary" id="pageNum1" style="border-radius: 0px;" value="${page1.pageLast1}">หน้าสุดท้าย</button>
</c:if>


