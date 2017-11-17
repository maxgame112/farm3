<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/includes.jsp"%>

<c:if test="${page.page!= 0 && page.pageFinal!=0}">
<button class="btn btn-info" style="border-radius: 0px; -webkit-user-select: none;">หน้าที่ ${page.page} จาก  ${page.pageFinal}</button>
</c:if>
<c:if test="${page.pageFirst!= 0}">
<button class="btn btn-info" id="pageNum" style="border-radius: 0px;" value="${page.pageFirst}">หน้าแรก</button>
</c:if>
<c:if test="${page.pageFirst1!= 0}">
<button class="btn btn-info" id="pageNum" style="border-radius: 0px;" value="${page.pageFirst1}"><<  กลับ</button>
</c:if>
<c:if test="${page.pagePrevious!= 0}">
<button class="btn btn-default" id="pageNum" style="border-radius: 0px;" value="${page.pagePrevious}">${page.pagePrevious}</button>
</c:if>
<c:if test="${page.pagePrevious1!= 0}">
<button class="btn btn-default" id="pageNum" style="border-radius: 0px;" value="${page.pagePrevious1}">${page.pagePrevious1}</button>
</c:if>
<c:if test="${page.pagePresent!= 0}">
<button class="btn btn-default " id="pageNum" style="border-radius: 0px;" value="${page.pagePresent}">${page.pagePresent}</button>
</c:if>
<c:if test="${page.pageNext!= 0}">	
<button class="btn btn-default" id="pageNum" style="border-radius: 0px;" value="${page.pageNext}">${page.pageNext}</button>
</c:if>
<c:if test="${page.pageNext1!= 0}">	
<button class="btn btn-default" id="pageNum" style="border-radius: 0px;" value="${page.pageNext1}">${page.pageNext1}</button>
</c:if>
<c:if test="${page.pageLast!= 0}">
<button class="btn btn-info"  id="pageNum" style="border-radius: 0px;" value="${page.pageLast}">ต่อไป  >></button>  
</c:if>
<c:if test="${page.pageLast1!= 0}">
<button class="btn btn-info" id="pageNum" style="border-radius: 0px;" value="${page.pageLast1}">หน้าสุดท้าย</button>
</c:if>


