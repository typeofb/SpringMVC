<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<select>
	<c:forEach var="x" items="${result}">
		<option value="${x.LOC_CD}" <c:if test="${x.LOC_CD eq selected}">selected</c:if>>${x.LOC_NM}</option>
	</c:forEach>
</select>