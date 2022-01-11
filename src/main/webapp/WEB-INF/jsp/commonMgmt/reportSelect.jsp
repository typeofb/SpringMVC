<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<select id="selArea" name="selArea" onchange="fnSelectTag2(this.value);">
	<c:forEach var="x" items="${result}">
		<option value="${x.AREA_CD}" <c:if test="${x.AREA_CD eq selected}">selected</c:if>>${x.AREA_NM}</option>
	</c:forEach>
</select>